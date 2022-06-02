package org.example.domain.departments;

import java.util.ArrayList;

public class Department {
//    private Integer id; // primary key
    private String name; // name
    private Integer countOfEmployees = 0; // count of employees
    private ArrayList<String> rooms; // rooms of department

    public Department(String name, ArrayList<String> rooms) {
//        this.id = id;
        this.name = name;
        this.rooms = rooms;
    }



//    // get set section
//    public long getId(){return id;}
//    public void setId(Integer id){ this.id = id; }

    // name field
    public String getName(){return this.name;}
    public void setName(String name){ this.name = name;}

    // countOfEmployees field
//    public void setCountOfEmployees(Integer count){ this.countOfEmployees=count; }
    public Integer getCountOfEmployees(){return this.countOfEmployees; }
    public void incrementCountOfEmployees(){
        this.countOfEmployees++;
    }
    public void decrementCountOfEmployees(){
        this.countOfEmployees++;
    }

    // rooms field
    public ArrayList<String> getRooms(){return this.rooms;}
    public ArrayList<String> addRoom(String room){
        this.rooms.add(room);
        return getRooms();
    }
    public ArrayList<String> setRooms(ArrayList<String> updDepRooms){
        this.rooms=updDepRooms;
        return getRooms();
    }
    public ArrayList<String> delRoomByValue(String name) {
        this.rooms.remove(name);
        return getRooms();
    }
    public ArrayList<String> delRoomByIndex(int index) {
        this.rooms.remove(index);
        return getRooms();
    }
}
