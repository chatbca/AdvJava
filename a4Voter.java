index.html



<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>voter</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            table{
                background-color: aqua;
                width:200px;
                margin-top: 100px;
                margin-left: auto;
                margin-right: auto;
                border: solid green 2px;
                color: green;
            }
            td{
                padding: 5px;
                   
            }
        </style>
    </head>
    
    <body>
        <form method="POST" action="CheckVoter">
            <table>
                <tr>
                    <td>Name</td>
                    <td><input type="text" name="uname"> </td>
                </tr>
                <tr>
                    <td>Age</td>
                    <td><input type="number" name="age"> </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="check voting elgibility"> </td>
                </tr>
            </table>
            
        </form>
    </body>
</html>
checkvoter.java

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class CheckVoter extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CheckVoter</title>");            
            out.println("</head>");
            out.println("<body>");
            String name= request.getParameter("uname");
            int age=Integer.parseInt(request.getParameter("age"));
            
            if(age>=18){
             out.println("<h4 style= \"color:green\">"+name+" you are elgible to vote</h4>");
            }
            else{
                out.println("<h4 style= \"color:red\">"+name+ " you are not elgible to vote</h4>");
            }
            
            out.println("<a href=\"index.html\">Home</a>");
            
            
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
