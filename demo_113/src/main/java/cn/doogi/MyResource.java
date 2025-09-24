package cn.doogi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
    	
    	Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
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
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
        return "Got it!113";
    }
}
