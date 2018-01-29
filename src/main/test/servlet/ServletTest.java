package servlet;

import org.junit.Test;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @autor FaceFeel
 * @create 2017-11-25 12:45
 */

public class ServletTest extends HttpServlet{

    @Test
    public void test_getParameterMap(){

//        service();
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response){

        Map<String, String[]> parameterMap = request.getParameterMap();
        System.err.println(""+ parameterMap + "  " + parameterMap.isEmpty());
    }
}
