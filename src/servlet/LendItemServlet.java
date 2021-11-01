package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LendItemLogic;

/**
 * アイテム貸出に関するリクエストを処理するコントローラ
 */
@WebServlet("/LendItemServlet")
public class LendItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * アイテム貸出フォーム画面へフォワード
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/lendItemForm.jsp");
		rd.forward(request, response);

	}

	/**
	 * アイテム貸出処理
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String to_who = request.getParameter("to_who").trim();
		int lend_quantity = Integer.parseInt(request.getParameter("lend_quantity"));
		int itemId = Integer.parseInt(request.getParameter("itemId"));

		LendItemLogic logic = new LendItemLogic();
		int count = logic.execute(itemId, to_who, lend_quantity);

		String msg = "";
		if(count != 0) {

			msg += "貸出に成功しました。";

		} else {

			msg += "貸出に失敗しました。";

		}

		request.setAttribute("resultMsg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/lendItemResult.jsp");
		rd.forward(request, response);

	}

}
