index.jsp..

  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    java.util.HashMap<String,Integer>cart=(java.util.HashMap<String,Integer>)
            session.getAttribute("cart");
                if(cart==null){
                    cart=new java.util.HashMap<String,Integer>();
                    session.setAttribute("cart", cart);
                }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping cart</title>
        <style>
            table{
                width:50%;
                border-collapse: collapse;
                margin-top:20px;
            }
            th,td{
                border:1px solid black;
                padding:8px;
                text-align: left;
            }
            th{
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>
        <h1>Add item to cart</h1>
        <form action="add.jsp" method"post">
              <label>Item Name</label>
            <input type="text" name="item" required>
            <input type="submit" value="Add to Cart">
            </form>
        <h2>Shopping Cart</h2>
        <table>
            <tr>
                <th>Item</th>
                <th>Quantity</th>
                <th>Action</th>
            </tr>
            <%
                for(String item:cart.keySet()){
            %>
            <tr>
                <td><%=item%></td>
                <td><%=cart.get(item)%></td>
                <td><a href="remove.jsp?item=<%=item%>">Remove</a></td>
            </tr>
            <%
                }
                %>
        </table>
                
                
    </body>
</html>


          add.jsp...

          

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String item =request.getParameter("item");
            java.util.HashMap<String,Integer>cart=
                    (java.util.HashMap<String,Integer>)
                    session.getAttribute("cart");
            
            if(cart.containsKey(item)){
                cart.put(item, cart.get(item)+1);
            }else{
                cart.put(item,1);
                
            }
            response.sendRedirect("index.jsp");     
        %>
    </body>
</html>


          remove.jsp..


          

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String item =request.getParameter("item");
            java.util.HashMap<String,Integer> cart = 
                    (java.util.HashMap<String,Integer>)
                    session.getAttribute("cart");
            if(cart.containsKey(item)){
                if(cart.get(item)>1){
                    cart.put(item, cart.get(item)-1);
                }else{
                    cart.remove(item);
                }
            }
            response.sendRedirect("index.jsp");
            
                    
        %>
    </body>
</html>
