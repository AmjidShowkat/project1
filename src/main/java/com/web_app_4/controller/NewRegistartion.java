package com.web_app_4.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web_app_4.model.DAOService;
import com.web_app_4.model.DAOServiceImpl;

@WebServlet("/saveReg")
public class NewRegistartion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NewRegistartion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/createRegistration.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String name = request.getParameter("name");
	String city = request.getParameter("city");
	String number = request.getParameter("number");
	String email = request.getParameter("email");
	
	DAOService ser = new DAOServiceImpl();
	ser.connectDB();
	ser.saveRegistration(name, city, number, email);
	request.setAttribute("md", "Details Saved Sussefully Hyati");
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/createRegistration.jsp");
	rd.forward(request, response);
	
	
	
	
	
	
	
	}

}
