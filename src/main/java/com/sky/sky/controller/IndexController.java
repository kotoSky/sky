package com.sky.sky.controller;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Auther: HJH
 * @Date: 2019/7/23
 * @Description: TODO
 */

@RestController
public class IndexController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    String index() {
        return "Hello Spring Boot";
    }

    @RequestMapping(path = "/img", method = RequestMethod.GET)
    public void getImg(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 获取文件
        String s = "C:\\Users\\kfwy_it_002\\Desktop\\E201905140012c6eb\\190723b10622019f2c49.png";
        File file = new File(s);
        // 设置长度
        response.setContentLength((int) file.length());
        // 内容配置中要转码,inline 浏览器支持的格式会在浏览器中打开,否则下载
        response.addHeader("Content-Disposition", "inline;filename=q.jpg");
        // 设置content-type
        response.setContentType("jpg");

        BufferedImage sourceImg = ImageIO.read(new FileInputStream(file));
        int width = sourceImg.getWidth();
        int height = sourceImg.getHeight();
        long pixel = width * height;
        System.out.println(height + " " + width);
        System.out.println(pixel);

        String newPath = "C:\\Users\\kfwy_it_002\\Desktop\\2-800-600.jpg";
        File fzm = new File(newPath);
        if (pixel > 480000) {
            Thumbnails.Builder<File> tb = Thumbnails.of(new File[]{file});
            // tb.forceSize(640, 480).toFile(fzm);
            tb.size(800, 600);
            tb.watermark(Positions.CENTER, ImageIO.read(new File("C:\\Users\\kfwy_it_002\\Desktop\\water.png")), 0.5f);
            tb.toFile(fzm);
        } else {
            fzm = file;
        }
        printFile(fzm, response);
    }

    public void printFile(File f, HttpServletResponse response) throws IOException {
        ServletOutputStream os = response.getOutputStream();
        FileInputStream is = new FileInputStream(f);
        int i = is.available();
        try {
            byte[] bytes = new byte[i];
            is.read(bytes);
            os.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                os.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }

}
