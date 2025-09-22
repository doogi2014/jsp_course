package jsp_restful_api.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jsp_restful_api.model.User;

public class UserService {
	
	private Connection con;
	
	public UserService() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/dev1?useSSL=false","root","123456");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void Create(User user) {
		String sql= "insert into user2(name,email) values(?,?);";
		try {
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.execute();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void Update(User user) {
		String sql= "update user2 set name=?,email=? where id =?";
		try {
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setInt(3, user.getId());
			statement.execute();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void Delete(int id) {
		String sql= "delete from user2 where id =?";
		try {
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public List<User> fetchAll() {
		List<User> list =new ArrayList<User>();
		String sql= "select * from user2 ";
		try {
			PreparedStatement statement=con.prepareStatement(sql);
			ResultSet rs =  statement.executeQuery();
			while(rs.next()) {
				User user =new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				list.add(user);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return list;
    }
	
	public List<User> fetchBy(int id) {
		List<User> list =new ArrayList<User>();
		String sql= "select * from user2 where id =?";
		try {
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs =  statement.executeQuery();
			while(rs.next()) {
				User user =new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				list.add(user);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return list;
	}

}
