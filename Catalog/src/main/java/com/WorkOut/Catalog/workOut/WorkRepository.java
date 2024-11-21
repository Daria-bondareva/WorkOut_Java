package com.WorkOut.Catalog.workOut;

import com.WorkOut.Catalog.workOut.WorkOut;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends MongoRepository<WorkOut, String> {

}
