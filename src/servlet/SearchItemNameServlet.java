package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SearchItemNameDAO;
import model.UserBeans;

/**
 * 非同期通信によるアイテム登録(編集)フォーム画面からのアイテム名検索(文字列の部分一致検索)に関するリクエストを処理するコントローラ
 */
@WebServlet("/SearchItemNameServlet")
public class SearchItemNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * アイテム名(文字列)の部分一致検索<br>
	 * 合致すればアイテム名(文字列群)を返却値に、なければ該当なしというメッセージを返却値に設定
	 *
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String searchName =  request.getParameter("searchName");

		HttpSession session = request.getSession();
		UserBeans beans = (UserBeans) session.getAttribute("login");
		if(beans == null) {

			response.sendRedirect(request.getContextPath() + "/");
			return;

		}

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		if(searchName != null && searchName.trim().length() != 0) {

			SearchItemNameDAO dao = new SearchItemNameDAO();
			List<String> list = dao.selectItemName(beans.getUserId(), searchName);

			if(list.size() != 0) {

				out.println("以下のアイテムが登録されています");
				for(String name : list) {

					out.println(name);

				}

			} else {

				out.print("該当なし");

			}

		} else {

			out.print("入力してください");

		}

	}

}
