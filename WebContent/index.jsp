<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- トップ画面 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>アイテム管理アプリ</title>

		<%-- Bootstrap CDN読み込み --%>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<%-- CSS読み込み --%>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">


	</head>
	<body>
		<div class="top-body"></div>
		<h2 class="appli-title">ようこそアイテム管理アプリへ</h2>
		<h3 class="appli-summary">ゲームや本などのアイテムをデータベースに登録し管理します</h3>

		<div class="msg">
			<c:out value="${errorMsg}"/>
		</div>

		<form action="">

			<div class="login-table">
				<table>
					<tr>
						<th>ユーザID</th>
						<td><input type="text" name="userId"></td>
					</tr>
					<tr>
						<th>パスワード</th>
						<td><input type="password" name="pass"></td>
					</tr>
				</table>
			</div>

			<div class="login-button"><button type="submit" name="submit">ログイン</button></div>
			<div class="signup-button"><button type="button" onclick="location.href='${pageContext.request.contextPath}/UserInsertServlet'">サインアップ</button></div>

		</form>

	</body>
</html>