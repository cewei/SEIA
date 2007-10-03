/*
 * AddLineItemServlet.java
 *
 * Created on 1 October 2007, 23:36
 */

package servlet;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
import model.Item;
import model.ItemDataManager;
import model.LineItem;

/**
 *
 * @author cewei.foo.2006
 * @version
 */
public class AddLineItemServlet extends HttpServlet {
    
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
        out.println("<title>Servlet AddLineItemServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet AddLineItemServlet at " + request.getContextPath () + "</h1>");
        out.println("</body>");
        out.println("</html>");
         */
        ArrayList <LineItem> cart = null;
        
        out.println("U are at AddLineItemServlet <br>");
        
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        cart = (ArrayList<LineItem>) session.getAttribute("shoppingCart");
        if(cart == null){
            cart = new ArrayList <LineItem>();
        }
        
        LineItem lineItem = new LineItem();
        lineItem.setLineItem(ItemDataManager.retrieve(id));
        cart.add(lineItem);
        
        session.setAttribute("shoppingCart", cart);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cart.jsp");
        dispatcher.forward(request, response);
        
        out.println(id);
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
