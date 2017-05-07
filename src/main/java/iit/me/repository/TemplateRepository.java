package iit.me.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import iit.me.entity.TemplateEntity;

@Repository
public interface TemplateRepository extends CrudRepository<TemplateEntity, Long>{

}
