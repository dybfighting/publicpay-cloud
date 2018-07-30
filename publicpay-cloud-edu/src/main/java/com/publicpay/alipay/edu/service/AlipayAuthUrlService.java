package com.publicpay.alipay.edu.service;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.service
 * @Description: 生成授权连接二维码
 * 测试用过的授权url merchantNo=为自己添加的标识用来标识哪一所学校的授权
 *
 * https://openauth.alipaydev.com/oauth2/appToAppAuth.htm?app_id=2016091900545994&redirect_uri=http%3a%2f%2f61.50.130.246%2fauthCallback&merchantNo=12345
 * 拼接规则:
 * <p>
 * https://openauth.alipay.com/oauth2/appToAppAuth.htm?app_id=2015101400446982&redirect_uri=http%3A%2F%2Fexample.com
 * <p>
 * TIPS：沙箱拼接规则详见关于沙箱。
 * <p>
 * 参数说明：
 * <p>
 * 参数	参数名称	类型	必填	描述	范例
 * app_id	开发者应用的AppId	String	是	开发者应用的AppId	2015101400446982
 * redirect_uri	回调页面	String	是	参数需要UrlEncode	http%3A%2F%2Fexample.com
 * TIPS：授权链接中配置的redirect_uri内容需要与应用中配置的授权回调地址完全一样，否则无法正常授权。
 * @date 2018/7/25 下午5:29
 */
public interface AlipayAuthUrlService {

     String getAuthUrl();
}
