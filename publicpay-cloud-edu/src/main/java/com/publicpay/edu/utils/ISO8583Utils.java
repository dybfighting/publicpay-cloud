package com.publicpay.edu.utils;



import java.text.DecimalFormat;
import java.util.BitSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ISO8583Utils
{

    public ISO8583Utils()
    {
    }
    
    public static byte[] bitSet2ByteArray(BitSet bitSet) {
		byte[] bytes = new byte[bitSet.size() / 8];
		for (int i = 0; i < bitSet.size(); i++) {
			int index = i / 8;
			int offset = 7 - i % 8;
			bytes[index] |= (bitSet.get(i) ? 1 : 0) << offset;
		}
		return bytes;
	}
    
    public static String int2char2(int val)
    {
        DecimalFormat fmt = new DecimalFormat("00");
        if(val < 0 || val > 99)
            return null;
        else
            return fmt.format(val);
    }

    public static String int2char3(int val)
    {
        DecimalFormat fmt = new DecimalFormat("000");
        if(val < 0 || val > 999)
            return null;
        else
            return fmt.format(val);
    }

    public static String int2char4(int val)
    {
        DecimalFormat fmt = new DecimalFormat("0000");
        if(val < 0 || val > 9999)
            return null;
        else
            return fmt.format(val);
    }

    public static String StringFillLeftZero(String str, int len)
    {
        if(str.length() < len)
        {
            StringBuffer sb = new StringBuffer(len);
            for(int i = 0; i < len - str.length(); i++)
                sb.append('0');

            sb.append(str);
            return new String(sb);
        } else
        {
            return str;
        }
    }

    public static String StringFillRightZero(String str, int len)
    {
        if(str.length() < len)
        {
            StringBuffer sb = new StringBuffer(len);
            sb.append(str);
            for(int i = 0; i < len - str.length(); i++)
                sb.append('0');

            return new String(sb);
        } else
        {
            return str;
        }
    }

    public static String StringFillRightBlank(String str, int len)
    {
        if(str.length() < len)
        {
            StringBuffer sb = new StringBuffer(len);
            sb.append(str);
            for(int i = 0; i < len - str.length(); i++)
                sb.append('0');

            return new String(sb);
        } else
        {
            return str;
        }
    }

    public static String StringFillRightBlankReal(String str, int len)
    {
        if(str.getBytes().length < len)
        {
            StringBuffer sb = new StringBuffer(len);
            sb.append(str);
            for(int i = 0; i < len - str.getBytes().length; i++)
                sb.append(' ');

            return new String(sb);
        } else
        {
            return str;
        }
    }

    public static String RemoveRightBlank(String str)
    {
        if(str == null)
            return null;
        for(int index = 0; (index = str.lastIndexOf(" ")) != -1 && index + 1 == str.length(); str = str.substring(0, index));
        return str;
    }

    public static String bcd2String(byte bytes[], boolean deleteflag)
    {
        StringBuffer sb = new StringBuffer(bytes.length * 2);
        for(int i = 0; i < bytes.length; i++)
            sb.append((byte)((bytes[i] & 240) >>> 4)).append((byte)(bytes[i] & 15));

        return deleteflag ? sb.substring(1) : sb.toString();
    }

    public static byte[] string2Bcd(String str)
    {
        String s = str.toUpperCase();
        if(s.length() % 2 != 0)
            s = (new StringBuilder()).append("0").append(s).toString();
        byte buffer[] = new byte[s.length() / 2];
        for(int i = 0; i < buffer.length; i++)
        {
            char c1 = s.charAt(2 * i);
            int i1;
            if(c1 - 65 >= 0)
                i1 = (c1 - 65) + 10;
            else
                i1 = c1 - 48;
            char c2 = s.charAt(2 * i + 1);
            int i2;
            if(c2 - 65 >= 0)
                i2 = (c2 - 65) + 10;
            else
                i2 = c2 - 48;
            buffer[i] = (byte)(i1 * 16 + i2);
        }

        return buffer;
    }

    public static byte[] getAsciiBytes(String input)
    {
        char c[] = input.toCharArray();
        byte b[] = new byte[c.length];
        for(int i = 0; i < c.length; i++)
            b[i] = (byte)(c[i] & 127);

        return b;
    }

    public static BitSet getBitMap(byte bitmap[], int len)
    {
        if(bitmap == null)
            return null;
        BitSet bs = new BitSet(129);
        for(int i = 0; i < len * 8; i++)
            if((bitmap[i / 8] & 128 >>> i % 8) != 0)
                bs.set(i + 1, true);

        return bs;
    }

    public static String Byte2Hex(byte bs[], int len)
    {
        return Byte2Hex(bs, 0, len);
    }

    public static String Byte2Hex(byte bs[], int offset, int len)
    {
        StringBuffer sb = new StringBuffer();
        for(int i = offset; i < offset + len; i++)
        {
            byte hi = (byte)(bs[i] >> 4 & 15);
            byte lo = (byte)(bs[i] & 15);
            hi = hi >= 10 ? (byte)((hi - 10) + 65) : (byte)(hi + 48);
            lo = lo >= 10 ? (byte)((lo - 10) + 65) : (byte)(lo + 48);
            sb.append((char)hi);
            sb.append((char)lo);
        }

        return new String(sb);
    }

    public static boolean isValidDecString(String str)
    {
        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if(ch < '0' || ch > '9')
                return false;
        }

        return true;
    }

    public static String toHexString(String s)
    {
        String str = "";
        for(int i = 0; i < s.length(); i++)
        {
            int ch = s.charAt(i);
            String s4 = Integer.toHexString(ch);
            str = (new StringBuilder()).append(str).append(s4).toString();
        }

        return str;
    }

    public static String bytesToHexString(byte bArray[])
    {
        StringBuffer sb = new StringBuffer(bArray.length);
        for(int i = 0; i < bArray.length; i++)
        {
            String sTemp = Integer.toHexString(255 & bArray[i]);
            if(sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }

        return sb.toString();
    }

    public static byte[] hexStringToByte(String hex)
    {
        int len = hex.length() / 2;
        byte result[] = new byte[len];
        char achar[] = hex.toCharArray();
        for(int i = 0; i < len; i++)
        {
            int pos = i * 2;
            result[i] = (byte)(toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }

        return result;
    }

    private static byte toByte(char c)
    {
        byte b = (byte)"0123456789ABCDEF".indexOf(c);
        return b;
    }

    public static String getXorString(byte xorbyte[])
    {
        String hexString = "";
        int len = xorbyte.length;
        int remainderlen = 0;
        int addlen = 0;
        byte addbyte[] = new byte[8];
        if(len % 8 != 0)
        {
            remainderlen = len % 8;
            addlen = 8 - remainderlen;
            for(int i = 0; i < addlen; i++)
                addbyte[i] = 0;

        }
        byte Xorbyte[] = new byte[len + addlen];
        System.arraycopy(xorbyte, 0, Xorbyte, 0, len);
        if(addlen > 0)
            System.arraycopy(addbyte, 0, Xorbyte, len, addlen);
        int number = (len + addlen) / 8;
        byte xorCycleA[] = new byte[8];
        byte xorCycleB[] = new byte[8];
        byte resultCycle[] = new byte[8];
        if(number > 2)
        {
            System.arraycopy(Xorbyte, 0, xorCycleA, 0, 8);
            System.arraycopy(Xorbyte, 8, xorCycleB, 0, 8);
            resultCycle = getXorbyte(xorCycleA, xorCycleB);
            for(int i = 2; i < number; i++)
            {
                System.arraycopy(resultCycle, 0, xorCycleA, 0, 8);
                System.arraycopy(Xorbyte, i * 8, xorCycleB, 0, 8);
                resultCycle = getXorbyte(xorCycleA, xorCycleB);
            }

            hexString = bytesToHexString(resultCycle);
        } else
        if(number == 2)
        {
            System.arraycopy(Xorbyte, 0, xorCycleA, 0, 8);
            System.arraycopy(Xorbyte, 8, xorCycleB, 0, 8);
            resultCycle = getXorbyte(xorCycleA, xorCycleB);
            hexString = bytesToHexString(resultCycle);
        } else
        {
            hexString = "";
        }
        return hexString;
    }

    public static byte[] getXorbyte(byte xorCycleA[], byte xorCycleB[])
    {
        byte resultCycle[] = new byte[8];
        for(int i = 0; i < xorCycleA.length; i++)
            resultCycle[i] = (byte)(xorCycleA[i] ^ xorCycleB[i]);

        return resultCycle;
    }

    public static int getChinCharNumber(String str)
    {
        int count = 0;
        String regEx = "[\\u4e00-\\u9fa5]";
        Pattern p = Pattern.compile(regEx);
        for(Matcher m = p.matcher(str); m.find();)
            count++;

        return count;
    }

    public static String getAvailableBalance(String str)
    {
        if(str == null)
            return null;
        int len = str.length();
        int num = 0;
        int startindex = 0;
        int endindex = 20;
        String numString = "";
        String reString = "";
        int index = 0;
        if(len > 0 && len % 20 == 0)
        {
            num = len / 20;
            for(int i = 0; i < num; i++)
            {
                numString = str.substring(startindex, endindex);
                index = numString.indexOf("02");
                if(index == 2)
                {
                    reString = numString;
                    return reString;
                }
                startindex += 20;
                endindex += 20;
            }

        }
        return null;
    }

    public static String putIssuerandAcquirer(String issuer, String acquirer)
    {
        String returnString = "";
        String issuercode = StringFillRightBlank(issuer, 11);
        String acquirercode = StringFillRightBlank(acquirer, 11);
        returnString = (new StringBuilder()).append(issuercode).append(acquirercode).toString();
        return returnString;
    }

    public static void main(String args[])
    {
        System.out.println(bytesToHexString(string2Bcd("8583")));
    }
}


/*
	DECOMPILATION REPORT

	Decompiled from: H:\repo\com\pay\CommonUtil\1.0.0\CommonUtil-1.0.0.jar
	Total time: 31 ms
	Jad reported messages/errors:
	Exit status: 0
	Caught exceptions:
*/