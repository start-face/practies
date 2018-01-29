package com.tuhao.base;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class Photo extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {

        String pathName= "/image/12.jpg";
        ServletContext context = this.getServletContext();
        String realPath = context.getRealPath(pathName);
        File file = new File(realPath);
        InputStream is= new FileInputStream(file);
//        OutputStream os = new FileOutputStream()
        OutputStream os = response.getOutputStream();

        byte [] buffer = new byte[1024];
        int len;

        while((len = is.read(buffer))>0){
            os.write(buffer,0,len);
        }
        os.close();
        is.close();
    }
}
