package com.laptrinhjavaweb.jdbc;

public class InsertDataJDBC {
	public static void main(String[] args) {
		AbstractJDBC abstractJDBC = new AbstractJDBC();
		String sql = "INSERT INTO building (name, ward, street, structure, numberOfBasement, buildingArea) VALUES ("
				+ "?, ?, ?, ?, ?, ?)";
		Long id = abstractJDBC.insert(sql, "Tòa nhà Vinhome","Bình Lợi", "Nơ trang long", "Khong biết" , 1,10);
	    System.out.println("Thêm tòa nhà có id "+id+" thành công!");
	}
}
