package lib;

import java.sql.*;

public abstract class ObjectDBIO {   //데이터베이스 연동을 위한 공용기능 정의 
    private Connection conn = null;
    private String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";   // mac: xe  window: orcl
    private String db_id = "scott";
    private String db_pwd ="scott";
    //setter 
    public void setJdbc_url(String jdbc_url) {
		this.jdbc_url = jdbc_url;
	}
	public void setDb_id(String db_id) {
		this.db_id = db_id;
	}
	public void setDb_pwd(String db_pwd) {
		this.db_pwd = db_pwd;
	}
    
    //DB 연결 
	private boolean open() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(jdbc_url,db_id,db_pwd);
			return true;
			
		} catch(ClassNotFoundException e1) {
			e1.printStackTrace();
			return false;
			
		} catch (SQLException e2) {
			e2.printStackTrace();
			return false;
		}
		
	}
	//DB 연결 종료
		protected boolean close() {
			try {
				conn.close();
				return true;
			}catch (SQLException e) {
                e.printStackTrace();
                return false;
			}
			
       }
	
	  // 지정된 테이블에서 데이터를 조회 기능 
		
		protected ResultSet execute(String strSql, ResultSet rs) {
			try {
				//데이터베이스 연결 요청 open()
				open();
				Statement obj = conn.createStatement();
				//쿼리를 실행 
				rs = obj.executeQuery(strSql);
			   
			    //결과값을 담아서 execute 요청한 위치에 전달
				
			} catch (Exception e) {
                  e.printStackTrace();
			}
			 return rs;	
			
		}
	protected boolean execute(String strSql) {
		try {
			//데이터베이스 연결 요청 open()
			open();
			PreparedStatement obj = conn.prepareStatement(strSql);

//			Statement obj = conn.createStatement();
			//쿼리를 실행
			ResultSet resultSet = obj.executeQuery();

			//결과값을 담아서 execute 요청한 위치에 전달

		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;

	}
		
		
		
		
		
		
		
		
		
		
    
}
