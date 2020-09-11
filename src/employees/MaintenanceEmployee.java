package employees;

import employees.Employee;
import planes.*;


public class MaintenanceEmployee extends Employee{
    public MaintenanceEmployee(int id, String name)
    {
        super(id, name);
        System.out.println("A Maintainter just created!\n");
    }

    @Override
    public void workOn(PassengerCompartment pc)
    {

    }

    @Override
    public void workOn(CargoBay cb) {
        System.out.println("Maintaner checks CargoBay!");

        if(cb.hasInside())
            System.out.println("Maintainter checks EquipmentCompartment of CargoBay!");
    }

    @Override
    public void workOn(EquipmentCompartment eq) {
        System.out.println("Maintaner checks EquipmentCompartment!");
    }

    @Override
    public void workOn(Plane plane) {
        // work in Cargo
        workOn(plane.getCargo());
        // work in Equipment
        for(int i = 0; i < 3; i++)
            workOn(plane.getEqCompartment(i));
        //work in Passengers area
    }

    @Override
    public void report() 
    {
        System.out.println("Plane processed for " + getName() +
        "\nMaintenance Report: Everything OK!\n");
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