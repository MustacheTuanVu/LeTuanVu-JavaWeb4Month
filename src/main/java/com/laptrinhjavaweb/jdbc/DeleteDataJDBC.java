package com.laptrinhjavaweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDataJDBC {
	public static void main(String[] args) {
		AbstractJDBC abstractJDBC = new AbstractJDBC();
		String sql = "DELETE FROM building WHERE id=?";
		Long id = abstractJDBC.delete(sql, Long.parseLong("4"));
		System.out.println("Xóa tòa nhà có id "+id+" thành công!");
	}
}
