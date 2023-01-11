<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 11/05/2022
  Time: 7:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Product Managnment System</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs5/dt-1.11.5/datatables.min.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <h1>Product List</h1>
        <div class="col-lg-3">
            <form:form action="showForm">
                <input type="submit" value="Submit">
            </form:form>
        </div>
    </div>
    <table class="table table-stripped table-bordered" id="student-table">
        <thead class="table-dark">
        <tr>
            <th>Product Name</th>
            <th>Brand</th>
            <th>Product Category</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <c:forEach var="Product" items="${ProductList}">
               <td>${Product.productName}</td>
                <td>${Product.brand}</td>
                <td>${Product.catergory}</td>
            </c:forEach>
        </tr>
        </tbody>
    </table>
</div>
</body>
</html>
