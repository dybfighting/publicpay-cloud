package com.publicpay.edu.alipay.service;

/**
 * @author dyb
 * @version V1.0
 * @Package com.publicpay.edu.alipay.service
 * @Description: 生成授权连接二维码
 * url加一级学校的标志以区分是哪个学校授权
 * https://openauth.alipay.com/oauth2/appToAppAuth.htm?app_id=2016112803504802&redirect_uri=https://k12jiaofei.alipay-eco.com/callback/home/
 * https://openauth.alipaydev.com/oauth2/appToAppAuth.htm?app_id=2016072800113330&redirect_uri=https://k12jiaofeisandbox.alipay-eco.com/callback/home
 * @date 2018/7/25 下午5:29
 */
public interface AlipayAuthUrlService {

     String getAuthUrl();
}
