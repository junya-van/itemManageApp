package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LendingItemBeans;
import model.LendingListLogic;

/**
 * アイテム貸出リストに関するリクエストを処理するコントローラ
 */
@WebServlet("/LendingListServlet")
public class LendingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * アイテム貸出リスト画面へフォワード
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("login");

		LendingListLogic logic = new LendingListLogic();
		List<LendingItemBeans> list = logic.execute(userId);

		request.setAttribute("lendingList", list);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/lendingList.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
