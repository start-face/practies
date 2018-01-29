package com.tuhao.controller;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @autor FaceFeel
 * @create 2017-10-15 20:38
 */

public class ExcuteTag extends SimpleTagSupport {

    @Override
    public void doTag() throws IOException, JspException {

        //取得标签体中的内容，并封装成份JspFragment对象
        JspFragment jspBody = this.getJspBody();
        //将标签体的内容输出到浏览器，null表示浏览器
        jspBody.invoke(null);
    }
}

