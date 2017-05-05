package iit.me.service;

import org.springframework.stereotype.Service;

import iit.me.entity.RequestEntity;

@Service
public interface TeacherService {
	
	Iterable<RequestEntity> listRequests();
	void comment(long requestId, String comm);
	void forwardRequest(long requestId);

}
