import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JingeriaDAO {

	Connection con = null;
	
	public void getConnection() throws Exception {
			
		String url = "jdbc:mariadb://localhost:3306/tu";
		String name ="root";
		String pw = "8498";
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.print("드라이버 적재 성공.");
			con=DriverManager.getConnection(url,name,pw);
			System.out.print("데이터베이스 연결 성공.");
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
		} catch(SQLException e) {
			System.out.println("연결에 실패했습니다.");
		}
	 
		
	}
	

	public void insertPoint(Point p) throws Exception {
		
		getConnection();
		try {
				
			String sql = "insert into point values(?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
				pstmt.setInt(1, Point.level);
		        pstmt.setInt(2, Point.pattyPoint);
		        pstmt.setInt(3, Point.vegetablesPoint);
		        pstmt.setInt(4, Point.bunPoint);
		        pstmt.setInt(5, Point.produceNum);
		        pstmt.setInt(6, Point.consumeNum_1);
		        pstmt.setInt(7, Point.consumeNum_2);
		        pstmt.setInt(8, Point.consumeNum_3);
		        pstmt.setInt(9, Point.consumeNum_4);
	
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				con.close();
			} catch(Exception ignore) {
				
			}
		}
	}
	
	public void deletePoint(int level) throws Exception {
		
		getConnection();
		
		try {
					
			String sql = "delete from point where level=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, level);
			
			pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				con.close();
			} catch(Exception ignore) {} 
		}
	}
	
	/*
	public ArrayList<Point> listPoint() throws Exception {
		ArrayList<Point> list = new ArrayList<Point>();
		
		getConnection();

		try {
			
			String sql = "select * from Point";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			Point p = null;
			
			while(rs.next()) {
				int getConsumeNum1= rs.getInt(1);
				int getConsumeNum2= rs.getInt(2);
				int getConsumeNum3= rs.getInt(3);
				int getConsumeNum4= rs.getInt(4);
	        
	            p = new Point();

	     //       p.setPattyPoint(pattyPoint1)[0];
	            
	            list.add(p);
			}

		} catch(Exception e) {
			throw e;
		} finally {
			try {
				con.close();
			} catch(Exception ignore) {}
		}
		return list;	
	}


	public void updateMember(Point p) throws Exception {

		getConnection();

		try {
			
			String sql = "update point set pw=? where id = ?";
		
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			
				pstmt.setInt(1, p.level);
		        pstmt.setInt(2, p.pattyPoint);
		        pstmt.setInt(3, p.vegetablesPoint);
		        pstmt.setInt(4, p.bunPoint);
		        pstmt.setInt(5, p.produceNum);
		        pstmt.setInt(6, p.consumeNum_1);
		        pstmt.setInt(7, p.consumeNum_2);
		        pstmt.setInt(8, p.consumeNum_3);
		        pstmt.setInt(9, p.consumeNum_4);
			
	         pstmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				con.close();
			} catch(Exception ignore) {}
		}
	}
	 */
	
}
