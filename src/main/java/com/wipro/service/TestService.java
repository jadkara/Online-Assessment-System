package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.model.Test;
import com.wipro.repository.TestRepository;

@Service
public class TestService {
	
	@Autowired
	private TestRepository testRepository;
	
	public List<Test> getAllTest()
	{
		return testRepository.findAll();
	}
	
	public void addTest(Test test)
	{
		testRepository.save(test);
	}

}
