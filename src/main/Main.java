package main;

import employees.*;
import planes.*;
import counter.*;

import java.util.ArrayList;

public class Main{

    public static void main(String[] args) throws CloneNotSupportedException
    {
        int capacity = Integer.parseInt(args[0]),
            nRooms = Integer.parseInt(args[1]);
        // Create a counter so that i can manage the number of created Object
        // and their id's
        Counter total_objects = new Counter(); 
        // Create a Plane
        Plane plane = new Plane(total_objects, capacity, nRooms, "Boeing", "454");
        // Create an ArrayList of Employess
        ArrayList<Employee> E = new ArrayList<Employee> (3);
        // Crate a Security
        total_objects.increment();
        E.add(new SecurityEmployee(total_objects.getCounter(),"Giwrgos"));
        // Create a MaintainEmployee
        total_objects.increment();
        E.add(new MaintenanceEmployee(total_objects.getCounter(),"Jim"));
        // Create a Cleaner
        total_objects.increment();
        E.add(new CleaningEmployee(total_objects.getCounter(),"Giannis"));

        // Let them do their job
        plane.process(E);
    }
}