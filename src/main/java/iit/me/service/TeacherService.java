package iit.me.service;

import org.springframework.stereotype.Service;

import iit.me.entity.RequestEntity;
import iit.me.entity.TeacherEntity;

@Service
public interface TeacherService {
	
	void newTeacher(TeacherEntity newTeacher);
	Iterable<RequestEntity> listRequests();
	void comment(long requestId, String comm);
	void forwardRequest(long requestId);

}
