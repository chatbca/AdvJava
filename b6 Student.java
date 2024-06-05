firstpage.jsp...

  <%-- 
    Document   : firstPage
    Created on : 3 Apr, 2024, 5:41:03 PM
    Author     : HP
--%>
<%@page import="com.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page 01 </title>
    </head>
    <body>
        <h1>Student Details are saved!...</h1>
        <jsp:useBean id="std" scope="session" class="com.Student">
            <jsp:setProperty name="std" property="regNo" value="${param.regno}"/>
            <jsp:setProperty name="std" property="name" value="${param.sname}"/>
            <jsp:setProperty name="std" property="course" value="${param.course}"/>
            <jsp:setProperty name="std" property="sem" value="${param.sem}"/>
        </jsp:useBean>
        <h2><a href="secondPage.jsp">View Student Details</a></h2>
                     
                     
                     
    </body>
</html>


    index.html

    <!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Student INfo..</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <h2>Enter Student Details</h2>
    <form method="POST" action="firstPage.jsp">
        <table>
            <tr>
                <td> Register No:</td>
                <td> <input type="text" name="regno"></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td> <input type="text" name="sname"></td>
            </tr>
            <tr>
                <td>Course:</td>
                <td> <input type="text" name="course"></td>
            </tr>
            <tr>
                <td>Semester</td>
                <td> <input type="text" name="sem"></td>
            </tr>
            <tr>
                <td></td>
                <td> <input type="submit" name="subBtn" value="Register"></td>
            </tr>
        </table>
    </form>
    
    </body>
</html>


  second.jsp..

<%-- 
    Document   : secondPage
    Created on : 3 Apr, 2024, 6:16:31 PM
    Author     : HP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page 02</title>
    </head>
    <body>
        <h1>Student Details Are:</h1>
        <table>
            <tr>
                <td> Register No:</td>
                <td><c:out value="${std.regNo}"/></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><c:out value="${std.name}"/></td>
            </tr>
            <tr>
                <td>Course:</td>
                <td><c:out value="${std.course}"/></td>
            </tr>
            <tr>
                <td>Semester</td>
                <td><c:out value="${std.sem}"/></td>
            </tr>
            
        </table>
    </body>
</html>


    student.java..

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.Serializable;

/**
 *
 * @author HP
 */
public class Student implements Serializable{
    private String regNo;
    private String name;
    private String course;
    private String sem;

    public Student() {
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }
    
    
}

