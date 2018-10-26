 package com.jcl.stock.simulate;

import java.util.List;
import java.util.zip.CRC32;

import org.apache.log4j.Logger;
import org.zeromq.ZMQ;

import com.jcl.stock.common.DeployProperties;
import com.jcl.stock.queue.Param;
import com.jcl.stock.simulate.DefineNumber.ServerNumber;
import com.jcl.stock.simulate.entity.HeadData;
import com.jcl.stock.simulate.entity.LoginInfoRsp;
import com.jcl.stock.simulate.entity.RouterHead;

/**        
 * Title: HeadSession.java    
 * Description: 会话头文件
 * @author zhuj       
 * @created 2015-5-14 上午8:51:18    
 */      
public class HeadSession {
	
	private static Logger logger = Logger.getLogger(HeadSession.class);
	
	public static final String ZEROMQ_SERVER = DeployProperties.getInstance().getZeroMQServer();
	//public static final String ZEROMQ_GUID=DeployProperties.getInstance().getFundServerGuid();
	
	private static List<String> serverListHead = null;
	
	private static ZMQ.Poller poll = new ZMQ.Poller(1);
	
	private static int pollIndex = 0;
	
	/*同步对象*/
	private static Object synStrHead = "456";
	
	//private static Object synStrRsp = "789";
	
	//private static Object synStrRspData = "012";
	
	/**
	 *   
     * @discription 请求头文件参数格式化
     * @author zhuj       
     * @created 2015-5-14 上午8:46:29     
     * @param funcId  功能号ID
     * @param packlen 请求参数格式化后的byte数组长度
     * @return 格式化后的请求头文件byte数组
	 */
	public static byte[] getHeadReqBufferByJson(int funcId, long assisid, String bussinessId, String clientId, int compressed, int rawLen, int packlen, LoginInfoRsp loginInfoRsp) {
		
		
		//String serverGuid = UUID.randomUUID().toString();
		int headSize = 0;
		
		long hs = 1; // 记录了提供端口服务的总句柄        web默认给 4字节1
		int  version=7; // 协议版本号256个版本
		//int  compressed = 0; 	 //压缩或者加密，混合最多情况(0 : 没有压缩；1：zlib；2：c压缩)
		int  encrypt = 0; 	 //0-未加密，1-ssl
		//int hclient = 1;  // 记录了这个用户的链接句柄  web默认给 4字节1
		//long cookie=0l;  // 用户上层自己携带的信息（可能服务端主动推送给客户端的）
		//BigInteger cookie = StringUtil.getLastHashCode(clientId);
		byte[] cookie = StringUtil.getLastHashCodeByte(clientId);
		//if(loginInfoRsp!=null){
			//cookie = loginInfoRsp.getCookie();
		//}
        long synid =0l;// 同步ID，保留使用的异步信息
        //long assisid = 0l; // 辅助ID，方便客户端携带更多信息
		
		byte[] ReqHeadBuffer = new byte[DefineNumber.HEAD_BYTE_LENGTH];
		
		System.arraycopy(DataParseUtil.longToByte(hs),0,ReqHeadBuffer,headSize,8);// hs
		headSize += 8;
		DataParseUtil.intToHByte(version, headSize, 1, ReqHeadBuffer);// version
		headSize += 1;
		DataParseUtil.intToHByte(compressed, headSize, 1, ReqHeadBuffer);// encrypt
		headSize += 1;
		DataParseUtil.intToHByte(encrypt, headSize, 1, ReqHeadBuffer);// encrypt
		headSize += 1;
		
		/*System.arraycopy(DataParseUtil.bigIntegerToByte(cookie),0,ReqHeadBuffer,headSize,8);// cookie
		headSize += 8;*/
		System.arraycopy(cookie, 0, ReqHeadBuffer, headSize, cookie.length);
		headSize += 8;
		System.arraycopy(DataParseUtil.longToByte(synid),0,ReqHeadBuffer,headSize,8);// synid
		headSize += 8;
		System.arraycopy(DataParseUtil.longToByte(assisid),0,ReqHeadBuffer,headSize,8);// assisid
		headSize += 8;
		
		DataParseUtil.intToHByte(rawLen, headSize, 4, ReqHeadBuffer);// packLen
		headSize += 4;
		DataParseUtil.intToHByte(packlen, headSize, 4, ReqHeadBuffer);// packLen
		headSize += 4;
		DataParseUtil.intToHByte(funcId, headSize, 4, ReqHeadBuffer);// funcId
		headSize += 4;
		
		return ReqHeadBuffer;
	}
	
