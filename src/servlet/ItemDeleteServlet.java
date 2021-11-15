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
import model.ItemDeleteLogic;

/**
 * アイテム削除に関するリクエストを処理するコントローラ
 */
@WebServlet("/ItemDeleteServlet")
public class ItemDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * アイテム削除処理
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		ItemBeans beans = (ItemBeans) session.getAttribute("item_session");
		if(beans == null) {

			response.sendRedirect(request.getContextPath() + "/MainServlet");
			return;

		}

		ItemDeleteLogic logic = new ItemDeleteLogic();
		int count = logic.execute(beans.getItemId());

		String msg = "";
		if(count != 0) {

			msg += "削除しました。";

		} else {

			msg += "削除できませんでした。";

		}

		request.setAttribute("resultMsg", msg);
		session.removeAttribute("item_session");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/itemDeleteResult.jsp");
		rd.forward(request, response);

	}

}
