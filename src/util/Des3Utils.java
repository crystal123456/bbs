package util;

import java.io.PrintStream;
import java.security.SecureRandom;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Des3Utils
{

    public Des3Utils(String sharekey)
    {
        try
        {
            byte keyBytes[] = {
                124, -75, -14, 52, 109, 47, 109, 117, 14, 122, 
                -56, 37, 4, -89, 41, 47, -36, -98, 82, 91, 
                -125, 70, 109, 14
            };
            key = new SecretKeySpec(keyBytes, "DESede");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void getKey(String strKey)
    {
        try
        {
            KeyGenerator _generator = KeyGenerator.getInstance("DESede");
            _generator.init(168, new SecureRandom(strKey.getBytes()));
            key = _generator.generateKey();
            _generator = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public String getEncString(String strMing)
    {
        String strMi;
        BASE64Encoder base64en;
        byte byteMi[] = (byte[])null;
        byte byteMing[] = (byte[])null;
        strMi = "";
        base64en = new BASE64Encoder();
        try
        {
            byte byteMing[] = strMing.getBytes("UTF8");
            byte byteMi[] = getEncCode(byteMing);
            strMi = base64en.encode(byteMi);
            break MISSING_BLOCK_LABEL_88;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        base64en = null;
        byte byteMing[] = (byte[])null;
        byte byteMi[] = (byte[])null;
        break MISSING_BLOCK_LABEL_101;
        Exception exception;
        exception;
        base64en = null;
        byte byteMing[] = (byte[])null;
        byte byteMi[] = (byte[])null;
        throw exception;
        base64en = null;
        byte byteMing[] = (byte[])null;
        byte byteMi[] = (byte[])null;
        return strMi;
    }

    public String getDesString(String strMi)
    {
        BASE64Decoder base64De;
        String strMing;
        base64De = new BASE64Decoder();
        byte byteMing[] = (byte[])null;
        byte byteMi[] = (byte[])null;
        strMing = "";
        try
        {
            byte byteMi[] = base64De.decodeBuffer(strMi);
            byte byteMing[] = getDesCode(byteMi);
            strMing = new String(byteMing, "UTF8");
            break MISSING_BLOCK_LABEL_93;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        base64De = null;
        byte byteMing[] = (byte[])null;
        byte byteMi[] = (byte[])null;
        break MISSING_BLOCK_LABEL_106;
        Exception exception;
        exception;
        base64De = null;
        byte byteMing[] = (byte[])null;
        byte byteMi[] = (byte[])null;
        throw exception;
        base64De = null;
        byte byteMing[] = (byte[])null;
        byte byteMi[] = (byte[])null;
        return strMing;
    }

    private byte[] getEncCode(byte byteS[])
    {
        byte byteFina[] = (byte[])null;
        Cipher cipher;
        try
        {
            cipher = Cipher.getInstance("DESede");
            cipher.init(1, key);
            byteFina = cipher.doFinal(byteS);
            break MISSING_BLOCK_LABEL_48;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        cipher = null;
        break MISSING_BLOCK_LABEL_50;
        Exception exception;
        exception;
        cipher = null;
        throw exception;
        cipher = null;
        return byteFina;
    }

    private byte[] getDesCode(byte byteD[])
    {
        byte byteFina[] = (byte[])null;
        Cipher cipher;
        try
        {
            cipher = Cipher.getInstance("DESede");
            cipher.init(2, key);
            byteFina = cipher.doFinal(byteD);
            break MISSING_BLOCK_LABEL_48;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        cipher = null;
        break MISSING_BLOCK_LABEL_50;
        Exception exception;
        exception;
        cipher = null;
        throw exception;
        cipher = null;
        return byteFina;
    }

    public static String byte2hex(byte b[])
    {
        String hs = "";
        String stmp = "";
        for(int n = 0; n < b.length; n++)
        {
            stmp = Integer.toHexString(b[n] & 255);
            if(stmp.length() == 1)
                hs = (new StringBuilder(String.valueOf(hs))).append("0").append(stmp).toString();
            else
                hs = (new StringBuilder(String.valueOf(hs))).append(stmp).toString();
        }

        return hs.toUpperCase();
    }

    public static byte[] hex2byte(byte b[])
    {
        if(b.length % 2 != 0)
            throw new IllegalArgumentException("\u957F\u5EA6\u4E0D\u662F\u5076\u6570");
        byte b2[] = new byte[b.length / 2];
        for(int n = 0; n < b.length; n += 2)
        {
            String item = new String(b, n, 2);
            b2[n / 2] = (byte)Integer.parseInt(item, 16);
        }

        return b2;
    }

    public static void main(String args[])
    {
        Des3Util des = new Des3Util("gmac_saic20111013");
        String strEnc = des.getEncString("Abc123**(");
        System.out.println(strEnc);
        String strDes = des.getDesString("b1K0Un8AGdNvQA7hlWGwVg==");
        System.out.println(strDes);
    }

    private SecretKey key;
}
