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
import model.ItemEditLogic;

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

		HttpSession session = request.getSession();
		ItemBeans beans = (ItemBeans) session.getAttribute("item_session");
		if(beans == null) {

			response.sendRedirect(request.getContextPath() + "/MainServlet");
			return;

		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/itemEditForm.jsp");
		rd.forward(request, response);

	}

	/**
	 * アイテム編集
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

		ItemBeans beans = new ItemBeans();
		beans.setItemId(itemId);
		beans.setItemName(itemName);
		beans.setProduct(product);
		beans.setGenreId(genre);
		beans.setJan(jan);
		beans.setQuantity(quantity);
		beans.setScore(score);
		beans.setImgName(imgName);

		ItemEditLogic logic = new ItemEditLogic();
		int count = logic.execute(beans);

		String msg = "";
		if(count != 0) {

			msg += "編集しました。";

		} else {

			msg += "編集に失敗しました。";

		}

		request.setAttribute("resultMsg", msg);

		HttpSession session = request.getSession();
		session.removeAttribute("item_session");

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/itemEditResult.jsp");
		rd.forward(request, response);

	}

}
