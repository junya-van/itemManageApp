package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ItemBeans;
import model.ItemLogic;

/**
 * アイテム詳細画面に関するリクエストを処理するコントローラ
 */
@WebServlet("/ItemDetailServlet")
public class ItemDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * アイテム詳細画面へフォワード
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String itemId = request.getParameter("itemId");

		if(itemId == null) {

			response.sendRedirect(request.getContextPath() + "/MainServlet");
			return;

		}

		ItemLogic logic = new ItemLogic();
		ItemBeans beans = logic.execute(Integer.parseInt(itemId));

		HttpSession session = request.getSession();
		session.setAttribute("item_session", beans);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/itemDetail.jsp");
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
