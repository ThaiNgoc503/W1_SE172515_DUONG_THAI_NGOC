<%-- 
    Document   : accountUpdate
    Created on : Jun 17, 2024, 10:08:01 AM
    Author     : thai.ngoc
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
            <h1>Add new Account</h1>
            <div style="color: green; font-size: 40px"><%= request.getAttribute("scAddNewAccount") != null ? request.getAttribute("scAddNewAccount") : ""%></div>
            <form class="form-horizontal" action="MainController" method="post">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="accounts"><span class="red">*</span>Account:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="accounts" name="txtAccount" placeholder="Account" required="required" value="<%= request.getParameter("txtAccount") == null ? "" : request.getParameter("txtAccount")%>">
                    <div class="red" id="baoLoi"><%= request.getAttribute("baoLoiNewAccount") != null ? request.getAttribute("baoLoiNewAccount") : ""%></div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="pwd"><span class="red">*</span>Password:</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="pwd"  name="txtPassword" placeholder="Password" required="required" value="<%= request.getParameter("txtPassword") == null ? "" : request.getParameter("txtPassword")%>">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="lname">Last name:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="lname"  name="txtLastName" placeholder="Last name" value="<%= request.getParameter("txtLastName") == null ? "" : request.getParameter("txtLastName")%>">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="fname"><span class="red">*</span>First name:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="fname" name="txtFirstName"  placeholder="First name" required="required" value="<%= request.getParameter("txtFirstName") == null ? "" : request.getParameter("txtFirstName")%>">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="phone">Phone Number:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="phone" name="txtPhone" placeholder="Phone Number" value="<%= request.getParameter("txtPhone") == null ? "" : request.getParameter("txtPhone")%>">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="birthday"><span class="red">*</span>Birth day:</label>
                <div class="col-sm-10">
                    <input type="date" class="form-control" id="birthday" name="dBirthday" placeholder="Birth day" required="required" value="<%= request.getParameter("dBirthday") == null ? "" : request.getParameter("dBirthday")%>">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2"><span class="red">*</span>Gender:</label>
                <div class="col-sm-10">
                    <label class="control-label" for="genderMale"><input type="radio" value="male" name="rdGender" id="genderMale" checked="checked"> Male</label>
                    <label class="control-label" for="genderFemale"><input type="radio" value="female" name="rdGender" id="genderFemale"> Female</label>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="role"><span class="red">*</span>Role in system:</label>
                <div class="col-sm-10">
                    <select name="slRole" id="role" class="form-control form-control-select">
                        <option value="1">Administrator</option>
                        <option value="2">Manager</option>
                        <option value="3">User</option>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label><input name="ckbIsUse" value="ON" type="checkbox"> is Active</label>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" class="btn btn-default" name="btAction" value="Registration">
                </div>
            </div>
        </form>
    </body>
</html>
