package phjtest.domain;

import java.util.*;
import lombok.*;
import phjtest.domain.*;
import phjtest.infra.AbstractEvent;

@Data
@ToString
public class DepartmentAdded extends AbstractEvent {

    private Long id;
    private String name;

    public DepartmentAdded(Department aggregate) {
        super(aggregate);
    }

    public DepartmentAdded() {
        super();
    }
}
