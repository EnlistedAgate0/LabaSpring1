package org.example.application;

import org.example.domain.departments.Department;
import org.example.domain.employees.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ApplicationService {
//    void removeEntitiesWithSChar(char ch);

    // Employees
    Employee createEmployee(String fullName, String address, ArrayList<Integer> departments, String dateOfBirth, String position);
    Employee getEmployee(int id);
    Map<Integer, Employee> getEmployees();
    Employee editEmployee(int id, String fullName, String address, ArrayList<Integer> departments, String dateOfBirth,
                          String position);
    void removeEmployee(int id);

    // Departments
    Department getDepartment(int id);
    Map<Integer, Department> getDepartments();
    Department editDepartment(int updDepId, String updDepName, ArrayList<String> updDepRooms);
    void removeDepartment(int id);
    Department createDepartment(String name, ArrayList<String> rooms);
}
