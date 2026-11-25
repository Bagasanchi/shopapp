<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en"><head><meta charset="UTF-8"><title>Order complete</title><link rel="stylesheet" href="css/style.css"></head>
<body class="customer"><h1>Order complete</h1>
<c:if test="${not empty error}"><p class="error" role="alert"><c:out value="${error}"/></p></c:if>
<h2>Purchase history</h2><table><thead><tr><th>Date</th><th>Customer</th><th>Product</th><th>Category</th><th>Unit price</th><th>Quantity</th><th>Subtotal</th><th>Delivery</th><th>Fee</th><th>Total</th></tr></thead><tbody>
<c:forEach items="${orders}" var="row"><tr><td><c:out value="${row.orderedAt}"/></td><td><c:out value="${row.userName}"/></td><td><c:out value="${row.productName}"/></td><td><c:out value="${row.categoryName}"/></td><td><c:out value="${row.price}"/></td><td><c:out value="${row.quantity}"/></td><td><c:out value="${row.amount}"/></td><td><c:out value="${row.deliveryName}"/></td><td><c:out value="${row.deliveryFee}"/></td><td><c:out value="${row.total}"/></td></tr></c:forEach></tbody></table>
<nav><a href="shop">Shop</a> · <a href="login">Administrator login</a></nav></body></html>
