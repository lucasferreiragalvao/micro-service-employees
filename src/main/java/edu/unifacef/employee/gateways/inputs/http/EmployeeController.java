package edu.unifacef.employee.gateways.inputs.http;

import edu.unifacef.employee.domains.Employee;
import edu.unifacef.employee.gateways.inputs.http.requests.CreateEmployeeRequest;
import edu.unifacef.employee.gateways.inputs.http.responses.EmployeeResponse;
import edu.unifacef.employee.gateways.inputs.http.responses.ListResponse;
import edu.unifacef.employee.usecases.CreateEmployee;
import edu.unifacef.employee.usecases.FindEmployees;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/employees")
public class EmployeeController {

    private final FindEmployees findEmployees;
    private final CreateEmployee createEmployee;

    @GetMapping
    public ListResponse<EmployeeResponse> findByPage(@RequestParam(defaultValue = "0") final Integer page,
                                                     @RequestParam(defaultValue = "50") final Integer size) {

        Page<EmployeeResponse> employeePage =
                findEmployees.execute(PageRequest.of(page, size))
                .map(EmployeeResponse::new);

        return new ListResponse<>(employeePage);
    }

    @PostMapping
    public EmployeeResponse create(@RequestBody @Validated final CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = createEmployee.execute(createEmployeeRequest.toDomain());
        return new EmployeeResponse(employee);
    }
}
