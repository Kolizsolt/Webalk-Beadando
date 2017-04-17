package iit.me.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import iit.me.entity.StudentEntity;

@Repository
public interface StudentRepository extends CrudRepository<StudentEntity, Long>{

}
