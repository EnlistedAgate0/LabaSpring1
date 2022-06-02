package org.example.domain.departments;

import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.*;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository{
    private Map<Integer, Department> departments = new HashMap<>();
    static Integer counter = 0;

    @Override
    public Department getDepartment(int id) {
        return this.departments.get(id);
    }

    @Override
    public Map<Integer, Department> getDepartments() {
        return this.departments;
    }

    @Override
    public Department editDepartment(int id, String name, ArrayList<String> updDepRooms) {
        Department department = getDepartment(id);
        if (!(Objects.equals(name, "")))
            department.setName(name);
        if (!(updDepRooms.size() == 0))
            department.setRooms(updDepRooms);
        return department;
    }

    @Override
    public void removeDepartment(int id) {
        this.departments.remove(id);
    }

    @Override
    public Department createDepartment(String name, ArrayList<String> rooms) {
        Department department = new Department(name, rooms);
        this.departments.put(counter, department);
        counter++;
        return department;
    }

    @Override
    public void addDepartment(Department dep) {
        this.departments.put(counter, dep);
        counter++;
    }
}

