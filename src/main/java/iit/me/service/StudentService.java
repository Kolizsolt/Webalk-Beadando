package iit.me.service;

import org.springframework.stereotype.Service;

import iit.me.entity.RequestEntity;

@Service
public interface StudentService {
	
	void submitRequest(RequestEntity newRequest);
	Iterable<RequestEntity> listRequests();

}
