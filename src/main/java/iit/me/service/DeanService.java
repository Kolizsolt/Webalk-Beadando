package iit.me.service;

import org.springframework.stereotype.Service;

import iit.me.entity.DeanEntity;
import iit.me.entity.RequestEntity;
import iit.me.entity.TemplateEntity;

@Service
public interface DeanService {
	
	void newDean(DeanEntity newDean);
	Iterable<RequestEntity> listRequests();
	RequestEntity findRequest(long requestId);
	void acceptVerdict(long requestId);
	void refuseVerdict(long requestId);
	void createTemplate(TemplateEntity newTemplate);

}
