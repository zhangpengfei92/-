package com.jcl.task;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jcl.util.FileUtil;
import com.jcl.util.Pinyin4jUtil;

@Component 
public class TaskJob {

	public static Logger log = Logger.getLogger(TaskJob.class);
	
	 /*@Scheduled(cron="00 00 05 * * ? ")   //每10秒执行一次  
	 public void aTask(){  
		 log.info("股票数据读取处理任务开始>........");
		 try {
				String rootPath = getClass().getResource("/").getFile().toString();
				String jsPath = rootPath.replace("/WEB-INF/classes/", "/js/stockjs/");
				//js/stockjs/stockdata.js
				
				Map<String, String> map = new HashMap<String, String>();
				//代码链放入缓存
				//MemCached.getClient().add("CODEMAP", map);
				
				//map.containsValue("深证指数");
				//System.out.println("+++++++++++++"+map.containsValue("农牧饲渔")+"++++++++++++++");
				//String vvvv = (String) map.get("SH000001");
				//System.out.println(vvvv);
				Iterator entries = map.entrySet().iterator();
				
				
				StringBuffer sb = new StringBuffer();
				sb.append("var stock = [");

				while (entries.hasNext()) {
					Map.Entry entry = (Map.Entry) entries.next();
					boolean flag = true;
					String code = entry.getKey().toString();
					if(entry.getValue().equals("农牧饲渔")){
						
						System.out.println(entry.getKey());
					}
					if(code.length() == 8){
						String shichang = code.substring(0,2);
						String newcode = code.substring(2,6);
						if(shichang.equals("SH")){
							if(newcode.indexOf("000") == 0 || newcode.indexOf("990") == 0 || newcode.indexOf("88") == 0 || newcode.indexOf("777") == 0 || newcode.indexOf("778") == 0 || newcode.indexOf("779") == 0){
								flag = false;
							}
						}else if(shichang.equals("SZ")){
							if(newcode.indexOf("339") == 0 ){
								flag = false;
							}
						}
					}else if(code.length() == 6){
						if(code.indexOf("000") != 0 && code.indexOf("60") != 0 && code.indexOf("300") != 0 && code.indexOf("002") != 0){
							flag = false;
						}
					}
					if(flag){
						//String pingyin = Pinyin.toDBC(Pinyin.getPinYinHeadChar(entry.getValue().toString()));
						String pingyin = Pinyin4jUtil.getPinyinJianPin(entry.getValue().toString());
						sb.append("{code:\"").append(entry.getKey().toString()).append("\",name:\"")
						.append(entry.getValue().toString()).append("\",pinyin:\"").append(pingyin)
						.append("\"},");
					}
				}
				String content = sb.toString().substring(0, sb.toString().length() - 1);
				content = content + "];"; 
				FileUtil.writerFile(jsPath + "stockdata.js", content, false, "UTF-8");
				//代码链放入缓存-除掉板块
				Iterator iterator = map.keySet().iterator();    
				while (iterator.hasNext()) {   
				    String key = (String) iterator.next();  
				    String keycode = key.substring(2);
				    if (keycode.startsWith("88")) {   
				       iterator.remove();        //添加该行代码   
				        //map.remove(key);       
				     }   
				 } 
				//MemCached.getClient().add("CODEMAPNOBANKUAI", map);
			} catch (Exception e) {
				e.printStackTrace();
			}
			log.info("股票数据读取处理任务结束>........");
		} */
	}

