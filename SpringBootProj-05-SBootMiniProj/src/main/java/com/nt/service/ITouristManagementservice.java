package com.nt.service;

import java.util.List;

import com.nt.entity.Tourist;
import com.nt.model.TouristNotFoundException;

public interface ITouristManagementservice {

	public String registerTourist(Tourist tourist);

	public List<Tourist> fetchAllTourists();

	public Tourist FetchById(Integer tid) throws TouristNotFoundException;

	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException;
	
	public String deleteTourist(Integer tid ) throws TouristNotFoundException;
	
	public String updateTouristBudgetById(Integer tid,Float hikepercent) throws TouristNotFoundException;

	public String deleteByIdbetween(int start, int end) throws TouristNotFoundException;

}
