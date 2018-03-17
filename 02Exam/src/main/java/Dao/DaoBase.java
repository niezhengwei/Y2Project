package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoBase {

	private final String DRIVER="com.mysql.jdbc.Driver";
	private String URL="jdbc:mysql://127.0.0.1:3306/table";
	private final String USERNAME="root";
	private final String PASSWORD="123456";

	Connection con=null;
	PreparedStatement pstmt=null;
	/**
	 * ��������
	 * @return
	 * @throws Exception
	 */
	public  Connection getConnection(){
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL,USERNAME, PASSWORD);
			return con;	
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * �رշ���
	 * @throws Exception
	 */
	public  void allClose(){
		try {
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ��ɾ�ķ���
	 * @param sql
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public int exeUpDate(String sql,Object...obj){
		try {
			pstmt = getConnection().prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pstmt.setObject(1+i, obj[i]);
			}
			int result = pstmt.executeUpdate();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	/**
	 * ��ѯ����
	 * @param sql
	 * @return
	 * @throws Exception 
	 * @throws SQLException 
	 */
	public ResultSet exeQuery(String sql,Object...obj){
		
		try {
			pstmt = getConnection().prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				pstmt.setObject(1+i, obj[i]);
			}
			ResultSet rs = pstmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @return the uRL
	 */
	public String getURL() {
		return URL;
	}
	/**
	 * @param uRL the uRL to set
	 */
	public void setURL(String uRL) {
		URL = uRL;
	}

	
	
}
