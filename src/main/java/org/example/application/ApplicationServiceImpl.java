package org.example.application;

import org.example.domain.departments.Department;
import org.example.domain.departments.DepartmentRepository;
import org.example.domain.employees.Employee;
import org.example.domain.employees.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ApplicationServiceImpl implements ApplicationService{
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;


    @Override
    public Employee createEmployee(String fullName, String address, ArrayList<Integer> departments, String dateOfBirth, String position) {
        return this.employeeRepository.createEmployee(
                fullName,
                address,
                departments,
                dateOfBirth,
                position
        );
    }

    @Override
    public Employee getEmployee(int id) {
        return this.employeeRepository.getEmployee(id);
    }

    @Override
    public Map<Integer, Employee> getEmployees() {
        return this.employeeRepository.getEmployees();
    }

    @Override
    public Employee editEmployee(int id, String fullName, String address, ArrayList<Integer> departments, String dateOfBirth,
                                 String position) {
        return this.employeeRepository.editEmployee(id, fullName, address, departments, dateOfBirth, position);
    }

    @Override
    public void removeEmployee(int id) {
        this.employeeRepository.removeEmployee(id);
    }

    @Override
    public Department getDepartment(int id) {
        return this.departmentRepository.getDepartment(id);
    }

    @Override
    public Map<Integer, Department> getDepartments(){
        return this.departmentRepository.getDepartments();
    }

    @Override
    public Department editDepartment(int updDepId, String updDepName, ArrayList<String> updDepRooms) {
        return this.departmentRepository.editDepartment(updDepId, updDepName, updDepRooms);
    }

    @Override
    public void removeDepartment(int id) {
        this.departmentRepository.removeDepartment(id);
    }

    @Override
    public Department createDepartment(String name, ArrayList<String> rooms) {
        return this.departmentRepository.createDepartment(name, rooms);
    }

//    @Override
//    public void removeEntitiesWithSChar(char ch){
//        List<Employee> list = repository.getEmployees();
//        if (list == null) {
//            System.out.println("LIST IS NULL");
//            return;
//        }
//        for(Employee employee : list){
//            if( employee.getName().charAt(0)==ch )
//                repository.removeEmployee(1);
//        }
//    }
}

