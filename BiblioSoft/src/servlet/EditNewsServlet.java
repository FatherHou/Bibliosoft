package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import entity.Book;
import entity.BorrowedRecord;
import entity.Post;
import entity.Reader;
import updateTo.ImgUtil;
import updateTo.StringUtil;
import updateTo.ToBook;
import updateTo.ToBorrowedRecord;
import updateTo.ToPost;
import updateTo.ToReader;

public class EditNewsServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		int start = 0;
		int id=0;
		String account="";
		String barcode="";
		String image_content = "";
		String word_content ="";
		String picturePath = "";
		try{
			image_content = request.getParameter("editorValue");//��ø��ı��༭������
			word_content = request.getParameter("MyPostTitle");//��ø��ı��༭������
			List list = ImgUtil.getImageSrc(request.getParameter("editorValue"));
//			List list = ImgUtil.getImageSrc(request.getParameter("MyPostTitle"));
			picturePath = StringUtil.listToString(list, ',');
		}catch(NumberFormatException e){

		}

		Reader reader = new ToReader().getByAccount(account, "");
		System.out.print("===========================>content is :"+word_content);
		System.out.print("===========================>picturePath is :"+picturePath);
		System.out.print("===========================>image_content is :"+image_content);
		
		
		Date date = new Date(System.currentTimeMillis());//��ͬ��java.util.Date

		
		Post post = new Post("1",date,"",picturePath,word_content);
		
		
		System.out.print(post.toString()+'\n');
		request.setAttribute("Post", post);
		System.out.print(post.toString()+'\n');

				request.getRequestDispatcher("LibrarianEditPostText.jsp").forward(request, response);

				return;
	}
	
}