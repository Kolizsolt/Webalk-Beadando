package iit.me.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import iit.me.entity.RequestEntity;

@Repository
public interface RequestRepository extends CrudRepository<RequestEntity, Long>{
	
	//List<RequestEntity> findByStudentId(long studentId);

}