	/**
     * @discription 解析响应均衡文件数据
     * @param HeadBuffer 响应文件 byte[]
     * @return RouterHead 均衡文件数据对象
	 */
	public static RouterHead getRspRouterHeadData(byte HeadBuffer[]) {
		RouterHead headData = new RouterHead();
		//synchronized (synStrRsp) {
		try {
			if(HeadBuffer != null && HeadBuffer.length > 0){
				/*int nf = 0;
				headData.setServiceId(DataParseUtil.byteToNInt(HeadBuffer, nf, 4));
				nf += 4;
				
				byte[] buf = new byte[16];
				System.arraycopy(HeadBuffer, nf, buf, 0, 16);
				headData.setDestId(buf);
				nf += 16;
				
				headData.setServiceIdReceive(DataParseUtil.byteToNInt(HeadBuffer, nf, 4));
				nf += 4;
				
				buf = new byte[16];
				System.arraycopy(HeadBuffer, nf, buf, 0, 16);
				headData.setDestIdReceive(buf);
				nf += 16;
				
				//headData.setCookie(DataParseUtil.byteToNLong(HeadBuffer, nf, 8));
				buf = new byte[8];
				System.arraycopy(HeadBuffer, nf, buf, 0, 8);
				//headData.setCookie(new BigInteger(String.valueOf(DataParseUtil.byteToNLong(HeadBuffer, nf, 8))));
				headData.setCookie(buf);
				nf += 8;
				
				headData.setStatus(DataParseUtil.byteToNInt(HeadBuffer, nf, 8));
				nf += 8;
				
				headData.setMsg(DataParseUtil.byteToNString(HeadBuffer, nf, 32));
				nf +=32;*/
			}
		} catch (Exception e) {
			logger.error("长度：104,getRspRouterHeadData异常: ArrayIndexOutOfBoundsException length->" + HeadBuffer.length + e.getMessage());
		}
		//}
		return headData;
	}
	
	/**
     * @discription 解析响应头文件数据
     * @param HeadBuffer 响应头文件 byte[]
     * @return HeadData 头文件数据对象
	 */
	public static HeadData getRspheadData(byte HeadBuffer[]) {
		HeadData headData = new HeadData();
		//synchronized (synStrRspData) {
		try {
			if(HeadBuffer != null && HeadBuffer.length > 0){
				int nf = 0;
				headData.setHs(DataParseUtil.byteToNInt(HeadBuffer, nf, 8));
				nf += 8;
				/*headData.setHclient(DataParseUtil.byteToNInt(HeadBuffer, nf, 4));
				nf += 4;*/
				headData.setVersion(DataParseUtil.byteToNInt(HeadBuffer, nf, 1));
				nf += 1;
				headData.setCompressed(DataParseUtil.byteToNInt(HeadBuffer, nf, 1));
				nf += 1;
				headData.setEncrypt(DataParseUtil.byteToNInt(HeadBuffer, nf, 1));
				nf += 1;
				
				headData.setCookie(DataParseUtil.byteToNLong(HeadBuffer,nf,8));
				nf += 8;
				headData.setSynId(DataParseUtil.byteToNLong(HeadBuffer,nf,8));
				nf += 8;
				headData.setAssisId(DataParseUtil.byteToNLong(HeadBuffer,nf,8));
				nf += 8;
				
				headData.setRawLen(DataParseUtil.byteToNInt(HeadBuffer, nf, 4));
				nf += 4;
				headData.setPackLen(DataParseUtil.byteToNInt(HeadBuffer, nf, 4));
				nf += 4;
				headData.setFuncId(DataParseUtil.byteToNInt(HeadBuffer, nf, 4));
				nf += 4;
			}
		} catch (Exception e) {
			logger.error("长度：47,getRspheadData异常:length->" + HeadBuffer.length + e.getMessage());
		}
		//}
		
		//***RouterMsg***//
		/*headData.setDwhs(DataParseUtil.byteToNInt(HeadBuffer, nf, 4));
		nf += 4;
		headData.setDwh(DataParseUtil.byteToNInt(HeadBuffer, nf, 4));
		nf += 4;

		headData.setCookie_router(DataParseUtil.byteToNLong(HeadBuffer,nf,8));
		nf += 8;
		headData.setSynId_router(DataParseUtil.byteToNLong(HeadBuffer,nf,8));
		nf += 8;
		headData.setAssisId_router(DataParseUtil.byteToNLong(HeadBuffer,nf,8));
		nf += 8;
		
		headData.setFuncId_router(DataParseUtil.byteToNInt(HeadBuffer, nf, 4));
		nf += 4;
		
		headData.setEncrypt_router(DataParseUtil.byteToNInt(HeadBuffer, nf, 1));
		nf += 1;
		headData.setLen_router(DataParseUtil.byteToNInt(HeadBuffer, nf, 4));
		nf += 4;
		
		headData.setVersion_router(DataParseUtil.byteToNInt(HeadBuffer, nf, 1));
		nf += 1;
		headData.setGuid_router(DataParseUtil.byteToNString(HeadBuffer, nf, 128));
		nf +=128;
		headData.setBusinessId_router(DataParseUtil.byteToNString(HeadBuffer, nf, 128));
		nf +=128;*/
		
		//***end***//
		
		/*headData.setGuid(DataParseUtil.byteToNString(HeadBuffer, nf, 128));
		nf +=128;
		headData.setBusinessId(DataParseUtil.byteToNString(HeadBuffer, nf, 128));*/
		return headData;
	}
	
