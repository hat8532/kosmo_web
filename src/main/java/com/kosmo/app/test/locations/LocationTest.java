package com.kosmo.app.test.locations;

public class LocationTest {

	public static void main(String[] args) {
		LocationDAO dao = new LocationDAO();
		
		try {
			dao.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
