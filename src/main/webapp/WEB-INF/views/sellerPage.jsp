<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>

</head>
<body>
<form action ="/admin">
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
<h1>업체만접근가능하다</h1>
</form>
</body>
</html>