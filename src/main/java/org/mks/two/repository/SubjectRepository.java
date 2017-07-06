package org.mks.two.repository;

import org.mks.two.entities.SubjectEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SubjectRepository extends CrudRepository<SubjectEntity, Long> {

}
