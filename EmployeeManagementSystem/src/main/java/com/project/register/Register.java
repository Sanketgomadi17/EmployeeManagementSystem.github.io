package com.project.register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.dao.Employee;
import com.project.dao.EmployeeBoImp;

@WebServlet("/register")
public class Register extends HttpServlet {

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			System.out.println("HELLO");
			
		
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String department = req.getParameter("department");
			int salary = Integer.parseInt(req.getParameter("salary"));
			
			
			Employee employee = new Employee(id, name, email, department, salary);
			
			EmployeeBoImp employeebo = new EmployeeBoImp();
			
			
			employeebo.save(employee);
		}
}
