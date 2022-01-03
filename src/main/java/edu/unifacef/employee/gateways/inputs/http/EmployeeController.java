package edu.unifacef.employee.gateways.inputs.http;

import edu.unifacef.employee.gateways.inputs.http.requests.CreateEmployeeRequest;
import edu.unifacef.employee.gateways.inputs.http.requests.UpdateEmployeeRequest;
import edu.unifacef.employee.gateways.inputs.http.responses.EmployeeResponse;
import edu.unifacef.employee.gateways.inputs.http.responses.ListResponse;
import edu.unifacef.employee.usecases.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1/employees")
public class EmployeeController {

    private final FindEmployees findEmployees;
    private final CreateEmployee createEmployee;
    private final FindByEmployeeId findByEmployeeId;
    private final DeleteEmployee deleteEmployee;
    private final UpdateEmployee updateEmployee;

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
        return new EmployeeResponse(createEmployee.execute(createEmployeeRequest.toDomain()));
    }

    @GetMapping(path = "/{id}")
    public EmployeeResponse find(@PathVariable final String id) {
        return new EmployeeResponse(findByEmployeeId.execute(id));
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable final String id) {
        deleteEmployee.execute(id);
    }

    @PutMapping(path = "/{id}")
    public EmployeeResponse update(@PathVariable final String id, @RequestBody @Validated final UpdateEmployeeRequest updateEmployeeRequest) {
        return new EmployeeResponse(updateEmployee.execute(updateEmployeeRequest.toDomain(id)));
    }
}
