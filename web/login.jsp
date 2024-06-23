<%-- 
    Document   : login
    Created on : Jun 17, 2024, 8:16:54 AM
    Author     : thai.ngoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            .red {
                color: red;
            }
        </style>
    </head>
    <body>

        <jsp:include page="headerNotLogin.jsp"></jsp:include>
            <form action="MainController" class="was-validated" method="POST">
                <div class="form-group">
                    <label for="uname">Username:</label>
                    <input type="text" class="form-control" id="uname" placeholder="Enter username"  name="txtUsername">
                <%
                    String baoLoi = request.getAttribute("baoloiLogin") + "";
                    if (baoLoi.equals("null")) {
                        baoLoi = "";
                    }
                %>
                <div class="text-left"><span class="red"><%=baoLoi%></span></div>
            </div>
            <div class="form-group">
                <label for="pwd">Password:</label>
                <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="txtPassword">
            </div>
            <button type="submit" name="btAction" value="Login" class="btn btn-primary">Submit</button>
        </form>


    </body>
</html>
