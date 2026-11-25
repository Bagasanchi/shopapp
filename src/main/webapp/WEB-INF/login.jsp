<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en"><head><meta charset="UTF-8"><title>Administrator login</title><link rel="stylesheet" href="css/style.css"></head>
<body class="admin"><h1>Administrator login</h1>
<c:if test="${not empty error}"><p class="error" role="alert"><c:out value="${error}"/></p></c:if>
<form method="post"><label>Name <input name="name" type="text" value="<c:out value="${param.name}"/>"  required></label><label>Password <input name="password" type="password"   required></label><button>Log in</button></form>
<nav><a href="shop">Shop</a> · <a href="adminMenu">Admin menu</a></nav></body></html>
