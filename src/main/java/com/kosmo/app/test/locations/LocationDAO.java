package com.kosmo.app.test.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kosmo.app.util.DBConnection;

public class LocationDAO {
	
	public void list() throws Exception {
		DBConnection connection = new DBConnection();
		Connection con = connection.getDB();
		
		String sql = "SELECT LOCATION_ID, STREET_ADDRESS, CITY	 FROM LOCATIONS";
		
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			int id = rs.getInt("LOCATION_ID");
			String name = rs.getString("STREET_ADDRESS");
			String name2 = rs.getString("CITY");
			System.out.println("지역번호는: "+id+" 지역 이름은: "+name+" 도시 이름은: "+name2);
		}
		
		rs.close();
		st.close();
		con.close();
	}
}
