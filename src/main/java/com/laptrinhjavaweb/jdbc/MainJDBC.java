package com.laptrinhjavaweb.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.enums.BuildingTypeEnums;

public class MainJDBC {
	public static void main(String[] args) {
		AbstractJDBC<?> abstractJDBC = new AbstractJDBC<Object>();
		System.out.println("-------DANH SÃ�CH TÃ’A NHÃ€-------------");
	    String query = "SELECT * FROM building";
		List<BuildingEntity> results = abstractJDBC.query(query, BuildingEntity.class);
		for (BuildingEntity buildingModel : results) {
			System.out.println(buildingModel.toString());
		}
//		
//		String sqlInsert = "INSERT INTO building (name, ward, street, structure, numberOfBasement, buildingArea) VALUES ("
//				+ "?, ?, ?, ?, ?, ?)";
//		Long id = abstractJDBC.insert(sqlInsert, "TÃ²a nhÃ  Ä�áº¹p nháº¥t","HoÃ ng Hoa ThÃ¡m", "HoÃ ng Hoa ThÃ¡m", "Khong biáº¿t" , 1,10);
//	    System.out.println("ThÃªm tÃ²a nhÃ  cÃ³ id "+id+" thÃ nh cÃ´ng!");
//	    System.out.println("-------------------------------------");
//	    
//	    String sqlUpdate = "UPDATE building set name=? WHERE id=?";
//	    Long idUpdate =  abstractJDBC.update(sqlUpdate, "TÃ²a nhÃ  xáº¥u nháº¥t",Long.valueOf("38"));
//		System.out.println("Sá»­a tÃ²a nhÃ  cÃ³ id "+idUpdate+" thÃ nh cÃ´ng!");
//		System.out.println("-------------------------------------");
//		
//		String sqlDelete = "DELETE FROM building WHERE id=?";
//		Long idDelete = abstractJDBC.delete(sqlDelete, Long.valueOf("38"));
//		System.out.println("XÃ³a tÃ²a nhÃ  cÃ³ id "+idDelete+" thÃ nh cÃ´ng!");
//		System.out.println("-------------------------------------");
		
//		Map<String, String> buildingTypes = new HashMap<>();
//		Stream.of(BuildingTypeEnums.values()).forEach(item -> {
//			//buildingTypes.put(key, item.getValue()),
//			buildingTypes.put(item.name(),item.getValue());
//		});
	}
}
