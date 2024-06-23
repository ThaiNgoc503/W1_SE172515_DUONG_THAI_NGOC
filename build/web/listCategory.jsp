<%-- 
    Document   : listCategory
    Created on : Jun 19, 2024, 9:59:37 AM
    Author     : thai.ngoc
--%>

<%@page import="java.util.List"%>
<%@page import="model.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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

                List<Category> rs = (List<Category>) request.getAttribute("resultCategoryList");
                if (rs != null) { %> 
            <table class="table">
                <thead>
                    <tr>
                        <th>Category id</th>
                        <th>Category Name</th>
                        <th>Memo</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Category ca : rs) {
                            String reWritng = "MainController?btAction=DeletCategory&typeId=" + ca.getTypeId();
                    %>
                <form action="MainController">
                    <tr class="info">
                        <td>
                            <input type="text" name="tTypeId" value="<%= ca.getTypeId()%>">
                        </td>
                        <td>
                            <input type="text" name="tCateName" value="<%= ca.getCategoryName()%>">
                        </td>
                        <td>
                            <input type="text" name="tCateMemo" value="<%= ca.getMemo()%>">
                        </td>
                        <td>
                            <a href=<%= reWritng%>><button type="button" class="btn btn-danger">Delete</button></a>
                            <button type="submit" name="btAction" value="updateCategory" class="btn btn-primary">Update</button>
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
