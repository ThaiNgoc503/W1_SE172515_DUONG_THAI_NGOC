

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link href="style/headerlogin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluids ">
                <div class="nav navbar-nav navbar-left welcom">
                    <% String username = (String) session.getAttribute("username");  %>
                    <% if (username != null) {%>
                    <font color="red">Welcome, <%= username%></font>

                    <%}%>
                </div>

                <div class="header">
                    <ul class="nav navbar-nav">
                        <li class="active"><a style=" padding-left: 14px" href="#"><form action="MainController" method="post">
                                    <input style="background-color: transparent; border: none; outline: none;"
                                           class="header-listAccount" type="submit" value="Home" name="btAction">
                                </form></a></li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Accounts
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a  href="addAccount.jsp">Add New Accounts</a></li>
                                <li><a style=" padding-left: 14px" href="#"><form action="MainController" method="post">
                                            <input style="background-color: transparent; border: none; outline: none;"
                                                   class="header-listAccount" type="submit" value="List Account" name="btAction">
                                        </form>
                                    </a>
                                </li>

                            </ul>
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Categories
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="addCategory.jsp">Add New Categories</a></li>
                                <li><a style=" padding-left: 14px" href="#"><form action="MainController" method="post">
                                            <input style="background-color: transparent; border: none; outline: none;"
                                                   type="submit" value="List Category" name="btAction">
                                        </form>
                                    </a>
                                </li>

                    </ul>
                    </li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Products
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="addProduct.jsp">Update Product</a></li>
                            <li><a style=" padding-left: 14px" href="#"><form action="MainController" method="post">
                                        <input style="background-color: transparent; border: none; outline: none;"
                                               type="submit" value="List Products" name="btAction">
                                    </form></a></li></li></li>
                    </ul>
                    </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <form action="MainController">
                            <li><span style="color: #fff" class="glyphicon glyphicon-log-in"></span><input style=" background-color: transparent; 
                                                                                                           color: white; font-size: 15px; 
                                                                                                           margin-top: 10px; 
                                                                                                           outline: none; 
                                                                                                           border: none" 
                                                                                                           name ="btAction" type="submit" value="Logout"></li>
                        </form>
                    </ul>
                </div>
            </div>
        </nav>
    </body>
</html>
