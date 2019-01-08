package com.jcl.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jcl.util.Constant;

@Controller
@RequestMapping("/Captcha")
public class Captcha {

	// 图片宽度
	private static final int WIDTH = 120;
	// 图片高度
	private static final int HEIGHT = 40;
	// 字符距上边框的距离
	private static final int PADDINGTOP = 35;
	// 字符距左边框的距离
	private static final int PADDINGLEFT = 20;
	// 字符间距
	private static final int SPACING = 20;
	// 字符大小
	private static final int FONTSIZE = 40;

	private static char[] captchas = new char[] { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'o', 'p', 'a', 's', 'd', 'f',
			'g', 'h', 'j', 'k', 'z', 'x', 'c', 'v', 'b', 'n', 'm', '2', '3', '4', '5', '6', '7', '8', '9',
			'0', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'O', 'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K','Z',
			'X', 'C', 'V', 'B', 'N', 'M' };

	Random random = new Random();

	// 给定范围获取随机颜色
	Color getRandColor(int fc, int bc) {

		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);

	}

	@RequestMapping("/get/{no}")
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		// 设置页面缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/JPEG");
		// 在内存中创建图像
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文
		Graphics g = image.getGraphics();
		// 生成随机类
		Random random = new Random();
		// 设置背景颜色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, WIDTH, HEIGHT);

		// 设定字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, FONTSIZE));

		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 50; i++) {
			int x = random.nextInt(WIDTH);
			int y = random.nextInt(HEIGHT);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		// 取随机产生的认证码(4位数字)
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			int car = captchas.length - 1;
			String rand = String.valueOf(captchas[random.nextInt(car) + 1]);
			sRand += rand;
			// 将认证码显示到图象中
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(rand, SPACING * i + PADDINGLEFT, PADDINGTOP);
		}
		// 将认证码存入session
		request.getSession().setAttribute(Constant.SESSION_CAPTCHA, sRand);

		// 图像生效
		g.dispose();

		// 输出图像到页面
		try {
			ImageIO.write(image, "jpeg", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
