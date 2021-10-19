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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.ItemBeans;
import model.ItemInsertLogic;
import model.UserBeans;

/**
 * アイテム登録に関するリクエストを処理するコントローラ
 */
@WebServlet("/ItemInsertServlet")
@MultipartConfig
public class ItemInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * アイテム登録フォーム画面へフォワード
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/itemInsertForm.jsp");
		rd.forward(request, response);

	}

	/**
	 * アイテム登録処理
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String itemName = request.getParameter("itemName");
		String product = request.getParameter("product");
		int genreId = Integer.parseInt(request.getParameter("genre"));
		String jan = request.getParameter("jan");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		Part part = request.getPart("imgName");

		String imgName = "";

		// 画像がアップロードされた場合の処理
		if(part.getSize() != 0) {

			imgName = Paths.get(part.getSubmittedFileName()).getFileName().toString();	// ファイル名の取得
			String path = getServletContext().getRealPath("/upload");					// 送信されたファイルを格納するフォルダの指定
			part.write(path + File.separator + imgName);								// ファイルの保存(upload/xxxx.jpgという形で保存)

		}

		HttpSession session = request.getSession();
		UserBeans userBeans = (UserBeans) session.getAttribute("login");

		ItemBeans itemBeans = new ItemBeans();
		itemBeans.setItemName(itemName);
		itemBeans.setProduct(product);
		itemBeans.setGenreId(genreId);
		itemBeans.setJan(jan);
		itemBeans.setQuantity(quantity);
		itemBeans.setImgName(imgName);

		ItemInsertLogic logic = new ItemInsertLogic();
		int count = logic.execute(userBeans.getUserId(), itemBeans);

		String msg = "";
		if(count != 0) {

			msg += "登録しました";

		} else {

			msg += "登録に失敗しました";

		}

		request.setAttribute("resultMsg", msg);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/itemInsertResult.jsp");
		rd.forward(request, response);

	}

}
