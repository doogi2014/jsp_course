package cn.doogi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.doogi.model.OrderLogic;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "OrderMain", urlPatterns = "/OrderMain")
public class OrderMain extends HttpServlet {

	private static final long serialVersionUID = 4606657409948588815L;
	private static final List<String> myList = new ArrayList<String>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String con = req.getParameter("con");
		if(con !=null) {
			OrderLogic orderLogic =new OrderLogic();
			req.getSession().setAttribute("list", orderLogic.getResult(myList));
			req.getRequestDispatcher("/result.jsp").forward(req, resp);
			return;
		}
		List<String> list = new ArrayList<String>();
		list.add(req.getParameter("n1"));
		list.add(req.getParameter("n2"));
		list.add(req.getParameter("n3"));
		list.add(req.getParameter("n4"));
		list.add(req.getParameter("n5"));
		list.add(req.getParameter("n6"));
		
		req.getSession().setAttribute("list", list);
		myList.clear();
		myList.addAll(list);
		req.getRequestDispatcher("/confirm.jsp").forward(req, resp);
	}
	
	

}
