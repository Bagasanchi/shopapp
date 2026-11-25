<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en"><head><meta charset="UTF-8"><title>Product details</title><link rel="stylesheet" href="css/style.css"></head>
<body class="customer"><h1>Product details</h1>
<c:if test="${not empty error}"><p class="error" role="alert"><c:out value="${error}"/></p></c:if>
<dl><dt>ID</dt><dd><c:out value="${p.id}"/></dd><dt>Product</dt><dd><c:out value="${p.name}"/></dd><dt>Category</dt><dd><c:out value="${p.categoryName}"/></dd><dt>Price</dt><dd><c:out value="${p.price}"/></dd><dt>Stock</dt><dd><c:out value="${p.stock}"/></dd></dl><a href="order?id=${p.id}">Order this product</a>
<nav><a href="shop">Shop</a> · <a href="login">Administrator login</a></nav></body></html>
