package com.kosmo.app.departments;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class DepartmentUpdateController
 */
@WebServlet("/dept/update")
public class DepartmentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("departmentId");
		int n = Integer.parseInt(id);
		DepartmentDAO departmentDAO = new DepartmentDAO();
		
		try {
			DepartmentDTO departmentDTO = departmentDAO.detail(n);
			request.setAttribute("dto", departmentDTO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// foward
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/dept/update.jsp");
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DepartmentDTO departmentDTO = new DepartmentDTO();
		int di = Integer.parseInt(request.getParameter("departmentId"));
		String dn = request.getParameter("departmentName");
		int mi = Integer.parseInt(request.getParameter("managerId"));
		int li = Integer.parseInt(request.getParameter("locationId"));
		
		departmentDTO.setDepartmentId(di);
		departmentDTO.setDepartmentName(dn);
		departmentDTO.setManagerId(mi);
		departmentDTO.setLocationId(li);
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
		
		try {
			int result = departmentDAO.update(departmentDTO);
			
			if(result>0) {
				response.sendRedirect("./list");
			}else {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
