<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- アイテムリスト画面 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>アイテムリスト画面|アイテム管理アプリ</title>

		<%-- Bootstrap CDN読み込み --%>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	</head>
	<body>

		<div class="top-body">

			<div class="left">
				<form action="${pageContext.request.contextPath}/MainServlet">
					<%-- 検索ボタンを押した後もテキストボックスに文字列を表示したまま --%>
					<input type="text" name="searchWord" value="${screen_info.searchWord}">
					<button type="submit">検索</button>

					<c:if test="${not empty screen_info.searchWord}">
						<%-- 抽出ワード検索した時にのみ全件検索リンクを表示 --%>
						<a href="${pageContext.request.contextPath}/MainServlet">全件検索</a>
					</c:if>
				</form>
			</div>

			<div class="left2">
				<form action="${pageContext.request.contextPath}/MainServlet">
					<select name="genre" required>
						<option value="">ジャンル検索</option>
						<option value="1" <c:if test="${screen_info.genreId == 1}"> selected </c:if>>本</option>
						<option value="2" <c:if test="${screen_info.genreId == 2}"> selected </c:if>>ゲーム</option>
						<option value="3" <c:if test="${screen_info.genreId == 3}"> selected </c:if> >CD</option>
						<option value="4" <c:if test="${screen_info.genreId == 4}"> selected </c:if>>BD・DVD</option>
						<option value="5" <c:if test="${screen_info.genreId == 5}"> selected </c:if>>グッズ</option>
						<option value="6" <c:if test="${screen_info.genreId == 6}"> selected </c:if>>その他</option>
					</select>
					<button type="submit">検索</button>
				</form>
			</div>

			<div class="right">
				<jsp:include page="/WEB-INF/jsp/header.jsp"/>
			</div>

		</div>

		<div class="center"><a href="${pageContext.request.contextPath}/ItemInsertServlet">新規登録</a></div>

		<div class="item-field">
			<c:forEach var="beans" items="${screen_info.list}">
				<div class="item">

					<%-- 画像表示。画像がアップロードされていない場合代わりにNo Image画像を表示 --%>
					<c:choose>
						<c:when test="${not empty beans.imgName}">
							<div class="img-name">
								<img src="${pageContext.request.contextPath}/upload/${beans.imgName}">
							</div>
						</c:when>
						<c:otherwise>
							<div class="img-name">
								<img src="${pageContext.request.contextPath}/upload/NoImage.png">
							</div>
						</c:otherwise>
					</c:choose>

					<div class="item-name">
						<c:out value="${beans.itemName}"/>
					</div>

					<div class="item-product">
						メーカー : <c:out value="${beans.product}"/>
					</div>

					<div class="item-genre">
						ジャンル : <c:out value="${beans.genre}"/>
					</div>

					<div class="item-jan">
						JANコード : <c:out value="${beans.jan}"/>
					</div>

					<div class="item-score">
						<c:choose>
							<c:when test="${beans.score == 0}">
								評価 : ---
							</c:when>
							<c:otherwise>
								評価 :
								<c:set var="stars" value=""/>
									<c:forEach var="i" begin="1" end="${beans.score}" step="1">
										<c:out value="${stars += '★'}"/>
									</c:forEach>
							</c:otherwise>
						</c:choose>
					</div>

					<div class="item-link">
						<a href="${pageContext.request.contextPath}/ItemDetailServlet?itemId=${beans.itemId}">詳細</a>
					</div>

				</div>
			</c:forEach>

			<%-- ページネーション作成 --%>
			<%-- Bootstrapの雛型を使うのでBootstrap CDNを読み込んでおく --%>
			<c:if test="${not empty screen_info.pager}">
				<div class="paginationBox">
					<ul class="pagination">
						<c:forEach var="row" items="${screen_info.pager}">
							<li class="${row[0]}">
								<a href="${pageContext.request.contextPath}/MainServlet?page=${row[1]}&searchWord=${screen_info.searchWord}&genre=${screen_info.genreId}"><c:out value="${row[2]}"/></a>
							</li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
		</div>

	</body>
</html>