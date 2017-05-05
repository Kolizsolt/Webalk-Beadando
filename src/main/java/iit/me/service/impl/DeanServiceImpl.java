package iit.me.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iit.me.entity.RequestEntity;
import iit.me.repository.RequestRepository;
import iit.me.service.DeanService;

@Service
public class DeanServiceImpl implements DeanService {
	
	RequestRepository requestRepository;

	@Autowired
	public DeanServiceImpl(RequestRepository requestRepository) {
		super();
		this.requestRepository = requestRepository;
	}

	
	@Override
	public Iterable<RequestEntity> listRequests() {
		return requestRepository.findAll();
	}

	@Override
	public void makeVerdict(long requestId) {
		requestRepository.findOne(requestId).setIsAccepted(true);
		requestRepository.save(requestRepository.findOne(requestId));
	}
	
	//void addTemplate(TemplateEntity newTemplate){}

}
