package jsp_restful_api.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	public List<User> fetchAll() {
		List<User> list =new ArrayList<User>();
		list.add(new User("Zhang san","zhang@163.com"));
    	list.add(new User("Li si","li@163.com"));
        return list;
    }
	
	public User fetchBy(int id) {
		
		return new User("Li si","li@163.com");
	}

}
