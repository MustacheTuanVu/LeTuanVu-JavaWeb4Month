package com.laptrinhjavaweb.controller.admin.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.BuildingService;
import com.laptrinhjavaweb.utils.HttpUtil;

@WebServlet(urlPatterns = {"/api-admin-building"})
public class BuildingAPI extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private IBuildingService buildingService;
	
	public BuildingAPI() {
		buildingService = new BuildingService();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json"); 
		BuildingDTO buidingDTO =  HttpUtil.of(request.getReader()).toModel(BuildingDTO.class); //XONG, CHỈ VIỆC BINDING Building qua
		// trả lại về json
		int page = Integer.parseInt(request.getParameter("page"));
		String sortBy = request.getParameter("sortBy");
		String sortType = request.getParameter("sortType");
		String action = request.getParameter("action");
		switch (action) {
		case "search":
			List<BuildingEntity> buildingEntities = buildingService.search(buidingDTO,page, sortBy, sortType);
			mapper.writeValue(response.getOutputStream(), buildingEntities);
			break;
		case "save":
			buidingDTO = buildingService.save(buidingDTO);
			mapper.writeValue(response.getOutputStream(), buidingDTO);
			break;	
		case "update":
			buidingDTO = buildingService.update(buidingDTO);
			mapper.writeValue(response.getOutputStream(), buidingDTO);
			break;
		case "delete":
			buidingDTO = buildingService.delete(buidingDTO);
			mapper.writeValue(response.getOutputStream(), buidingDTO);
			break;
		case "findID":
			List<BuildingEntity> buildingEntitiess = buildingService.findID(buidingDTO);
			mapper.writeValue(response.getOutputStream(), buildingEntitiess);
			break;
		default:
			break;
		}
	}

}
