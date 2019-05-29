package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;

public interface IBuildingService {
	BuildingDTO save(BuildingDTO newBuilding);
	BuildingDTO update(BuildingDTO building);
	BuildingDTO delete(BuildingDTO building);
	List<BuildingEntity> search(BuildingDTO building, Integer page, String sortBy, String sortType);
	List<BuildingEntity> findID(BuildingDTO building);
}
