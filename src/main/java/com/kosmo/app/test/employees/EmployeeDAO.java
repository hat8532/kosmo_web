package com.kosmo.app.test.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kosmo.app.util.DBConnection;

public class EmployeeDAO {
	
	public void list() throws Exception {
		DBConnection connection = new DBConnection();
		Connection con = connection.getDB();
		
		String sql = "SELECT LAST_NAME, SALARY FROM EMPLOYEES";
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			String name = rs.getString("LAST_NAME");
			int money = rs.getInt("SALARY");
			System.out.println("이름은: "+name+" 연봉은: "+money+" 입니다");
		}
		
		rs.close();
		st.close();
		con.close();
	}
}
