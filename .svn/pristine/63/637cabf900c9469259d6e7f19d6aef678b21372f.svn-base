package com.jcl.stock.simulate.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.jcl.stock.simulate.DefineNumber;
import com.jcl.util.DateUtil;

public class SimulateTest implements CallBackStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SimulateStockService sss = new SimulateStockServiceImpl();
		try {
			//String rbStr = sss.commonFunction("{\"client_id\":\"ZxmnX10033\"}", DefineNumber.JCL_PROTOCOL_ID_REQ_TRADECOUNT);
			/*String rbStr = sss.commonFunction("{\"login\":5506451,\"password\":\"z123456\"}", 11101); //客户校验即绑定用户 OK
			String rbStr = sss.commonFunction("{\"login\":5506462,\"password\":\"z123456\"}", 11101); //客户校验即绑定用户 OK
			System.out.println(rbStr);
			
			System.out.println(rbStr2);*/
			//String rbStr2 = sss.commonFunction("{\"login\":5506470}", 11103); //资金查询 OK
			//System.out.println("资金查询"+rbStr2);
			String rbStr2 = sss.commonFunction("{\"login\":5510120}", 11103); //资金查询 OK
			System.out.println("资金查询 5510120"+rbStr2);
			
			//String rbStr = sss.commonFunction("{\"login\":5506462}", 11123); //用户持仓查询 OK
			//System.out.println(rbStr);
			//String rbStr3 = sss.commonFunction("{\"login\":5506470}", 11123); //用户持仓查询 OK
			//System.out.println("持仓查询"+rbStr3);
			
			/*rbStr = sss.commonFunction("{}", 11104); //资金查询 OK
			System.out.println(rbStr);
			
			rbStr = sss.commonFunction("{\"login\":5506451}", 11146); //合约查询  OK
			System.out.println(rbStr);*/
			
			for(int i = 0; i < 1; i++) {
				//String rbStr = sss.commonFunction("{\"login\":5506438}", 11123); //用户持仓查询 OK
				//System.out.println("用户持仓:" + rbStr);
				
				Date nowDate = Calendar.getInstance().getTime();//当前时间
				Date lastThreeDate = DateUtil.changeMonth(nowDate, -3);
				
				String settledate = DateUtil.dateToString(nowDate) + " 00:00:00";
				String lastSettledate = DateUtil.changeDay(settledate, "yyyy-MM-dd", -1) + " 23:59:59";
				/*入库DB结算日期*/
				Date settledateIntoDb = DateUtil.stringToDate(DateUtil.changeDay(settledate, DateUtil.DATETIME_PATTERN_ONE, -1), DateUtil.DATETIME_PATTERN_ONE);
				
				String settleMonth = DateUtil.dateFormat(lastThreeDate, "yyyy-MM-dd") + " 00:00:00";
				BigDecimal fromDayDate = (new BigDecimal(DateUtil.stringToDate(settleMonth, DateUtil.DATETIME_PATTERN_ONE).getTime())).divide(new BigDecimal(1000));
				String toDayStr = DateUtil.dateFormat(nowDate, "yyyy-MM-dd") + " 23:59:59";
				BigDecimal toDayDate = (new BigDecimal(DateUtil.stringToDate(toDayStr, DateUtil.DATETIME_PATTERN_ONE).getTime())).divide(new BigDecimal(1000));
				long fromDay = fromDayDate.longValue();
				long toDay = toDayDate.longValue();//5506451
				//String nowMonthStr = DateUtil.dateFormat(nowDate, "yyyy-MM-dd").substring(0, 7) + "-01 00:00:00";
				//long nowMonth = (new BigDecimal(DateUtil.stringToDate(nowMonthStr, DateUtil.DATETIME_PATTERN_ONE).getTime())).divide(new BigDecimal(1000)).longValue();
				String rbStr = sss.commonFunction("{\"login\":5510077,\"from\":"+fromDay+",\"to\":"+toDay+"}", 11121); //历史成交  OK
				System.out.println("\"from\":"+fromDay+",\"to\":"+toDay + "-----" + rbStr);
				
				fromDayDate = (new BigDecimal(settledateIntoDb.getTime())).divide(new BigDecimal(1000));
				toDayDate = (new BigDecimal(DateUtil.stringToDate(lastSettledate, DateUtil.DATETIME_PATTERN_ONE).getTime())).divide(new BigDecimal(1000));
				rbStr = sss.commonFunction("{\"login\":5510077,\"from\":"+fromDayDate.longValue()+",\"to\":"+toDayDate.longValue()+"}", DefineNumber.JCL_PROTOCOL_ID_REQ_LSCJ);
				System.out.println("\"from\":"+fromDay+",\"to\":"+toDay + "-----" + rbStr);
				//rbStr = sss.commonFunction("{\"login\":5506452,\"from\":"+nowMonth+",\"to\":"+toDay+"}", 11121); //历史成交  OK
				//System.out.println("\"from\":"+nowMonth+",\"to\":"+toDay + "-----" + rbStr);
				
				//5506458 5506438 5506450 5506452 5506451 5506453
				//System.out.println(fromDay + "-" + toDay + "-" + DateUtil.stringToDate(toDayStr, DateUtil.DATETIME_PATTERN_ONE).getTime());
				/*Long time =System.currentTimeMillis()/1000;
				System.out.println(time);
				 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");//24小时制 
				 long time2 = simpleDateFormat.parse("2017-10-9 00-00-00").getTime()/1000;
				 System.out.println(time2);
				 long time1 = simpleDateFormat.parse("2017-10-12 00-00-00").getTime()/1000;
				 System.out.println(time1);
				 Map<String, Object> result = new LinkedHashMap<String, Object>();
				 result.put("login", 5506470);
				 result.put("from", time2);
				 result.put("to", time);
				 Gson gson = new Gson();
				 String json = gson.toJson(result);
				 System.out.println(json);
				 rbStr = sss.commonFunction(json,11121); //历史成交  OK
				 */			
				//System.out.println(simpleDateFormat.format(Long.parseLong("1507856582000")));
				// rbStr = sss.commonFunction("{\"login\":5506450,\"from\":time2,\"to\":time1}", 11121); //历史成交  OK
			}
			
			/*Long time =System.currentTimeMillis()/1000;
			//System.out.println(time);
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");//24小时制 
			long time2 = simpleDateFormat.parse("2017-11-17 00-00-00").getTime()/1000;
			//System.out.println(time2);
			long time1 = simpleDateFormat.parse("2017-09-12 00-00-00").getTime()/1000;
			//System.out.println(time1);
			Map<String, Object> result = new LinkedHashMap<String, Object>();
			result.put("login", 5509975);
			result.put("from", time2);
			result.put("to", time);
			Gson gson = new Gson();
			String json = gson.toJson(result);
			// System.out.println("历史记录查询"+json);
			//System.out.println(simpleDateFormat.format(Long.parseLong("1507856582000")));
			String rbStr = sss.commonFunction("{\"login\":5506450,\"from\":time2,\"to\":time1}", 11121); //历史成交  OK
			// rbStr = sss.commonFunction("{\"login\":5509912,\"from\":time2,\"to\":time1}", 11121); //历史成交  OK
			rbStr = sss.commonFunction(json,11121); //历史成交  OK
			System.out.println("历史记录查询"+rbStr);*/

			/*rbStr = sss.commonFunction("{\"teach_id\":5506451,\"user_id\":5506452,\"follow_direction\":0,\"follow_way\":0,\"follow_num\":5.0,\"follow_ratio\":0.0,\"follow_sl\":0.0}", 11100); //客户跟单  OK
			System.out.println(rbStr);*/
			
			/*返回数据
			 * 
			 *  {"describe":"","status":0}

				{"data":{"balance":1000000.0,"equity":1000000.0,"margin":0.0,"margin_free":1000000.0,"margin_level":0.0},"describe":"","status":0}
				
				{"describe":"","holders":[],"status":0,"totalnum":0}
				
				{"describe":"","status":0,"symbols":[{"currency":"USD","description":"黄金/美元(浮动点差)","digits":2,"symbol":"XAUUSD"},{"currency":"USD","description":"白银/美元","digits":3,"symbol":"XAGUSD"},{"currency":"USD","description":"美元/日元","digits":3,"symbol":"USDJPY"},{"currency":"EUR","description":"欧元/美元","digits":5,"symbol":"EURUSD"},{"currency":"AUD","description":"澳元/美元","digits":5,"symbol":"AUDUSD"},{"currency":"USD","description":"美元/瑞士法郎","digits":5,"symbol":"USDCHF"},{"currency":"EUR","description":"欧元/英镑","digits":5,"symbol":"EURGBP"},{"currency":"GBP","description":"英镑/美元","digits":5,"symbol":"GBPUSD"},{"currency":"USD","description":"美元/加元","digits":5,"symbol":"USDCAD"},{"currency":"CHF","description":"瑞士法郎/日元","digits":3,"symbol":"CHFJPY"},{"currency":"AUD","description":"澳元/加元","digits":5,"symbol":"AUDCAD"},{"currency":"EUR","description":"欧元/瑞士法郎","digits":5,"symbol":"EURCHF"},{"currency":"AUD","description":"澳元/日元","digits":3,"symbol":"AUDJPY"},{"currency":"EUR","description":"欧元/日元","digits":3,"symbol":"EURJPY"},{"currency":"CAD","description":"加元/日元","digits":3,"symbol":"CADJPY"},{"currency":"NZD","description":"纽元/美元","digits":5,"symbol":"NZDUSD"},{"currency":"GBP","description":"英镑/瑞士法郎","digits":5,"symbol":"GBPCHF"},{"currency":"GBP","description":"英镑/澳元","digits":5,"symbol":"GBPAUD"},{"currency":"GBP","description":"英镑/加元","digits":5,"symbol":"GBPCAD"},{"currency":"GBP","description":"英镑/日元","digits":3,"symbol":"GBPJPY"},{"currency":"NZD","description":"纽元/瑞士法郎","digits":5,"symbol":"NZDCHF"},{"currency":"USD","description":"美元/新加坡元","digits":5,"symbol":"USDSGD"},{"currency":"CAD","description":"加元/瑞士法郎","digits":5,"symbol":"CADCHF"},{"currency":"EUR","description":"欧元/加元","digits":5,"symbol":"EURCAD"},{"currency":"AUD","description":"澳元/纽元","digits":5,"symbol":"AUDNZD"},{"currency":"AUD","description":"澳元/瑞士法郎","digits":5,"symbol":"AUDCHF"},{"currency":"EUR","description":"欧元/澳元","digits":5,"symbol":"EURAUD"},{"currency":"NZD","description":"纽元/日元","digits":3,"symbol":"NZDJPY"},{"currency":"EUR","description":"欧元/纽元","digits":5,"symbol":"EURNZD"},{"currency":"GBP","description":"英镑/纽元","digits":5,"symbol":"GBPNZD"},{"currency":"NZD","description":"纽元/加元","digits":5,"symbol":"NZDCAD"},{"currency":"USD","description":"US Dollar vs ","digits":5,"symbol":"USDCNH"},{"currency":"EUR","description":"Euro vs ","digits":5,"symbol":"EURNOK"},{"currency":"EUR","description":"Euro vs ","digits":5,"symbol":"EURPLN"},{"currency":"EUR","description":"Euro vs ","digits":5,"symbol":"EURSEK"},{"currency":"EUR","description":"Euro vs ","digits":5,"symbol":"EURTRY"},{"currency":"GBP","description":"Great Britan Pound vs ","digits":5,"symbol":"GBPSEK"},{"currency":"NOK","description":"","digits":5,"symbol":"NOKSEK"},{"currency":"USD","description":"US Dollar vs ","digits":3,"symbol":"USDHUF"},{"currency":"USD","description":"US Dollar vs ","digits":5,"symbol":"USDMXN"},{"currency":"USD","description":"US Dollar vs ","digits":5,"symbol":"USDNOK"},{"currency":"USD","description":"US Dollar vs ","digits":5,"symbol":"USDPLN"},{"currency":"USD","description":"US Dollar vs ","digits":5,"symbol":"USDSEK"},{"currency":"USD","description":"US Dollar vs ","digits":5,"symbol":"USDTRY"},{"currency":"USD","description":"US Dollar vs ","digits":5,"symbol":"USDZAR"},{"currency":"USD","description":"","digits":2,"symbol":"USDX"},{"currency":"XTI","description":"原油","digits":3,"symbol":"XTIUSD"},{"currency":"USD","description":"CSI 300 Index Spot","digits":2,"symbol":"CHINA300"},{"currency":"USD","description":"鑫富A50","digits":2,"symbol":"CHINA-A50"}],"totalnum":49}
				
				{"describe":"","records":[],"status":0,"totalnum":0}
				
				{"describe":"","status":0}

			 * */
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// 异步测试
		/*if (false) {
			SimulateTest simulateTest3 = new SimulateTest();
			String s = "{\"client_id\":\"49008\",\"start\":0,\"limit\":1000,\"entrust_type\":0}";
			String s2 = "{\"end\":4,\"game_type\":0,\"sort_type\":1,\"start\":0}";
			try {
				long tick = System.currentTimeMillis();
				long send = 0,recv = 0;
				long[] count = new long[7];
				while (true) {
					for (int i = 0; i < 1000; i++) {
						try {
							long num = sss.commonAjaxFunction(s, 30018, simulateTest3);
							//sss.commonAjaxFunction(s2, 40006, simulateTest3);
						} catch (BussinessException e) {
							e.printStackTrace();
						}
					}
					try {
						Thread.sleep(10);
					} catch (Exception e) {
					}
					long now = System.currentTimeMillis();
					if (now - tick > 5000) {
						double dt = now - tick;
						sss.getPackCount(count, false);
						System.out.println("send:" + (count[0] - send) / dt + "/ms, recv:" + (count[1] - recv) / dt + "/ms, 发送队列: " + count[2] + ", 接收队列: " + count[3] + ", 尚未回调: " + count[4] + ", 请求数:" + count[0] + ", 尚未应答数:" + (count[0] - count[1]) + ", 应答成功率:" + count[6]*100.0/count[0] + "%");
						tick = now;
						send = count[0];
						recv = count[1];
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {*/
			/*String s = "{\"client_id\":\"fdsa1022\",\"start\":0,\"limit\":1000,\"entrust_type\":0}";
			String s2 = "{\"end\":4,\"game_type\":0,\"sort_type\":1,\"start\":0}";
			String s3 = "{\"client_id\":\"18627939715\",\"start\":1,\"limit\":1000,\"entrust_type\":0,\"start_date\":20160601,\"end_date\":20160630}";
			try {
				while (true) {
					long count = 0;
					long tick = System.currentTimeMillis();
					for (int i = 0; i < 10; i++) {
						try {
							System.out.println(sss.commonFunction(s3, 30018));// 同步
							//sss.commonFunction(s2, 40006);
							count ++;
						} catch (BussinessException e) {
							e.printStackTrace();
						}
					}
					long now = System.currentTimeMillis();
					double dt = now - tick;
					System.out.println("同步请求耗时:" + dt/count + "ms/个");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			/*String s = "{\"client_id\":\"fdsa1022\",\"start\":0,\"limit\":1000,\"entrust_type\":0}";
			String s2 = "{\"end\":4,\"game_type\":0,\"sort_type\":1,\"start\":0}";
			String s3 = "{\"client_id\":\"18627939716\",\"start\":1,\"limit\":1000,\"entrust_type\":0,\"start_date\":20161101,\"end_date\":20161130}";
			String s4 = "{\"client_id\":\"18627939716\",\"entrust_bs\":1,\"entrust_price\":9.359999656677246,\"entrust_type\":3,\"entrust_typeid\":\"mn\",\"exchange_type\":0,\"game_id\":\"mn\",\"stock_code\":\"000001\"}";
			String s5 = "{\"client_id\":\"18627939716\",\"game_id\":\"mn\",\"limit\":10000,\"start\":0}";
			try {
				long count = 0;
				while (true) {
					long tick = System.currentTimeMillis();
					for (int i = 1; i < 10; i++) {
						try {
							//System.out.println(sss.commonFunction(s, 11119));// 同步
							//System.out.println(sss.commonFunction(s3, 11121));// 同步
							//System.out.println(sss.commonFunction(s2, 40006));
							//if(count%2 == 0){
							//	System.out.println(count + " action:" + sss.commonFunction(s5, 11124));
							//} else {
							//	System.out.println(count + " action:" + sss.commonFunction(s4, 11114));
							//}
							//System.out.println(count + " action:" + i + sss.commonFunction(s4, 11114));
							System.out.println(count + " action:" + sss.commonFunction(s5, 11124));
							count++;
						} catch (BussinessException e) {
							e.printStackTrace();
						}
					}
					Thread.sleep(10000);
					long now = System.currentTimeMillis();
					double dt = now - tick;
					System.out.println("同步请求耗时:" + dt/count + "ms/个");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}*/

		//}
	}

	@Override
	public String getResponseResult(Object... arg) {
		//System.out.println("请求返回数：" + arg[0] + " 功能号：" + arg[1] + " 返回值：" + arg[2] + " 是否成功：" + arg[3] + " 错误描述：" + arg[4] + " 状态值: " + arg[5]);
		return null;
	}

}
