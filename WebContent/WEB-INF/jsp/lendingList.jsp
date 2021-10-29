<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- アイテム貸出リスト画面 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>アイテム貸出リスト|アイテム管理アプリ</title>
	</head>
	<body>

		<div class="top-body">
			<jsp:include page="/WEB-INF/jsp/header.jsp"/>
		</div>

		<h2 class="">アイテム貸出リスト</h2>

		<div class="list">
			<table>
				<tr>
					<th>アイテムID</th><th>アイテム名</th><th>貸出数</th><th>貸出相手</th><th>貸出日</th><th></th>
				</tr>
				<c:forEach var="beans" items="lendingList">
					<tr>
						<th><c:out value="${lendingList.itemId}"/></th>
						<th><c:out value="${lendingList.itemName}"/></th>
						<th><c:out value="${lendingList.lend_quantity}"/></th>
						<th><c:out value="${lendingList.to_who}"/></th>
						<th><c:out value="${lendingList.lent_at}"/></th>
						<th><a href="">返却</a></th>
					</tr>
				</c:forEach>
			</table>
		</div>

	</body>
</html>