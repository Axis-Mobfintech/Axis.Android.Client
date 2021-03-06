package br.com.setis.axisdemoapp.viewmodel;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.axismobfintech.gpb.transactions.AcceptedBin;
import com.axismobfintech.gpb.transactions.CapkTable;
import com.axismobfintech.gpb.transactions.DeviceParameters;
import com.axismobfintech.gpb.transactions.DeviceParametersServiceGrpc;
import com.axismobfintech.gpb.transactions.DeviceRegister;
import com.axismobfintech.gpb.transactions.DeviceRegisterServiceGrpc;
import com.axismobfintech.gpb.transactions.EmvParametersOuterClass;
import com.axismobfintech.gpb.transactions.PassageRegister;
import com.axismobfintech.gpb.transactions.RegisterPassageServiceGrpc;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.protobuf.ByteString;
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

import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;
import br.com.setis.axisdemoapp.R;
import br.com.setis.axisdemoapp.data.Util;
import br.com.setis.axisdemoapp.room.Bin;
import br.com.setis.axisdemoapp.room.Pan;
import br.com.setis.axisdemoapp.room.ValidadorDatabase;
import br.com.setis.axisdemoapp.room.ValidadorInfo;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.netty.handler.ssl.SslContext;

import static br.com.setis.axisdemoapp.data.Util.getTimestamp;
import static br.com.setis.axisdemoapp.data.Util.getValueByTag;
import static com.idtechproducts.device.Common.getHexStringFromBytes;
import static com.idtechproducts.device.Common.hexStringToByteArray;
import static com.idtechproducts.device.Common.isFileExist;


public class ValidadorViewModel extends ViewModel {

    public static final String mTAG = "AxisLog";
    public static final String IdOperador = "1436a561-0a2f-426d-9541-fc69c1b0db08";
    public static final String NsValidador = "1234567890";
    public static final String IdLinha = "11111";
    public static final String IdVeiculo = "11111";
    public static final int Valor = 430;
    public static final String Geolocalizacao = "23.563,-46.186";

    public final Boolean DEFAULT_TABS = false; //utiliza as tabelas default do terminal.

    private final Context context;
    private final Handler handler;
    private final MediaPlayer mastercardSound;

    //private final String axisHost = "4ioiybj5xk.execute-api.sa-east-1.amazonaws.com";
    //private final String axisHost = "54.213.234.140";
    private final String axisHost = "transaction-dev.axis-mobfintech.com"; // Development environment
    private final int axisPort = 5001;

    private IDT_KioskIII device;
    private FirmwareUpdateTool fwTool;
    private MutableLiveData<String> liveData;
    private MutableLiveData<String> transactionLiveData;
    private MutableLiveData<String> simulaData;
    private ValidadorDatabase db;
    private StringBuilder dspLogs;

    public ValidadorViewModel(Context context) {
        initializeReader(context);
        this.context = context;
        liveData = new MutableLiveData<>();
        mastercardSound = MediaPlayer.create(context, R.raw.mastercard_sound);
        handler = new Handler(Looper.getMainLooper());
    }

    public boolean obterStatusLeitor() {
        if (device != null && device.device_pingDevice() == ErrorCode.SUCCESS) {
            String fw = getFirmwareVersion();
            return fw != null && fw.length() > 0;
        }
        return false;
    }

    private void logDeviceParameters(DeviceParameters.ParametersResponse response) {
        int i;

        displayLog("Date:" + response.getTransactionDate());

        displayLog("Vers??o das Tabelas EMV:" + response.getEmvParametersVersion());

        for (i = 0; i < response.getEmvParametersCount(); i++) {
            EmvParametersOuterClass.EmvParameters emv = response.getEmvParameters(i);

            displayLog(" Index:" + emv.getIndex());
            displayLog(" Action:" + emv.getCardAction());

            displayLog("   Terminal Type:" + emv.getTerminalType());
            displayLog("   Terminal Capabilities:" + getHexStringFromBytes(emv.getTerminalCapabilities().toByteArray()));
            displayLog("   Addictional Terminal Capabilities:" + getHexStringFromBytes(emv.getAddictionalTerminalCapabilities().toByteArray()));
            displayLog("   Application Identifier:" + getHexStringFromBytes(emv.getApplicationIdentifier().toByteArray()));
            displayLog("   Application Version Number:" + getHexStringFromBytes(emv.getApplicationVersionNumber().toByteArray()));
            displayLog("   Authorized Amount:" + emv.getAuthorizedAmount());
            displayLog("   Card Data Input Capability:" + getHexStringFromBytes(emv.getCardDataInputCapability().toByteArray()));
            displayLog("   Category Code:" + getHexStringFromBytes(emv.getCategoryCode().toByteArray()));
            displayLog("   Country Code:" + emv.getCountryCode());
            displayLog("   Currency Code:" + emv.getCurrencyCode());
            displayLog("   Currency Exponent:" + emv.getCurrencyExponent());
            displayLog("   Contactless Floor Limit:" + emv.getContactlessFloorLimit());
            displayLog("   Cvm Required Limit:" + emv.getCvmRequiredLimit());
            displayLog("   Cvm Capability Required:" + getHexStringFromBytes(emv.getCvmCapabilityRequired().toByteArray()));
            displayLog("   Cvm Capability Not Required:" + getHexStringFromBytes(emv.getCvmCapabilityNotRequired().toByteArray()));
            displayLog("   General Flags:" + getHexStringFromBytes(emv.getGeneralFlags().toByteArray()));
            displayLog("   Limit No On Device:" + emv.getLimitNoOnDevice());
            displayLog("   Limit On Device:" + emv.getLimitOnDevice());
            displayLog("   Reader Floor Limit:" + emv.getReaderFloorLimit());
            displayLog("   Merchant Category Code:" + emv.getMerchantCategoryCode());
            displayLog("   Risk Management Data:" + getHexStringFromBytes(emv.getRiskManagementData().toByteArray()));
            displayLog("   Security Capability:" + getHexStringFromBytes(emv.getSecurityCapability().toByteArray()));
            displayLog("   Terminal Action Code Default:" + getHexStringFromBytes(emv.getTerminalActionCodeDefault().toByteArray()));
            displayLog("   Terminal Action Code Online:" + getHexStringFromBytes(emv.getTerminalActionCodeOnline().toByteArray()));
            displayLog("   Terminal Action Code Denial:" + getHexStringFromBytes(emv.getTerminalActionCodeDenial().toByteArray()));
            displayLog("   Terminal Transaction Qualifiers:" + getHexStringFromBytes(emv.getTerminalTransactionQualifiers().toByteArray()));
        }
        for (i = 0; i < response.getCapkTableCount(); i++) {
            CapkTable.CertificateAuthorityPublicKeyTable capk = response.getCapkTable(i);

            displayLog(" Index:" + capk.getIndex());
            displayLog(" Action:" + capk.getCardAction());
            displayLog("   RID:" + getHexStringFromBytes(capk.getRegisteredIdentifier().toByteArray()));
            displayLog("   Rsa Key Exponent:" + getHexStringFromBytes(capk.getRsaKeyExponent().toByteArray()));
            displayLog("   Rsa Key Modulus:" + getHexStringFromBytes(capk.getRsaKeyModulus().toByteArray()));
            displayLog("   Checksum:" + getHexStringFromBytes(capk.getChecksum().toByteArray()));
        }


        displayLog("Vers??o da Tabela de BIN:" + response.getBinParametersVersion());
        for (i = 0; i < response.getBinTableCount(); i++) {
            AcceptedBin.AcceptedBankIdentificationNumber bin = response.getBinTable(i);

            displayLog(" Index:" + bin.getIndex());
            displayLog(" Action:" + bin.getCardAction());
            displayLog("   Issuer Code:" + bin.getIssuerCode());
            displayLog("   Initial Range:" + bin.getInitialRange());
            displayLog("   Final Range:" + bin.getFinalRange());
            displayLog("   Total Sequential Transactions Allowed " + bin.getTotalSequentialTransactionsAllowed());
        }
    }

