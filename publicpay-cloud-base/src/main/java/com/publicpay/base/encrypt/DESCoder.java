//package com.publicpay.base.encrypt;
//
//
//import com.pay.common.util.ISO8583.ISO8583Utile;
//import org.apache.commons.lang3.StringUtils;
//
//import javax.crypto.Cipher;
//import javax.crypto.KeyGenerator;
//import javax.crypto.SecretKey;
//import javax.crypto.SecretKeyFactory;
//import javax.crypto.spec.DESKeySpec;
//import java.security.Key;
//import java.security.SecureRandom;
//
//
///**
// * DES安全编码组件
// *
// * <pre>
// * 支持 DES、DESede(TripleDES,就是3DES)、AES、Blowfish、RC2、RC4(ARCFOUR)
// * DES                  key size must be equal to 56
// * DESede(TripleDES)    key size must be equal to 112 or 168
// * AES                  key size must be equal to 128, 192 or 256,but 192 and 256 bits may not be available
// * Blowfish             key size must be multiple of 8, and can only range from 32 to 448 (inclusive)
// * RC2                  key size must be between 40 and 1024 bits
// * RC4(ARCFOUR)         key size must be between 40 and 1024 bits
// * 具体内容 需要关注 JDK Document http://.../docs/technotes/guides/security/SunProviders.html
// * </pre>
// *
// * @author shixy
// * @version 1.0
// * @since 1.0
// */
//public abstract class DESCoder extends Coder {
//    /**
//     * ALGORITHM 算法 <br>
//     * 可替换为以下任意一种算法，同时key值的size相应改变。
//     *
//     * <pre>
//     * DES                  key size must be equal to 56
//     * DESede(TripleDES)    key size must be equal to 112 or 168
//     * AES                  key size must be equal to 128, 192 or 256,but 192 and 256 bits may not be available
//     * Blowfish             key size must be multiple of 8, and can only range from 32 to 448 (inclusive)
//     * RC2                  key size must be between 40 and 1024 bits
//     * RC4(ARCFOUR)         key size must be between 40 and 1024 bits
//     * </pre>
//     *
//     * 在Key toKey(byte[] key)方法中使用下述代码
//     * <code>SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);</code> 替换
//     * <code>
//     * DESKeySpec dks = new DESKeySpec(key);
//     * SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
//     * SecretKey secretKey = keyFactory.generateSecret(dks);
//     * </code>
//     */
//    public static final String ALGORITHM = "DES";
//
//    /**
//     * 转换密钥<br>
//     *
//     * @param key
//     * @return
//     * @throws Exception
//     */
//    private static Key toKey(byte[] key) throws Exception {
//        DESKeySpec dks = new DESKeySpec(key);
//        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
//        SecretKey secretKey = keyFactory.generateSecret(dks);
//
//        // 当使用其他对称加密算法时，如AES、Blowfish等算法时，用下述代码替换上述三行代码
//        // SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);
//
//        return secretKey;
//    }
//
//    /**
//     * 解密
//     *
//     * @param data
//     * @param key
//     * @return
//     * @throws Exception
//     */
//    public static byte[] decrypt(byte[] data, String key) {
//    	try {
//    		//Key k = toKey(decryptBASE64(key));
//    		Key k = toKey(key.getBytes());
//
//            Cipher cipher = Cipher.getInstance(ALGORITHM);
//            cipher.init(Cipher.DECRYPT_MODE, k);
//
//            return cipher.doFinal(data);
//    	} catch (Exception ex) {
//    		ex.printStackTrace();
//    		return new byte[]{};
//    	}
//    }
//
//    /**
//     * 解密
//     *
//     * @param data
//     * @param key
//     * @return
//     * @throws Exception
//     */
//    public static String decryptHexString(String data, String key) throws Exception {
//        String outputStr = "";
//
//        try {
//            if (StringUtils.isNotBlank(data) && StringUtils.isNotBlank(key)) {
//                byte[] inputData = ISO8583Utile.hexStringToByte(data);
//
//                Key k = toKey(ISO8583Utile.hexStringToByte(key));
//
//                Cipher cipher = Cipher.getInstance(ALGORITHM);
//                cipher.init(Cipher.DECRYPT_MODE, k);
//
//                byte[] outputData = cipher.doFinal(inputData);
//
//
//                outputStr = new String(outputData);
//            }
//        } catch (Exception ex) {
//            System.out.println("=== DESCoder.decrypt执行出错啦!!! ===" + ex);
//        }
//
//        return outputStr;
//    }
//
//    /**
//     * 加密
//     *
//     * @param data
//     * @param key
//     * @return
//     * @throws Exception
//     */
//    public static byte[] encrypt(byte[] data, String key) {
//    	try {
//    		//Key k = toKey(decryptBASE64(key));
//    		Key k = toKey(key.getBytes());
//
//            Cipher cipher = Cipher.getInstance(ALGORITHM);
//            cipher.init(Cipher.ENCRYPT_MODE, k);
//
//            return cipher.doFinal(data);
//    	} catch (Exception ex) {
//    		ex.printStackTrace();
//    		return new byte[]{};
//    	}
//
//    }
//
//    /**
//     * 加密
//     *
//     * @param data
//     * @param key
//     * @return
//     * @throws Exception
//     */
//    public static String encryptToHexString(String data, String key) throws Exception {
//        String outputStr = "";
//
//        try {
//            if (StringUtils.isNotBlank(data) && StringUtils.isNotBlank(key)) {
//                byte[] inputData = data.getBytes();
//
//                Key k = toKey(ISO8583Utile.hexStringToByte(key));
//                Cipher cipher = Cipher.getInstance(ALGORITHM);
//                cipher.init(Cipher.ENCRYPT_MODE, k);
//
//                byte[] outputData = cipher.doFinal(inputData);
//
//                outputStr = ISO8583Utile.bytesToHexString(outputData);
//            }
//        } catch (Exception ex) {
//            System.out.println("=== DESCoder.encrypt执行出错啦!!! ===" + ex);
//        }
//
//        return outputStr;
//    }
//
//    /**
//     * 生成密钥
//     *
//     * @return
//     * @throws Exception
//     */
//    public static String initKey() throws Exception {
//        return initKey(null);
//    }
//
//    /**
//     * 生成密钥
//     *
//     * @param seed
//     * @return
//     * @throws Exception
//     */
//    public static String initKey(String seed) throws Exception {
//        SecureRandom secureRandom = null;
//
//        if (seed != null) {
//            secureRandom = new SecureRandom(decryptBASE64(seed));
//        } else {
//            secureRandom = new SecureRandom();
//        }
//
//        KeyGenerator kg = KeyGenerator.getInstance(ALGORITHM);
//        kg.init(secureRandom);
//
//        SecretKey secretKey = kg.generateKey();
//
//        return encryptBASE64(secretKey.getEncoded());
//    }
//
//    public static void main(String[] args) throws Exception{
//        String inputStr = "6224242200000052";
//
//        String key = "1234567890000000";
//
//        System.err.println("原文:\t" + inputStr);
//
//        System.err.println("密钥:\t" + key);
//
//        String inputStr_en = DESCoder.encryptToHexString(inputStr, key);
//
//        System.err.println("加密后:\t" + inputStr_en);
//
//        String outputStr = DESCoder.decryptHexString(inputStr_en, key);
//
//        System.err.println("解密后:\t" + outputStr);
//    }
//}
