package com.kosmo.app.countries;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.kosmo.app.departments.DepartmentDAO;
import com.kosmo.app.departments.DepartmentDTO;

/**
 * Servlet implementation class CountryCreateController
 */
@WebServlet("/country/create")
public class CountryCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryCreateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/country/create.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cid = request.getParameter("countryId");
		String cn = request.getParameter("countryName");
		String rid = request.getParameter("regionId");
		
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartmentName(cid);
		departmentDTO.setManagerId(Integer.parseInt(cn));
		departmentDTO.setLocationId(Integer.parseInt(rid));
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
		try {
			int result=departmentDAO.create(departmentDTO);
			
			if(result>0) {
				response.sendRedirect("./list");
			}else {
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/country/list.jsp");
				view.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
