package iit.me.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iit.me.entity.RequestEntity;
import iit.me.entity.StudentEntity;
import iit.me.entity.TemplateEntity;
import iit.me.repository.RequestRepository;
import iit.me.repository.StudentRepository;
import iit.me.repository.TemplateRepository;
import iit.me.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	RequestRepository requestRepository;
	TemplateRepository templateRepository;
	StudentRepository studentRepository;

	@Autowired
	public StudentServiceImpl(RequestRepository requestRepository, TemplateRepository templateRepository,
			StudentRepository studentRepository) {
		super();
		this.requestRepository = requestRepository;
		this.templateRepository = templateRepository;
		this.studentRepository = studentRepository;
	}

	
	@Override
	public void newStudent(StudentEntity newStudent) {
		studentRepository.save(newStudent);
	}

	@Override
	public Iterable<StudentEntity> listStudents() {
		return studentRepository.findAll();
	}

	@Override
	public void submitRequest(RequestEntity newRequest) {
		requestRepository.save(newRequest);
	}

	@Override
	public Iterable<RequestEntity> listRequests() {
		return requestRepository.findAll();
	}
	/*
	public List<RequestEntity> findByStudentId(long studentId){
		return requestRepository.findByStudentId(studentId);
	}*/
	
	@Override
	public List<RequestEntity> findByStudentId(long stdtId){
		List<RequestEntity> studentsRequests = new ArrayList<>();
		for(RequestEntity re : requestRepository.findAll()){
			if(re.getOwnerId() == stdtId){
				studentsRequests.add(re);
			}
		}
		return studentsRequests;
	}

	@Override
	public Iterable<TemplateEntity> listTemplates() {
		return templateRepository.findAll();
	}

	@Override
	public TemplateEntity findTemplate(long templateId) {
		return templateRepository.findOne(templateId);
	}

}
