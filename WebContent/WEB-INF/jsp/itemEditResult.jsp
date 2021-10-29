<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- アイテム編集結果画面 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>アイテム編集結果画面|アイテム管理アプリ</title>
	</head>
	<body>

		<div class="top-body">
			<jsp:include page="/WEB-INF/jsp/header.jsp"/>
		</div>

		<h2 class="result-title">アイテム編集結果</h2>

		<div class="msg">
			<c:out value="${resultMsg}"/>
		</div>

		<div class="link">
			<a href="${pageContext.request.contextPath}/MainServlet">アイテムリスト画面へ</a>
		</div>

	</body>
</html>