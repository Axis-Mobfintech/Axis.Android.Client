package br.com.setis.axisdemoapp.viewmodel;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.axismobfintech.gpb.transactions.AcceptedBin;
import com.axismobfintech.gpb.transactions.ApplicationIdentifierOuterClass;
import com.axismobfintech.gpb.transactions.CapkTable;
import com.axismobfintech.gpb.transactions.DeviceRegisterOuterClass;
import com.axismobfintech.gpb.transactions.DeviceParameters;
import com.axismobfintech.gpb.transactions.DevicesParametersGrpc;
import com.axismobfintech.gpb.transactions.DevicesManagerGrpc;
import com.axismobfintech.gpb.transactions.PassageRegister;
import com.axismobfintech.gpb.transactions.TransactionsGrpc;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.axismobfintech.gpb.transactions.AcceptedBin.AcceptedBankIdentificationNumber;

import com.google.protobuf.ByteString;
//import static com.google.protobuf.util.Timestamps.fromMillis;
import static com.idtechproducts.device.Common.getHexStringFromBytes;
import static java.lang.System.currentTimeMillis;

import com.google.protobuf.Timestamp;

import com.idtechproducts.device.Common;
import com.idtechproducts.device.ErrorCode;
import com.idtechproducts.device.IDTEMVData;
import com.idtechproducts.device.IDTMSRData;
import com.idtechproducts.device.IDT_KioskIII;
import com.idtechproducts.device.OnReceiverListener;
import com.idtechproducts.device.ReaderInfo;
import com.idtechproducts.device.ResDataStruct;
import com.idtechproducts.device.StructConfigParameters;
import com.idtechproducts.device.audiojack.tools.FirmwareUpdateTool;

import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;
import br.com.setis.axisdemoapp.data.Util;
import br.com.setis.axisdemoapp.room.Bin;
import br.com.setis.axisdemoapp.room.Pan;
import br.com.setis.axisdemoapp.room.ValidadorDatabase;
import br.com.setis.axisdemoapp.room.ValidadorInfo;

import io.grpc.ManagedChannelBuilder;

import static br.com.setis.axisdemoapp.data.Util.getTimestamp;
import static br.com.setis.axisdemoapp.data.Util.getValueByTag;
import static com.idtechproducts.device.Common.isFileExist;


public class ValidadorViewModel extends ViewModel {
    public static final String mTAG = "AxisLog";
    private IDT_KioskIII device;
    private FirmwareUpdateTool fwTool;
    private MutableLiveData<String> liveData;
    private MutableLiveData<String> transactionLiveData;

    private String idValidador = "0123456789ABCDE"; //A15
    private byte[] codRegistro = "0123456789".getBytes(); //B20

    private final String axisProd = "4ioiybj5xk.execute-api.sa-east-1.amazonaws.com";

    private Context context;
    private ValidadorDatabase db;

    private StringBuilder dspLogs;

    private Handler handler;
    public final Boolean DEFAULT_TABS = true; //utiliza as tabelas default do terminal.

    public ValidadorViewModel(Context context) {
        initializeReader(context);
        this.context = context;
        liveData = new MutableLiveData<>();
        handler = new Handler(Looper.getMainLooper());
    }

    public boolean obterStatusLeitor() {
        if (device != null && device.device_pingDevice() == ErrorCode.SUCCESS) {
            String fw = getFirmwareVersion();
            if (fw != null && fw.length() > 0) {
                return true;
            }
        }
        return false;
    }

