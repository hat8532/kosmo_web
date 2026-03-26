package com.kosmo.app.test.employees;

public class EmployeeTest {

	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		
		try {
			dao.list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
