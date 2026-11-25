<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en"><head><meta charset="UTF-8"><title>Sales</title><link rel="stylesheet" href="css/style.css"></head>
<body class="admin"><h1>Sales</h1>
<c:if test="${not empty error}"><p class="error" role="alert"><c:out value="${error}"/></p></c:if>
<p>Total sales: ${total}</p><h2>By product</h2><table><thead><tr><th>Product</th><th>Sales</th></tr></thead><tbody>
<c:forEach items="${byProduct}" var="row"><tr><td><c:out value="${row.name}"/></td><td><c:out value="${row.amount}"/></td></tr></c:forEach></tbody></table><h2>By category</h2><table><thead><tr><th>Category</th><th>Sales</th></tr></thead><tbody>
<c:forEach items="${byCategory}" var="row"><tr><td><c:out value="${row.name}"/></td><td><c:out value="${row.amount}"/></td></tr></c:forEach></tbody></table>
<nav><a href="shop">Shop</a> · <a href="adminMenu">Admin menu</a></nav></body></html>
