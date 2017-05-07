package iit.me.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iit.me.entity.DeanEntity;
import iit.me.entity.RequestEntity;
import iit.me.entity.TemplateEntity;
import iit.me.repository.DeanRepository;
import iit.me.repository.RequestRepository;
import iit.me.repository.TemplateRepository;
import iit.me.service.DeanService;

@Service
public class DeanServiceImpl implements DeanService {
	
	RequestRepository requestRepository;
	TemplateRepository templateRepository;
	DeanRepository deanRepository;

	@Autowired
	public DeanServiceImpl(RequestRepository requestRepository, TemplateRepository templateRepository,
			DeanRepository deanRepository) {
		super();
		this.requestRepository = requestRepository;
		this.templateRepository = templateRepository;
		this.deanRepository = deanRepository;
	}
	

	@Override
	public void newDean(DeanEntity newDean) {
		deanRepository.save(newDean);
	}
	
	@Override
	public Iterable<RequestEntity> listRequests() {
		return requestRepository.findAll();
	}

	@Override
	public RequestEntity findRequest(long requestId) {
		return requestRepository.findOne(requestId);
	}

	@Override
	public void acceptVerdict(long requestId) {
		requestRepository.findOne(requestId).setIsAccepted(true);
		requestRepository.save(requestRepository.findOne(requestId));
	}

	@Override
	public void refuseVerdict(long requestId) {
		requestRepository.findOne(requestId).setIsAccepted(false);
		requestRepository.save(requestRepository.findOne(requestId));
	}
	
	@Override
	public void createTemplate(TemplateEntity newTemplate){
		templateRepository.save(newTemplate);
	}

}
