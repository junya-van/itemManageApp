<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- アイテム編集フォーム画面 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>アイテム編集画面|アイテム管理アプリ</title>

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

		<h2 class="form-title">アイテム編集フォーム画面</h2>

		<div class="form">
			<form action="${pageContext.request.contextPath}/ItemEditServlet" enctype="multipart/form-data" method="post">

				<table>
					<tr>
						<th><label for="itemName" class="required">アイテム名</label></th>
						<td><input type="text" name="itemName" id="itemName" value="${item_session.itemName}" maxlength="50" required></td>
					</tr>
					<tr>
						<th><label for="product" class="optional">出版社・制作会社</label></th>
						<td><input type="text" name="product" id="product" value="${item_session.product}" maxlength="20"></td>
					</tr>
					<tr>
						<th><label for="genre" class="required">ジャンル</label></th>
						<td>
							<select id ="genre" name="genre" required>
								<option value="1" <c:if test="${item_session.genre == '本'}"> selected </c:if> >本</option>
								<option value="2" <c:if test="${item_session.genre == 'ゲーム'}"> selected </c:if> >ゲーム</option>
								<option value="3" <c:if test="${item_session.genre == 'CD'}"> selected </c:if> >CD</option>
								<option value="4" <c:if test="${item_session.genre == 'BD・DVD'}"> selected </c:if> >BD・DVD</option>
								<option value="5" <c:if test="${item_session.genre == 'グッズ'}"> selected </c:if> >グッズ</option>
								<option value="6" <c:if test="${item_session.genre == 'その他'}"> selected </c:if> >その他</option>
							</select>
						</td>
					</tr>
					<tr>
						<th><label for="jan" class="optional">JANコード</label></th>
						<td><input type="text" name="jan" id="jan" value="${item_session.jan}" maxlength="13" pattern="[0-9]{13}"></td>
					</tr>
					<tr>
						<th><label for="quantity" class="required">所持数</label></th>
						<c:choose>
							<c:when test="${item_session.lend_quantity == 0}">
								<td><input type="number" name="quantity" id="quantity" value="${item_session.quantity}" min="1" required></td>
							</c:when>
							<c:otherwise>
								<td><input type="number" name="quantity" id="quantity" value="${item_session.quantity}" min="${item_session.lend_quantity}" required></td>
							</c:otherwise>
						</c:choose>
					</tr>

					<tr>
						<th><label for="score">評価</label></th>
						<td>
							<select id="score" name="score">
								<option value="0" <c:if test="${item_session.score == 0}"> selected </c:if>>---</option>
								<option value="1" <c:if test="${item_session.score == 1}"> selected </c:if>>★</option>
								<option value="2" <c:if test="${item_session.score == 2}"> selected </c:if>>★★</option>
								<option value="3" <c:if test="${item_session.score == 3}"> selected </c:if>>★★★</option>
								<option value="4" <c:if test="${item_session.score == 4}"> selected </c:if>>★★★★</option>
								<option value="5" <c:if test="${item_session.score == 5}"> selected </c:if>>★★★★★</option>
							</select>
						</td>
					</tr>


					<tr>
						<c:choose>
							<c:when test="${not empty item_session.imgName}">
								<%-- 現在アップロードされている画像を表示 --%>
								<td colspan=""><img src="${pageContext.request.contextPath}/upload/${item_session.imgName}"></td>
							</c:when>
							<c:otherwise>
								<td colspan=""><img src="${pageContext.request.contextPath}/upload/NoImage.png"></td>
							</c:otherwise>
						</c:choose>

					</tr>

					<tr>
						<th><label for="img">画像アップロード</label></th>
						<td><input type="file" name="imgName" id="img"></td>
					</tr>
				</table>

				<%-- 現在の画像をhiddenで渡す。もし画像選択がなかった場合、現在画像で設定する為。 --%>
				<input type="hidden" name="orgName" value="${item_session.imgName}">

				<input type="hidden" name="itemId" value="${item_session.itemId}">

				<div class="inner-button">
					<button type="submit" name="submit">登録</button>
				</div>

			</form>
		</div>

	</body>
</html>