<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${path}/resources/css/cst.css" type="text/css"/>
<title>고객정보</title>
</head>
<body>
	<form method="post" action="updateCst?PAGE_NO=${PAGE_NO}">
		<h2>고객정보 DB정보 수정 PAGE_NO = ${PAGE_NO}</h2>
		<table>
			<tr>
				<td>코드</td>
				<td>성명</td>
				<td>이메일</td>
				<td>전화번호</td>
				<td>체중</td>
			</tr>
			<tr>
				<td><input type="text" name="code" value="${CST.code}" readonly></td>
				<td><input type="text" name="name" value="${CST.name}"></td>
				<td><input type="text" name="email" value="${CST.email}"></td>
				<td><input type="text" name="tel" value="${CST.tel}"></td>
				<td><input type="text" name="weight" value="${CST.weight}"></td>
			</tr>
		</table>
		<input type="submit" value="수정"> 
		<input type="reset" value="다시작성">
		<input type="button" value="고객정보다건조회"
			onclick="document.location.href='sltMul?PAGE_NO=${PAGE_NO}'">
	</form>
</body>
</html>