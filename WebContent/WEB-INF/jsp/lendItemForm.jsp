<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- アイテム貸出フォーム画面 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>アイテム貸出フォーム|アイテム管理アプリ</title>
	</head>
	<body>

		<div class="top-body">
			<div class="right">
				<%-- ここにincludeタグを記述してヘッダーを付ける --%>
			</div>
		</div>

		<h2 class="form-title">アイテム貸出フォーム画面</h2>

			<div class="form">
				<form action="${pageContext.request.contextPath}/LendItemServlet" method="post">
					<table>
						<tr>
							<th>誰に</th>
							<td><input type="text" name="to_who" size="25" maxlength="20" required></td>
						</tr>
						<tr>
							<th>個数</th>
							<td><input type="number" name="lend_quantity" min="1" required></td>
						</tr>
					</table>

					<input type="hidden" name="itemId" value="${item_session.itemId}">

					<div class="inner-button">
						<button type="submit" name="submit">貸す</button>
					</div>

				</form>
			</div>

	</body>
</html>