    private void logDeviceParameters(DeviceParameters.ParametersResponse response) {
        int i;

        displayLog("Date:" + response.getResponseDate());

        displayLog("Versão da Tabela de AID:" + response.getEmvParametersVersion());
        for (i = 0; i < response.getEmvTableCount(); i++) {
            ApplicationIdentifierOuterClass.ApplicationIdentifier emv = response.getEmvTable(i);

            displayLog(" Terminal Type:" + emv.getTerminalType());
            displayLog(" Terminal Capabilities:" + getHexStringFromBytes(emv.getTerminalCapabilities().toByteArray()));
            displayLog(" Addictional Terminal Capabilities:" + getHexStringFromBytes(emv.getAddictionalTerminalCapabilities().toByteArray()));
            displayLog(" Application Identifier:" + getHexStringFromBytes(emv.getApplicationIdentifier().toByteArray()));
            displayLog(" Application Version Number:" + getHexStringFromBytes(emv.getApplicationVersionNumber().toByteArray()));
            displayLog(" Authorized Amount:" + emv.getAuthorizedAmount());
            displayLog(" Card Data Input Capability:" + getHexStringFromBytes(emv.getCardDataInputCapability().toByteArray()));
            displayLog(" Category Code:" + getHexStringFromBytes(emv.getCategoryCode().toByteArray()));
            displayLog(" Country Code:" + emv.getCountryCode());
            displayLog(" Currency Code:" + emv.getCurrencyCode());
            displayLog(" Currency Exponent:" + emv.getCurrencyExponent());
            displayLog(" Contactless Floor Limit:" + emv.getContactlessFloorLimit());
            displayLog(" Cvm Required Limit:" + emv.getCvmRequiredLimit());
            displayLog(" Cvm Capability Required:" + getHexStringFromBytes(emv.getCvmCapabilityRequired().toByteArray()));
            displayLog(" Cvm Capability Not Required:" + getHexStringFromBytes(emv.getCvmCapabilityNotRequired().toByteArray()));
            displayLog(" General Flags:" + getHexStringFromBytes(emv.getGeneralFlags().toByteArray()));
            displayLog(" Limit No On Device:" + emv.getLimitNoOnDevice());
            displayLog(" Limit On Device:" + emv.getLimitOnDevice());
            displayLog(" Reader Floor Limit:" + emv.getReaderFloorLimit());
            displayLog(" Merchant Category Code:" + emv.getMerchantCategoryCode());
            displayLog(" Risk Management Data:" + getHexStringFromBytes(emv.getRiskManagementData().toByteArray()));
            displayLog(" Security Capability:" + getHexStringFromBytes(emv.getSecurityCapability().toByteArray()));
            displayLog(" Terminal Action Code Default:" + getHexStringFromBytes(emv.getTerminalActionCodeDefault().toByteArray()));
            displayLog(" Terminal Action Code Online:" + getHexStringFromBytes(emv.getTerminalActionCodeOnline().toByteArray()));
            displayLog(" Terminal Action Code Denial:" + getHexStringFromBytes(emv.getTerminalActionCodeDenial().toByteArray()));
            displayLog(" Terminal Transaction Qualifiers:" + getHexStringFromBytes(emv.getTerminalTransactionQualifiers().toByteArray()));
        }
        for (i = 0; i < response.getCapkTableCount(); i++) {
            CapkTable.CertificateAuthorityPublicKeyTable capk = response.getCapkTable(i);

            displayLog(" Index:" + capk.getIndex());
            displayLog(" RID:" + getHexStringFromBytes(capk.getRegisteredIdentifier().toByteArray()));
            displayLog(" Rsa Key Exponent:" + getHexStringFromBytes(capk.getRsaKeyExponent().toByteArray()));
            displayLog(" Rsa Key Modulus:" + getHexStringFromBytes(capk.getRsaKeyModulus().toByteArray()));
            displayLog(" Checksum:" + getHexStringFromBytes(capk.getChecksum().toByteArray()));
        }

        displayLog("Versão da Tabela de BIN:" + response.getBinParametersVersion());
        for (i = 0; i < response.getAidTableCount(); i++) {
            AcceptedBin.AcceptedBankIdentificationNumber bin = response.getAidTable(i);

            displayLog(" Index:" + bin.getIndex());
            displayLog(" Issuer Code:" + bin.getIssuerCode());
            displayLog(" Initial Range:" + bin.getInitialRange());
            displayLog(" Final Range:" + bin.getFinalRange());
            displayLog(" Message Id:" + bin.getMessageId());
            displayLog(" Total Sequential Transactions Allowed " + bin.getTotalSequentialTransactionsAllowed());
        }
    }

