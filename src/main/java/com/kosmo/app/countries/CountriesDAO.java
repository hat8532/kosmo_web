package com.kosmo.app.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kosmo.app.util.DBConnection;

public class CountriesDAO {
	
	public void detail() throws Exception {
		DBConnection connection = new DBConnection();
		Connection con = connection.getDB();
		
		String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID='US'";
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			String name = rs.getString("COUNTRY_NANE");
			System.out.println(name);
		}else {
			System.out.println("없다");
		}
		
		rs.close();
		st.close();
		con.close();
	}
	
	public void countrylist() throws Exception {
		
		DBConnection connection = new DBConnection();
		Connection con = connection.getDB();
		
		String sql = "SELECT * FROM COUNTRIES";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			String name = rs.getString("COUNTRY_NAME");
			String id = rs.getString("COUNTRY_ID");
			System.out.println(name + " : " + id);
		}
		
		rs.close();
		st.close();
		con.close();
		
	}
}
