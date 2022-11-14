package mvc.simple;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    public void doPst(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");

        Object resultObject = null;
        if (type == null || type.equals("greeting")) {
            resultObject = "안녕하세요";
        } else if (type.equals("date")) {
            resultObject = new java.util.Date();
        } else resultObject = "Invalid TYpe";

        request.setAttribute("result", resultObject);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/chap18/simpleView.jsp");
        dispatcher.forward(request, response);

    }

}
