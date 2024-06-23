<%-- 
    Document   : homepagelogin
    Created on : Jun 17, 2024, 9:25:52 AM
    Author     : thai.ngoc
--%>

<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.List"%>
<%@page import="model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <style>
            *{
                box-sizing: border-box;
            }
            .Home {
                background: url(images/hnen.png);
                min-height: 100vh;
                justify-content: center;
                align-items: center;
            }
            img {
                width: 200px;
                height: 220px;
            }
            .container {
                display: flex;
                flex-wrap: wrap;
            }
            .table_card {
                position: relative;
                margin: 10px;
                box-shadow: 3px 3px 20px;
                padding: 20px 30px;
                height: 500px;
                width: 250px;
                border-radius: 10px;
                backdrop-filter: blur(25px);
                background-color: white;
            }
            .card-price {
                text-align: center;
                color: red;
                text-decoration: highlight;
            }
            .card-title {
                text-align: center;

            }

        </style>
    </head>
    <body>
        <div class="Home">

            <jsp:include page="headerAfterLogin.jsp"></jsp:include>
            <jsp:include page="banner.jsp"></jsp:include>
                <h1>NGOC SHOP AND FLOP</h1> 
                <h2>List of Product</h2>
            <%
                int count = 0;
                List<Product> rs = (List<Product>) request.getAttribute("result");
                if (rs != null) { %> 
            <div class="row container">
                <%

                    for (Product pr : rs) {
                        NumberFormat number = NumberFormat.getCurrencyInstance(new Locale("Vi", "VN"));
                %>
                <div class="col-xl-3">
                    <form class="table_card"> 
                        <div class="card">
                            <img src=".<%= pr.getProductImage()%>" class="card-img-top" alt="...">
                            <div class="card-title">
                                <h3 style="height: 100px"class="card-title"><%= pr.getProductName()%></h3>
                            </div>
                            <div class="card-price">
                                <h4 class="card-text"><%= number.format(pr.getPrice())%></h4>
                            </div>
                        </div> 
                    </form>
                </div>
                <%
                    }
                %>
            </div>
            <%}%>
        </div>
    </body>
</html>