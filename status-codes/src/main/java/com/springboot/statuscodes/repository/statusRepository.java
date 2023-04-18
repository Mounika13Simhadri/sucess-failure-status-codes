package com.springboot.statuscodes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.statuscodes.model.statusModel;

@Repository
public interface statusRepository extends JpaRepository<statusModel,Long> {

}
