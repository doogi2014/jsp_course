package cn.doogi.resources;

import java.util.List;

import cn.doogi.model.Book;
import cn.doogi.service.BookDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;

@Path("/Practice1302servlet")
public class Practice1302servlet {

	private BookDao bookDao =new BookDao();

    @GET
    public void goJsp(@Context HttpServletRequest req,@Context HttpServletResponse resp) {
		
//		  RequestDispatcher dispatcher = req.getRequestDispatcher("form.jsp");
//		  dispatcher.forward(req, resp);

        try {
        	String id = req.getParameter("id");
        	List<Book> list = bookDao.fetchBy(id);
            req.setAttribute("book", list.get(0));
            //请求转发
            req.getRequestDispatcher("/practice1302.jsp").forward(req, resp);
        } catch (Exception e) {
        }
    }
}