    /**
     * Inicializa a biblioteca e realiza a conex??o com o leitor Kioski IV.
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


                        String resultDatStr = Common.getHexStringFromBytes(idtmsrData.cardData);
                        String parsedTags = Util.getTransactionRegisterTags(resultDatStr);
                        Log.d(mTAG, "Parsed:" + parsedTags);
                        byte[] cardDataParsed = Common.hexStringToByteArray(parsedTags);

                        ValidadorInfo info = db.validadorInfoDAO().getInfo();
                        displayLog("Cart??o lido com sucesso.");

                        String res = device.device_getResponseCodeString(idtmsrData.result);
                        Log.d(mTAG, "res:" + res);

                        String detail = Common.parse_MSRData(Common.getDeviceType(), idtmsrData);
                        displayLog(String.format("%s\n%s\n", detail, res));

                        displayLog("Iniciando processo de valida????o.");

                        int valorTrn = info.valor;
                        String aux = Util.getValueByTag(idtmsrData, "9f02");
                        if (aux != null) valorTrn = Integer.parseInt(aux);


                        byte[] panHash = null;
                        aux = Util.getValueByTag(idtmsrData, "dfed4b");
                        if (aux != null) {
                            displayLog("Pan Hash encontrado.");
                            hashAvailable = true;
                            panHash = Common.getByteArray(aux);
                        }

                        ///*
                        //todo comentado para demonstra????o
                        if (!parAvailable && !hashAvailable) {
                            String errorMsg = "Transa????o Recusada: Tags DFED4B e 9F24 ausentes.";

                            aux = Util.getValueByTag(idtmsrData, "9f06");
                            if (aux != null) {
                                errorMsg += String.format("\nAid: %s", aux);
                            }
                            displayLog(errorMsg);

                            //sendTransactionStatus("Transa????o Recusada: Tags DFED4B e 9F24 ausentes.");
                            sendTransactionStatus(errorMsg);
                            return;
                        }
                        //*/

                        ///*
                        //todo comentado para demonstracao
                        int bin = 0;
                        aux = getValueByTag(idtmsrData, "5a");
                        if (aux != null) {
                            try {
                                bin = Integer.parseInt(aux.substring(0, 6));
                            } catch (Exception ex) {
                                bin = Integer.parseInt(aux.substring(0, 4)) * 100;
                            }
                        } else {
                            //displayLog("Transa????o Recusada: Tags 5A n??o encontrada.");
                            //sendTransactionStatus("Transa????o Recusada: Tags 5A n??o encontrada.");
                            //return;
                        }

                        //Passo 1: Valida????o do BIN.
                        Bin binDt = db.binDAO().checkBin(bin);
                        if (binDt == null) {
                            displayLog("Transa????o Recusada: BIN do cart??o n??o se encontra na faixa de BIN's cadastradas.");
                            sendTransactionStatus("Transa????o Recusada: BIN do cart??o n??o se encontra na faixa cadastrada.");
                            return;
                        } else {
                            displayLog("Bin do cart??o se encontra na faixa de BIN's cadastradas.");
                        }
                        //*/

                        //Passo 2:pulando valida????o PAR