    /**
     * Inicializa a biblioteca e realiza a conexão com o leitor Kioski IV.
     */
    private void initializeReader(final Context context) {
        if (device != null && device.device_pingDevice() == ErrorCode.SUCCESS) {
            releaseSDK();
        }
        db = Room.databaseBuilder(context, ValidadorDatabase.class, "database-validador").build();

        device = new IDT_KioskIII(new OnReceiverListener() {
            @Override
            public void swipeMSRData(final IDTMSRData idtmsrData) {
                if (idtmsrData == null) return;

                ExecutorService executor = Executors.newSingleThreadExecutor();
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        boolean parAvailable = false;
                        boolean hashAvailable = false;

                        ValidadorInfo info = db.validadorInfoDAO().getInfo();
                        displayLog("Cartão lido com sucesso.");

                        String res = device.device_getResponseCodeString(idtmsrData.result);
                        Log.d(mTAG, "res:" + res);

                        String detail = Common.parse_MSRData(Common.getDeviceType(), idtmsrData);
                        displayLog(String.format("%s\n%s\n", detail, res));

                        displayLog("Iniciando processo de validação.");

                        int valorTrn = 100;
                        String aux = Util.getValueByTag(idtmsrData, "9f02");
                        if (aux != null) valorTrn = Integer.valueOf(aux);

                        byte[] panHash = null;
                        aux = Util.getValueByTag(idtmsrData, "dfed4b");
                        if (aux != null) {
                            displayLog("Pan Hash encontrado.");
                            hashAvailable = true;
                            panHash = Common.getByteArray(aux);
                        }

                        if (!parAvailable && !hashAvailable) {
                            displayLog("Transação Recusada: Tags DFED4B e 9F24 ausentes.");
                            sendTransactionStatus("Transação Recusada: Tags DFED4B e 9F24 ausentes.");
                            return;
                        }

                        int bin = 0;
                        aux = getValueByTag(idtmsrData, "5a");
                        if (aux != null) {
                            try {
                                bin = Integer.parseInt(aux.substring(0, 6));
                            } catch (Exception ex) {
                                bin = Integer.parseInt(aux.substring(0, 4)) * 100;
                            }
                        } else {
                            displayLog("Transação Recusada: Tags 5A não encontrada.");
                            sendTransactionStatus("Transação Recusada: Tags 5A não encontrada.");
                            return;
                        }


                        //Passo 1: Validação do BIN.
                        Bin binDt = db.binDAO().checkBin(bin);
                        if (binDt == null) {
                            displayLog("Transação Recusada: BIN do cartão não se encontra na faixa de BIN's cadastradas.");
                            sendTransactionStatus("Transação Recusada: BON do cartão não se encontra na faixa cadastrada.");
                            return;
                        } else {
                            displayLog("Bin do cartão se encontra na faixa de BIN's cadastradas.");
                        }

                        //Passo 2:pulando validação PAR


                        //Passo 3: Validação do hashPAN
                        if (panHash != null) {
                            String strHashPan = Common.bytesToHex(panHash).substring(0, 24);
                            Pan pan = db.panDAO().checkPan(strHashPan.toUpperCase());
                            if (pan != null) {
                                if (pan.panAceito == 0) {
                                    displayLog(String.format("Transação Recusada: PAN %s presente na lista de PAN não aceitos.", strHashPan));
                                    sendTransactionStatus("Transação Recusada: PAN presente na lista de PAN não aceitos.");
                                    return;
                                } else {
                                    displayLog(String.format("Pan %s se encontra na lista de PAN aceitos.", strHashPan));

                                    //Passo 4: Validação de transações sequenciais
                                    if (info.panHashUlt != null) {
                                        if (info.panHashUlt.toUpperCase().equals(strHashPan.toUpperCase())) {
                                            if (binDt.qtdTranSeq == 0) {
                                                displayLog("Transação Recusada: transações sequenciais não são permitidas.");
                                                sendTransactionStatus("Transação Recusada: transações sequenciais não são permitidas.");
                                                return;
                                            } else {
                                                if (pan.panSeqNo > binDt.qtdTranSeq) {
                                                    displayLog("Transação Recusada: limite de transações sequenciais atingido.");
                                                    sendTransactionStatus("Transação Recusada: limite de transações sequenciais atingido.");
                                                    return;
                                                } else {
                                                    //incrementa o contador do pan
                                                    db.panDAO().updatePanSeqNum(pan.panSeqNo + 1, strHashPan.toUpperCase());
                                                    displayLog("Contador de transações sequenciais incrementado.");
                                                }
                                            }
                                        } else {
                                            //Passo 6.
                                            db.panDAO().updatePanSeqNum(0, strHashPan.toUpperCase());
                                            displayLog("Contador de transações zerado.");
                                        }
                                    }
                                }
                            } else {
                                //displayLog(String.format("Transação Recusada: PAN %s ausente na lista de PAN aceitos.", strHashPan));
                                //sendTransactionStatus("Transação Recusada: PAN ausente na lista de PAN aceitos.");
                                //return;
                            }
                        }
                        //Todo validar passo 5: Conferir data de validade
                        /*
                        aux = getValueByTag(idtmsrData, "9f06");
                        if (aux != null) {
                            ResDataStruct aidInfo = new ResDataStruct();
                            int ret = device.ctls_retrieveApplicationData(aux, aidInfo);

                        } else {
                            Log.d(mTAG, "Tag 9f06 [Aid] não encontrada.");
                            sb.append("Tag 9f06 [Aid] não encontrada.\n");
                            displayLog(sb.toString());
                        }
                         */

                        displayLog("Validação finalizada.");

                        final PassageRegister.RegisterPassage request = PassageRegister.RegisterPassage.newBuilder()
                                .setDeviceId(info.idValidador)
                                .setOperatorId(info.idOperador)
                                .setReaderSerialNumber(info.nsLeitor)
                                .setDeviceSerialNumber(info.nsValidador)
                                .setRegisterCode(12345)
                                .setPassageDate(getTimestamp())
                                .setTransactionDate(getTimestamp())
                                .setDeviceSuid(Integer.toString(info.nsuValidador))
                                .setPanHash(ByteString.copyFrom(panHash))
                                //.setParCard()
                                .setTransactionData(ByteString.copyFrom(idtmsrData.cardData))
                                .setEmvParametersVersion(info.vrsPrmEMV)
                                .setBinParametersVersion(info.vrsPrmBIN)
                                .setRestrictionListVersion(info.vrsListaExc)
                                .setTransactionValue(valorTrn)
                                .setLineId(info.idLinha)
                                .setVehicleId(info.idVeiculo)
                                .setGeolocation("23.563,-46.186")
                                .build();

                        PassageRegister.RegisterPassageResponse response;
                        try {
                            io.grpc.Channel channel = ManagedChannelBuilder.forAddress(axisProd, 443).build();
                            TransactionsGrpc.TransactionsBlockingStub stub = TransactionsGrpc.newBlockingStub(channel);

                            response = stub.makeTransaction(request);

                        } catch (io.grpc.StatusRuntimeException e) {
                            displayLog("Erro gRPC [" + e.getStatus().getCode() + "] (" + e.getStatus().getDescription() + ")");
                            liveData.postValue("Erro gRPC: " + e.getStatus().getCode());
                            return;
                        }

                        if (response.getResponseCode() != 0) {
                            sendTransactionStatus("Erro no Registro da Passagem:" + response.getResponseCode());
                            return;
                        }

                        displayLog("Versão da Tabela de BIN:" + response.getBinParametersVersion());
                        displayLog("Versão da Tabela EMV:" + response.getEmvParametersVersion());
                        displayLog("Versão da lista de restrição:" + response.getRestrictionListVersion());
                        displayLog("NSU do validador:" + response.getDeviceSuid());
                        displayLog("NSU do gateway:" + response.getGatewayUid());

                        sendTransactionStatus("Registro da Passagem Aprovado!");

                        db.validadorInfoDAO().updateNsu(info.nsuValidador + 1);
                        db.validadorInfoDAO().updateLastPanHash(Common.bytesToHex(panHash).substring(0, 24));
                    }
                });


            }

