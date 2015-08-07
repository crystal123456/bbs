package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class putjcaptchaUtils {

	public void getJcaptcha() throws IOException {
		BufferedImage img = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);

		// 得到该图片的绘图对象

		Graphics g = img.getGraphics();

		Random r = new Random();

		Color c = new Color(200, 150, 255);

		g.setColor(c);

		// 填充整个图片的颜色

		g.fillRect(0, 0, 68, 22);

		// 向图片中输出数字和字母

		StringBuffer sb = new StringBuffer();

		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

		int index, len = ch.length;

		for (int i = 0; i < 4; i++) {

			index = r.nextInt(len);

			g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));

			g.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));// 输出的
																		// 字体和大小

			g.drawString("" + ch[index], (i * 15) + 3, 18);// 写什么数字，在图片的什么位置画

			sb.append(ch[index]);

		}

		Struts2Utils.getRequest().getSession().setAttribute("piccode", sb.toString());

		ImageIO.write(img, "JPG", Struts2Utils.getResponse().getOutputStream());

	}
}
