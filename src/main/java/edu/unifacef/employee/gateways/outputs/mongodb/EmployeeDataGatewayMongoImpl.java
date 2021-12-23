package edu.unifacef.employee.gateways.outputs.mongodb;

import edu.unifacef.employee.domains.Employee;
import edu.unifacef.employee.gateways.outputs.EmployeeDataGateway;
import edu.unifacef.employee.gateways.outputs.mongodb.documents.EmployeeDocument;
import edu.unifacef.employee.gateways.outputs.mongodb.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmployeeDataGatewayMongoImpl implements EmployeeDataGateway {

    private final EmployeeRepository employeeRepository;


    @Override
    public Employee save(final Employee employee) {
        if(Objects.isNull(employee.getCreatedDate())) {
            employee.setCreatedDate(LocalDateTime.now());
        }
        return employeeRepository.save(new EmployeeDocument(employee)).toDomain();
    }

    @Override
    public Optional<Employee> findById(final String id) {
        return employeeRepository.findById(id).map(EmployeeDocument::toDomain);
    }

    @Override
    public Page<Employee> findByPage(final Pageable pageable) {
        return employeeRepository.findAll(pageable).map(EmployeeDocument::toDomain);
    }
}
