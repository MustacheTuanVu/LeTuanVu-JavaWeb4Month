package com.laptrinhjavaweb.jdbc;

import java.util.List;

import com.laptrinhjavaweb.mapper.ResultSetMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AbstractJDBC<T> {
	private Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String databaseURL = "jdbc:mysql://localhost:3306/estate_javaweb_learning";
			String userName = "root";
			String password = "123456";
			return DriverManager.getConnection(databaseURL, userName, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("hiding")
	public <T> List<T> query(String sql, Class<T> zClass, Object... parameters){
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();
		
		try (Connection conn = getConnection();
				PreparedStatement statement =  conn.prepareStatement(sql);
				ResultSet resultset =  statement.executeQuery();
				) {
			if(conn != null) {
				return resultSetMapper.mapRow(resultset, zClass);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	public Long insert(String sql, Object... parameters) {
		Long id = null;
		
		Connection conn = null;
		PreparedStatement statement =  null;
		ResultSet resultset = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement =  conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			if(conn != null) {
				//set parameters
				for (int i = 0; i < parameters.length; i++) {
					statement.setObject(i+1, parameters[i]);
				}
				 
				int rowsInserted = statement.executeUpdate();
				resultset = statement.getGeneratedKeys();
				conn.commit();
				if (rowsInserted > 0) {
					while (resultset.next()) {
						id = resultset.getLong(1);
						return id;
					}
				}
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public Long update(String sql, Object... parameters ) {
		Long id = null;
		Connection conn = null;
		PreparedStatement statement =  null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement =  conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			if(conn != null) {
				//set parameters
				for (int i = 0; i < parameters.length; i++) {
					statement.setObject(i+1, parameters[i]);
					if(i == (parameters.length-1)) {
						id =  (Long) parameters[i];
					}
				}
				statement.executeUpdate();
				statement.getGeneratedKeys();
				conn.commit();
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return id;
	}
	
	public Long delete(String sql, Long id) {
		String databaseURL = "jdbc:mysql://localhost:3306/estate_javaweb_learning";
		String userName = "root";
		String password = "123456";
		
		Connection conn = null;
		PreparedStatement statement =  null;
		try {
			conn = DriverManager.getConnection(databaseURL, userName, password);
			conn.setAutoCommit(false);
			statement =  conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			Class.forName("com.mysql.jdbc.Driver");
			if(conn != null) {
				//set parameters
				statement.setLong(1, id);
				 
				statement.executeUpdate();
				statement.getGeneratedKeys();
				conn.commit();
				return id;
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
