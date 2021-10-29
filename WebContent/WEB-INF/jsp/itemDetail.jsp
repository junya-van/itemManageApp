<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- アイテム詳細画面 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>アイテム詳細画面|アイテム管理アプリ</title>

		<%-- Bootstrap CDN読み込み --%>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	</head>
	<body>

		<div class="top-body">
			<div class="right">
				<jsp:include page="/WEB-INF/jsp/header.jsp"/>
			</div>
		</div>

		<h2 class="form-title">アイテム詳細画面</h2>

		<div class="item-detail">
			<table>

				<tr>

					<%-- 現在アップロードされている画像を表示。されていなければ代わりにNoImageを表示 --%>
					<c:choose>
						<c:when test="${not empty item_session.imgName}">
							<th rowspan="9"><img src="${pageContext.request.contextPath}/upload/${item_session.imgName}"></th>
						</c:when>
						<c:otherwise>
							<th rowspan="9"><img src="${pageContext.request.contextPath}/upload/NoImage.png"></th>
						</c:otherwise>
					</c:choose>
				</tr>

				<tr>
					<td>
					アイテム名：<c:out value="${item_session.itemName}"/>
					</td>
				</tr>
				<tr>
					<td>
						メーカー名:<c:out value="${item_session.product}"/>
					</td>
				</tr>
				<tr>
					<td>
						ジャンル名:<c:out value="${item_session.genre}"/>
					</td>
				</tr>
				<tr>
					<td>
						JANコード:<c:out value="${item_session.jan}"/>
					</td>
				</tr>
				<tr>
					<td>
						所持数:<c:out value="${item_session.quantity}"/>
					</td>
				</tr>
				<tr>
					<td>
						貸出数:<c:out value="${item_session.lend_quantity}"/>
					</td>
				</tr>
				<tr>
					<td>
						<c:choose>
							<c:when test="${item_session.score == 0}">
								評価 : ---
							</c:when>
							<c:otherwise>
								評価 :
								<c:set var="stars" value=""/>
									<c:forEach var="i" begin="1" end="${item_session.score}" step="1">
										<c:out value="${stars += '★'}"/>
									</c:forEach>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td>
						登録日:<c:out value="${item_session.created_at}"/>
					</td>
				</tr>
				<tr>
					<td>
						更新日:<c:out value="${item_session.updated_at}"/>
					</td>
				</tr>

			</table>
		</div>

		<div class="detail-link">

			<a href="${pageContext.request.contextPath}/ItemEditServlet">編集</a>

			<c:set var="quantity" value="${item_session.quantity}"/>
			<c:set var="lend_quantity" value="${item_session.lend_quantity}"/>
			<c:set var="num_possible" value="${quantity - lend_quantity}"/>

			<c:choose>
				<%-- アイテムの所持数と貸出数の差が0の時の処理 --%>
				<c:when test="${num_possible == 0}">
					<a href="#">貸す</a>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath}/LendItemServlet">貸す</a>
				</c:otherwise>
			</c:choose>

			<c:choose>
			 	<c:when test="${item_session.lend_quantity != 0}">
			  		<div class="no-press"><a href="#">削除</a></div>
			  	</c:when>
			  	<c:otherwise>
			   		 <div class="ok-press"><a href="${pageContext.request.contextPath}/ItemDeleteServlet" onclick="return confirm('削除してもよろしいですか?')">削除</a></div>
			   	</c:otherwise>
			</c:choose>

		</div>

	</body>
</html>