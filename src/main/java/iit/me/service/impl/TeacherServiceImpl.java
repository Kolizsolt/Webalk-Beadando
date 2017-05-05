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

	@Override
	public void comment(long requestId, String comm){
		requestRepository.findOne(requestId).setComment(comm);
		requestRepository.save(requestRepository.findOne(requestId));
	}
	
	@Override
	public void forwardRequest(long requestId) {
		requestRepository.findOne(requestId).setIsForwarded(true);
		requestRepository.save(requestRepository.findOne(requestId));
	}

}
