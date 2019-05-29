package com.laptrinhjavaweb.jdbc;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.laptrinhjavaweb.dto.*;
import com.laptrinhjavaweb.mapper.BuildingMapper;

public class GetDataJDBC {
	public static void main(String[] args) {
		AbstractJDBC abstractJDBC = new AbstractJDBC();
		String query = "SELECT * FROM building";
		//List<BuildingModel> results = abstractJDBC.query(query, new BuildingMapper());
		//System.out.println(results.get(0).getName());
	}
}
