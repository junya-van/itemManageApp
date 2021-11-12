<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- アイテム貸出フォーム画面 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>アイテム貸出フォーム|アイテム管理アプリ</title>

		<%-- Bootstrap CDN読み込み --%>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

		<%-- css読み込み --%>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

	</head>
	<body>

		<div class="top-body">
			<div class="right">
				<jsp:include page="/WEB-INF/jsp/header.jsp"/>
			</div>
		</div>

		<h2 class="form-title">アイテム貸出フォーム画面</h2>

			<div class="form">
				<form action="${pageContext.request.contextPath}/LendItemServlet" method="post">
					<table>
						<tr>
							<th>誰に</th>
							<td><input type="text" name="to_who" maxlength="20" required></td>
						</tr>
						<tr>
							<th>個数</th>
							<c:set var="quantity" value="${item_session.quantity}"/>
							<c:set var="lend_quantity" value="${item_session.lend_quantity}"/>
							<c:set var="num_possible" value="${quantity - lend_quantity}"/>
							<%-- 貸出できる数は(所持数 - 現在貸出している数) まで --%>
							<td><input type="number" name="lend_quantity" min="1" max="${num_possible}" required></td>
						</tr>
					</table>

					<input type="hidden" name="itemId" value="${item_session.itemId}">

					<div class="process-button">
						<button type="submit" name="submit">貸す</button>
					</div>

				</form>

				<div class="return-button">
					<button onClick="history.back()">戻る</button>
				</div>

			</div>

	</body>
</html>