package servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * アイテム編集に関するリクエストを処理するコントローラ
 */
@WebServlet("/ItemEditServlet")
@MultipartConfig
public class ItemEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * アイテム編集画面へフォワード
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/itemEditForm.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		String itemName = request.getParameter("itemName");
		String product = request.getParameter("product");
		int genre = Integer.parseInt(request.getParameter("genre"));
		String jan = request.getParameter("jan");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int score = Integer.parseInt(request.getParameter("score"));
		String orgName = request.getParameter("orgName");
		Part part = request.getPart("imgName");

		String imgName = "";
		// 新規画像がアップロードされていれば画像アップロード処理、そうでなければ既存の画像で設定
		if(part.getSize() != 0) {

			imgName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
			String path = getServletContext().getRealPath("/upload");
			part.write(path + File.separator + imgName);

		} else {

			imgName = orgName;

		}

		// ここから

	}

}
