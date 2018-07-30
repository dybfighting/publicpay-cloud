package com.publicpay.base.encrypt;

import com.publicpay.base.utils.ComUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
  
/** 
 * RSA安全编码组件 
 *  
 * @author shixy 
 * @version 1.0 
 * @since 1.0 
 */  
public abstract class RSACoder extends Coder {  
	
	private static Logger logger = LoggerFactory.getLogger(RSACoder.class);
	
    public static final String KEY_ALGORITHM = "RSA";
    public static final String KEY_ALGORITHM2 = "RSA2";
    public static final int KEY_LENGTH = 1024;
    public static final int KEY_LENGTH2 = 2048;
    public static final String SIGNATURE_ALGORITHM = "SHA1withRSA";//MD5withRSA 
    public static final String SIGNATURE_ALGORITHM2 = "SHA256withRSA";
    private static final String PUBLIC_KEY = "RSAPublicKey";  
    private static final String PRIVATE_KEY = "RSAPrivateKey";  
  
    /** 
     * 用私钥对信息生成数字签名 
     *  
     * @param data 
     *            加密数据 
     * @param privateKey 
     *            私钥 
     *  
     * @return 
     * @throws Exception 
     */  
    public static String sign(byte[] data, String privateKey,String key_algorithm,String signature_algorithm) throws Exception {
        // 解密由base64编码的私钥  
        byte[] keyBytes = decryptBASE64(privateKey);  
  
        // 构造PKCS8EncodedKeySpec对象  
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);  
  
        // KEY_ALGORITHM 指定的加密算法  
        KeyFactory keyFactory = KeyFactory.getInstance(key_algorithm);
  
        // 取私钥匙对象  
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
  
        // 用私钥对信息生成数字签名  
        Signature signature = Signature.getInstance(signature_algorithm);
        signature.initSign(priKey);  
        signature.update(data);  
  
