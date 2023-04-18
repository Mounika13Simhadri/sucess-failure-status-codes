package com.springboot.statuscodes.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.springboot.statuscodes.model.errorResponseBody;
import com.springboot.statuscodes.model.metadata;
import com.springboot.statuscodes.model.statusModel;
import com.springboot.statuscodes.service.TimeStamp;
import com.springboot.statuscodes.service.statusService;

@RestController
@RequestMapping("/status")
public class statusController {
	
	@Autowired
	statusService stService;
	@Autowired
	TimeStamp timeStamp;
	
	@GetMapping
	public ResponseEntity<Object> statusList(){
		List<statusModel> statusData= stService.getAllStatus();
		metadata metaData=new metadata(200,"Successful",null);
		Map<String,Object> response=new HashMap<String, Object>();
		response.put("body",statusData);
		response.put("metadata",metaData);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> status(@PathVariable Long id){
		try {
			System.out.println(timeStamp);
			statusModel status=stService.getStatus( id);
			metadata metadata=new metadata(200,"success",null);
			Map<String,Object> response=new HashMap<String, Object>();		
			response.put("body", status);
			response.put("metadata", metadata);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		catch(ResponseStatusException ex) {		
			errorResponseBody erResp= new errorResponseBody(timeStamp.timeStamp, ex.getStatusCode().value(),ex.getStatusCode(), ex.getReason(),"/status/"+id);
			return new ResponseEntity<> (erResp,ex.getStatusCode());
		}
		catch (Exception ex) {
	        metadata metadata = new metadata(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null);
			Map<String,Object> response=new HashMap<String, Object>();
			response.put("metadata", metadata);
			response.put("Error",ex.getLocalizedMessage() );
	        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	    }	
	}
	
	@PostMapping
	public ResponseEntity<Object> storeStatus(@RequestBody statusModel status)
	{
	   try {
		    statusModel st=stService.saveStatus(status);
			metadata metadata=new metadata(201,"success",null);
			Map<String,Object> response=new HashMap<String, Object>();
			response.put("body", st);
			response.put("metadata", metadata);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}
	   catch(ResponseStatusException ex) {
			errorResponseBody errorResponseBody= new errorResponseBody(timeStamp.timeStamp, ex.getStatusCode().value(),ex.getStatusCode(), ex.getReason(),"/status");
			return new ResponseEntity<> (errorResponseBody,ex.getStatusCode()); 
	  }
	   catch (Exception ex) {
	        metadata metadata = new metadata(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null);
			Map<String,Object> response=new HashMap<String, Object>();
			response.put("metadata", metadata);
			response.put("Error",ex.getLocalizedMessage() );
	        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> removeStatus(@PathVariable Long id) {
		try {
		stService.deleteStatus(id);
		metadata metadata=new metadata(204,"success",null);
		Map<String,Object> response=new HashMap<String, Object>();
		response.put("body","[]");
		response.put("metadata", metadata);
		return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
		}
		catch(ResponseStatusException ex) {		
			errorResponseBody errorResponseBody= new errorResponseBody(timeStamp.timeStamp, ex.getStatusCode().value(),ex.getStatusCode(), ex.getReason(),"/status/"+id);
			return new ResponseEntity<> (errorResponseBody,ex.getStatusCode());
		}
		catch (Exception ex) {
	        metadata metadata = new metadata(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage(), null);
			Map<String,Object> response=new HashMap<String, Object>();
			response.put("metadata", metadata);
			response.put("Error",ex.getLocalizedMessage() );
	        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
