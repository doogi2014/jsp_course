package cn.doogi.resources;

import java.util.List;

import cn.doogi.model.Book;
import cn.doogi.service.BookDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;

@Path("/Practice1301servlet")
public class Practice1301servlet {
	
	private BookDao bookDao =new BookDao();

    @GET
    public void goJsp(@Context HttpServletRequest req,@Context HttpServletResponse resp) {
		
//		  RequestDispatcher dispatcher = req.getRequestDispatcher("form.jsp");
//		  dispatcher.forward(req, resp);

        try {
        	List<Book> list = bookDao.fetchAll();
            req.setAttribute("list", list);
            //请求转发
            req.getRequestDispatcher("/practice1301.jsp").forward(req, resp);
        } catch (Exception e) {
        }
    }
}
