package iit.me.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import iit.me.entity.TeacherEntity;

@Repository
public interface TeacherRepository extends CrudRepository<TeacherEntity, Long>{

}
