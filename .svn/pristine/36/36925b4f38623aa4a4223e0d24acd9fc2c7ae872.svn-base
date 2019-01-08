/**
 * Copyright : http://www.sandpay.com.cn , 2011-2014
 * Project : sandpay-cashier-webgateway
 * $Id$
 * $Revision$
 * Last Changed by pxl at 2016-12-28 上午10:49:46
 * $URL$
 * <p>
 * Change Log
 * Author      Change Date    Comments
 * -------------------------------------------------------------
 * pxl         2016-12-28        Initailized
 */
package com.sandepay.quickpay;

import cn.com.sandpay.cashier.sdk.util.CertUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author pan.xl
 */
public class ContextLoadListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(ContextLoadListener.class);

    public void contextDestroyed(ServletContextEvent arg0) {
    }

    /**
     * 初始化密钥
     * @param arg0
     */
    public void contextInitialized(ServletContextEvent arg0) {

		String publicKeyPath = "classpath:sand-test.cer";
        String privateKeyPath = "classpath:mid-test.pfx";
		String keyPassword = "Lax123456";
        /*String publicKeyPathSC = "classpath:sand-test-sc.cer";
        String privateKeyPathSC = "classpath:mid-test-sc.pfx";
        String keyPasswordSC = "123456";*/

        // 加载证书
        try {
            logger.info("加载证书...");
            CertUtil.init(publicKeyPath, privateKeyPath, keyPassword);
            //CertUtil.init(publicKeyPathSC, privateKeyPathSC, keyPasswordSC);
            logger.info("加载证书...");
            //CertUtil.init(publicKeyPathSC, privateKeyPathSC, keyPasswordSC);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
