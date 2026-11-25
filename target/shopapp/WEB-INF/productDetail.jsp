<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product Detail</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="admin">
<h1>Product Detail</h1>
<c:if test="${not empty error}"><p class="error" role="alert"><c:out value="${error}"/></p></c:if>
<table>
    <tr><th scope="row">ID</th><td><c:out value="${product.id}"/></td></tr>
    <tr><th scope="row">Name</th><td><c:out value="${product.name}"/></td></tr>
    <tr><th scope="row">Category</th><td><c:out value="${product.categoryName}"/></td></tr>
    <tr><th scope="row">Price</th><td><c:out value="${product.price}"/></td></tr>
    <tr><th scope="row">Stock</th><td><c:out value="${product.stock}"/></td></tr>
</table>
<form action="productDelete" method="post">
    <input type="hidden" name="id" value="${product.id}">
    <button type="submit">Delete</button>
</form>
<p><a href="products">Back to List</a></p>
<nav><a href="shop">Shop</a> · <a href="adminMenu">Admin menu</a></nav>
</body>
</html>
