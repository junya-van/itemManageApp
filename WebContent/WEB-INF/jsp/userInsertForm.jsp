<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- ユーザ登録フォーム画面 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ユーザ登録フォーム|アイテム管理アプリ</title>

		<%-- Bootstrap CDN読み込み --%>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	</head>
	<body>
		<div class="top-body"></div>

		<h2 class="form=title">ユーザ登録フォーム画面</h2>

		<div class="form">
			<form action="${pageContext.request.contextPath}/UserInsertServlet" method="post">

				<table>
					<tr>
						<th><label for="userId">ユーザID</label></th>
						<td><input type="text" name="userId" id="userId" maxlength="5" size="25" pattern="[0-9]{5}" placeholder="半角数字で5文字" required></td>
					</tr>

					<tr>
						<th><label for="pass">パスワード</label></th>
						<td><input type="password" name="pass" id="pass" maxlength="10" size="25" placeholder="半角英数字アンダーバーで5文字以上10文字以下" pattern="\w{5,10}" required></td>
					</tr>
					<tr>
						<th><label for="userName">ユーザ名</label></th>
						<td><input type="text" name="userName" id="userName" maxlength="15" size="25" placeholder="15文字まで" required></td>
					</tr>
				</table>

				<div class="inner-button">
					<button type="submit">登録</button>
				</div>

			</form>
		</div>

	</body>
</html>