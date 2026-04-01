package com.kosmo.app.home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import com.kosmo.app.util.DBConnection;

public class CommunityDAO {
	private DBConnection connection;
	
	public void CommunityDAO() {
		this.connection = new DBConnection();
	}
	
	public void delete(CommunityDTO communityDTO) throws Exception {
		Connection con = connection.getDB();
		String sql = """
					DELETE COMMUNITY WHERE NUMNUMBER=?
					""";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, communityDTO.getNumNumber());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
	}
	
	public int create(CommunityDTO communityDTO) throws Exception {
		Connection con = connection.getDB();
		String sql = """
					INSERT INTO COMMUNITY (NUMNUMBER, TITLE, NAME, CONTENTS, WRITE_DATE)
					VALUES (COMM_SEQ.NEXTVAL, ?, ?, ?, SYSDATE);
					""";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, communityDTO.getTitle());
		st.setString(2, communityDTO.getName());
		st.setString(3, communityDTO.getContents());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	public CommunityDTO detail(int numNumber) throws Exception {
		Connection con = connection.getDB();
		String sql = "SELECT * FROM COMMUNITY WHERE NUMNUMBER=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, numNumber);
		
		ResultSet rs = st.executeQuery();
		CommunityDTO dto=null;
		if(rs.next()) {
			dto = new CommunityDTO();
			dto.setNumNumber(rs.getInt("NUMNUMBER"));
			dto.setTitle(rs.getString("TITLE"));
			dto.setName(rs.getString("NAME"));
			dto.setContents(rs.getString("CONTENTS"));
			dto.setDate(rs.getObject("WRITE_DATE", LocalDate.class)); 
            dto.setStar(rs.getInt("STARNUMBER"));
		}
		
		rs.close(); 
		st.close(); 
		con.close();
		
        return dto;
	}
	
	public ArrayList<CommunityDTO> list() throws Exception {
		Connection con = connection.getDB();
		
		String sql = "SELECT * FROM COMMUNITY ORDER BY NUMNUMBER";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		ArrayList<CommunityDTO> ar = new ArrayList<>();
		while(rs.next()) {
			CommunityDTO dto = new CommunityDTO();	
			int num = rs.getInt("NUMNUMBER");
			String title = rs.getString("TITLE");
			String name = rs.getString("NAME");
			String contents = rs.getString("CONTENTS");
			LocalDate date = rs.getObject("WRITE_DATE", LocalDate.class);
			int star = rs.getInt("STARNUMBER");
			
			dto.setNumNumber(num);
			dto.setTitle(title);
			dto.setName(name);
			dto.setContents(contents);
			dto.setDate(date);
	        dto.setStar(star);
			
			ar.add(dto);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
	
}