                        //Passo 3: Valida????o do hashPAN
                        /*
                        //todo comentado para demonstra????o.
                        if (panHash != null) {
                            String strHashPan = Common.bytesToHex(panHash).substring(0, 24);
                            Pan pan = db.panDAO().checkPan(strHashPan.toUpperCase());
                            if (pan != null) {
                                if (pan.panAceito == 0) {
                                    displayLog(String.format("Transa????o Recusada: PAN %s presente na lista de PAN n??o aceitos.", strHashPan));
                                    sendTransactionStatus("Transa????o Recusada: PAN presente na lista de PAN n??o aceitos.");
                                    return;
                                } else {
                                    displayLog(String.format("Pan %s se encontra na lista de PAN aceitos.", strHashPan));

                                    //Passo 4: Valida????o de transa????es sequenciais
                                    if (info.panHashUlt != null) {
                                        if (info.panHashUlt.toUpperCase().equals(strHashPan.toUpperCase())) {
                                            if (binDt.qtdTranSeq == 0) {
                                                displayLog("Transa????o Recusada: transa????es sequenciais n??o s??o permitidas.");
                                                sendTransactionStatus("Transa????o Recusada: transa????es sequenciais n??o s??o permitidas.");
                                                return;
                                            } else {
                                                if (pan.panSeqNo > binDt.qtdTranSeq) {
                                                    displayLog("Transa????o Recusada: limite de transa????es sequenciais atingido.");
                                                    sendTransactionStatus("Transa????o Recusada: limite de transa????es sequenciais atingido.");
                                                    return;
                                                } else {
                                                    //incrementa o contador do pan
                                                    db.panDAO().updatePanSeqNum(pan.panSeqNo + 1, strHashPan.toUpperCase());
                                                    displayLog("Contador de transa????es sequenciais incrementado.");
                                                }
                                            }
                                        } else {
                                            //Passo 6.
                                            db.panDAO().updatePanSeqNum(0, strHashPan.toUpperCase());
                                            displayLog("Contador de transa????es zerado.");
                                        }
                                    }
                                }
                            } else {
                                //displayLog(String.format("Transa????o Recusada: PAN %s ausente na lista de PAN aceitos.", strHashPan));
                                //sendTransactionStatus("Transa????o Recusada: PAN ausente na lista de PAN aceitos.");
                                //return;
                            }
                        }
                        */

                        //Todo validar passo 5: Conferir data de validade
                        /*
                        aux = getValueByTag(idtmsrData, "9f06");
                        if (aux != null) {
                            ResDataStruct aidInfo = new ResDataStruct();
                            int ret = device.ctls_retrieveApplicationData(aux, aidInfo);

                        } else {
                            Log.d(mTAG, "Tag 9f06 [Aid] n??o encontrada.");
                            sb.append("Tag 9f06 [Aid] n??o encontrada.\n");
                            displayLog(sb.toString());
                        }
                         */

                        displayLog("Valida????o finalizada.");

                        db.validadorInfoDAO().updateNsu(++info.nsuValidador);

                        //monta o objeto para envio ao Axis baseado na leitura dos dados do cart??o.
                        final PassageRegister.RegisterPassageRequest request = PassageRegister.RegisterPassageRequest.newBuilder()
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
                                .setTransactionData(ByteString.copyFrom(cardDataParsed))
                                .setEmvParametersVersion(info.vrsPrmEMV)
                                .setBinParametersVersion(info.vrsPrmBIN)
                                .setRestrictionListVersion(info.vrsListaExc)
                                .setTransactionValue(valorTrn)
                                .setLineId(info.idLinha)
                                .setVehicleId(info.idVeiculo)
                                .setGeolocation(info.geoValidador)
                                .build();

                        PassageRegister.RegisterPassageResponse response;
                        SslContext sslContext;
                        ManagedChannel channel;
                        try {
                            sslContext = GrpcSslContexts.forClient().trustManager(context.getResources().openRawResource(R.raw.setis_edited)).build();
                            channel = NettyChannelBuilder.forAddress(axisHost, axisPort)
//                                    .sslContext(sslContext)
                                    .build();
                        } catch (IOException e) {
                            displayLog("Erro certificado invalido.");
                            //liveData.postValue("Erro certificado invalido.");
                            sendTransactionStatus("RECUSADA: certificado invalido.");
                            return;
                        }

                        try {
                            RegisterPassageServiceGrpc.RegisterPassageServiceBlockingStub stub = RegisterPassageServiceGrpc.newBlockingStub(channel);
                            response = stub.makeTransaction(request);

                            channel.shutdown();
                            displayLog("Resposta do servidor Grpc recebida.");
                            //servidor enviou resposta
                            if (response.getResponseCode() != 0) {
                                sendTransactionStatus("RECUSADA:" + response.getResponseCode());
                                displayLog(String.format("Servidor retornou codigo de resposta [%d]", response.getResponseCode()));
                                return;
                            }

                            displayLog("Vers??o da Tabela de BIN:" + response.getBinParametersVersion());
                            displayLog("Vers??o da Tabela EMV:" + response.getEmvParametersVersion());
                            displayLog("Vers??o da lista de restri????o:" + response.getRestrictionListVersion());
                            displayLog("NSU do validador:" + response.getDeviceSuid());
                            displayLog("NSU do gateway:" + response.getGatewayUid());

                            sendTransactionStatus("APROVADA");
                            //sendTransactionStatus("Registro da Passagem Aprovado!");

                            //executa som ao aprovar um cart??o mastercard.
                            aux = getValueByTag(idtmsrData, "9f06");
                            if (aux != null) {
                                //rid master
                                if (aux.contains("A000000004") || aux.contains("A000000861")) {
                                    mastercardSound.start();
                                }
                            }

                            db.validadorInfoDAO().updateLastPanHash(Common.bytesToHex(panHash).substring(0, 24));

                        } catch (io.grpc.StatusRuntimeException e) {
                            e.printStackTrace();
                            channel.shutdown();
                            displayLog("Erro gRPC [" + e.getStatus().getCode() + "] (" + e.getStatus().getDescription() + ")");
                            //liveData.postValue("Erro gRPC: " + e.getStatus().getCode());
                            sendTransactionStatus("RECUSADA: erro durante envio de dados ao servidor.");
                            return;
                        }
                        Log.d(mTAG, "fim do processo transacional.");
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
     * Libera a conex??o com o leitor Kioski IV.
     */
    public void releaseSDK() {
        if (device != null && device.device_pingDevice() == ErrorCode.SUCCESS) {
            device.ctls_cancelTransaction();
            device.unregisterListen();
            device.release();
        }
    }