	/**
	 * 
     * @discription 通过socket协议请求并获得相应结果
     * @param defineNumber 功能号
     * @param ReqDataBuffer 请求数据（包含头文件信息+协议参数）
     * @return byte[]  响应结果（包含头文件信息+返回结果）
     * @throws BussinessException
	 */
	public static byte[] getJsonData(Param param)throws BussinessException {
		//ZMQ.Context context = ZMQ.context(1); 
		ZMQ.Socket subscriber = null;
		try {
	        
			boolean bol = false;
			//RouterHead routerHead = null;
			/*创建均衡节点*/
	        boolean serverFlag = true;
	        /*if(serverListHead == null){
	        	serverListHead = ProcessThread.serverList;
	        } else if(serverListHead != ProcessThread.serverList){
	        	serverListHead = ProcessThread.serverList;
	        }*/
			if(serverListHead != null && serverListHead.size() > 0){//zookeeper获取节点
	        	//for(int i = 0; i < serverListHead.size(); i++){
				int i = 0;
				for(String strServer : serverListHead){
	        		if(i == pollIndex){
						//i = pollIndex;
		        		if(StringUtil.isAnyNullOrEmpty(strServer)){
		        			continue;
		        		}
		        		subscriber = param.getContext().socket(ZMQ.DEALER);
		                subscriber.setIdentity(param.getByteArray());//原始byte
		                subscriber.setHWM(0);
		                subscriber.setReceiveTimeOut(DefineNumber.SO_TIME_OUT);
		                subscriber.connect(strServer);
		        		poll.register(subscriber, ZMQ.EVENT_ALL);
		        		serverFlag = false;
		        		break;
	        		}
	        		i++;
	        	}
	        } 
			String [] configServer = ZEROMQ_SERVER.split(",");
	        if(serverFlag){
	        	if(configServer.length > 0){
	        		//for(int i = 0; i < configServer.length; i++){
	        			//i = pollIndex;
	        			subscriber = param.getContext().socket(ZMQ.DEALER);
	        	        subscriber.setIdentity(param.getByteArray());//原始byte
	        	        subscriber.setHWM(0);
	        	        subscriber.setReceiveTimeOut(DefineNumber.SO_TIME_OUT);
	            		subscriber.connect(configServer[pollIndex]);
	            		poll.register(subscriber, ZMQ.EVENT_ALL);
	            	//}
	        	}
	        }
			
	        subscriber = poll.getSocket(0);
	        pollIndex++;
	        if(serverFlag){
	        	if(pollIndex >= configServer.length){
	        		pollIndex = 0;
	        	}
	        } else {
	        	if(pollIndex >= serverListHead.size()){
	        		pollIndex = 0;
	        	}
	        }
			synchronized (synStrHead) {
		        //第一帧请求数据  发送服务ID 默认空字符串
		        subscriber.sendMore("");
		        //第二帧请求数据 发送服务名;
		        subscriber.sendMore(param.getRouterHeadBuffer());
		        //第三帧请求数据，发送业务请求数据
		        bol = subscriber.send(param.getReqBuffer());
			}
	        
	        byte[] FullDataBuffer = null;
	        byte[] RspDataBuffer = null;
	        //请求结果返回true 表示发送消息成功
			if(bol){
				//tpm.autoWarn(param);
				//Date timeoutPoint = new Date();
			    //采用recv方法接受JCL服务端返回结果，循环获取所有消息，拿不到阻塞
			    while(true){
		    	    //每个数据体有多帧数据 
		    	    //第一帧数据为服务ID 无需存储
	                subscriber.recv();
	                //读取第二帧数据(均衡数据)
		            if(subscriber.hasReceiveMore()){
		            	FullDataBuffer = subscriber.recv();
		    	    }
	                
		            if(FullDataBuffer == null){
		            	throw new BussinessException("requestdata null");
		            }
		           // routerHead = getRspRouterHeadData(FullDataBuffer);
		            /*if(routerHead != null && DefineNumber.STATUS_SUCCESS == routerHead.getStatus()){//成功
		            	//读取第三帧数据(业务数据)
			            if(subscriber.hasReceiveMore()){
			            	FullDataBuffer = subscriber.recv();
			            }
			            if(FullDataBuffer ==null){
			            	throw new BussinessException("requestdata null");
			            }
			    	    HeadData headData = getRspheadData(FullDataBuffer);// 解析协议头
			    	    //包头文件正确解析，数据长度匹配，业务号匹配，功能号匹配 返回响应结果
			    	    if(headData!=null
			    	       &&FullDataBuffer.length==(DefineNumber.HEAD_BYTE_LENGTH+headData.getPackLen())
			    	       &&bussinessId.equals(headData.getBusinessId())
			    	       &&defineNumber==headData.getFuncId()){
			    	    if(headData!=null
					    	       &&FullDataBuffer.length==(DefineNumber.HEAD_BYTE_LENGTH+headData.getPackLen())
					    	       &&param.getFunctionNum()==headData.getFuncId()){
			    	       RspDataBuffer = new byte[headData.getPackLen()];
			    	       System.arraycopy(FullDataBuffer, DefineNumber.HEAD_BYTE_LENGTH, RspDataBuffer, 0, RspDataBuffer.length);
			    	       //是否解压缩
			    	       if(headData.getCompressed() == 1){
			    	    	   RspDataBuffer = ConvertData.decompress(RspDataBuffer);
			    	       }
			    	       
			    	       break;
			    	    }else{
			    	        //数据长度不匹配，循环直到指定超时时间	
			    	    	if(StringUtil.readTimeOut(timeoutPoint)){
								throw new BussinessException("getdata timeout");
							}
			    	    }
		            } else {//失败
		            	返回均衡返回信息
		            	byte[] buffer = new byte[32];
		            	int nf = 0;
		            	System.arraycopy(StringUtil.isNull(routerHead.getMsg()).getBytes(),0,
		        				buffer,nf,StringUtil.isNull(routerHead.getMsg()).getBytes().length);
		        		nf+=32;
		            	
		        		RspDataBuffer = buffer;
		            	break;
		            	//throw new BussinessException(routerHead.getMsg());
		            }*/
			    }	
			}
			
			return RspDataBuffer;
		} catch (Exception e) {
			throw new BussinessException(e.getMessage());
		} finally{
			if(subscriber!=null && poll!=null){
				poll.unregister(subscriber);
				subscriber.close();
				//context.close();
			}
		}
	}
	
