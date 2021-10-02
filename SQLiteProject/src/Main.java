import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {//
		// TODO Auto-generated method stub
	Connection con = null;
	try {
		Class.forName("org.sqlite.JDBC");
		
		String dbFile = "myfirst.db";
		con = DriverManager.getConnection("jdbc:sqlite:"+dbFile);
		
		//데이터조회
		System.out.println("\n***데이터 조회 ***");
		Statement stat1 = con.createStatement();
		String sql1 = "select * from g_artists";
		ResultSet rs1 = stat1.executeQuery(sql1);
		while(rs1.next()) {
			String id = rs1.getString("id");
			String name = rs1.getString("name");
			System.out.println(id+" "+ name);
			
		}
		stat1.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		if(con !=null) {
			try {
				con.close();
			}catch(Exception e) {}
		}
	}
	}

}
