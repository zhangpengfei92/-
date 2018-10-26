/**
 * 
 */
package com.jcl.tradedao;

import java.util.List;
import java.util.Map;

import com.jcl.pojo.EntrustOrder;

/**
 * @author heqiwen
 * @date 2018-5-24
 * @describe
 * @modify 
 * @Copyright jcl
 */
public interface HisOrderMapper {

	/**
	 * @return 
	 * @author heqiwen
	 * @date 2018-5-24
	 * @decribe 从c++交易库中查询历史委托记录，定时任务只查当天的
	 * @param condition
	 * @return
	 */
	List<EntrustOrder> getEntrustRecordList(Map<String, Object> condition);

}
