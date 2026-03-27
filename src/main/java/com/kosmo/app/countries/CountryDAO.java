package com.kosmo.app.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kosmo.app.departments.DepartmentDTO;
import com.kosmo.app.util.DBConnection;

public class CountryDAO {
	private DBConnection connection;
	
	public CountryDAO(){
		this.connection = new DBConnection();
	}
	
	public int update(CountryDTO countryDTO) throws Exception {
		Connection con = connection.getDB();
		
		String sql = """
					UPDATE COUNTRIES SET COUNTRY_ID=?, COUNTRY_NAME=?, REGION_ID=?
					WHERE COUNTRY_ID=?
					""";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, countryDTO.getCountryId());
		st.setString(2, countryDTO.getCountryName());
		st.setInt(3, countryDTO.getRegionId());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int delete(String countryId) throws Exception {
		Connection con = connection.getDB();
		
		String sql = """
					DELETE COUNTRIES WHERE COUNTRY_ID=?
					""";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, countryId);
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public int create(CountryDTO countryDTO) throws Exception {
		Connection con = connection.getDB();
		
		 String sql = """
		 			INSERT INTO COUNTRIES (COUNTRY_ID, COUNTRY_NAME, REGION_ID)
					VALUES (?, ?, ?)
		 			""";
		 PreparedStatement st = con.prepareStatement(sql);
		 
		 st.setString(1, countryDTO.getCountryId());
		 st.setString(2,countryDTO.getCountryName());
		 st.setInt(3, countryDTO.getRegionId());
		 
		 int result = st.executeUpdate();
		 
		 st.close();
		 con.close();
		 
		 return result;
	}
	
	
	public CountryDTO detail(String countryId) throws Exception {
		Connection con = connection.getDB();
	    
	    // 1. 시퀀스 빼고 문자열 ID로 조회하는 쿼리 작성
	    String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID = ?"; 
	    
	    PreparedStatement st = con.prepareStatement(sql);
	    
	    // ? 채우기
	    st.setString(1, countryId);
	    
	    ResultSet rs = st.executeQuery();
	    CountryDTO dto = null;
	    
	    if(rs.next()) {
	        dto = new CountryDTO();
	        dto.setCountryId(rs.getString("COUNTRY_ID"));
	        dto.setCountryName(rs.getString("COUNTRY_NAME"));
	        dto.setRegionId(rs.getInt("REGION_ID"));
	    }
	    
	    rs.close();
	    st.close();
	    con.close();
	    
	    return dto;
	}
	
	public ArrayList<CountryDTO> list() throws Exception {
		Connection con = connection.getDB();
		
		String sql = """
					SELECT * FROM COUNTRIES
					ORDER BY REGION_ID DESC
					""";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		ArrayList<CountryDTO> ar = new ArrayList<>();
		while(rs.next()) {
			CountryDTO dto = new CountryDTO();
			String cid = rs.getString("COUNTRY_ID");
			String cname= rs.getString("COUNTRY_NAME");
			int rid = rs.getInt("REGION_ID");
			
			dto.setCountryId(cid);
			dto.setCountryName(cname);
			dto.setRegionId(rid);
			
			ar.add(dto);	
		}
		//6. 연결 해제
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
}
