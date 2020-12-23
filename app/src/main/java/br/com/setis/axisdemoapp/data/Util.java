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

}
