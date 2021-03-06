package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.UserBeans;

/**
 * ログイン、ログアウトに関するリクエストを処理するコントローラ
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ログアウト処理
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/");

	}

	/**
	 * ユーザIDとパスワードを使ってユーザを検索。<br>
	 * 取得できればアイテムリスト画面へ。<br>
	 * 取得できなければログイン失敗
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");

		LoginLogic logic = new LoginLogic();
		UserBeans beans = logic.execute(userId, pass);

		if(beans != null) {

			HttpSession session = request.getSession();
			session.setAttribute("login", beans);
			RequestDispatcher rd = request.getRequestDispatcher("/MainServlet");
			rd.forward(request, response);

		} else {

			request.setAttribute("errorMsg", "ユーザIDまたはパスワードが間違ってます。");
			RequestDispatcher rd = request.getRequestDispatcher("/");
			rd.forward(request, response);

		}

	}

}
