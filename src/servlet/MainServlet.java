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
	 * 抽出ワードがある場合はキーワード抽出検索を、ない場合でジャンルIDが0の場合はアイテム全件検索、0ではない場合はジャンル検索をしてアイテムリスト画面へフォワード
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserBeans beans = (UserBeans) session.getAttribute("login");
		if(beans == null) {

			response.sendRedirect(request.getContextPath() +"/");
			return;

		}

		String page = request.getParameter("page");
		int pageNo = page == null ? 1 : Integer.parseInt(page);

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
