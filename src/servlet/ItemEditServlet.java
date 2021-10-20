package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ItemBeans;
import model.ItemLogic;

/**
 * アイテム編集に関するリクエストを処理するコントローラ
 */
@WebServlet("/ItemEditServlet")
public class ItemEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * アイテム編集画面へフォワード
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String itemId = request.getParameter("itemId");
		if(itemId == null) {

			response.sendRedirect(request.getContextPath() + "/MainServlet");
			return;

		}

		int id = Integer.parseInt(itemId);
		ItemLogic logic = new ItemLogic();
		ItemBeans beans = logic.execute(id);

		request.setAttribute("item", beans);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/itemEditForm.jsp");
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
