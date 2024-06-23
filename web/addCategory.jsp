<%-- 
    Document   : addCategori
    Created on : Jun 17, 2024, 9:20:11 PM
    Author     : thai.ngoc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .red {
                color: red;
            }
        </style>
    </head>
    <body>
        <jsp:include page="headerAfterLogin.jsp"></jsp:include>


            <form class="form-horizontal" action="MainController" method="get">
                <h1>New Category</h1>
                <div style="color: green; font-size: 40px"><%= request.getAttribute("scAddCategory") != null ? request.getAttribute("scAddCategory") : ""%></div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="category"><span class="red">*</span>Category name:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="category" name="txtCategory" placeholder="Category name" required="required" value="<%= request.getAttribute("txtCategory") != null ? request.getAttribute("txtCategory") : ""%>">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="pwd">Memo:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="pwd"  name="txtMemo" placeholder="Memo" value="<%= request.getAttribute("txtMemo") != null ? request.getAttribute("txtMemo") : ""%>">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" class="btn btn-default" name="btAction" value="Save">
                </div>
            </div>
    </body>
</html>
