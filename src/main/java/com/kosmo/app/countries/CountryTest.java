package com.kosmo.app.countries;

public class CountryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountriesDAO dao = new CountriesDAO();
		try {
			dao.detail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
