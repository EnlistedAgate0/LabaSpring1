package org.example.domain.employees;


import org.example.domain.departments.DepartmentRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.*;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private Map<Integer,Employee> employees = new HashMap<>();
    static Integer counter = 0;


    @Override
    public Employee getEmployee(int id) {
        return this.employees.get(id);
    }

    @Override
    public Map<Integer, Employee> getEmployees() {
        return this.employees;
    }

    @Override
    public Employee editEmployee(
            int id, String fullName, String address, ArrayList<Integer> departments, String dateOfBirth,
            String position) {
        Employee employee = getEmployee(id);
        if (!(Objects.equals(fullName, "")))
            employee.setName(fullName);
        if (!(Objects.equals(address, "")))
            employee.setAddress(address);
        if (!(departments.size() == 0))
            employee.setDepartment(departments);
        if (!(Objects.equals(dateOfBirth, "")))
            employee.setDateOfBirth(dateOfBirth);
        return employee;
    }


    @Override
    public void removeEmployee(int id) {
        this.employees.remove(id);
    }

    @Override
    public Employee createEmployee(String fullName, String address, ArrayList<Integer> departments, String dateOfBirth, String position) {
        Employee employee = new Employee(fullName, address, departments, dateOfBirth, position);
        this.employees.put(counter, employee);
        counter++;
        return employee;
    }

    @Override
    public void addEmployee(Employee emp) {
        this.employees.put(counter, emp);
        counter++;
    }

    @Override
    public void test(){
        System.out.println("TEST");
    }
}
