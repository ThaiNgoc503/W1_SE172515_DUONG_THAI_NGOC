<%-- 
    Document   : listAccounts
    Created on : Jun 18, 2024, 10:43:27 PM
    Author     : thai.ngoc
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Account"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            input {
                background: transparent;
                border: none;
                outline: none;
                &:hover {
                    border: 2px solid rgba(255, 255, 255, .3);
                    background-color: rgba(255, 255, 255, .3)
                }
            }

        </style>
    </head>
    <body>
        <jsp:include page="headerAfterLogin.jsp"></jsp:include>
            <div class="container">
                <h2>List of Accounts</h2>
            <%

                String username = (String) session.getAttribute("username");
                List<Account> rs = (List<Account>) request.getAttribute("result");
                if (rs != null) {

            %> 
            <table class="table">
                <thead>
                    <tr>
                        <th>Account</th>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Birth day</th>
                        <th>Gender</th>
                        <th>Phone</th>
                        <th>Role in system</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%                        for (Account ac : rs) {

                            String reWriting = "MainController?"
                                    + "btAction=Delete&"
                                    + "accountName=" + ac.getAccount();
                    %>
                <form action="MainController" method="get">
                    <tr class="info">
                        <td>
                            <%= ac.getAccount()%>
                            <input size="10" type="hidden" name="txtAccou" value="<%= ac.getAccount()%>" >

                        </td>

                        <td>
                            <input size="5" type="text" name="txtFullName" value="<%= ac.getFirstName()%>" >

                        </td>
                        <td>
                            <input size="9" type="text" name="txtLastName" value="<%= ac.getLastName()%>" >
                        </td>
                        <td>
                            <input  type="date" name="txtBirth" value="<%= ac.getBirthday()%>" >
                        </td>
                        <td>
                            <input type="radio" name="rGender" value="Male" <%
                                if (ac.isGender()) { %>
                                   checked="checked"
                                   <%}%>>

                            Male
                            <input type="radio" name="rGender" value="Female"
                                   <% if (ac.isGender() == false) { %>
                                   checked="checked"
                                   <%}%>
                                   > Female
                        </td>
                        <td>
                            <input size="9" type="text" name="txphon" value="<%= ac.getPhone()%>" />
                        </td>
                        <td>
                            <select name="sRol">
                                <option value="1" 
                                        <% if (ac.getRoleInSystem() == 1) { %>
                                        selected="selected"
                                        <%}%>>Adminstrator
                                </option>
                                <option value="2"
                                        <% if (ac.getRoleInSystem() == 2) { %>
                                        selected="selected"
                                        <%}%>>Manager
                                </option>
                                <option value="3" 
                                        <% if (ac.getRoleInSystem() == 3) { %>
                                        selected="selected"
                                        <%}%>>User
                                </option>
                            </select>
                        </td>
                        <td> 
                            <% if (ac.getAccount().equalsIgnoreCase(username)) {%>
                            <button type="button" class="btn btn-info">it you</button>
                            <%} else {%>
                            <a href=<%= reWriting%>><button type="button" class="btn btn-danger">Delete</button></a>
                            <%}%>

                            <button type="submit" name="btAction" value="Update Account" class="btn btn-primary">update</button>

                        </td>
                    </tr>
                </form>

                <%
                    }
                %>

                </tbody>
            </table>
            <%}%>
        </div>
    </body>
</html>
