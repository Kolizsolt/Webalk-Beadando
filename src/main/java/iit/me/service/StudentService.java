package iit.me.service;

import java.util.List;

import org.springframework.stereotype.Service;

import iit.me.entity.RequestEntity;
import iit.me.entity.StudentEntity;
import iit.me.entity.TemplateEntity;

@Service
public interface StudentService {
	
	void newStudent(StudentEntity newStudent);
	void submitRequest(RequestEntity newRequest);
	Iterable<RequestEntity> listRequests();
	List<RequestEntity> findByStudentId(long studentId);
	Iterable<TemplateEntity> listTemplates();
	TemplateEntity findTemplate(long templateId);

}
