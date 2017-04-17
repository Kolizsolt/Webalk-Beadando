package iit.me.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import iit.me.entity.RequestEntity;

@Repository
public interface RequestRepository extends CrudRepository<RequestEntity, Long>{

}
