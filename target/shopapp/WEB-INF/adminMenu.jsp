<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en"><head><meta charset="UTF-8"><title>Administrator menu</title><link rel="stylesheet" href="css/style.css"></head>
<body class="admin"><h1>Administrator menu</h1>
<c:if test="${not empty error}"><p class="error" role="alert"><c:out value="${error}"/></p></c:if>
<ul><li><a href="products">Products</a></li><li><a href="productAdd">Add product</a></li><li><a href="orders">Orders</a></li><li><a href="sales">Sales</a></li></ul>
<nav><a href="shop">Shop</a> · <a href="adminMenu">Admin menu</a></nav></body></html>
