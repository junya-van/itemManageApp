package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ReturnedItemLogic;

/**
 * アイテム返却に関するリクエストを処理するコントローラ
 */
@WebServlet("/ReturnedItemServlet")
public class ReturnedItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * doPost()を実行
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	/**
	 * アイテム返却処理
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int lendId = Integer.parseInt(request.getParameter("lendId"));

		ReturnedItemLogic logic = new ReturnedItemLogic();
		int count = logic.execute(lendId);

		String msg = "";
		if(count != 0) {

			msg += "返却に成功しました";

		} else {

			msg += "返却に失敗しました";

		}

		request.setAttribute("resultMsg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/returnedItemResult.jsp");
		rd.forward(request, response);

	}

}
