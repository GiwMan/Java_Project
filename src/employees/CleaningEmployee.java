package employees;

import employees.Employee;
import planes.*;


public class CleaningEmployee extends Employee{
    public CleaningEmployee(int id, String name)
    {
        super(id, name);
        System.out.println("A Cleaner just created!\n");
    }

    @Override
    public void workOn(PassengerCompartment pc)
    {
        System.out.println("Cleaner cleans PassengerComaprtment!");

        if(pc.hasInside())
            System.out.println("    Cleaner checks internal space!");
    }

    @Override
    public void workOn(CargoBay cb) {
        System.out.println("Cleaner cleans CargoBay!");

        if(cb.hasInside())
            System.out.println("Cleaner cleans EquipmentCompartment of CargoBay!");
    }

    @Override
    public void workOn(EquipmentCompartment eq) {
        
    }

    @Override
    public void workOn(Plane plane) {
        // work in Cargo
        workOn(plane.getCargo());
        //work in Passengers area
        for(int j = 0; j < plane.getRooms(); j++)
            workOn(plane.getPassCompartment(j));
    }

    @Override
    public void report() 
    {
        System.out.println("Plane processed for " + getName() +
        "\nCleaning Report: Everything OK!\n");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o)
    {
        return super.equals(o);
    }

    @Override
    public String toString()
    {
        return super.toString() + " : " +  Integer.toString(getId()) + 
        " " + getName();
    }

}