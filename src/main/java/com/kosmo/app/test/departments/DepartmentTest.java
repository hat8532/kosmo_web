package com.kosmo.app.test.departments;

import com.kosmo.app.departments.DepartmentDAO;
import com.kosmo.app.departments.DepartmentDTO;

public class DepartmentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DepartmentDAO dao = new DepartmentDAO();
		try {
			dao.detail(110);
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartmentName("class2");
			departmentDTO.setManagerId(100);
			departmentDTO.setLocationId(1700);
			dao.create(departmentDTO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