            @Override
            public void lcdDisplay(int i, String[] strings, int i1) {

            }

            @Override
            public void lcdDisplay(int i, String[] strings, int i1, byte[] bytes, byte b) {

            }

            @Override
            public void emvTransactionData(IDTEMVData idtemvData) {
                displayLog("Passou emv!");
            }

            @Override
            public void deviceConnected() {

            }

            @Override
            public void deviceDisconnected() {

            }

            @Override
            public void timeout(int i) {
                Log.d(mTAG, "timeout");
                sendTransactionStatus("TIMEOUT");
            }

            @Override
            public void autoConfigCompleted(StructConfigParameters structConfigParameters) {

            }

            @Override
            public void autoConfigProgress(int i) {

            }

            @Override
            public void msgRKICompleted(String s) {

            }

            @Override
            public void ICCNotifyInfo(byte[] bytes, String s) {

            }

            @Override
            public void msgBatteryLow() {

            }

            @Override
            public void LoadXMLConfigFailureInfo(int i, String s) {

            }

            @Override
            public void msgToConnectDevice() {

            }

            @Override
            public void msgAudioVolumeAjustFailed() {

            }

            @Override
            public void dataInOutMonitor(byte[] bytes, boolean b) {

            }
        }, context);
        String filepath = Util.getXMLFileFromRaw(context);
        if (!isFileExist(filepath)) {
            filepath = null;
        }
        device.config_setXMLFileNameWithPath(filepath);
        device.config_loadingConfigurationXMLFile(false);
        device.log_setVerboseLoggingEnable(true);
        //fwTool = new FirmwareUpdateTool(callback, context);
        device.device_setDeviceType(ReaderInfo.DEVICE_TYPE.DEVICE_KIOSK_III, 0x4480);
        //device.setIDT_Device(fwTool);
        device.registerListen();

        desativaPolling();
        Log.d(mTAG, "FW version:" + getFirmwareVersion());
    }

    /**
     * Libera a conexão com o leitor Kioski IV.
     */
    public void releaseSDK() {
        if (device != null && device.device_pingDevice() == ErrorCode.SUCCESS) {
            device.ctls_cancelTransaction();
            device.unregisterListen();
            device.release();
        }
    }

    /**
     * Obtem a versão do firmware do leitor Kioski IV.
     */
    public String getFirmwareVersion() {
        if (device != null && device.device_pingDevice() == ErrorCode.SUCCESS) {
            StringBuilder sb = new StringBuilder();
            int res = device.device_getFirmwareVersion(sb);
            String parsedres = device.device_getResponseCodeString(res);
            if (res == ErrorCode.SUCCESS) {
                return sb.toString();
            }
        }
        return "";
    }

    public MutableLiveData<String> getLiveData() {
        if (liveData == null) {
            liveData = new MutableLiveData<String>();
        }
        return liveData;
    }

    public MutableLiveData<String> getTransactionLiveData() {
        if (transactionLiveData == null) {
            transactionLiveData = new MutableLiveData<String>();
        }
        return transactionLiveData;
    }

    public void clearLivedata() {
        liveData = new MutableLiveData<>();
        transactionLiveData = new MutableLiveData<>();
    }


    /**
     * O Validador deve utilizar esta transação para realizar o seu registro no
     * sistema da Axis Go Cloud e assim obter autorização e receber os dados de
     * funcionamento, lista de cartões negados e registro de passagem.
     */
    public void registrarValidador() {

        resetLog();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {

                db.validadorInfoDAO().deleteAll();

                //TODO obter dados do leitor / usuário
                ValidadorInfo info = new ValidadorInfo();
                info.idValidador = "1";
                info.idOperador = "1";
                info.nsLeitor = "1";
                info.nsValidador = "1";
                info.idLinha = "1";
                info.idVeiculo = "1";
                info.codRegistro = "01020304050607080900";

                info.panHashUlt = "E223A727677571549B395600";

                db.validadorInfoDAO().insertBaseValues(info);

                final DeviceRegisterOuterClass.DeviceRegister request = DeviceRegisterOuterClass.DeviceRegister.newBuilder()
                        .setOperatorId(info.idOperador)
                        .setReaderSerialNumber(info.nsLeitor)
                        .setVehicleId(info.idVeiculo)
                        .setDeviceSerialNumber("123456")
                        .setKsnData(com.google.protobuf.ByteString.copyFromUtf8("1234"))
                        .setLineId("123456")
                        //.setRegisterDate(fromMillis(currentTimeMillis()))
                        .build();

                DeviceRegisterOuterClass.DeviceRegisterResponse response;
                try {
                    io.grpc.Channel channel = ManagedChannelBuilder.forAddress(axisProd, 443).build();
                    DevicesManagerGrpc.DevicesManagerBlockingStub stub = DevicesManagerGrpc.newBlockingStub(channel);

                    response = stub.registerDevice(request);

                } catch (io.grpc.StatusRuntimeException e) {
                    displayLog("Erro gRPC [" + e.getStatus().getCode() + "] (" + e.getStatus().getDescription() + ")");
                    liveData.postValue("Erro gRPC: " + e.getStatus().getCode());
                    return;
                }

                if (response.getResponseCode() != 0) {
                    liveData.postValue("Erro no Registro do Validador:" + response.getResponseCode());
                    return;
                }

                displayLog("ID do Dispositivo:" + response.getDeviceId());
                displayLog("Código de registro:" + response.getRegisterCode());
                displayLog("Data de registro:" + response.getRegisterDate());

                sendTransactionStatus("Registro do Dispositivo Aprovado!");

                liveData.postValue("Registro OK");
            }
        });
    }

    /**
     * Método utilizado para se obter ou atualizar os parâmetros EMV e BINs aceitos
     */
    public void obterParametro() {
        resetLog();

        if (device != null && device.device_pingDevice() == ErrorCode.SUCCESS) {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    ValidadorInfo info = db.validadorInfoDAO().getInfo();
                    if (info == null) {
                        displayLog("Erro: Realize o registro do validador.");
                        return;
                    }

                    int ret;

                    if (!DEFAULT_TABS) {
                        ret = device.ctls_removeAllApplicationData();
                        displayLog(String.format("Removendo AID's: %s", device.device_getResponseCodeString(ret)));
                        if (ret != 0) return;

                        //Configura grupo
                        String groupString = "FFE401329F02060000000001009F03060000000000009F1A0200765F2A0209865F3601029C01009F3501259F1B0400001F40FFF506000000001000DF812306000000008000DF812406000000030000DF8125060000000500009F150212349F400500000000009F09020002DF81170100DF81180160DF81190108DF811F0108FFFC0106FFFE050000000000FFFF050000000000FFFD0500000000009F1D086CFF000000000000FFF3020001DF2601009F5301522E9E";
                        ResDataStruct groupResData = new ResDataStruct();
                        ret = device.ctls_setConfigurationGroup(Common.getByteArray(groupString), groupResData);
                        displayLog(String.format("Criando Grupo: %s", device.device_getResponseCodeString(ret)));
                        if (ret != 0) return;

                        //relaciona aid ao grupo recem criado.
                        String hexString = "FFE401329F0607A0000000041010FFE10101FFE50110FFE30114FFE903030032FFE60100";
                        byte[] data = Common.getByteArray(hexString);
                        ResDataStruct resData = new ResDataStruct();
                        ret = device.ctls_setApplicationData(data, resData);
                        displayLog(String.format("Criando AID: %s", device.device_getResponseCodeString(ret)));
                        if (ret == ErrorCode.SUCCESS && resData.statusCode == 0x00) {
                            db.validadorInfoDAO().updateVersionEmv(1);
                            displayLog("Tabelas AID atualizadas. Versão: 1");
                        } else {
                            displayLog("Erro na atualização de tabelas. Verifique os logs.");
                        }

                        //ResDataStruct aidInfo = new ResDataStruct();
                        //ret = device.ctls_retrieveApplicationData("A0000000041010", aidInfo);

                        //Configuração de CAPK
                        String capk = "A00000000308010120D213126955DE205ADC2FD2822BD22DE21CF9A80000000300B0D9FD6ED75D51D0E30664BD157023EAA1FFA871E4DA65672B863D255E81E137A51DE4F72BCC9E44ACE12127F87E263D3AF9DD9CF35CA4A7B01E907000BA85D24954C2FCA3074825DDD4C0C8F186CB020F683E02F2DEAD3969133F06F7845166ACEB57CA0FC2603445469811D293BFEFBAFAB57631B3DD91E796BF850A25012F1AE38F05AA5C4D6D03B1DC2E568612785938BBC9B3CD3A910C1DA55A5A9218ACE0F7A21287752682F15832A678D6E1ED0B";
                        ret = device.ctls_removeAllCAPK();
                        displayLog(String.format("Removendo CAPK's: %s", device.device_getResponseCodeString(ret)));

                        byte[] capk_b = Common.getByteArray(capk);
                        ResDataStruct resCapk = new ResDataStruct();
                        ret = device.ctls_setCAPK(capk_b, resCapk);
                        displayLog(String.format("Criando CAPK: %s", device.device_getResponseCodeString(ret)));
                    } else {
                        //utiliza as tabelas default do leitor.
                        ResDataStruct res = new ResDataStruct();
                        ret = device.device_sendDataCommand("0409", false, null, res);
                        displayLog("Utilizando configurações padrão do leitor.");
                    }

                    final DeviceParameters.Parameters request = DeviceParameters.Parameters.newBuilder()
                            .setBinParametersVersion(info.vrsPrmBIN)
                            .setEmvParametersVersion(info.vrsPrmEMV)
                            .setDeviceId(info.idValidador)
                            .setOperatorId(info.idOperador)
                            .setDeviceSerialNumber(info.nsValidador)
                            .setKsnData(com.google.protobuf.ByteString.copyFromUtf8("1234"))
                            .setLineId(info.idLinha)
                            .setReaderSerialNumber(info.nsLeitor)
                            .setRegisterCode(12345)
                            .setRegisterDate(getTimestamp())
                            .setVehicleId(info.idVeiculo)
                            .build();

                    DeviceParameters.ParametersResponse response;
                    try {
                        io.grpc.Channel channel = ManagedChannelBuilder.forAddress(axisProd, 443).build();
                        DevicesParametersGrpc.DevicesParametersBlockingStub stub = DevicesParametersGrpc.newBlockingStub(channel);

                        response = stub.getDeviceParameters(request);

                    } catch (io.grpc.StatusRuntimeException e) {
                        displayLog("Erro gRPC [" + e.getStatus().getCode() + "] (" + e.getStatus().getDescription() + ")");
                        liveData.postValue("Erro gRPC: " + e.getStatus().getCode());
                        return;
                    }

                    if (response.getResponseCode() != 0) {
                        sendTransactionStatus("Erro na Requisição de Parâmetros:" + response.getResponseCode());
                        return;
                    }

                    logDeviceParameters(response);

                    //TODO salvar os parâmetros recebidos do Servidor AXIS!

                    //Configuração de BIN
                    displayLog("Removendo BIN's cadastrados.");
                    db.binDAO().deleteAll();

                    displayLog("Inserindo BIN: 000000:999999");
                    Bin bin = new Bin();
                    bin.id = 1;
                    bin.codigoEmissor = 3;
                    bin.faixaFinal = 0;
                    bin.faixaFinal = 999999;
                    bin.qtdTranSeq = 1;
                    db.binDAO().insertBin(bin);

                    db.validadorInfoDAO().updateVersionBin(1);

                    displayLog("Tabela de BINs atualizada. Versão 1.");

                }
            });
        } else {
            displayLog("Erro: Leitor não encontrado.");
        }
    }

    /**
     * Método utilizado para se obter ou atualizar a lista de PANs e PAR que não devem
     * ser aceitos.
     */
    public void obterListaExcecao() {
        /**
         * Nesta demonstração, iremos utilizar valores pre-fixados (Não haverá requisição
         * a Axis Go Cloud).
         * Nesta demonstração, iremos trabalhar apenas com tabelas de PAN's.
         * */
        resetLog();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                ValidadorInfo info = db.validadorInfoDAO().getInfo();
                if (info == null) {
                    displayLog("Erro: Realize o registro do validador.");
                    return;
                }

                db.panDAO().deleteAll();
                displayLog("Excluindo a lista de PAN's");

                Pan pan1 = new Pan();
                pan1.id = 1;
                pan1.dataInclusao = 201202;
                pan1.motivo = "1";
                pan1.panHash = "E223A727677571549B395600";
                pan1.panSeqNo = 0;
                pan1.panAceito = 1;
                db.panDAO().insertPan(pan1);
                displayLog("Inserindo PAN na lista de exceção.");

                Pan pan2 = new Pan();
                pan2.id = 2;
                pan2.dataInclusao = 201202;
                pan2.motivo = "1";
                pan2.panHash = "9FD72062ABC7E4809FA23384";
                pan2.panSeqNo = 2;
                pan2.panAceito = 0;
                db.panDAO().insertPan(pan2);
                displayLog("Inserindo PAN na lista de exceção.");

                db.validadorInfoDAO().updateVersionListaExc(1);
                displayLog("Lista de Exceção configurada com sucesso. Versão: 1");
            }
        });
    }

    /**
     * Esta transação deve ser utilizada pelo Validador para realizar o registro de uma
     * passagem.
     */
    public void registrarPassagem() {
        resetLog();
        if (device != null && device.device_pingDevice() == ErrorCode.SUCCESS) {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    ValidadorInfo info = db.validadorInfoDAO().getInfo();
                    if (info == null) {
                        displayLog("Erro: Realize o registro do validador.");
                        return;
                    }

                    displayLog("Aproxime um cartão CTLS.");
                    byte[] tags = null;
                    int res = device.ctls_startTransaction(4.30, 0.00, 0, 255, tags);

                    Log.d(mTAG, "Iniciando transação:" + device.device_getResponseCodeString(res));
                }
            });
        } else {
            displayLog("Erro: Leitor não encontrado.");
        }
    }

    private void checkAid() {
        ResDataStruct res = new ResDataStruct();
        int ret = device.device_sendDataCommand("0304", false, "9F0607A0000000041010", res);
        String str = Common.bytesToHex(res.resData);

        ret = device.device_sendDataCommand("0306", false, "FFE40108", res);
        str = Common.bytesToHex(res.resData);
    }

    /*
    private void deleteAllAid() {
        ResDataStruct res = new ResDataStruct();
        displayLog("Buscando lista de Aid's cadastrados.");
        int ret = device.device_sendDataCommand("0305", false, "", res);
        List<String> aids = Util.getAidValues(Common.bytesToHex(res.resData));
        displayLog(String.format("Encontrado %d AID's cadastrados.", aids.size()));

        displayLog("Removendo todos os AID's cadastrados.");
        for (String item: aids) {
            ret = device.device_sendDataCommand("0404", false, item, res);
            displayLog(String.format("Removendo AID: [%s] - status: %d", item.substring(6, item.length()), ret));
        }

        Log.d(mTAG, "Removendo AID's:" + device.device_getResponseCodeString(ret));
        if (ret != 0) return;
    }
     */

    /**
     * Esta transação deve ser utilizada pelo Validador para solicitar a remoção de um
     * cartão das tabelas de cartão não aceito da lista de exceção.
     */
    public void recuperarDebito() {
        resetLog();
        if (device != null && device.device_pingDevice() == ErrorCode.SUCCESS) {
            checkAid();
            //deleteAllAid();
        } else {
            displayLog("Erro: Leitor não encontrado.");
        }
    }

    public boolean verificaRegistro() {
        ValidadorInfo info = db.validadorInfoDAO().getInfo();
        if (info == null) {
            displayLog("Erro: Realize o registro do validador.");
            return false;
        }
        return true;
    }

    public void reconectarLeitor() {
        resetLog();
        initializeReader(context);
    }


    private void desativaPolling() {
        int res = device.device_setPollMode((byte) 1);
        Log.d(mTAG, "Removing poll-mode: " + device.device_getResponseCodeString(res));

        res = device.device_setBurstMode((byte) 1);
        Log.d(mTAG, "Burst Mode: " + device.device_getResponseCodeString(res));
    }

    private void resetLog() {
        if (dspLogs == null) {
            dspLogs = new StringBuilder();
            return;
        }
        dspLogs.setLength(0);
    }

    private void displayLog(final String log) {
        Log.d(mTAG, log);
        dspLogs.append(log + "\n");
        handler.post(new Runnable() {
            @Override
            public void run() {
                liveData.setValue(dspLogs.toString());
            }
        });
    }

    private void sendTransactionStatus(final String status) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                transactionLiveData.setValue(status);
            }
        });
    }

    public void cancelTransaction() {
        device.ctls_cancelTransaction();
    }

    private static class NetworkTaggingExecutor extends ThreadPoolExecutor {

        private int trafficStatsTag;

        NetworkTaggingExecutor(int tag) {
            super(
                    0,
                    Integer.MAX_VALUE,
                    60L,
                    TimeUnit.SECONDS,
                    new SynchronousQueue<Runnable>(),
                    new ThreadFactoryBuilder().setDaemon(true).setNameFormat("grpc-android-%d").build());
            trafficStatsTag = tag;
        }

        @Override
        protected void beforeExecute(Thread t, Runnable r) {
            TrafficStats.setThreadStatsTag(trafficStatsTag);
            super.beforeExecute(t, r);
        }

        @Override
        protected void afterExecute(Runnable r, Throwable t) {
            TrafficStats.clearThreadStatsTag();
            super.afterExecute(r, t);
        }
    }
}
