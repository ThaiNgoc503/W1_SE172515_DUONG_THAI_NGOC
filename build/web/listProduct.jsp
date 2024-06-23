<%-- 
    Document   : listCategory
    Created on : Jun 19, 2024, 9:59:37 AM
    Author     : thai.ngoc
--%>

<%@page import="model.Product"%>
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

            textArea {
                background: transparent;
                border: none;
                outline: none;
                text-align: left;
            }

        </style>
    </head>
    <body>
        <jsp:include page="headerAfterLogin.jsp"></jsp:include>
            <div class="container">
                <h2>List of Product</h2>
                 <div style="color: red; font-size: 40px"><%= request.getAttribute("errorUpdateProd") != null ? request.getAttribute("errorUpdateProd") : ""%></div>
                 <div style="color: green; font-size: 40px"><%= request.getAttribute("ssUpdatePro") != null ? request.getAttribute("ssUpdatePro") : ""%></div>
            <%
                int count = 0;
                List<Product> rs = (List<Product>) request.getAttribute("result_product");
                if (rs != null) { %> 
            <table class="table">
                <thead>
                    <tr>
                        <th>NO.</th>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Product Image</th>
                        <th>Brief</th>
                        <th>Posted Date</th>
                        <th>Unit</th>
                        <th>Price</th>
                        <th>Discount</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        String path = application.getInitParameter("pathSaveImages");

                        for (Product pr : rs) {
                            String reWriting = "MainController?btAction=DeleteProduct&ProductId=" + pr.getProductId() + "&pathImg=" + pr.getProductImage();
                            
                    %>


                <form action="UpdateNewProductServlet" enctype="multipart/form-data" method="POST">
                    <tr class="info">
                        <td><%= ++count%></td>

                        <td>
                            <%= pr.getProductId()%>
                            <input type="hidden" value="<%= pr.getProductId()%>" name="txtProductId2">
                        </td>
                        <td>
                            <textarea  name="txtProductName2"><%= pr.getProductName()%></textarea>
                        <td>
                            <% String rsImage = pr.getProductImage(); %>
                            <img style="width:150px" src=".<%=pr.getProductImage()%>" alt="hinh" >
                            <input type="file" name="fileUpload" style="width: 92px;
                                   overflow:hidden;">
                            <input type="hidden" name="currentImage" value="<%= rsImage %>">
                        </td>
                        <td>
                            <textarea  name="txtProductBrief2"><%= pr.getBrief()%></textarea>
                        </td>
                        <td>
                           <%= pr.getPostedDate()%>
                        </td>
                        <td>
                            <input type="text" value="<%= pr.getUnit()%>" size="5" name="txtProductUnit">
                        </td>
                        <td>
                            <input style="width: 90px" type="number"  value="<%= pr.getPrice()%>" name="nProductPrice">
                        </td>
                        <td>
                            <input style="width: 50px" type="number" value="<%= pr.getDiscount()%>" name="nProductDis">
                        </td>
                        <td> 
                            <a href="<%= reWriting%>"><button type="button" class="btn btn-danger">Delete</button></a>
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
