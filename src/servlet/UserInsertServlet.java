package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserBeans;
import model.UserInsertLogic;

/**
 * Servlet implementation class UserInsertServlet
 */
@WebServlet("/UserInsertServlet")
public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ユーザ登録フォーム画面へフォワード
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/userInsertForm.jsp");
		rd.forward(request, response);

	}

	/**
	 * ユーザ情報登録処理
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId").trim();
		String pass = request.getParameter("pass").trim();
		String userName = request.getParameter("userName").trim();

		UserInsertLogic logic = new UserInsertLogic();
		UserBeans beans = new UserBeans(userId, pass, userName);
		int count = logic.execute(beans);

		String msg = "";
		if(count != 0) {

			msg += "登録しました";

		} else {

			msg += "登録に失敗しました";

		}

		request.setAttribute("resultMsg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/userInsertResult.jsp");
		rd.forward(request, response);

	}

}
