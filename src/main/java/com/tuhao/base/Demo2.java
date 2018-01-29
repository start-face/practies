package com.tuhao.base;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.UUID;

public class Demo2 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{

        response.setHeader("refresh","3;url=http://localhost:8888/demo2");
        response.setContentType("image");
        BufferedImage bufferedImage = new BufferedImage(600,50,BufferedImage.TYPE_INT_RGB);
        //取得画笔
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setFont(new Font("黑体",Font.BOLD,22));
        graphics.setColor(Color.YELLOW);
        graphics.drawString(getUUID(),20,20);
        ImageIO.write(bufferedImage,"JPG",response.getOutputStream());
    }

    private String getUUID(){
        return UUID.randomUUID().toString();
    }
}

