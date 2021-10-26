<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- アイテム削除結果画面 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>アイテム削除結果|アイテム管理アプリ</title>
	</head>
	<body>
		<div class="top-body">
			<%-- ここにincludeタグを記述してヘッダー部分を付ける --%>
		</div>

		<h2 class="result-title">アイテム削除結果</h2>

		<div class="msg">
			<c:out value="${resultMsg}"/>
		</div>

		<div class="link">
			<a href="${pageContext.request.contextPath}/MainServlet">アイテムリスト画面へ</a>
		</div>
	</body>
</html>