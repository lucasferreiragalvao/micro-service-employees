package edu.unifacef.employee.gateways.outputs.mongodb.repositories;

import edu.unifacef.employee.gateways.outputs.mongodb.documents.EmployeeDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<EmployeeDocument, String> {
    Optional<EmployeeDocument> findByCpf(String cpf);
}
