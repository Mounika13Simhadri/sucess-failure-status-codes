package com.springboot.statuscodes.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.springboot.statuscodes.model.statusModel;
import com.springboot.statuscodes.repository.statusRepository;

@Service
public class statusService {

	@Autowired
	private statusRepository statusRepo;
	
	public List<statusModel> getAllStatus(){
		return statusRepo.findAll();
	}
	
	public statusModel getStatus(Long id) {
		return statusRepo.findById(id)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Status not found:"+id));
	}
	public statusModel saveStatus(statusModel status) {
		if(status.getName()==null|| status.getCategory()==null) {
			System.out.println(status.toString());
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request Body missing  :");
		}
		return statusRepo.save(status);
	}
	public void deleteStatus(Long id) {
		 statusModel status=statusRepo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Status not found:"+id));
		 statusRepo.delete(status);
	}
}
