package iit.me.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iit.me.entity.RequestEntity;
import iit.me.repository.RequestRepository;
import iit.me.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	RequestRepository requestRepository;

	@Autowired
	public StudentServiceImpl(RequestRepository requestRepository) {
		super();
		this.requestRepository = requestRepository;
	}

	@Override
	public void submitRequest(RequestEntity newRequest) {
		requestRepository.save(newRequest);
	}

	@Override
	public Iterable<RequestEntity> listRequests() {
		return requestRepository.findAll();
	}

}
