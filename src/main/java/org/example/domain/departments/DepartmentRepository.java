package org.example.domain.departments;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface DepartmentRepository {
    Department getDepartment(int id);
    Map<Integer, Department> getDepartments();
    Department editDepartment(int id, String name, ArrayList<String> updDepRooms);
    void removeDepartment(int id);
    Department createDepartment(String name, ArrayList<String> rooms);
    void addDepartment(Department dep);
}

