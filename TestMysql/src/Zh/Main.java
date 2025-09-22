package Zh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/dev1?useSSL=false","root","123456");
			pstmt = con.prepareStatement("select * from lunch_menu");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.print(rs.getInt("no"));
				System.out.print("  |  ");
				System.out.print(rs.getString("set_name"));
				System.out.print("  |  ");
				System.out.print(rs.getInt("price"));
				System.out.print("  |  ");
				System.out.println(rs.getInt("count"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
