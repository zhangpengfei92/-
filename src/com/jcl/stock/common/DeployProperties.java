package com.jcl.stock.common;



import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;




public class DeployProperties extends PropertiesConfigBase{
	private static Logger logger = Logger.getLogger(DeployProperties.class);

	private static final String FILE_NAME = "resoure.properties";
	private static DeployProperties instance = new DeployProperties();

	public static DeployProperties getInstance() {
		return instance;
	}
	
	@Override
	protected Resource getResource() {
		return new ClassPathResource(FILE_NAME);
	}

	private DeployProperties() {
		try {
			this.load();
		} catch (Exception e) {
			logger.error("Failed to load the config file " + FILE_NAME,e);
		}
	}

	public Integer getInt(String key) {
		return Integer.parseInt(getProperty(key));
	}

	/**
	 * 获取交易平台服务器地址&端口
	 * @return
	 */
	public String getZeroMQServer(){
		return getProperty("zeromq.server");
	}
	/**
	 * 获取服务器绑定唯一标识码
	 * @return
	 */
	public String getFundServerGuid(){
		return getProperty("fund.server.guid");
	}
	
	/**
	 * 获取Zookeeper服务器地址
	 * @return
	 */
	public String getZookeeperServer(){
		return getProperty("zookeeper.server");
	}
	
	/**
	 * 获取Zookeeper目录地址
	 * @return
	 */
	public String getZookeeperAddress(){
		return getProperty("zookeeper.address");
	}
	
	/**
	 * 签到获取积分数
	 * @return
	 */
	public int getLoginSignIntegration(){
		return Integer.parseInt(getProperty("public.login.sign"));
	}
	
	/**
	 * 注册编号
	 * @return
	 */
	public int getRegisterNum(){
		return Integer.parseInt(getProperty("public.register.num"));
	}
	
	/**
	 * 猜对排名添加积分数
	 * @return
	 */
	public int getGuessRightIntegration(){
		return Integer.parseInt(getProperty("public.guessright.integration"));
	}
	
	/**
	 * 排名猜猜乐所需积分数
	 * @return
	 */
	public int getGuessIntegration(){
		return Integer.parseInt(getProperty("public.guess.integration"));
	}
	
	/**
	 * 获取手机注册验证码参数
	 * @return
	 */
	public String getPosturl(){
		return getProperty("SendTes.Post.url");
	}
	public String getPostuid(){
		return getProperty("SendTes.Post.uid");
	}
	public String getPostname(){
		return getProperty("SendTes.Post.name");
	}
	public String getPostpass(){
		return getProperty("SendTes.Post.pass");
	}
	
	/**
	 * 模拟比赛Id
	 * @return
	 */
	public String getSimulationGameId(){
		return getProperty("public.gameid.simulation");
	}
	
	/**
	 * 模拟比赛 比赛时间
	 * @return
	 */
	public String getSimulationTime(){
		return getProperty("public.time.simulation");
	}
	
	/**
	 * 获取默认初始资金
	 * @return
	 */
	public String getDefaultInitialcapital(){
		return getProperty("public.default.initialcapital");
	}
	
	/**
	 * 获取apache路径地址
	 * @return
	 */
	public String getApacheUrl(){
		return getProperty("public.apache.url");
	}
	
}