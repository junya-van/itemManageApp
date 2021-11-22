# 概要
ゲームや本等のアイテムを登録して管理するアプリ

# 制作背景
何か要らないアイテムを駿河屋等に売る時に、ダンボールや収納ボックスから現物の確認をしてどれを売るかを決めるといった行為に煩わしさを感じてました。

そこでアイテムを管理できるアプリがあれば便利だと思い制作しました。

# 使用技術
Java(Servlet)

JSP

MySQL 8.0.23

HTML/CSS

jQuery 3.6.0

Bootstrap 3.3.7




jQueryはAjaxといった非同期通信、アイテムリスト画面での各アイテムの領域の高さを揃える為に使用しました。

Bootstrapは主にページネーション機能の雛型に使用しました。

# 機能一覧
ログイン、ログアウト機能
サインアップ機能
アイテム登録、編集、削除機能
アイテム貸出、返却機能
アイテム貸出リスト閲覧機能
評価をつける機能
画像アップロード機能
アイテム検索機能(文字列部分一致検索、ジャンル検索、非同期通信を使った文字列部分一致検索機能)

# DB設計

![テーブルについて](./table_ex.png)
![ER図について](./ER!.png)

# 工夫した点
アイテム貸出機能の実装。当初はアイテムを登録して管理するだけでしたが、アイテムを誰かに貸す場合もあると思うので実装しました。

文字列部分一致検索とジャンル検索といった絞り込み機能の実装。また、それらの機能でもアイテム数が多い場合はページネーションを表示するようにしました。

アイテム登録時、そのアイテム名が既にDBに登録されているかを素早くチェックできたら便利だと思い、Ajaxを使った非同期通信での処理を実装しました。

# 苦労した点
あとで書く

# こだわった点
あとで書く

# 課題点反省点
あとで書く
