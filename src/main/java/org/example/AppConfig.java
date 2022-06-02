package org.example;

import org.example.domain.departments.Department;
import org.example.domain.departments.DepartmentRepositoryImpl;
import org.example.domain.employees.Employee;
import org.example.domain.employees.EmployeeRepository;
import org.example.domain.employees.EmployeeRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan("org.example")
public class AppConfig {

//   Example how to register external beans like TransactionManager or SessionFactory etc.
//   @Bean
//   public HelloWorld helloWorld(){
//      return new HelloWorld();
//   }

    @Bean(name = "employee1")
    public Employee employee1(){
        return new Employee(
                "Name1",
                "Address",
                new ArrayList<>(Arrays.asList(1, 2, 3)),
                "Date",
                "Position");
    }

    @Bean(name = "employee2")
    public Employee employee2(){
        return new Employee(
                "Name2",
                "Address",
                new ArrayList<>(Arrays.asList(2, 3, 4)),
                "Date",
                "Position");
    }

    @Bean(name = "employee3")
    public Employee employee3(){
        return new Employee(
                "Name3",
                "Address",
                new ArrayList<>(Arrays.asList(2, 3, 5)),
                "Date",
                "Position");
    }

    @Bean(name = "employee4")
    public Employee employee4(){
        return new Employee(
                "Name4",
                "Address",
                new ArrayList<>(List.of(3)),
                "Date",
                "Position");
    }

    @Bean(name = "employee5")
    public Employee employee5(){
        return new Employee(
                "Name5",
                "Address",
                new ArrayList<>(List.of()),
                "Date",
                "Position");
    }


    @Bean(name = "department1")
    public Department department1(){
        return new Department(
                "DepName1",
                new ArrayList<>(Arrays.asList("1", "2", "3"))
        );
    }

    @Bean(name = "department2")
    public Department department2(){
        return new Department(
                "DepName2",
                new ArrayList<>(Arrays.asList("2", "3", "4"))
        );
    }

    @Bean(name = "department3")
    public Department department3(){
        return new Department(
                "DepName3",
                new ArrayList<>(Arrays.asList("4", "5", "6"))
        );
    }

    @Bean(name = "department4")
    public Department department4(){
        return new Department(
                "DepName4",
                new ArrayList<>(Arrays.asList("1", "3", "6"))
        );
    }

    @Bean(name = "department5")
    public Department department5(){
        return new Department(
                "DepName5",
                new ArrayList<>(Arrays.asList("2", "4", "5"))
        );
    }

//    @Bean
//    public EmployeeRepository employeeRepository(){
//        return new EmployeeRepositoryImpl();
//    }
}