	/**
	 * 将服务名转为Long类型
	 */
	public static long getCrcLongByString(ServerNumber zeromqServer, String str){
		CRC32 crc = new CRC32();
        crc.update(zeromqServer==null?str.getBytes():zeromqServer.toString().getBytes());
        
        return crc.getValue();
	}
	
	/**
	 * 获取发送数据json
	 */
	public static byte[] getReqBufferByCondition(String str, int functionNum, long requestNum, String clientId){
		/*判断是否压缩*/
		int packLength = str.length();
		byte[] ReqHeadBuffer = HeadSession.getHeadReqBufferByJson(functionNum, requestNum, null, clientId, 0, packLength, packLength, null);// 获得请求协议头
		byte[] reqBuffer = new byte[ReqHeadBuffer.length + StringUtil.isNull(str).getBytes().length];
		System.arraycopy(ReqHeadBuffer, 0, reqBuffer, 0, ReqHeadBuffer.length);
		//System.arraycopy(ReqDataBuffer, 0, reqBuffer, ReqHeadBuffer.length,ReqDataBuffer.length);
		System.arraycopy(StringUtil.isNull(str).getBytes(), 0, reqBuffer, ReqHeadBuffer.length, StringUtil.isNull(str).getBytes().length);
		
		return reqBuffer;
	}
	
}