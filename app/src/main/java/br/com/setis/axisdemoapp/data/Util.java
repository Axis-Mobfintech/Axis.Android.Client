package br.com.setis.axisdemoapp.data;

import android.content.Context;
import android.util.Log;

import com.google.protobuf.Timestamp;
import com.idtechproducts.device.Common;
import com.idtechproducts.device.IDTMSRData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import br.com.setis.axisdemoapp.R;

import static android.content.Context.MODE_PRIVATE;

public class Util {

    public static String getXMLFileFromRaw(Context context) {
        //the target filename in the application path
        String fileName = "idt_unimagcfg_default.xml";

        try{
            InputStream in = context.getResources().openRawResource(R.raw.idt_unimagcfg_default);
            int length = in.available();
            byte [] buffer = new byte[length];
            in.read(buffer);
            in.close();
            context.deleteFile(fileName);
            FileOutputStream fout = context.openFileOutput(fileName, MODE_PRIVATE);
            fout.write(buffer);
            fout.close();

            // to refer to the application path
            File fileDir = context.getFilesDir();
            fileName = fileDir.getParent() + java.io.File.separator + fileDir.getName();
            fileName = fileName+java.io.File.separator+"idt_unimagcfg_default.xml";

        } catch(Exception e){
            e.printStackTrace();
            fileName = null;
        }
        return   fileName;
    }

    public static Timestamp getTimestamp() {
        long millis = System.currentTimeMillis();
        Timestamp timestamp = Timestamp.newBuilder().setSeconds(millis / 1000)
                .setNanos((int) ((millis % 1000) * 1000000)).build();
        return timestamp;
    }

    /**
     * Retorna o valor da tag alvo, se encontrada.
     * */
    public static String getValueByTag(IDTMSRData data, String tag) {
        String dt = Common.parse_MSRData(Common.getDeviceType(), data);

        String[] parts = dt.split("unencrypted tags:\r\n");
        if (parts.length > 1) {
            String[] tags = parts[1].split("\r\n");
            for (String tg : tags){
                if (tg.toUpperCase().contains(tag.toUpperCase()+":")) {
                    String[] vl = tg.split(":");
                    return vl[1].trim();
                }
            }
        }
        return null;
    }

    public static List<String> getAidValues(String tagList) {
        ArrayList<String> list = new ArrayList<>();
        String[] aux = tagList.split("9F06");
        String aid;
        int len;
        int i = 0;
        for (String part: aux) {
            if (i == 0) {
                i++;
                continue;
            }


            len = Integer.parseInt(part.substring(0, 2), 16);
            aid = part.substring(0, len*2+2);
            list.add("9f06"+aid);
        }
        return list;
    }

    /*
    * Retorna a String contendo os objetos TLV interessantes ao registro de transa??o.
    * */
    public static String getTransactionRegisterTags(String input) {
        StringBuilder sb = new StringBuilder();
        input = input.toUpperCase();

        //jeito mais simples.
        addToken(input, "FFEE120A", 10, sb);
        addToken(input, "DFED4B20", 32, sb);
        addToken(input, "5AA108", 8, sb);
        addToken(input, "5AC110", 16, sb);
        addToken(input, "9A03", 3, sb);
        addToken(input, "57C118", 24, sb);
        addToken(input, "8202", 2, sb);
        addToken(input, "9505", 5, sb);
        addToken(input, "9F0206", 6, sb);
        addToken(input, "9F2103", 3, sb);
        addToken(input, "5F2403", 3, sb);
        addToken(input, "9F2608", 8, sb);
        addToken(input, "9F2701", 1, sb);
        addToken(input, "9F3602", 2, sb);
        addToken(input, "9F3403", 3, sb);
        addToken(input, "9F3704", 4, sb);
        addToken(input, "5F3401", 1, sb);
        addToken(input, "9F10", 0, sb);
        addToken(input, "9F06", 0, sb);
        //9F24 - sem PAR, por enquanto.
        return sb.toString();
    }

    /*
    *
    * Obs: Utilizar len = 0, quando o tamanho do campo ? variavel.
    * */
    private static void addToken(String input, String what, int len, StringBuilder sb) {
        //transforma objeto tlv 5a para dfff20
        if (what.equals("5AA108")) {
            int s = input.indexOf(what) + 6;
            int e = s + len*2;
            String b = input.substring(s, e);
            b = "DFFF2008" + b;
            sb.append(b);
        }

        //copia o objeto tlv
        else if (input.contains(what)) {
            if (len == 0) {
                int s = input.indexOf(what);
                int e = s + what.length() + 2;
                String b = input.substring(s, e);
                String ll = b.substring(b.length()-2, b.length());
                int llen = Integer.parseInt(ll, 16) * 2;
                e = e + llen;
                b = input.substring(s, e);
                sb.append(b);
            } else {
                int s = input.indexOf(what);
                int e = s + what.length() + len*2;
                String b = input.substring(s, e);
                sb.append(b);
            }
        }
    }

}
