<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="admin">
    <h1>Add Product</h1>
    <c:forEach items="${errors}" var="error">
        <p class="error" role="alert"><c:out value="${error}"/></p>
    </c:forEach>
    <form action="productAdd" method="post">
        <label>Name <input type="text" name="name"></label>
        <label>Category
            <select name="categoryId">
                <c:forEach items="${categoryList}" var="category">
                    <option value="${category.id}"><c:out value="${category.name}"/></option>
                </c:forEach>
            </select>
        </label>
        <label>Price <input type="text" name="price"></label>
        <label>Stock <input type="text" name="stock"></label>
        <button type="submit">Add</button>
    </form>
    <p><a href="products">Back to List</a></p>
    <nav><a href="shop">Shop</a> &middot; <a href="adminMenu">Admin menu</a></nav>
</body>
</html>
