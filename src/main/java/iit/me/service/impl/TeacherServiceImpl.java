package iit.me.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iit.me.entity.RequestEntity;
import iit.me.entity.TeacherEntity;
import iit.me.repository.RequestRepository;
import iit.me.repository.TeacherRepository;
import iit.me.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	RequestRepository requestRepository;
	TeacherRepository teacherRepository;

	@Autowired
	public TeacherServiceImpl(RequestRepository requestRepository, TeacherRepository teacherRepository) {
		super();
		this.requestRepository = requestRepository;
		this.teacherRepository = teacherRepository;
	}

	
	@Override
	public void newTeacher(TeacherEntity newTeacher) {
		teacherRepository.save(newTeacher);
	}

	@Override
	public Iterable<TeacherEntity> listTeachers() {
		return teacherRepository.findAll();
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