        return encryptBASE64(signature.sign());  
    }  
    public static String sign(byte[] data, String privateKey) throws Exception {
        return sign(data, privateKey,KEY_ALGORITHM,SIGNATURE_ALGORITHM);
    }

    public static String signRSA2(byte[] data, String privateKey) throws Exception {
        return sign(data, privateKey,KEY_ALGORITHM2,SIGNATURE_ALGORITHM2);
    }
    /** 
     * 用私钥对信息生成数字签名 
     *  
     * @param signMap 
     *            加密数据 
     * @param privateKey 
     *            私钥 
     *  
     * @return 
     * @throws Exception 
     */  
    public static String sign(Map<String, Object> signMap, String privateKey) throws Exception {  
    	String signValue = "";
    	
    	try {
    		String sortStr = ComUtils.sortStr(signMap);
    		signValue = sign(sortStr.getBytes(), privateKey);
    		
    		int maxLength = 2000;
    		int sortStrLength = 0;
    		String sortStrSub = "";
    		if (StringUtils.isNotBlank(sortStr)) {
    			sortStrLength = sortStr.length();
    			if (sortStrLength > maxLength) {
    				sortStrSub = sortStr.substring(0, maxLength) + " ......";
    			} else {
    				sortStrSub = sortStr;
    			}
    		}
    		
    		logger.info("签名原文    长度为:[{}], 内容为:{}, 签名值为:[{}]", sortStrLength, sortStrSub, signValue);
    	} catch (Exception ex) {
    		logger.error("签名异常, 异常信息为：{}", ex);
    	}
    	 
        return signValue;  
    }  
  
    /** 
     * 校验数字签名 
     *  
     * @param data 
     *            加密数据 
     * @param publicKey 
     *            公钥 
     * @param sign 
     *            数字签名 
     *  
     * @return 校验成功返回true 失败返回false 
     * @throws Exception 
     *  
     */  
    public static boolean verify(byte[] data, String publicKey, String sign,String key_algorithm,String signature_algorithm)
            throws Exception {  
  
        // 解密由base64编码的公钥  
        byte[] keyBytes = decryptBASE64(publicKey);  
  
        // 构造X509EncodedKeySpec对象  
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);  
  
        // KEY_ALGORITHM 指定的加密算法  
        KeyFactory keyFactory = KeyFactory.getInstance(key_algorithm);
  
        // 取公钥匙对象  
        PublicKey pubKey = keyFactory.generatePublic(keySpec);
  
        Signature signature = Signature.getInstance(signature_algorithm);
        signature.initVerify(pubKey);  
        signature.update(data);  
  
        // 验证签名是否正常  
        return signature.verify(decryptBASE64(sign));  
    }

    public static boolean verify(byte[] data, String publicKey, String sign)
            throws Exception {
        return verify(data,publicKey,sign,KEY_ALGORITHM,SIGNATURE_ALGORITHM);
    }
    public static boolean verifyRSA2(byte[] data, String publicKey, String sign)
            throws Exception {
        return verify(data,publicKey,sign,KEY_ALGORITHM2,SIGNATURE_ALGORITHM2);
    }


        /**
         * 校验数字签名
         *
         * @param data
         *            加密数据
         * @param publicKey
         *            公钥
         * @param sign
         *            数字签名
         *
         * @return 校验成功返回true 失败返回false
         * @throws Exception
         *
         */
    public static boolean verify(Map<String, Object> signMap, String publicKey, String sign) {  
  
    	boolean verifyResult = false;
    	
    	try {
    		String sortStr = ComUtils.sortStr(signMap);
    		verifyResult = verify(sortStr.getBytes(), publicKey, sign);
    		
    		logger.info("校验签名原文为：{}, 校验结果为：{}", sortStr, verifyResult);
    	} catch (Exception ex) {
    		logger.error("校验签名异常, 异常信息为：{}", ex);
    	}
        // 验证签名是否正常  
        return verifyResult;  
    }  
  
    /** 
     * 解密<br> 
     * 用私钥解密 
     *  
     * @param data 
     * @param key 
     * @return 
     * @throws Exception 
     */  
    public static byte[] decryptByPrivateKey(byte[] data, String key)  
            throws Exception {  
        // 对密钥解密  
        byte[] keyBytes = decryptBASE64(key);  
  
        // 取得私钥  
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
  
        // 对数据解密  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.DECRYPT_MODE, privateKey);  
  
        return cipher.doFinal(data);  
    }  
  
    /** 
     * 解密<br> 
     * 用公钥解密 
     *  
     * @param data 
     * @param key 
     * @return 
     * @throws Exception 
     */  
    public static byte[] decryptByPublicKey(byte[] data, String key)  
            throws Exception {  
        // 对密钥解密  
        byte[] keyBytes = decryptBASE64(key);  
  
        // 取得公钥  
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
        Key publicKey = keyFactory.generatePublic(x509KeySpec);  
  
        // 对数据解密  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.DECRYPT_MODE, publicKey);  
  
        return cipher.doFinal(data);  
    }  
  
    /** 
     * 加密<br> 
     * 用公钥加密 
     *  
     * @param data 
     * @param key 
     * @return 
     * @throws Exception 
     */  
    public static byte[] encryptByPublicKey(byte[] data, String key)  
            throws Exception {  
        // 对公钥解密  
        byte[] keyBytes = decryptBASE64(key);  
  
        // 取得公钥  
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
        Key publicKey = keyFactory.generatePublic(x509KeySpec);  
  
        // 对数据加密  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);  
  
        return cipher.doFinal(data);  
    }  
  
    /** 
     * 加密<br> 
     * 用私钥加密 
     *  
     * @param data 
     * @param key 
     * @return 
     * @throws Exception 
     */  
    public static byte[] encryptByPrivateKey(byte[] data, String key)  
            throws Exception {  
        // 对密钥解密  
        byte[] keyBytes = decryptBASE64(key);  
  
        // 取得私钥  
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);  
  
        // 对数据加密  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);  
  
        return cipher.doFinal(data);  
    }  
  
    /** 
     * 取得私钥 
     *  
     * @param keyMap 
     * @return 
     * @throws Exception 
     */  
    public static String getPrivateKey(Map<String, Object> keyMap)  
            throws Exception {  
        Key key = (Key) keyMap.get(PRIVATE_KEY);  
  
        return encryptBASE64(key.getEncoded());  
    }  
  
    /** 
     * 取得公钥 
     *  
     * @param keyMap 
     * @return 
     * @throws Exception 
     */  
    public static String getPublicKey(Map<String, Object> keyMap)  
            throws Exception {  
        Key key = (Key) keyMap.get(PUBLIC_KEY);  
  
        return encryptBASE64(key.getEncoded());  
    }  
  
    /** 
     * 初始化密钥 
     *  
     * @return 
     * @throws Exception 
     */  
    public static Map<String, Object> initKey() throws Exception {  
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);  
        keyPairGen.initialize(KEY_LENGTH);  
  
        KeyPair keyPair = keyPairGen.generateKeyPair();  
  
        // 公钥  
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  
  
        // 私钥  
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();  
  
        Map<String, Object> keyMap = new HashMap<String, Object>(2);  
  
        keyMap.put(PUBLIC_KEY, publicKey);  
        keyMap.put(PRIVATE_KEY, privateKey);  
        return keyMap;  
    }

    
    public static void main(String[] args) throws Exception {
    	Map<String, Object> map = initKey();
    	String privateKey = getPrivateKey(map);
    	String publicKey = getPublicKey(map);
    	
    	logger.info("privateKey:[{}], publicKey:[{}]", privateKey, publicKey);
    }
}  
