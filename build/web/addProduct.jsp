<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Product</title>
        <style>
            .red {
                color: red;
            }
        </style>
    </head>
    <body>
        <jsp:include page="headerAfterLogin.jsp"></jsp:include>
            <h1>New Product</h1>
            <div style="color: green; font-size: 40px"><%= request.getAttribute("scAddProduct") != null ? request.getAttribute("scAddProduct") : ""%></div>
        <div style="color: red; font-size: 40px"><%= request.getAttribute("errorAddProduct") != null ? request.getAttribute("errorAddProduct") : ""%></div>

        <form class="form-horizontal" action="AddNewProductServlet" enctype="multipart/form-data" method="POST">
            <div class="form-group">
                <label class="control-label col-sm-2" for="pdId"><span class="red">*</span>Product ID:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="pdId" name="txtProductId" placeholder="Product ID">
                    <div style="color: red"><%= request.getAttribute("errorAddPr") != null ? request.getAttribute("errorAddPr") : ""%></div>

                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="pdName"><span class="red">*</span>Product Name:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="pdName" name="txtProductName" placeholder="Product Name" required="requỉed">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="image">Product Image:</label>
                <div class="col-sm-10">
                    <input type="file" class="form-control" id="image" accept="image/*" name="fImage" >
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="brief">Brief:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="brief" name="txtBrief" placeholder="Brief">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="price"><span class="red">*</span>Price:</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="price" name="nPrice" placeholder="Price" required="required">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="discount"><span class="red">*</span>Discount:</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="discount" name="nDiscount" placeholder="Discount"  required="required">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="unit">Unit:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="unit" name="txtUnit" placeholder="Unit">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="account"><span class="red">*</span>Account:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="account" name="txtAccount" placeholder="Account (ex: admin, you account)" required="required">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="typeid"><span class="red">*</span>TypeId:</label>
                <div class="col-sm-10">
                    <input type="number" class="form-control" id="typeid" name="nTypeId" placeholder="Type id"  required="required">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input type="submit" class="btn btn-default" name="btAction" value="Add">
                </div>
            </div>
        </form>
    </body>
</html>
