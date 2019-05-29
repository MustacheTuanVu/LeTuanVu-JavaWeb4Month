<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang Chủ</title>
</head>
<body>
	<h1>Danh sách tòa nhà</h1>
	<c:forEach items="${building}" var="item">
		<p>${item.name}</p>
	</c:forEach>
</body>
</html>