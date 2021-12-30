package edu.unifacef.employee.gateways.inputs.http;

import edu.unifacef.employee.gateways.inputs.http.requests.CreateEmployeeRequest;
import edu.unifacef.employee.gateways.inputs.http.responses.EmployeeResponse;
import edu.unifacef.employee.gateways.inputs.http.responses.ListResponse;
import edu.unifacef.employee.usecases.CreateEmployee;
import edu.unifacef.employee.usecases.DeleteEmployee;
import edu.unifacef.employee.usecases.FindByEmployeeId;
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
    private final FindByEmployeeId findByEmployeeId;
    private final DeleteEmployee deleteEmployee;

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
}
