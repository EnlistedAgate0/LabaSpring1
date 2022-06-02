package org.example.presentation;

import org.example.application.ApplicationService;
import org.example.domain.departments.Department;
import org.example.domain.employees.Employee;

import java.util.*;

public class Presentation {
    private ApplicationService service;

    public Presentation(ApplicationService service){
        this.service=service;
    }

    public void menu(){
        System.out.println("Select a number action: ");
        System.out.println("0. Exit");
        System.out.println("1. Print all employees");
        System.out.println("2. Create an employee");
        System.out.println("3. Delete an employee by index");
        System.out.println("4. Update employee by index");
        System.out.println("5. Print employee");

        System.out.println("6. Print all departments");
        System.out.println("7. Create an department");
        System.out.println("8. Delete an department by index");
        System.out.println("9. Update department by index");
        System.out.println("10. Print department");
    }

    public void start(){
//        menu();
        Scanner scanner = new Scanner(System.in);

        while (true){
            menu();
            String command = scanner.nextLine();
            switch (command){
                case ("1"):
                    System.out.println("Print all employees:");
                    Map<Integer, Employee> employees = service.getEmployees();
                    for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
                        System.out.println(entry.getKey() + ":" + entry.getValue().getName());
                    }
                    break;
                case ("2"):
                    System.out.println("Create an employee");

                    System.out.println("Enter name");
                    String name = scanner.nextLine();

                    System.out.println("Enter address");
                    String address = scanner.nextLine();

                    ArrayList<Integer> departments = new ArrayList<>();
                    System.out.println("Enter ids of departments separated by a space");
                    String[] ids = scanner.nextLine().split(" ");
                    for (String id : ids) {
                        int intId = Integer.parseInt(id);
                        departments.add(intId);
                        service.getDepartment(intId).incrementCountOfEmployees();
                    }

                    System.out.println("Enter dateOfBirth");
                    String dateOfBirth = scanner.nextLine();

                    System.out.println("Enter position");
                    String position = scanner.nextLine();

                    Employee createdEmp =  service.createEmployee(name, address, departments, dateOfBirth, position);
                    System.out.println("Employee " + createdEmp.getName() + " successfully created");
                    break;
                case ("3"):
                    System.out.println("Enter id of employee");
                    String id = scanner.nextLine();
                    ArrayList<Integer> employeeDeps = service.getEmployee(Integer.parseInt(id)).getDepartments();
                    for (Integer depId: employeeDeps){
                        service.getDepartment(depId).decrementCountOfEmployees();
                    }
                    service.removeEmployee(Integer.parseInt(id));
                    System.out.println("Employee successfully removed");
                    break;
                case ("4"):
                    System.out.println("Enter id of employee");

                    System.out.println("Enter id");
                    String empId = scanner.nextLine();

                    System.out.println("Enter name");
                    String empName = scanner.nextLine();

                    System.out.println("Enter address");
                    String empAddress = scanner.nextLine();

                    ArrayList<Integer> empDepartments = new ArrayList<>();
                    System.out.println("Enter ids of departments separated by a space");
                    String depIds = scanner.nextLine();
                    if (!(Objects.equals(depIds,""))) {
                        for (String depId : depIds.split(" ")) {
                            int intId = Integer.parseInt(depId);
                            empDepartments.add(intId);
                        }
                    }

                    System.out.println("Enter dateOfBirth");
                    String empDateOfBirth = scanner.nextLine();

                    System.out.println("Enter position");
                    String empPosition = scanner.nextLine();

                    service.editEmployee(Integer.parseInt(empId), empName, empAddress, empDepartments, empDateOfBirth, empPosition);

                    break;
                case ("5"):
                    System.out.println("Print Employee info");

                    System.out.println("Enter Employee id");
                    String singleEmpId = scanner.nextLine();

                    Employee employee = service.getEmployee(Integer.parseInt(singleEmpId));
                    System.out.println("Employee name: " + employee.getName());
                    System.out.println("Employee address: " + employee.getAddress());
                    System.out.println("Employee departments id:");
                    ArrayList<Integer> singleEmpDepIds = employee.getDepartments();
                    for (Integer singleEmpDepId: singleEmpDepIds)
                        System.out.println("* Department with id: " + singleEmpDepId);
                    System.out.println("Employee position: " + employee.getPosition());
                    break;
                case ("6"):
                    System.out.println("Print all departments");
                    Map<Integer, Department> departmentMap = service.getDepartments();
                    for (Map.Entry<Integer, Department> entry : departmentMap.entrySet()) {
                        System.out.println(entry.getKey() + ":" + entry.getValue().getName());
                    }
                    break;
                case ("7"):
                    System.out.println("Create an department");

                    System.out.println("Enter name");
                    String depName = scanner.nextLine();

                    System.out.println("Enter names of rooms separated by a space");
                    String[] roomsNames = scanner.nextLine().split(" ");
                    ArrayList<String> rooms = new ArrayList<>(Arrays.asList(roomsNames));

                    Department dep =  service.createDepartment(depName, rooms);
                    System.out.println("Department " + dep.getName() + " successfully created");
                    break;
                case ("8"):
                    System.out.println("Enter id of department");
                    String depId = scanner.nextLine();
                    service.removeDepartment(Integer.parseInt(depId));
                    break;
                case ("9"):
                    System.out.println("Enter id of department");

                    System.out.println("Enter id");
                    String updDepId = scanner.nextLine();

                    System.out.println("Enter name");
                    String updDepName = scanner.nextLine();

                    ArrayList<String> updDepRooms = new ArrayList<>();
                    System.out.println("Enter name of rooms separated by a space");
                    String roomIds = scanner.nextLine();
                    if (!(Objects.equals(roomIds,""))) {
                        updDepRooms.addAll(Arrays.asList(roomIds.split(" ")));
                    }

                    service.editDepartment(Integer.parseInt(updDepId), updDepName, updDepRooms);
                    break;
                case ("10"):
                    System.out.println("Print Department info");

                    System.out.println("Enter Department id");
                    String singleDepId = scanner.nextLine();

                    Department department = service.getDepartment(Integer.parseInt(singleDepId));
                    System.out.println("Department name: " + department.getName());
                    System.out.println("Department count of employees: " + department.getCountOfEmployees());
                    System.out.println("Department rooms: ");
                    ArrayList<String> singleDepRooms = department.getRooms();
                    for (String singleDepRoom: singleDepRooms)
                        System.out.println("* Department room: " + singleDepRoom);
                    break;
            }

            if (command.equals("0")){
                break;
            }
        }
    }
}
