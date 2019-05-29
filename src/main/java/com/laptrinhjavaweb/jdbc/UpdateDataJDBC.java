package com.laptrinhjavaweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDataJDBC {
	public static void main(String[] args) {
		AbstractJDBC abstractJDBC = new AbstractJDBC();
		String sql = "UPDATE building set name=? WHERE id=?";
		Long id = abstractJDBC.update(sql, "abc",4);
		System.out.println("Sửa tòa nhà có id "+id+" thành công!");
	}
}
