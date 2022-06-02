package org.example.domain.employees;

import java.util.ArrayList;

public class Employee {
//    private Long id; // primary key
    private String fullName; // full name
    private String address; // Address
    private ArrayList<Integer> departments; // list of departments
    private String dateOfBirth; // date of birth
    private String position; // position

    public Employee(
            String fullName, String address, ArrayList<Integer> departments, String dateOfBirth, String position) {
        this.fullName = fullName;
        this.address = address;
        this.departments = departments;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
    }

//    // get set section
//    public long getId(){return id;}
//    public void setId(Long id){ this.id = id; }

    // name field
    public String getName(){return this.fullName;}
    public void setName(String name){ this.fullName = name; }

    // address field
    public String getAddress(){return this.address;}
    public void setAddress(String address){ this.address = address; }

    // departments field
    public ArrayList<Integer> getDepartments(){return this.departments;}
    public ArrayList<Integer> addDepartment(Integer departmentId){
        this.departments.add(departmentId);
        return getDepartments();
    }
    public ArrayList<Integer> setDepartment(ArrayList<Integer> newDepartments){
        this.departments=newDepartments;
        return getDepartments();
    }
    public ArrayList<Integer> delDepartmentByValue(Integer departmentId) {
        this.departments.remove(departmentId);
        return getDepartments();
    }
    public ArrayList<Integer> delDepartmentByIndex(int index) {
        this.departments.remove(index);
        return getDepartments();
    }

    // dateOfBirth field
    public String getDateOfBirth(){return dateOfBirth;}
    public void setDateOfBirth(String dateOfBirth){ this.dateOfBirth = dateOfBirth; }

    // position field
    public String getPosition(){return position;}
    public void setPosition(String position){ this.position = position; }

}
