package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "BirthdayMain", urlPatterns = "/BirthdayMain")
public class BirthdayMain extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2817307475372439235L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html;charset=utf-8");
//
//        
//		PrintWriter out = resp.getWriter();
//        //window.location:alert弹框消失后跳转到的页面  window.location='index.jsp';
//        out.println("<script>window.location='form.jsp';</script>");
		


		RequestDispatcher dispatcher = req.getRequestDispatcher("form.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String mon = req.getParameter("month");
		String day = req.getParameter("day");
		
		Date nowDate1 = new Date();
		Date nowDate2 = new Date();
		nowDate2.setMonth(Integer.valueOf(mon)-1);
		nowDate2.setDate(Integer.valueOf(day));
		if(nowDate1.after(nowDate2)) {
			nowDate2.setYear(nowDate2.getYear()+1);
		}
		LocalDate date1 = LocalDate.of(nowDate1.getYear(), nowDate1.getMonth(), nowDate1.getDate());
        LocalDate date2 = LocalDate.of(nowDate2.getYear(), nowDate2.getMonth(), nowDate2.getDate());
		int c = (int) ChronoUnit.DAYS.between(date1, date2);
		
		req.getSession().setAttribute("count", c);
		//req.setAttribute("count", c);

		RequestDispatcher dispatcher = req.getRequestDispatcher("result.jsp");
		dispatcher.forward(req, resp);
	}
	
	

}