    /**
     * Obtem a vers??o do firmware do leitor Kioski IV.
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

    public MutableLiveData<String> getSimulaData() {
        if (simulaData == null) {
            simulaData = new MutableLiveData<String>();
        }
        return simulaData;
    }

    public void clearLivedata() {
        liveData = new MutableLiveData<>();
        transactionLiveData = new MutableLiveData<>();
        simulaData = new MutableLiveData<>();
    }


    /**
     * O Validador deve utilizar esta transa????o para realizar o seu registro no
     * sistema da Axis Go Cloud e assim obter autoriza????o e receber os dados de
     * funcionamento, lista de cart??es negados e registro de passagem.
     */
    public void registrarValidador() {

        resetLog();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {

            ValidadorInfo info = db.validadorInfoDAO().getInfo();
            if (info == null) {
                info = new ValidadorInfo();

                info.idOperador = IdOperador;
                info.nsValidador = NsValidador;
                info.idLinha = IdLinha;
                info.idVeiculo = IdVeiculo;
                info.valor = Valor;
                info.geoValidador = Geolocalizacao;
            }

            db.validadorInfoDAO().deleteAll();

            info.nsLeitor = "041H101073";
            info.codRegistro = "01020304050607080900";
            info.panHashUlt = "E223A727677571549B395600";
            info.ksn = "1234567890";

            long millis = System.currentTimeMillis();
            Timestamp timestamp = Timestamp.newBuilder().setSeconds(millis / 1000).setNanos((int) ((millis % 1000) * 1000000)).build();

            final DeviceRegister.DeviceRegisterRequest request = DeviceRegister.DeviceRegisterRequest.newBuilder()
                    .setOperatorId(info.idOperador)
                    .setReaderSerialNumber(info.nsLeitor)
                    .setVehicleId(info.idVeiculo)
                    .setDeviceSerialNumber(info.nsValidador)
                    .setKsnData(ByteString.copyFromUtf8(info.ksn))
                    .setLineId(info.idLinha)
                    .setTransactionDate(timestamp)
                    .build();

            DeviceRegister.DeviceRegisterResponse response;

            SslContext sslContext;
            ManagedChannel channel;
            try {
                sslContext = GrpcSslContexts.forClient().trustManager(context.getResources().openRawResource(R.raw.setis_edited)).build();
                channel = NettyChannelBuilder.forAddress(axisHost, axisPort)
//                        .sslContext(sslContext)
                        .build();
            } catch (IOException e) {
                displayLog("Erro: certificado invalido.");
                liveData.postValue("Erro: certificado invalido.");
                return;
            }

            try {
                DeviceRegisterServiceGrpc.DeviceRegisterServiceBlockingStub stub = DeviceRegisterServiceGrpc.newBlockingStub(channel);
                response = stub.registerDevice(request);

                channel.shutdown();
                if (response.getResponseCode() != 0) {
                    sendTransactionStatus("Erro no Registro do Validador:" + response.getResponseCode());
                    displayLog(String.format("Servidor retornou codigo de resposta [%d]", response.getResponseCode()));
                    return;
                }

                displayLog("ID do Dispositivo:" + response.getDeviceId());
                displayLog("C??digo de registro:" + response.getRegisterCode());
                displayLog("Data de registro:" + response.getTransactionDate());

                info.idValidador = response.getDeviceId();
                info.nsuValidador = (int) timestamp.getSeconds();
                db.validadorInfoDAO().insertBaseValues(info);

                sendTransactionStatus("Registro do Dispositivo Aprovado!");

                liveData.postValue("Registro OK");
            } catch (StatusRuntimeException e) {
                e.printStackTrace();
                channel.shutdown();
                displayLog("Erro gRPC [" + e.getStatus().getCode() + "] (" + e.getStatus().getDescription() + ")");
                liveData.postValue("Erro gRPC: " + e.getStatus().getCode());
            }
        });
    }

    /**
     * M??todo utilizado para se obter ou atualizar os par??metros EMV e BINs aceitos
     */
    public void obterParametro() {
        resetLog();

        if (device != null && device.device_pingDevice() == ErrorCode.SUCCESS) {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.execute(() -> {
                ValidadorInfo info = db.validadorInfoDAO().getInfo();
                if (info == null || info.idValidador == null) {
                    displayLog("Erro: Realize o registro do validador.");
                    return;
                }

                int ret;

                if (!DEFAULT_TABS) {
                    ret = device.ctls_removeAllApplicationData();
                    displayLog(String.format("Removendo AID's: %s", device.device_getResponseCodeString(ret)));
                    if (ret != 0) return;

                    //Configura grupo
                    //String groupString = "FFE401329F02060000000001009F03060000000000009F1A0200765F2A0209865F3601029C01009F3501259F1B0400001F40FFF506000000001000DF812306000000008000DF812406000000030000DF8125060000000500009F150212349F400500000000009F09020002DF81170100DF81180160DF81190108DF811F0108FFFC0106FFFE050000000000FFFF050000000000FFFD0500000000009F1D086CFF000000000000FFF3020001DF2601009F5301522E9E";
                    String groupString = "FFE401089F02060000000000009F03060000000000009F1A0200765F2A0209865F3601029C01009F3501259F1B04000003E8FFF106000000010000FFF506000000003000DF812306000000001000DF812406000000010000DF8125060000000030009F150241319F400520000000019F09020002DF81170100DF81180100DF81190108DF811F0108FFFC0104FFFE05F850ACF800FFFF05FC00000000FFFD05FC50ACA0009F1D080C00800000000000DF2601019F5301589F33030008085F5701009F6D020001DF110100DF270100DF811A039F6A04DF811C020000DF811D0100DF811E0110DF812C0100FFF2083030303030303030";
                    String groupString2 = "FFE401009F02060000000000019F1A0200765F2A0209869F3501259F660421004000FFF5060000000030009F15024131FFF30202859F530158FFEE1D0506042A0C31DFED4801FF";
                    String groupVisa = "FFE401049F02060000000000009F03060000000000009F1A0200765F2A0209865F3601029C01009F3501259F660421004000FFF0030200009F1B0400000000FFF106000000010000FFF403000703FFF506000000003000DF812306000000000000";

                    ResDataStruct groupResData = new ResDataStruct();
                    ret = device.ctls_setConfigurationGroup(Common.getByteArray(groupString), groupResData);
                    displayLog(String.format("Criando Grupo: %s", device.device_getResponseCodeString(ret)));
                    if (ret != 0) return;

                    groupResData = new ResDataStruct();
                    ret = device.ctls_setConfigurationGroup(Common.getByteArray(groupString2), groupResData);
                    displayLog(String.format("Criando Grupo: %s", device.device_getResponseCodeString(ret)));
                    if (ret != 0) return;

                    groupResData = new ResDataStruct();
                    ret = device.ctls_setConfigurationGroup(Common.getByteArray(groupVisa), groupResData);
                    displayLog(String.format("Criando Grupo: %s", device.device_getResponseCodeString(ret)));
                    if (ret != 0) return;

                    //relaciona aid ao grupo recem criado.
                    String aidMaster = "FFE401329F0607A0000000041010FFE10101FFE50110FFE30114FFE903030032FFE60100";
                    String aidAxis = "FFE401089F0607A0000008611010FFE10101FFE50110FFE30174FFE903020008FFE20103FFEA0102";
                    String aidVisa = "FFE401049F0607A0000000031010FFE10101FFE50110FFE30114FFE903030004FFE60100";

                    ResDataStruct resData = new ResDataStruct();
                    ret = device.ctls_setApplicationData(Common.getByteArray(aidMaster), resData);
                    displayLog(String.format("Criando AID: %s", device.device_getResponseCodeString(ret)));

                    resData = new ResDataStruct();
                    ret = device.ctls_setApplicationData(Common.getByteArray(aidAxis), resData);
                    displayLog(String.format("Criando AID: %s", device.device_getResponseCodeString(ret)));

                    resData = new ResDataStruct();
                    ret = device.ctls_setApplicationData(Common.getByteArray(aidVisa), resData);
                    displayLog(String.format("Criando AID: %s", device.device_getResponseCodeString(ret)));

                    if (ret == ErrorCode.SUCCESS && resData.statusCode == 0x00) {
                        db.validadorInfoDAO().updateVersionEmv(1);
                        displayLog("Tabelas AID atualizadas. Vers??o: 1");
                    } else {
                        displayLog("Erro na atualiza????o de tabelas. Verifique os logs.");
                    }


                    //ResDataStruct aidInfo = new ResDataStruct();
                    //ret = device.ctls_retrieveApplicationData("A0000000041010", aidInfo);

                    //Configura????o de CAPK
                    String capkMaster1 = "A000000004050101EBFA0D5D06D8CE702DA3EAE890701D45E274C8450000000300B0B8048ABC30C90D976336543E3FD7091C8FE4800DF820ED55E7E94813ED00555B573FECA3D84AF6131A651D66CFF4284FB13B635EDD0EE40176D8BF04B7FD1C7BACF9AC7327DFAA8AA72D10DB3B8E70B2DDD811CB4196525EA386ACC33C0D9D4575916469C4E4F53E8E1C912CC618CB22DDE7C3568E90022E6BBA770202E4522A2DD623D180E215BD1D1507FE3DC90CA310D27B3EFCCD8F83DE3052CAD1E48938C68D095AAC91B5F37E28BB49EC7ED597";
                    String capkMaster2 = "A000000004060101F910A1504D5FFB793D94F3B500765E1ABCAD72D90000000300F8CB26FC830B43785B2BCE37C81ED334622F9622F4C89AAE641046B2353433883F307FB7C974162DA72F7A4EC75D9D657336865B8D3023D3D645667625C9A07A6B7A137CF0C64198AE38FC238006FB2603F41F4F3BB9DA1347270F2F5D8C606E420958C5F7D50A71DE30142F70DE468889B5E3A08695B938A50FC980393A9CBCE44AD2D64F630BB33AD3F5F5FD495D31F37818C1D94071342E07F1BEC2194F6035BA5DED3936500EB82DFDA6E8AFB655B1EF3D0D7EBF86B66DD9F29F6B1D324FE8B26CE38AB2013DD13F611E7A594D675C4432350EA244CC34F3873CBA06592987A1D7E852ADC22EF5A2EE28132031E48F74037E3B34AB747F";
                    String capkMaster3 = "A0000000040901011D90595C2EF9FC6E71B0C721118333DF8A71FE21000000030060967B6264436C96AA9305776A5919C70DA796340F9997A6C6EF7BEF1D4DBF9CB4289FB7990ABFF1F3AE692F12844B2452A50AE075FB327976A40E8028F279B1E3CCB623957D696FC1225CA2EC950E2D415E9AA931FF18B13168D661FBD06F0ABB ";
                    String capkAxis = "A000000861FF010120A86FF00F00E9ED15DF4E83D6FEACDA076DD6290000000300F88CA018522F99BB3552544D66E2886F978F7AB5065A80545FCAB1584A50E31CB6302FAD7EEDB6A6A71315E51D4C21D8A9AA8799305B8124226A8F26C2847FA9798944C983FC7342688AAC11ED1842AACEAF9624DD38FFE983360C95FE966ACE97223DFCDEED66B25A0C8283381BAE2D5B5F72BDBB4119DE355BE24AD8ADCF3B18C5EF2682932FDDA7BB519DBFAFE09CA59A9B724CC27283D5075886B9FA9B30E183B44D1455F186E183F6AF1DCEDF9B6879C19542B9914921E262B8552CF8E65708934ECCD4AC23FED32B4E7D1A6190EB85D819DFF9F976C30330C829AE6CEDBCCAFC292D9F3E2E92EA046597AB482760E0B8A345C4A7EB21";
                    String capkVisa1 = "A00000000308010120D213126955DE205ADC2FD2822BD22DE21CF9A80000000300B0D9FD6ED75D51D0E30664BD157023EAA1FFA871E4DA65672B863D255E81E137A51DE4F72BCC9E44ACE12127F87E263D3AF9DD9CF35CA4A7B01E907000BA85D24954C2FCA3074825DDD4C0C8F186CB020F683E02F2DEAD3969133F06F7845166ACEB57CA0FC2603445469811D293BFEFBAFAB57631B3DD91E796BF850A25012F1AE38F05AA5C4D6D03B1DC2E568612785938BBC9B3CD3A910C1DA55A5A9218ACE0F7A21287752682F15832A678D6E1ED0B";
                    String capkVisa2 = "A0000000030901011FF80A40173F52D7D27E0F26A146A1C8CCB290460000000300F89D912248DE0A4E39C1A7DDE3F6D2588992C1A4095AFBD1824D1BA74847F2BC4926D2EFD904B4B54954CD189A54C5D1179654F8F9B0D2AB5F0357EB642FEDA95D3912C6576945FAB897E7062CAA44A4AA06B8FE6E3DBA18AF6AE3738E30429EE9BE03427C9D64F695FA8CAB4BFE376853EA34AD1D76BFCAD15908C077FFE6DC5521ECEF5D278A96E26F57359FFAEDA19434B937F1AD999DC5C41EB11935B44C18100E857F431A4A5A6BB65114F174C2D7B59FDF237D6BB1DD0916E644D709DED56481477C75D95CDD68254615F7740EC07F330AC5D67BCD75BF23D28A140826C026DBDE971A37CD3EF9B8DF644AC385010501EFC6509D7A41";
                    ret = device.ctls_removeAllCAPK();
                    displayLog(String.format("Removendo CAPK's: %s", device.device_getResponseCodeString(ret)));

                    byte[] capk_b = Common.getByteArray(capkMaster1);
                    ResDataStruct resCapk = new ResDataStruct();
                    ret = device.ctls_setCAPK(capk_b, resCapk);
                    displayLog(String.format("Criando CAPK: %s", device.device_getResponseCodeString(ret)));

                    resCapk = new ResDataStruct();
                    ret = device.ctls_setCAPK(Common.getByteArray(capkMaster2), resCapk);
                    displayLog(String.format("Criando CAPK: %s", device.device_getResponseCodeString(ret)));

                    resCapk = new ResDataStruct();
                    ret = device.ctls_setCAPK(Common.getByteArray(capkMaster3), resCapk);
                    displayLog(String.format("Criando CAPK: %s", device.device_getResponseCodeString(ret)));

                    resCapk = new ResDataStruct();
                    ret = device.ctls_setCAPK(Common.getByteArray(capkAxis), resCapk);
                    displayLog(String.format("Criando CAPK: %s", device.device_getResponseCodeString(ret)));

                    resCapk = new ResDataStruct();
                    ret = device.ctls_setCAPK(Common.getByteArray(capkVisa1), resCapk);
                    displayLog(String.format("Criando CAPK: %s", device.device_getResponseCodeString(ret)));

                    resCapk = new ResDataStruct();
                    ret = device.ctls_setCAPK(Common.getByteArray(capkVisa2), resCapk);
                    displayLog(String.format("Criando CAPK: %s", device.device_getResponseCodeString(ret)));

                } else {
                    //utiliza as tabelas default do leitor.
                    ResDataStruct res = new ResDataStruct();
                    ret = device.device_sendDataCommand("0409", false, null, res);
                    displayLog("Utilizando configura????es padr??o do leitor.");
                }

                //Configura????o de BIN
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

                displayLog("Tabela de BINs atualizada. Vers??o 1.");

                DeviceParameters.ParametersRequest request = DeviceParameters.ParametersRequest.newBuilder()
                        .setBinParametersVersion(info.vrsPrmBIN)
                        .setEmvParametersVersion(info.vrsPrmEMV)
                        .setDeviceId(info.idValidador)
                        .setOperatorId(info.idOperador)
                        .setDeviceSerialNumber(info.nsValidador)
                        .setKsnData(ByteString.copyFromUtf8(info.ksn))
                        .setLineId(info.idLinha)
                        .setReaderSerialNumber(info.nsLeitor)
                        .setRegisterCode(12345)
                        .setTransactionDate(getTimestamp())
                        .setVehicleId(info.idVeiculo)
                        .build();

                DeviceParameters.ParametersResponse response;
                SslContext sslContext;
                ManagedChannel channel;

                try {
                    sslContext = GrpcSslContexts.forClient().trustManager(context.getResources().openRawResource(R.raw.setis_edited)).build();
                    channel = NettyChannelBuilder.forAddress(axisHost, axisPort)
//                                .sslContext(sslContext)
                            .build();
                } catch (IOException e) {
                    displayLog("Erro: certificado invalido.");
                    liveData.postValue("Erro: certificado invalido.");
                    return;
                }

                try {
                    DeviceParametersServiceGrpc.DeviceParametersServiceBlockingStub stub = DeviceParametersServiceGrpc.newBlockingStub(channel);
                    response = stub.getDeviceParameters(request);

                    channel.shutdown();
                    if (response.getResponseCode() != 0) {
                        sendTransactionStatus("Erro no Registro da Passagem:" + response.getResponseCode());
                        displayLog(String.format("Servidor retornou codigo de resposta [%d]", response.getResponseCode()));
                        return;
                    }
                    logDeviceParameters(response);
                } catch (StatusRuntimeException e) {
                    e.printStackTrace();
                    channel.shutdown();
                    displayLog("Erro gRPC [" + e.getStatus().getCode() + "] (" + e.getStatus().getDescription() + ")");
                    liveData.postValue("Erro gRPC: " + e.getStatus().getCode());
                }
            });
        } else {
            displayLog("Erro: Leitor nao encontrado.");
        }
    }

    /**
     * M??todo utilizado para se obter ou atualizar a lista de PANs e PAR que n??o devem
     * ser aceitos.
     */
    public void obterListaExcecao() {
        /**
         * Nesta demonstra????o, iremos utilizar valores pre-fixados (N??o haver?? requisi????o
         * a Axis Go Cloud).
         * Nesta demonstra????o, iremos trabalhar apenas com tabelas de PAN's.
         * */
        resetLog();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            ValidadorInfo info = db.validadorInfoDAO().getInfo();
            if (info == null || info.idValidador == null) {
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
            displayLog("Inserindo PAN na lista de exce????o.");

            Pan pan2 = new Pan();
            pan2.id = 2;
            pan2.dataInclusao = 201202;
            pan2.motivo = "1";
            pan2.panHash = "9FD72062ABC7E4809FA23384";
            pan2.panSeqNo = 2;
            pan2.panAceito = 0;
            db.panDAO().insertPan(pan2);
            displayLog("Inserindo PAN na lista de exce????o.");

            db.validadorInfoDAO().updateVersionListaExc(1);
            displayLog("Lista de Exce????o configurada com sucesso. Vers??o: 1");
        });
    }

    /**
     * Esta transa????o deve ser utilizada pelo Validador para realizar o registro de uma
     * passagem.
     */
    public void registrarPassagem() {
        Log.d(mTAG, "metodo registrar passagem chamado.");
        resetLog();
        if (device == null) {
            Log.d(mTAG, "reconectando ao leitor.");
            reconectarLeitor();
        }

        if (device != null && device.device_pingDevice() == ErrorCode.SUCCESS) {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.execute(() -> {
                ValidadorInfo info = db.validadorInfoDAO().getInfo();
                if (info == null || info.idValidador == null) {
                    displayLog("Erro: Realize o registro do validador.");
                    return;
                }

                displayLog("Aproxime um cart??o CTLS.");
                byte[] tags = null;
                double amount = info.valor/100d;
                int res = device.ctls_startTransaction(amount, 0.00, 0, 255, tags);

                Log.d(mTAG, "Iniciando transa????o:" + device.device_getResponseCodeString(res));
            });
        } else {
            displayLog("Erro: Leitor nao encontrado.");
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
     * Esta transa????o deve ser utilizada pelo Validador para solicitar a remo????o de um
     * cart??o das tabelas de cart??o n??o aceito da lista de exce????o.
     */
    public void recuperarDebito() {
        resetLog();

        /*
        String aux = "A0000000041010";
        if (aux != null) {
            //rid master
            if (aux.contains("A000000004")) {
                mastercardSound.start();
            }
        }
         */

        if (device != null && device.device_pingDevice() == ErrorCode.SUCCESS) {
            checkAid();
            //deleteAllAid();
        } else {
            displayLog("Erro: Leitor nao encontrado.");
        }
    }

    public boolean verificaRegistro() {
        ValidadorInfo info = db.validadorInfoDAO().getInfo();
        if (info == null || info.idValidador == null) {
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

    public void displayLog(final String log) {
        Log.d(mTAG, log);
        dspLogs.append(log).append("\n");
        handler.post(new Runnable() {
            @Override
            public void run() {
                liveData.setValue(dspLogs.toString());
            }
        });
    }

    private void sendTransactionStatus(final String status) {
        handler.post(() -> {
            if (transactionLiveData == null) {
                transactionLiveData = new MutableLiveData<String>();
            }
            transactionLiveData.setValue(status);
        });
    }

    public void cancelTransaction() {
        device.ctls_cancelTransaction();
    }

    /*
     * Envia dados simulados ao ambiente. N??o deve ser utilizado em produ????o.
     * */
    public void commTest() {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {

            ValidadorInfo info = db.validadorInfoDAO().getInfo();
            if (info == null || info.idValidador == null) {
                displayLog("Erro: Realize o registro do validador.");
                return;
            }

            byte[] panHash = {(byte) 0xe2, (byte) 0x23, (byte) 0xa7, 0x67, 0x75, 0x71, 0x54, (byte) 0x9b,
                    0x39, 0x56, 0x00};

            //byte[] resData = hexStringToByteArray("5669564f746563683200020a01b7c1ffee120a629949009900042000fbffee1f0455900009500c56495341204352454449544f57a113415275cccccc1117d2411201cccccccccccccc57c118dfa65220cb98aafb58c7459fa8968f98a898cac8fb6d8d3e5aa108415275cccccc11175ac1103dfab28878512b777632bac52dc4c1268407a00000000310105f24032411305f2a0209865f34010082022000950500000000009a032107199c01009f02060000000001009f0607a00000000310109f0702ff009f090200029f0e052010a800009f0f05986854f8009f100706010a03a028009f1a0200769f21031442299f260827603745205709149f2701809f360200259f3704a85ed1d79f5d060000000000009f3901079f6c0228405f2d0870746573656e66729f1101019f120c56495341204352454449544f9f03060000000000009f3501259f33030008e89f400560000030009f34033f0001ffee010cdf520100df300100df5b0108dfef7f01009f6604218040009f1e0838333654303835315f280200769f410400000345dfed4b206eb357f9602e1cac7efaa6b10f25248f11102b342815f8c1ed022e051780bba4dfed5d0a415275be7a8777101117dfee2601c17582");

            String resultDatStr = "5669564F7465636832000223027FC1FFEE120A629949009900042000F19F3901078E0E000000000000000002031E031F035F25032104125F280200765F2D067074656E65739F0607A00000086110109F0D05B4508400049F0E0500000000009F0F05B4708480049F21031341089F420209869F6D0200019F6E0700760000303000DFEE7605000000000EDF830701029F40052000000001DF8116161E040000007074656E65730000000000000000000000DF81290830F0F000B0F0FF00FF810628DF8115060000000000FF9F42020986DF810B0100DF810E0100DF810F01009F6E0700760000303000FF8105820106" +
                    "9F0206" + String.format(Locale.getDefault(), "%012d", info.valor) +
                    "9F03060000000000009F26089661B8CCEAA287EE5F2403270430820219815004415849535AA108250045CCCCCC95005AC1106F927B891CE0EB7F82264BBF8B1D77415F3401009F1204415849539F3602002B9F0702FF009F090200028407A00000086110109F1E0830303030303030309F1101019F2701809F34031F03029F10120110A04001220000000000000000000000FF9F33030008089F1A0200769F3501259505000000000E57A113250045CCCCCC9500D2704201CCCCCCCCCCCCCC57C118B7333D472BE5ACA3CF96369D7547C1C06D08C9C9395E0C649F5301585F2A0209869A032107169C01009F3704AA42729EDF830602003D9F15024131DF8116161B000000007074656E657300000000000000000000009F420209865F280200769F410400000323DFED4B20CA47911725281961235835EBB6825851B839BCE0B9A76860E48154F78CE42961DFED5D0A605547A367E00B809500DFEE2601C1DFEF4C06002700000000DFEF4D28C973D699DCDBDEDBEB509D4514119FE612458FB181A507C032E701F67FD50A7DD7D5C2D4CEDA9DBF0706";
            byte[] resData = hexStringToByteArray(resultDatStr);

            String ff = Util.getTransactionRegisterTags(resultDatStr);
            Log.d(mTAG, "res:" + ff);

            byte[] transactionData2 = hexStringToByteArray(ff);

            db.validadorInfoDAO().updateNsu(++info.nsuValidador);

/*
        IDTMSRData ddt = new IDTMSRData();
        Common.parseCardData3in1(resData, ddt);
        String res2 = Common.getHexStringFromBytes(ddt.cardData);
        */

            final PassageRegister.RegisterPassageRequest request = PassageRegister.RegisterPassageRequest.newBuilder()
                    .setDeviceId(info.idValidador)
                    .setVehicleId(info.idVeiculo)
                    .setLineId(info.idLinha)
                    .setRestrictionListVersion(info.vrsListaExc)
                    .setTransactionDate(getTimestamp())
                    .setRegisterCode(0)
                    .setAcceptanceListVersion(info.vrsListaExc)
                    .setBinParametersVersion(info.vrsPrmBIN)
                    .setTransactionValue(info.valor)
                    .setDeviceSerialNumber(info.nsValidador)
                    .setTransactionData(ByteString.copyFrom(transactionData2))
                    .setOperatorId(info.idOperador)
                    .setReaderSerialNumber(info.nsLeitor)
                    .setPassageDate(getTimestamp())
                    .setDeviceSuid(Integer.toString(info.nsuValidador))
                    //.setPanHash(ByteString.copyFrom(panHash))
                    //.setParCard()
                    .setEmvParametersVersion(info.vrsPrmEMV)
                    .setGeolocation(info.geoValidador)
                    .build();

            PassageRegister.RegisterPassageResponse response;

            SslContext sslContext;
            ManagedChannel channel;

            try {
                sslContext = GrpcSslContexts.forClient().trustManager(context.getResources().openRawResource(R.raw.setis_edited)).build();
                channel = NettyChannelBuilder.forAddress(axisHost, axisPort)
//                    .sslContext(sslContext)
                        .build();
            } catch (IOException e) {
                displayLog("Erro: n??o conseguiu carregar o arquivo .pem");
                return;
            }

            try {
                RegisterPassageServiceGrpc.RegisterPassageServiceBlockingStub stub = RegisterPassageServiceGrpc.newBlockingStub(channel);
                response = stub.makeTransaction(request);
                channel.shutdown();
                if (response.getResponseCode() != 0) {
                    sendTransactionStatus("Erro no Registro da Passagem:" + response.getResponseCode());
                    displayLog(String.format("Servidor retornou codigo de resposta [%d]", response.getResponseCode()));
                    return;
                }
                liveData.setValue(String.format("Teste Ok [%d]", response.getResponseCode()));
            } catch (StatusRuntimeException e) {
                e.printStackTrace();
                displayLog("Erro gRPC [" + e.getStatus().getCode() + "] (" + e.getStatus().getDescription() + ")");
                liveData.postValue("Erro gRPC: " + e.getStatus().getCode());
                channel.shutdown();
            }
        });
    }

    private static class NetworkTaggingExecutor extends ThreadPoolExecutor {

        private final int trafficStatsTag;

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
