package iit.me.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import iit.me.entity.DeanEntity;

@Repository
public interface DeanRepository extends CrudRepository<DeanEntity, Long>{

}
