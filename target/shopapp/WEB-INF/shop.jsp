<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en"><head><meta charset="UTF-8"><title>Shop App | Products</title><link rel="stylesheet" href="css/style.css"></head>
<body class="customer"><h1>Shop</h1>
<c:if test="${not empty error}"><p class="error" role="alert"><c:out value="${error}"/></p></c:if>
<form method="get"><label>Product name <input name="keyword" value="<c:out value="${param.keyword}"/>"></label><label>Category <select name="categoryId"><option value="0">All categories</option><c:forEach var="c" items="${categories}"><option value="${c.id}" ${param.categoryId == c.id ? 'selected' : ''}><c:out value="${c.name}"/></option></c:forEach></select></label><label>Sort <select name="sort"><option value="idAsc" ${param.sort eq 'idAsc' ? 'selected' : ''}>ID ascending</option><option value="idDesc" ${param.sort eq 'idDesc' ? 'selected' : ''}>ID descending</option><option value="priceAsc" ${param.sort eq 'priceAsc' ? 'selected' : ''}>Lowest price</option><option value="priceDesc" ${param.sort eq 'priceDesc' ? 'selected' : ''}>Highest price</option></select></label><button>Search</button></form><p>Results: ${products.size()}</p><table><thead><tr><th>ID</th><th>Product</th><th>Category</th><th>Price</th><th>Stock</th><th>Details</th></tr></thead><tbody>
<c:forEach items="${products}" var="row"><tr><td><c:out value="${row.id}"/></td><td><c:out value="${row.name}"/></td><td><c:out value="${row.categoryName}"/></td><td><c:out value="${row.price}"/></td><td><c:out value="${row.stock}"/></td><td><a href="shopDetail?id=${row.id}">View</a></td></tr></c:forEach></tbody></table>
<nav><a href="shop">Shop</a> · <a href="login">Administrator login</a></nav></body></html>
