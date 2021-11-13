<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- ユーザ情報登録結果画面 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ユーザ情報登録結果|アイテム管理アプリ</title>

		<%-- Bootstrap CDN読み込み --%>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

		<%-- css読み込み --%>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

	</head>
	<body>

		<div class="top-body"></div>

		<h2 class="result-title">ユーザ登録結果</h2>

		<div class="msg">
			<c:out value="${resultMsg}"/>
		</div>

		<div class="result-link">
			<a href="${pageContext.request.contextPath}/">ログイン画面へ</a>
		</div>

	</body>
</html>