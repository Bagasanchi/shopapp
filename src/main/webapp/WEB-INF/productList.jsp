<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en"><head><meta charset="UTF-8"><title>Product List</title><link rel="stylesheet" href="css/style.css"></head>
<body class="admin"><h1>Product List</h1>
<p><a href="productAdd">Add Product</a></p>
<c:if test="${not empty error}"><p class="error" role="alert"><c:out value="${error}"/></p></c:if>
<table><thead><tr><th>ID</th><th>Name</th><th>Category</th><th>Price</th><th>Stock</th><th></th></tr></thead><tbody>
<c:forEach items="${products}" var="row"><tr><td><c:out value="${row.id}"/></td><td><c:out value="${row.name}"/></td><td><c:out value="${row.categoryName}"/></td><td><c:out value="${row.price}"/></td><td><c:out value="${row.stock}"/></td><td><a href="productDetail?id=${row.id}">Detail</a></td></tr></c:forEach></tbody></table>
<nav><a href="shop">Shop</a> · <a href="adminMenu">Admin menu</a></nav></body></html>
