package org.example;

import org.example.application.ApplicationService;
import org.example.domain.departments.Department;
import org.example.domain.departments.DepartmentRepository;
import org.example.domain.employees.Employee;
import org.example.domain.employees.EmployeeRepository;
import org.example.presentation.Presentation;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class Main{
    public static void main(String[] args){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationService service = (ApplicationService ) applicationContext.getBean(ApplicationService.class);

        // already created with @Repository
        EmployeeRepository employeeRepository = applicationContext.getBean(EmployeeRepository.class);
        DepartmentRepository departmentRepository = applicationContext.getBean(DepartmentRepository.class);

        System.out.println("START");

        Employee employee1 = applicationContext.getBean("employee1", Employee.class);
        Employee employee2 = applicationContext.getBean("employee2", Employee.class);
        Employee employee3 = applicationContext.getBean("employee3", Employee.class);
        Employee employee4 = applicationContext.getBean("employee4", Employee.class);
        Employee employee5 = applicationContext.getBean("employee5", Employee.class);

        employeeRepository.addEmployee(employee1);
        employeeRepository.addEmployee(employee2);
        employeeRepository.addEmployee(employee3);
        employeeRepository.addEmployee(employee4);
        employeeRepository.addEmployee(employee5);

//        Map<Integer, Employee> employees = employeeRepository.getEmployees();
//        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue().getName());
//        }

        Department department1 = applicationContext.getBean("department1", Department.class);
        Department department2 = applicationContext.getBean("department2", Department.class);
        Department department3 = applicationContext.getBean("department3", Department.class);
        Department department4 = applicationContext.getBean("department4", Department.class);
        Department department5 = applicationContext.getBean("department5", Department.class);

        departmentRepository.addDepartment(department1);
        departmentRepository.addDepartment(department2);
        departmentRepository.addDepartment(department3);
        departmentRepository.addDepartment(department4);
        departmentRepository.addDepartment(department5);

//        Map<Integer, Department> departmentMap = departmentRepository.getDepartments();
//        for (Map.Entry<Integer, Department> entry : departmentMap.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue().getName());
//        }

        Presentation presentation = new Presentation(service);
        presentation.start();
    }
}