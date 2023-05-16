package phjtest.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import phjtest.BasicApplication;
import phjtest.domain.EmployeeAdded;

@Entity
@Table(name = "Employee_table")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;

    @Embedded
    private RankId rankId;

    @Embedded
    private DepartmentId departmentId;

    @ElementCollection
    private List<EmployeeUser> employeeUser;

    @PostPersist
    public void onPostPersist() {
        EmployeeAdded employeeAdded = new EmployeeAdded(this);
        employeeAdded.publishAfterCommit();
    }

    public static EmployeeRepository repository() {
        EmployeeRepository employeeRepository = applicationContext()
            .getBean(EmployeeRepository.class);
        return employeeRepository;
    }

    public static ApplicationContext applicationContext() {
        return BasicApplication.applicationContext;
    }
}
