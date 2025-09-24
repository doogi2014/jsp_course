package cn.doogi.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.doogi.model.Book;

public class BookDao {
	private Connection con;
	
	public BookDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/dev1?useSSL=false","root","123456");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public List<Book> fetchAll() {
		List<Book> list =new ArrayList<Book>();
		String sql= "select * from practice_table ";
		try {
			PreparedStatement statement=con.prepareStatement(sql);
			ResultSet rs =  statement.executeQuery();
			while(rs.next()) {
				Book book =new Book();
				book.setId(rs.getString("id"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getString("price"));
				book.setAuthor(rs.getString("author"));
				book.setComment(rs.getString("comment"));
				list.add(book);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return list;
    }
	
	public List<Book> fetchBy(String id) {
		List<Book> list =new ArrayList<Book>();
		//在这浪费了很长时间，?不需要加单引号
		String sql= "select * from practice_table where id=?";
		try {
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setString(1, id);
			ResultSet rs =  statement.executeQuery();
			while(rs.next()) {
				Book book =new Book();
				book.setId(rs.getString("id"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getString("price"));
				book.setAuthor(rs.getString("author"));
				book.setComment(rs.getString("comment"));
				list.add(book);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return list;
	}
}
