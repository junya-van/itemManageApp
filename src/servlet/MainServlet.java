package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CreateItemListScreenLogic;
import model.GenreSearchLogic;
import model.ItemListScreenInfo;
import model.SearchWordLogic;
import model.UserBeans;

/**
 * アイテムリスト画面表示に関するリクエストを処理するコントローラ
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * アイテムリスト画面表示処理<br>
	 * ログイン後やアイテム登録結果画面等でリンクを踏んだ後では、リクエストパラメータを取得しようとしてもnullを取得するので<br>
	 * その場合はページ番号なら1を、ジャンルIDなら0をセット
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String page = request.getParameter("page");
		int pageNo = page == null ? 1 : Integer.parseInt(page);

		HttpSession session = request.getSession();
		UserBeans beans = (UserBeans) session.getAttribute("login");

		ItemListScreenInfo info = new ItemListScreenInfo();
		info.setPageNo(pageNo);

		String searchWord = request.getParameter("searchWord");

		if(searchWord == null || searchWord.trim().length() == 0) {

			String genre = request.getParameter("genre");
			int genreId = genre == null ? 0 : Integer.parseInt(genre);

			if(genreId == 0) {

				// アイテム全件検索
				CreateItemListScreenLogic logic = new CreateItemListScreenLogic();
				logic.execute(beans.getUserId(), info);

			} else {

				// ジャンル検索
				info.setGenreId(genreId);
				GenreSearchLogic logic = new GenreSearchLogic();
				logic.execute(beans.getUserId(), info);

			}

		} else {

			// キーワード抽出検索
			info.setSearchWord(searchWord);
			SearchWordLogic logic = new SearchWordLogic();
			logic.execute(beans.getUserId(), info);

		}

		request.setAttribute("screen_info", info);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/itemList.jsp");
		rd.forward(request, response);

	}

	/**
	 * doGet()を実行
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}
