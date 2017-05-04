package iit.me.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iit.me.entity.RequestEntity;
import iit.me.repository.RequestRepository;
import iit.me.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	RequestRepository requestRepository;

	@Autowired
	public TeacherServiceImpl(RequestRepository requestRepository) {
		super();
		this.requestRepository = requestRepository;
	}

	@Override
	public Iterable<RequestEntity> listRequests() {
		return requestRepository.findAll();
	}

	
	// comment adattag a requestbe a comment funkcióhoz(metódushoz)
	
	
	// forwarded, accepted adattagok a requestbe, egy lista van
	/*@Override
	public void forwardRequest(RequestEntity frwdableRequest) {
		// TODO Auto-generated method stub

	}*/

}
