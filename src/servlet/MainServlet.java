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
import model.ItemListScreenInfo;
import model.UserBeans;

/**
 * アイテムリスト画面表示に関するリクエストを処理するコントローラ
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * アイテムリスト画面表示処理
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String page = request.getParameter("page");
		int pageNo = page == null ? 1 : Integer.parseInt(page);

		String searchWord = request.getParameter("searchWord");
		if(searchWord == null) {

			searchWord = "";

		}

		HttpSession session = request.getSession();
		UserBeans beans = (UserBeans) session.getAttribute("login");

		ItemListScreenInfo info = new ItemListScreenInfo();
		info.setPageNo(pageNo);
		info.setSearchWord(searchWord);

		CreateItemListScreenLogic logic = new CreateItemListScreenLogic();
		logic.execute(beans.getUserId(), info);

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
