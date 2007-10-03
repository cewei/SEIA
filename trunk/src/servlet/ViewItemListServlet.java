/*
 * ViewItemListServlet.java
 *
 * Created on 1 October 2007, 21:53
 */

package servlet;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;
import model.*;

/**
 *
 * @author cewei.foo.2006
 * @version
 */
public class ViewItemListServlet extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /* TODO output your page here
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet ViewItemListServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet ViewItemListServlet at " + request.getContextPath () + "</h1>");
        out.println("</body>");
        out.println("</html>");
         */
        Item [] result = ItemDataManager.retriveAll();
        request.setAttribute("items", result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/itemListing.jsp");
        dispatcher.forward(request, response);
        out.close();
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
