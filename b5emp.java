index.html

  <!DOCTYPE html>

    
<html>
    <head>
        <title>Add employee.</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Add Employee</h1>
        <form method="POST" action="AddEmployee">
            <table>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="ename"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email"></td>
                </tr>
                <tr>
                    <td>Country</td>
                    <td><select name="country">
                    <option>India</option>
                    <option>Sri Lanka</option>
                    <option>Nepal</option>
                    <option>Bhutan</option>
                        </select></td>
                </tr>
                <tr>
                    
                    <td colspan="2"><input type="submit" name="Submit" value="Save Employee"></td>
                </tr>
            </table>
        </form>
        <a href="ViewEmployee">View Employees</a>
        
         
        
        
    </body>
</html>

    AddEmployee.java


package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddEmployee extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String ename=request.getParameter("ename");
            String password=request.getParameter("password");
            String email=request.getParameter("email");
            String country=request.getParameter("country");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/EmployeeDB","neelu","abcd1234");
            Statement stmt = con.createStatement();
            String sql="INSERT INTO NEELU.EMPLYOEE (ENAME, PASSWORD, EMAIL, COUNTRY) VALUES ('"+ename+"', '"+password+"', '"+email+"', '"+country+"')";
            int rcount=stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> AddEmployee</title>");            
            out.println("</head>");
            out.println("<body>");
            if(rcount==1){
            out.println("<h1>RECORD SAVED..:)</h1>");
            }else{
            out.println("<h1>ERROR..:(</h1>");
            }
            out.println("<a href=\"index.html\">Home</a>");
            
            out.println("</body>");
            out.println("</html>");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


SaveEmployee.java..

 

package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveEmployee extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String id=request.getParameter("id");
           String ename=request.getParameter("ename");
            String password=request.getParameter("password");
            String email=request.getParameter("email");
            String country=request.getParameter("country");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/EmployeeDB","neelu","abcd1234");
            Statement stmt = con.createStatement();
            String sql="UPDATE NEELU.EMPLYOEE SET ENAME='"+ename+"',PASSWORD='"+password+"',EMAIL='"+email+"',COUNTRY='"+country+"' WHERE ID="+id;
            int rcount=stmt.executeUpdate(sql);
            stmt.close();
            con.close();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>SaveEmployee</title>");            
            out.println("</head>");
            out.println("<body>");
            if(rcount==1){
            out.println("<h1>RECORD SAVED..:)</h1>");
            }else{
            out.println("<h1>ERROR..:(</h1>");
            }
            out.println("<a href=\"ViewEmployee\">View Employees</a>");
            
            out.println("</body>");
            out.println("</html>");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SaveEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SaveEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


updateEmployee.java..


package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateEmployee extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int id=Integer.parseInt(request.getParameter("id"));
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/EmployeeDB", "neelu", "abcd1234");
            Statement stmt = con.createStatement();
            String sql = "select * from NEELU.EMPLYOEE where ID="+id;
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateEmployee</title>");            
            out.println("</head>");
            out.println("<body>");
      out.println("<h1>Update Employee</h1> ");
     out.println(" <form method=\"POST\" action=\"SaveEmployee\">");
     out.println("<input type=\"hidden\"name=\"id\" value=\""+id+"\">");
     out.println("     <table>");
     out.println("         <tr>");
     out.println("             <td>Name</td>");
     out.println("             <td><input type=\"text\" name=\"ename\"value="+rs.getString("ENAME")+"></td>");
     out.println("         </tr>");
     out.println("         <tr>");
     out.println("             <td>Password</td>");
     out.println("             <td><input type=\"password\" name=\"password\" value="+rs.getString("PASSWORD")+"></td>");
     out.println("         </tr>");
     out.println("         <tr>");
     out.println("             <td>Email</td>");
     out.println("             <td><input type=\"text\" name=\"email\"value="+rs.getString("EMAIL")+"></td>");
     out.println("         </tr>");
     out.println("         <tr>");
     out.println("             <td>Country</td>");
     out.println("             <td><select name=\"country\">");
     String sel=rs.getString("Country").equals("India")?"Selected":"";
     out.println("             <option "+sel+">India</option>");
     sel=rs.getString("Country").equals("Sri Lanka")?"Selected":"";
     out.println("             <option "+sel+">Sri Lanka</option>");
     sel=rs.getString("Country").equals("Nepal")?"Selected":"";
     out.println("             <option "+sel+">Nepal</option>");
     sel=rs.getString("Country").equals("Bhutan")?"Selected":"";
     out.println("             <option "+sel+">Bhutan</option>");
     out.println("                 </select></td>");
     out.println("         </tr>");
     out.println("         <tr>");
     out.println("             <td colspan=\"2\"><input type=\"submit\" name=\"Submit\" value=\"Edit&Save\"></td>");
     out.println("         </tr>");
     out.println("     </table>");
     out.println(" </form>");
     out.println("<a href=\"ViewEmployee\">View Employees</a>");
            out.println("</body>");
            out.println("</html>");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


viewEmployee.java..


package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 class ViewEmployee extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/EmployeeDB", "neelu", "abcd1234");
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM NEELU.EMPLYOEE";
            ResultSet rs = stmt.executeQuery(sql);
             out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> ViewEmployee</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("  <h1>EMPLOYEE LIST</h1>");
            out.println("  <table border=\"2\">");
            out.println("  <tr>");
            out.println("<th>ID</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th>");
            out.println("   </tr>");
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString("ID") + "</td>");
                out.println("<td>" + rs.getString("ENAME") + "</td>");
                out.println("<td>" + rs.getString("PASSWORD") + "</td>");
                out.println("<td>" + rs.getString("EMAIL") + "</td>");
                out.println("<td>" + rs.getString("COUNTRY") + "</td>");
                out.println("<td> <a href=\"UpdateEmployee?id="+rs.getString("ID")+"\">Edit</a></td>");

                out.println("</tr>");
            }
            out.println(" </table>");
            out.println("</body>");
            out.println("</html>");
            stmt.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewEmployee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
