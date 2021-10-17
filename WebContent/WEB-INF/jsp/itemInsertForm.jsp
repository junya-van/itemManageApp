<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- アイテム登録フォーム画面 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>アイテム登録フォーム|アイテム管理サイト</title>

		<%-- Bootstrap CDN読み込み --%>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

		<%-- css読み込み --%>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

	</head>
	<body>

		<div class="top-body">
			<div class="right">
				<%-- ここにincludeタグを記述してヘッダーを付ける --%>
			</div>
		</div>

		<h2 class="form-title">アイテム登録フォーム画面</h2>

		<div class="form">
			<form action="">

				<table>
					<tr>
						<th><label for="itemName" class="required">アイテム名</label></th>
						<td><input type="text" name="itemName" id="itemName" maxlength="50" required></td>
					</tr>
					<tr>
						<th><label for="product" class="optional">出版社・制作会社</label></th>
						<td><input type="text" name="product" id="product" maxlength="20"></td>
					</tr>
					<tr>
						<th><label for="genre" class="required">ジャンル</label></th>
						<td>
							<select id = "genre" name="genre" required>
								<option value="">選択してください</option>
								<option value="1">本</option>
								<option value="2">ゲーム</option>
								<option value="3">CD</option>
								<option value="4">BD・DVD</option>
								<option value="5">グッズ</option>
								<option value="6">その他</option>
							</select>
						</td>
					</tr>
					<tr>
						<th><label for="jan" class="optional">JANコード</label></th>
						<td><input type="text" name="jan" id="jan" maxlength="13" pattern="[0-9]{13}"></td>
					</tr>
					<tr>
						<th><label for="quantity" class="required">所持数</label></th>
						<td><input type="number" name="quantity" id="quantity" min="1" required></td>
					</tr>
					<tr>
						<th><label for="img">画像アップロード</label></th>
						<td><input type="file" name="imgName" id="img"></td>
					</tr>
				</table>

				<div class="inner-button">
					<button type="submit" name="submit">登録</button>
				</div>

			</form>
		</div>

	</body>
</html>