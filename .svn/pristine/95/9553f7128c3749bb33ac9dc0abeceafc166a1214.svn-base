package com.jcl.util;

import java.io.InputStream;
import java.security.Security;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

public class MessageUtils {

	public static Properties properties;
	// 读取配置文件
	static {
		try {
			properties = new Properties();
			// 加载一下项目中所有的配置文件 目前就加载一个 后期改变成扫描项目 加载所有的配置文件
			InputStream inputStream = MessageUtils.class.getResourceAsStream("/appconfig.properties");
			// 加载一下对象
			properties.load(inputStream);
			// 加载完成后关闭
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 发送短信
	 * 
	 * @param phone
	 *            手机号码
	 * @param content
	 *            需要发送的短信内容
	 * @return
	 * @throws Exception
	 */
	public static String sendMassager(String phone, String content, String type) {
		// 设置超时时间-可自行调整
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");
		// 初始化ascClient需要的几个参数
		final String product = "Dysmsapi";// 短信API产品名称（短信产品名固定，无需修改）
		final String domain = "dysmsapi.aliyuncs.com";// 短信API产品域名（接口地址固定，无需修改）
		// 替换成你的AK
		final String accessKeyId = properties.getProperty("message.accesskeyid");// 你的accessKeyId,参考本文档步骤2
		System.out.println(accessKeyId);
		final String accessKeySecret = properties.getProperty("message.accesskeysecret");// 你的accessKeySecret，参考本文档步骤2
		System.out.println(accessKeySecret);
		// 初始化ascClient,暂时不支持多region
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
		try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IAcsClient acsClient = new DefaultAcsClient(profile);
		// 组装请求对象
		SendSmsRequest request = new SendSmsRequest();
		// 使用post提交
		request.setMethod(MethodType.POST);
		// 必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
		request.setPhoneNumbers(phone);
		// 必填:短信签名-可在短信控制台中找到
		request.setSignName(properties.getProperty("message.signname"));
		if ("1".equals(type)) {//安置成功短信
			request.setTemplateCode(properties.getProperty("message.templatecode1"));
			request.setTemplateParam("{\"username\":\"" + content + "\"}");
		} else if("2".equals(type)){//积分认购短信
			request.setTemplateCode(properties.getProperty("message.templatecode2"));
			request.setTemplateParam("{\"username\":\"" + content + "\"}");
		} else {
			// 必填:短信模板-可在短信控制台中找到
			request.setTemplateCode(properties.getProperty("message.templatecode"));
			// 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
			// 友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
			request.setTemplateParam("{\"code\":\"" + content + "\"}");
		}
		// 可选-上行短信扩展码(无特殊需求用户请忽略此字段)
		// request.setSmsUpExtendCode("90997");
		// 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
		request.setOutId("123456789");
		// 请求失败这里会抛ClientException异常
		SendSmsResponse sendSmsResponse = null;
		try {
			sendSmsResponse = acsClient.getAcsResponse(request);
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
		if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
			// 请求成功
		}
		System.out.println(sendSmsResponse.getCode());
		return sendSmsResponse.getMessage();
	}

	// 发送邮箱的
	public static void sendMail(String toEmail, String title, String content) throws MessagingException {
		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        
        //设置邮件会话参数
        Properties props = new Properties();
        //邮箱的发送服务器地址
        props.setProperty("mail.smtp.host", properties.getProperty("mail.host"));
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        //邮箱发送服务器端口,这里设置为465端口
//        props.setProperty("mail.smtp.localhost", "127.0.0.1");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", properties.getProperty("mail.smtp.auth"));
        
        final String username = properties.getProperty("mail.username");
        final String password = properties.getProperty("mail.password");
        
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
		
      //通过会话,得到一个邮件,用于发送
        Message msg = new MimeMessage(session);
        //设置发件人
        msg.setFrom(new InternetAddress(properties.getProperty("mail.smtp.from")));
        //设置收件人,to为收件人,cc为抄送,bcc为密送
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
//        msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(properties.getProperty("mail.smtp.from"), false));
//        msg.setRecipients(Message.RecipientType.BCC, InternetAddress.parse(to, false));
        msg.setSubject(title);
        //设置邮件消息
        msg.setText(content);
        //设置发送的日期
        msg.setSentDate(new Date());
        
        //调用Transport的send方法去发送邮件
        Transport.send(msg);
        /*============================分割线===================================*/
//		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
//		// 设定mail server
//		senderImpl.setHost(properties.getProperty("mail.host"));
//		// 建立邮件消息
//		SimpleMailMessage mailMessage = new SimpleMailMessage();
//		// 设置收件人，寄件人 用数组发送多个邮件
//		// String[] array = new String[] {"sun111@163.com","sun222@sohu.com"};
//		// mailMessage.setTo(array);
//		mailMessage.setTo(toEmail);
//		mailMessage.setFrom(properties.getProperty("mail.smtp.from"));
//		mailMessage.setSubject(title);
//		mailMessage.setText(content);
//		senderImpl.setUsername(properties.getProperty("mail.username")); // 设置username
//		senderImpl.setPassword(properties.getProperty("mail.password")); // 设置password
//		Properties prop = new Properties();
//		prop.put("mail.smtp.auth", properties.getProperty("mail.smtp.auth")); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
//		prop.put("mail.smtp.timeout", properties.getProperty("mail.smtp.timeout"));
//		senderImpl.setJavaMailProperties(prop);
//		// 发送邮件
//		senderImpl.send(mailMessage);
//		System.out.println("邮件发送成功.." + toEmail);
	}

	public static void sendKaihuMsg(String phone, String content) {
		sendMassager(phone, content, "1");
	}
	public static void sendRengouMsg(String phone, String content) {
		sendMassager(phone, content, "2");
	}

	public static void sendMassager(String phone, String content) {
		sendMassager(phone, content, null);
	}

	public static void main(String[] args) throws Exception {
		// sendMassager("18627074562", "9527",null);
//		String sixRandomStr = CommonFunc.getSixRandomStr();
//		Map<String,Object> resultMap = new HashMap<String,Object>();
//		String content = "尊敬的用户：您的校验码："+sixRandomStr+"，该验证码5分钟内有效，请勿泄漏于他人。";
//		sendMassager("13162677122", sixRandomStr, null);
		 String mail="370703978@qq.com";
		 String content=Integer.toString((int) (Math.random()*9000+1000));
		 sendMail(mail, "验证码", content);
//		 sendMassager("18627074562", "test");
	}
}
