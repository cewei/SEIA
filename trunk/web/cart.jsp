<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="model.*,java.util.ArrayList,java.util.Iterator,java.text.DecimalFormat" %>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%
//HttpSession session = request.getSession();
ArrayList <LineItem> cart = (ArrayList<LineItem>) session.getAttribute("shoppingCart");
if(cart == null){
    response.sendRedirect("View-All");
}
Iterator display = cart.iterator();
DecimalFormat format = new DecimalFormat("0.00");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online T-Shirt Shop</title>
    </head>
    <body>
        
        <h1>My Shopping Cart</h1>
        <form method="POST" enctype="multipart/form-data" action="./index.jsp">
        <table border="1">
            <thead>
                <tr>
                    <th>S/N</th>
                    <th>Description</th>
                    <th>Size</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Sub-Total</th>
                </tr>
            </thead>
            <tbody>
                <% int i=0;
                while(display.hasNext()){
                    LineItem temp = (LineItem) display.next();
                %>
                <tr>
                    <td><%=i+1%></td>
                    <td><%=temp.getLineItem().getItemDescription()%></td>
                    <td><select name="size" >
                            <option value="Small">Small</option>
                            <option value="Medium">Medium</option>
                            <option value="Large">Large</option>
                    </select></td>
                    <td>$<%=format.format(temp.getLineItem().getItemPrice())%></td>
                    <td><input type="text" name="quantity" value="" size="5" /></td>
                    <td></td>
                    <td>Delete</td>
                </tr>
                <%
                i++;
                }
                %>
            </tbody>
        </table>
            <input type="submit" value="Update" name="Update" />
        </form>
        
        
        <%--
    This example uses JSTL, uncomment the taglib directive above.
    To test, display the page like this: index.jsp?sayHello=true&name=Murphy
    --%>
        <%--
    <c:if test="${param.sayHello}">
        <!-- Let's welcome the user ${param.name} -->
        Hello ${param.name}!
    </c:if>
    --%>
    
    </body>
</html>
