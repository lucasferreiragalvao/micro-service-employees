package edu.unifacef.employee.gateways.outputs.mongodb.repositories;

import edu.unifacef.employee.gateways.outputs.mongodb.documents.EmployeeDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<EmployeeDocument, String> {

}
