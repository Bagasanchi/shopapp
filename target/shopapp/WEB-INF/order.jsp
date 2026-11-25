<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en"><head><meta charset="UTF-8"><title>Place an order</title><link rel="stylesheet" href="css/style.css"></head>
<body class="customer"><h1>Place an order</h1>
<c:if test="${not empty error}"><p class="error" role="alert"><c:out value="${error}"/></p></c:if>
<p><c:out value="${p.name}"/> · Unit price ${p.price} · Stock ${p.stock}</p><form method="post"><input type="hidden" name="id" value="${p.id}"><label>Customer name <input name="name" type="text" value="<c:out value="${param.name}"/>"  required></label><label>Password <input name="password" type="password"   required></label><label>Quantity <input name="quantity" type="number" min="1" value="${empty param.quantity ? 1 : ''}<c:out value="${param.quantity}"/>" required></label><label>Delivery <select name="deliveryName"><option>Standard</option><option ${param.deliveryName eq 'Express' ? 'selected' : ''}>Express</option></select></label><p>Standard: 5000, free on orders of 50000 or more. Express: 10000.</p><button>Place order</button></form>
<nav><a href="shop">Shop</a> · <a href="login">Administrator login</a></nav></body></html>
