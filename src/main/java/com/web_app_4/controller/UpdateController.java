package com.web_app_4.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web_app_4.model.DAOService;
import com.web_app_4.model.DAOServiceImpl;

@WebServlet("/updateReg")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email = request.getParameter("email");
	String number = request.getParameter("mobile");
	request.setAttribute("email", email);
	request.setAttribute("number", number);
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/updateRegistration.jsp");
	rd.forward(request, response);
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email = request.getParameter("email");
		String number = request.getParameter("number");
		DAOService d = new DAOServiceImpl();
		d.connectDB();
		d.update(email, number);
		ResultSet result = d.listReg();
		request.setAttribute("res", result);
		request.setAttribute("lk", "Updated Successfully");
		RequestDispatcher rdd = request.getRequestDispatcher("/WEB-INF/views/listRegistration.jsp");
		rdd.forward(request, response);
	     
		
	}

}
