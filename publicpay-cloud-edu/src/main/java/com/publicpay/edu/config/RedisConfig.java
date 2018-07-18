//package com.publicpay.edu.config;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
////import com.publicpay.edu.enums.CallerAgency;
////import com.publicpay.edu.enums.IndustryAgence;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.AutoConfigureBefore;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.MapPropertySource;
//import org.springframework.core.env.PropertySource;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.RedisSentinelConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//
//import redis.clients.jedis.JedisPoolConfig;
//
//import com.publicpay.base.utils.DateUtils;
//import com.publicpay.base.utils.RedisUtils;
//import com.publicpay.edu.utils.Constants4Front;
//import com.publicpay.edu.utils.FrontUtils;
//import com.publicpay.edu.utils.PropertiesUtil;
//
///**
// * 配置redis哨兵
// * 目的为了创建redisConnectionFactory、redisTemplate
// * 这个组件是给共享session用的，其他功能当然也可以用（把redisTemplate当成一个bean用就可以，本身是单例并且是线程安全的）。
// * 如果功能点移植自ipos的newbusifront，考虑到不改之前的逻辑，也可以用iposcommon里面的redis组件
// *
// */
//@org.springframework.context.annotation.PropertySource("classpath:redis.properties")
////@Configuration
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 7200)
////@AutoConfigureBefore(FrontConfig.class)
//public class RedisConfig {
//	private static final Logger logger = LoggerFactory.getLogger(FrontUtils.class);
//
//    /** 哨兵集群*/
//    @Value("${publicpay.redis.host}")
//    private String host;
//
//    /** master*/
//    @Value("${publicpay.redis.master.name}")
//    private String master;
//
//    /** password*/
//    @Value("${publicpay.redis.password}")
//    private String password;
//
//    /** dbid*/
//    @Value("${publicpay.redis.dbIndex}")
//    private String dbid;
//
//    /** minIdle*/
//    @Value("${publicpay.redis.pool.minIdle}")
//    private String minIdle;
//
//    /** 连接池阻塞时间： 连接被耗尽时，新的连接池请求将会被阻塞，超过时间后则抛出异常*/
//    @Value("${publicpay.redis.pool.maxWaitMillis}")
//    private String maxait;
//
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        /**设置哨兵 */
//        Map<String, Object> map = new HashMap<>();
//        host = host.replace(";", ",");
//        map.put("spring.redis.sentinel.master", master);
//        map.put("spring.redis.sentinel.nodes", host);
//
//        PropertySource propertySource1 = new MapPropertySource("map", map);
//        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration(propertySource1);
//
//        /**设置POOL，一切用默认就好，只设置了获取连接的阻塞时间*/
//        JedisPoolConfig jc = new JedisPoolConfig();
//        jc.setMaxWaitMillis(Integer.parseInt(maxait));
//        jc.setMinIdle(Integer.parseInt(minIdle));
//        jc.setTestOnBorrow(true);
//
//        JedisConnectionFactory jf = new JedisConnectionFactory(sentinelConfig,jc);
//        jf.setDatabase(Integer.parseInt(dbid));
//        jf.setPassword(password);
//        return jf;
//    }
//
//    @Bean(name = "redisTemplate")
//    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate rt = new RedisTemplate();
//        rt.setConnectionFactory(redisConnectionFactory);
//
//        //设置key-value序列化方式
///*        rt.setKeySerializer(new StringRedisSerializer());
//        rt.setValueSerializer(new StringRedisSerializer());*/
//
//        return rt;
//    }
//
//    @Bean(name = "stringRedisTemplate")
//    public RedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate rt = new RedisTemplate();
//        rt.setConnectionFactory(redisConnectionFactory);
//        //设置key-value序列化方式
//        rt.setKeySerializer(new StringRedisSerializer());
//        rt.setValueSerializer(new StringRedisSerializer());
//        return rt;
//    }
//
//    @Bean
//    public RedisUtils redisUtils(@Qualifier("redisTemplate")RedisTemplate redisTemplate, @Qualifier("stringRedisTemplate")RedisTemplate stringRedisTemplate) {
//        RedisUtils redisUtils = new RedisUtils(redisTemplate,stringRedisTemplate);
//
//        initializeDate();
//        return redisUtils;
//    }
//
//
//    public void  initializeDate() {
//    	Properties properties = PropertiesUtil.getProperties("application.properties");
////		String privatekey = properties.getProperty("publicpay.edu.privatekey");
////		String publickey = properties.getProperty("publicpay.server.publickey");
////		String deskey = properties.getProperty("publicpay.edu.deskey");
//        String  unionpayIwaterPrivatekey = properties.getProperty("publicpay.edu.unionpay-iwater.privatekey");
//        String  unionpayIwaterPublickey = properties.getProperty("publicpay.server.unionpay-iwater.publickey");
//        String  unionpayIwaterDeskey = properties.getProperty("publicpay.edu.unionpay-iwater.deskey");
//        String  unionpayPrivatekey = properties.getProperty("publicpay.edu.unionpay.privatekey");
//        String  unionpayPublickey = properties.getProperty("publicpay.server.unionpay.publickey");
//        String  unionpayDeskey = properties.getProperty("publicpay.edu.unionpay.deskey");
//		String masterkeyIWater = properties.getProperty("public.edu.masterkey.iwater");
//		String masterkeyRYJ = properties.getProperty("public.edu.masterkey.rongyijiao");
//
////		RedisUtils.set(Constants4Front.PUBLICPAY_FRONT_PRI_KEY, privatekey);
////		RedisUtils.set(Constants4Front.PUBLICPAY_SERVER_PUB_KEY, publickey);
////		RedisUtils.set(Constants4Front.PUBLICPAY_FRONT_DES_KEY, deskey);
//
////        RedisUtils.set(Constants4Front.PUBLICPAY_FRONT_PRI_KEY+ CallerAgency.UNIONPAY_IWATER, unionpayIwaterPrivatekey);
////        RedisUtils.set(Constants4Front.PUBLICPAY_SERVER_PUB_KEY+ CallerAgency.UNIONPAY_IWATER, unionpayIwaterPublickey);
////        RedisUtils.set(Constants4Front.PUBLICPAY_FRONT_DES_KEY+ CallerAgency.UNIONPAY_IWATER, unionpayIwaterDeskey);
////
////        RedisUtils.set(Constants4Front.PUBLICPAY_FRONT_PRI_KEY+ CallerAgency.UNIONPAY, unionpayPrivatekey);
////        RedisUtils.set(Constants4Front.PUBLICPAY_SERVER_PUB_KEY+ CallerAgency.UNIONPAY, unionpayPublickey);
////        RedisUtils.set(Constants4Front.PUBLICPAY_FRONT_DES_KEY+ CallerAgency.UNIONPAY, unionpayDeskey);
////
////        RedisUtils.set(Constants4Front.PUBLICPAY_MASTER_KEY_ + IndustryAgence.IWATER.name(), masterkeyIWater);
////        RedisUtils.set(Constants4Front.PUBLICPAY_MASTER_KEY_ + IndustryAgence.RONGYIJIAO.name(), masterkeyRYJ);
//
//        Date date = new Date(); String format = "yyyy-MM-dd HH:mm:ss";
//
//		String dateStr01 = getStr01(date, format);
//		String dateStr02 = getStr03(date, format);
//		String dateStr03 = DateUtils.parseDate2Str(date, format);
//
//		logger.info("获取到的系统时间, date:{}, dateStr01:{}, dateStr02:{}, dateStr03:{}",
//				date, dateStr01, dateStr02, dateStr03);
//
//		logger.info("初始化的参数为, unionpayIwaterPrivatekey:{}, unionpayIwaterPublickey:{}, unionpayIwaterDeskey:{}", unionpayIwaterPrivatekey, unionpayIwaterPublickey, unionpayIwaterDeskey);
//        logger.info("初始化的参数为, unionpayPrivatekey:{}, unionpayPublickey:{}, unionpayDeskey:{}", unionpayPrivatekey, unionpayPublickey, unionpayDeskey);
//        logger.info("初始化的参数 masterkeyIWater:{}, masterkeyRYJ:{}",masterkeyIWater,masterkeyRYJ);
//    }
//
//    public String getStr01(final Date date, String format) {
//    	SimpleDateFormat dateFormat = new SimpleDateFormat(format);
//    	return dateFormat.format(date);
//    }
//
//    public String getStr02(Date date, String format) {
//    	SimpleDateFormat dateFormat = new SimpleDateFormat(format);
//    	return dateFormat.format(date);
//    }
//
//    public static String getStr03(final Date date, String format) {
//		SimpleDateFormat sdf = new SimpleDateFormat(format);
//		return sdf.format(date);
//	}
//
//}
//
