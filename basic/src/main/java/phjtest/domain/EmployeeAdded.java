package phjtest.domain;

import java.util.*;
import lombok.*;
import phjtest.domain.*;
import phjtest.infra.AbstractEvent;

@Data
@ToString
public class EmployeeAdded extends AbstractEvent {

    private Long id;
    private String userId;
    private RankId rankId;
    private DepartmentId departmentId;

    public EmployeeAdded(Employee aggregate) {
        super(aggregate);
    }

    public EmployeeAdded() {
        super();
    }
}
