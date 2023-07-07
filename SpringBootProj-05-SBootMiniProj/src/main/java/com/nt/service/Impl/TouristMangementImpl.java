package com.nt.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.Repository.ITourist;
import com.nt.entity.Tourist;
import com.nt.model.TouristNotFoundException;
import com.nt.service.ITouristManagementservice;



@Service
public class TouristMangementImpl implements ITouristManagementservice {
	@Autowired
	private ITourist repo;

	@Override
	public String registerTourist(Tourist tourist) {
		Integer tid = repo.save(tourist).getTid();
		return "Tourist is registered having the id value::" + tid;
	}

	@Override
	public List<Tourist> fetchAllTourists() {
		List<Tourist> list = repo.findAll();
		list.sort((t1, t2) -> t1.getTid().compareTo(t2.getTid()));
		return list;
	}

	@Override
	public Tourist FetchById(Integer tid) throws TouristNotFoundException {

		return repo.findById(tid).orElseThrow(() -> new TouristNotFoundException(tid + "tourist not found"));
	}

	@Override
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException {
		Optional<Tourist> optional1 = repo.findById(tourist.getTid());
		if (optional1.isPresent()) {
			repo.save(tourist);// save() performed either save or update object opertion
			return tourist.getTid() + "Tourist is updated";
		} else
			throw new TouristNotFoundException(tourist.getTid() + "Tourist not found");

	}

	@Override
	public String deleteTourist(Integer tid) throws TouristNotFoundException {
		Optional<Tourist> optional2 = repo.findById(tid);
		if (optional2.isPresent()) {
			repo.delete(optional2.get());
			return tid + "Tourist deleted";
		} else
			throw new TouristNotFoundException(tid + "Tourist not found");

	}

	@Override
	public String updateTouristBudgetById(Integer tid, Float hikepercent) throws TouristNotFoundException {
		Optional<Tourist> optional3 = repo.findById(tid);
		if (optional3.isPresent()) {
			Tourist tourist = optional3.get();
			tourist.setBudget(tourist.getBudget() + tourist.getBudget() * (hikepercent / 100));
			repo.save(tourist);
			return "Tourist budget is updated";
		} else
			throw new TouristNotFoundException(tid + "Tourist budget not updated");

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String deleteByIdbetween(int start, int end) throws TouristNotFoundException {
		Integer list = repo.deleteByIdRange(start, end);
		if (list.SIZE >= 1) {
			repo.deleteByIdRange(start, end);
			return "deleted successfully";
		} else {
			throw new TouristNotFoundException("list is empty");
		}
	}
}
