package com.jcl.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class AsposeLicense
{
	public static InputStream getStringInputStream() {
    	StringBuilder str=new StringBuilder();
    	str.append("<License>");
    	str.append("<Data>");
    	str.append("<Products>");
    	str.append("<Product>");
    	str.append("Aspose.Total for Java");
    	str.append("</Product>");
    	str.append("<Product>");
    	str.append("Aspose.Words for Java");
    	str.append("</Product>");
    	str.append("</Products>");
    	str.append("<EditionType>");
    	str.append("Enterprise");
    	str.append("</EditionType>");
    	str.append("<SubscriptionExpiry>");
    	str.append("20991231");
    	str.append("</SubscriptionExpiry>");
    	str.append("<LicenseExpiry>");
    	str.append("20991231");
    	str.append("</LicenseExpiry>");
    	str.append("<SerialNumber>");
    	str.append("23dcc79f-44ec-4a23-be3a-03c1632404e9");
    	str.append("</SerialNumber>");
    	str.append("</Data>");
    	str.append("<Signature>");
    	str.append("2sNLLKGMUdF0r8O1kKilWAGdgfs2BvJb/2Xp8p5iuDVfZXmhppo+d0Ran1P9TKdjV4ABwAgKXxJ3jcQTqE/2IRfqwnPf8itN8aFZlV3TJPYeD3yWE7IT55Gz6EijUpC7aKeoohTb4w2fpox58wWoF3SNp6sK6jDfiAUGEHYJ9pjU=");
    	str.append("</Signature>");
    	str.append("</License>");
        if (str != null && str.length()>0) {
            try {
                ByteArrayInputStream stringInputStream = new ByteArrayInputStream(
                		str.toString().getBytes());
                return stringInputStream;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
