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
<script src="${path}/resources/js/func.js"></script>
<title>고객정보</title>
</head>
<body>
	<h2>고객정보 DB정보 페이지 단위 보기 PAGE_NO = ${PAGE_NO}</h2>
	<table>
		<tr>
			<td>코드</td>
			<td>성명</td>
			<td>이메일</td>
			<td>전화번호</td>
			<td>체중</td>
			<td colspan='2'>비고</td>
		</tr>
		<c:forEach var="cnt" begin="0" end="${LIST.size() - 1}">
		<tr>
			<td>${LIST[cnt].code}</td>
			<td>${LIST[cnt].name}</td>
			<td>${LIST[cnt].email}</td>
			<td>${LIST[cnt].tel}</td>
			<td>${LIST[cnt].weight}</td>
			<td><a href="sltOne?CODE=${LIST[cnt].code}&PAGE_NO=${PAGE_NO}">수정</a></td>
			<td><a name="del" onclick="del()" href="deleteCst?CODE=${LIST[cnt].code}">삭제</a>
		</tr>
		</c:forEach>
	</table>
	<c:if test="${STARTPAGE > 5}">
		<a href="sltMul?PAGE_NO=${STARTPAGE - 5}">[이전]</a>
	</c:if>
	<c:forEach var="i" begin="${STARTPAGE}" end="${ENDPAGE}">
		<a href="sltMul?PAGE_NO=${i}">[${i}]</a>
	</c:forEach>
	<c:if test="${ENDPAGE < PAGECOUNT}">
		<a href="sltMul?PAGE_NO=${STARTPAGE + 5}">[다음]</a>
	</c:if>
	<br>
	<input style="margin-top:10px" type="button" value="회원등록" onclick="location.href='insertCstForm'">
</body>
</html>