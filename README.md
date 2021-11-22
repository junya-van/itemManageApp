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
テーブル

![テーブルについて](./table_ex.png)

ER図

![ER図について](./ER1.png)

# 工夫した点
アイテム貸出機能の実装。当初はアイテムを登録して管理するだけでしたが、アイテムを誰かに貸す場合もあると思うので実装しました。

文字列部分一致検索とジャンル検索といった絞り込み機能の実装。また、それらの機能でもアイテム数が多い場合はページネーションを表示するようにしました。

アイテム登録時、そのアイテム名が既にDBに登録されているかを素早くチェックできたら便利だと思い、Ajaxを使った非同期通信での処理を実装しました。

# 苦労した点
・ページネーションの実装

SQLでLIMITとOFFSETを使って実装する所まではわかっていましたが、その後どうやって実装するかがどうしてもわからなかったのでネットで方法を探りました。

結果、無事実装する事に成功しました。方法としてはBootstrapのページネーションの雛型( https://getbootstrap.jp/docs/5.0/components/pagination/ )　を使用する事、ページネーション作成の為の情報を二次元配列に格納する事(1次元目にはリンク数分の要素を用意、2次元目にはそれぞれjspでliタグの属性値に使う値、リンク先のページ番号、表記文言といった3要素をfor文で回しながら格納していく)により、実装する事ができました。　

・アイテム詳細画面で特定のアイテムの情報(アイテム名やメーカー、所持数など)と貸出数を表示する際にSQL文を使ってitemテーブルとgenreテーブルとlendingListテーブルから情報を持ってくる必要があり、この時のSQL文記述に苦労しました。例えばlendingListが次のような状態の時,


+---------+---------+---------------+------------------+------------+
| lend_id | item_id | lend_quantity | to_who           | lent_at    |
+---------+---------+---------------+------------------+------------+
|      36 |      18 |             1 | Aさん             | 2021-11-08 |
|      37 |      18 |             1 | Bさん             | 2021-11-09  |
|      38 |      68 |             2 | Cさん             | 2021-11-09 |
|      47 |      97 |             1 | Aさん             | 2021-11-16 |
+---------+---------+---------------+------------------+------------+

アイテムIDが18のアイテムの詳細画面では貸出数を2と表示するにはSQLをどう記述するべきか悩みました。
そこで、2パターンのSQL文を思いつきました。

パターン1: SUM関数を使う

 select item.item_id, genre.genre_name, sum(lendingList.lend_quantity) as lend_quantity, lendingList.to_who from item
 join genre on item.genre_id = genre.genre_id
 left join lendingList on item.item_id = lendingList.item_id
 where item.user_id = 'ユーザID' AND item.item_id = 'アイテムID';

しかしこれでは存在しないユーザIDやアイテムIDを指定すると、全カラムにNULLが入ったレコードを取得してしまいます。
存在しないアイテムIDやユーザIDを指定できないようにすればこれが一番理想的かと思います。

パターン2:SQL文を2つに分ける
SELECT item.item_id, item.item_name, item.product, item.jan, genre.genre_name, item.quantity, item.score, item.imgname, item.created_at, item.updated_at FROM item
 JOIN genre ON item.genre_id = genre.genre_id
 WHERE item.item_id = アイテムID;

SELECT item.item_name, lendingList.lend_id, lendingList.item_id, lendingList.lend_quantity, lendingList.to_who, lendingList.lent_at FROM lendingList"
 JOIN item ON lendingList.item_id = item.item_id
 WHERE item.user_id = ユーザID;


パターン1はSQL文の発行数が1つ少ないというメリットがありますが、全カラムにNULLが格納されて返ってくる可能性もあるので一番無難そうなパターン2を選択しました。

データベース構築やSQL文について不足な点が多いと感じました。アプリ作りではこれらがとても重要だと感じたのでもっと勉強したいと思いました。

# こだわった点
あとで書く

# 課題点反省点
あとで書く
