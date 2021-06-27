package test;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletRequest;
public class RetrieveDao {
	int k = 0;
	public int retrieveBook32(ServletRequest req, PrintWriter pw) {
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from book32 where bcode = "+ "'" + req.getParameter("bId") +"'");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				pw.println("BId = " +  rs.getString(1)+ "<br> BName = " + rs.getString(2) + "<br> BAuthor = " + rs.getString(3) +
						"<br> BPrice = " + rs.getFloat(4) + "<br> BQnty " + rs.getInt(5) );
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return k;
	}

}
