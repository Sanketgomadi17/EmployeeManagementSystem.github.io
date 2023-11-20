package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.modals.EmployeeBO;

public class EmployeeBoImp implements EmployeeBO {

	private static Connection connection = null;
	private static PreparedStatement prepareStatement;
	private static Statement statement;
	private static ResultSet res;

	private final static String INSERT_QUERY = "INSERT into `employee` (`id`,`name`,`email`,`department`,`salary`) values(?,?,?,?,?)";
	private final static String GET_ALL_QUERY = "SELECT * from `employee`";
	private final static String DELETE_QUERY = "DELETE from `emploee` WHERE `id` = ?";
	private final static String UPDATE_QUERY = "UPDATE `employee` SET name = ?,email=?,department=?,salary=? WHERE id=? ";
	
	public EmployeeBoImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcclasses", "root", "root");
	
			
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public int save(Employee e) {
		
		try {
			prepareStatement = connection.prepareStatement(INSERT_QUERY);
			
			prepareStatement.setInt(1, e.getId());
			prepareStatement.setString(2, e.getName());
			prepareStatement.setString(3, e.getEmail());
			prepareStatement.setString(4, e.getDepartment());
			prepareStatement.setInt(5, e.getSalary());
			
			
			int i = prepareStatement.executeUpdate();
			
			return prepareStatement.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return 0;
			
	}

	@Override
	public int update(Employee e) {
		
		
		try {
			prepareStatement = connection.prepareStatement(UPDATE_QUERY);
		
			prepareStatement.setString(1, e.getName());
			prepareStatement.setString(2, e.getEmail());
			prepareStatement.setString(3, e.getDepartment());
			prepareStatement.setInt(4, e.getSalary());
			prepareStatement.setInt(5, e.getId());
					
			return prepareStatement.executeUpdate();
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int delete(int id) {
		
		
		try {
			 prepareStatement = connection.prepareStatement(DELETE_QUERY);
			 
			 prepareStatement.setInt(1, id); 
			 
			 return prepareStatement.executeUpdate();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		return 0;
	}

	@Override
	public int delete(Employee e) {
		 
		return delete(e.getId());
		
	}

	@Override
	public Employee get(int id) {
		
		
		
		
		return null;
	}

	@Override
	public List<Employee> getAll() {
		
		
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		
		try {
			statement = connection.createStatement();
			
			res = statement.executeQuery(GET_ALL_QUERY);
			
			
			while(res.next())
			{
				int id = res.getInt("id");
				String name = res.getString("name");
				String email = res.getString("email");
				String department = res.getString("department");
				int salary = res.getInt("salary");
				
				Employee e = new Employee(id, name, email, department, salary);
				
				employeeList.add(e);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return employeeList;
		
	}

}
