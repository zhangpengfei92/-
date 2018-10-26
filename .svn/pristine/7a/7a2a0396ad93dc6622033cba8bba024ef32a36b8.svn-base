package com.jcl.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jcl.util.OrderNumUUId;
import com.jcl.util.RedisUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-*.xml")
public class appTest {
	@Test
	public void test() {
//		String string = OrderNumUUId.getOrderNo();
		System.out.println(RedisUtil.removeString("closeOrderList"+3));
		System.out.println(RedisUtil.removeString("traderOrderList"+1));
		System.out.println(RedisUtil.removeString("cancelOrderList"+3));
//		System.out.println(RedisUtil.getString("traderOrderList"+3).length());
	}
}
