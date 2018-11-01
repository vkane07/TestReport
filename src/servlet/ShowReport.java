package servlet;
import service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 报表工程
 */
public class ShowReport extends HttpServlet{
    public ShowReport(){
        super();
    }
    public void init() throws ServletException{

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        List list;
        Service service = new Service();
        list = service.getProfit();

        request.getSession().setAttribute("PROFIT",list);
        response.sendRedirect("index.jsp");
    }
}
