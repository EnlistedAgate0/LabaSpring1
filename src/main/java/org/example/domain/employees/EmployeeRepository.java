package org.example.domain.employees;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface EmployeeRepository {
    Employee getEmployee(int id);
    Map<Integer, Employee> getEmployees();
    Employee editEmployee(int id, String fullName, String address, ArrayList<Integer> departments, String dateOfBirth,
                          String position);
    void removeEmployee(int id);
    Employee createEmployee(String fullName, String address, ArrayList<Integer> departments, String dateOfBirth, String position);
    void addEmployee(Employee emp);

    void test();
}

