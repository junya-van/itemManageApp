<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- アイテム貸出リスト画面 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>アイテム貸出リスト|アイテム管理アプリ</title>

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

		<h2 class="screen-title">アイテム貸出リスト</h2>

		<c:choose>
			<c:when test="${not empty lendingList}">
				<div class="lend-list">
					<table>
						<tr>
							<th>アイテムID</th><th>アイテム名</th><th>貸出数</th><th>貸出相手</th><th>貸出日</th><th></th>
						</tr>
						<c:forEach var="beans" items="${lendingList}">
							<tr>
								<td><c:out value="${beans.itemId}"/></td>
								<td><c:out value="${beans.itemName}"/></td>
								<td><c:out value="${beans.lend_quantity}"/></td>
								<td><c:out value="${beans.to_who}"/></td>
								<td><c:out value="${beans.lent_at}"/></td>
								<td><a href="${pageContext.request.contextPath}/ReturnedItemServlet?lendId=${beans.lendId}" onclick="return confirm('返却処理をしますか?')">返却</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:when>
			<c:otherwise>
				<div class="list">
					現在貸出しているアイテムはありません
				</div>
			</c:otherwise>
		</c:choose>

		<div class="return-button">
			<button onClick="history.back()">戻る</button>
		</div>

	</body>
</html>