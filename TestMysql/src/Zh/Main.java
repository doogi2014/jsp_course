package Zh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		int high_jumps_count=0;
		int low_jumps_count=0;
		int[] list = {1,4,2,2,3,5,3,4};
		for (int i = 0; i < list.length -1; i++) {
			if(list[i]<list[i+1]) {
				high_jumps_count++;
			}else if(list[i]> list[i+1]) {
				low_jumps_count++;
			}
		}
		System.out.print(high_jumps_count +"|"+low_jumps_count);
		
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			con = DriverManager.getConnection("jdbc:mysql://localhost/dev1?useSSL=false","root","123456");
//			pstmt = con.prepareStatement("select * from lunch_menu");
//			rs = pstmt.executeQuery();
//			while(rs.next()) {
//				System.out.print(rs.getInt("no"));
//				System.out.print("  |  ");
//				System.out.print(rs.getString("set_name"));
//				System.out.print("  |  ");
//				System.out.print(rs.getInt("price"));
//				System.out.print("  |  ");
//				System.out.println(rs.getInt("count"));
//			}
//			
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
		
	}

}
