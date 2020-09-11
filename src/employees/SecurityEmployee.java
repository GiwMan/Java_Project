package employees;

import employees.Employee;
import planes.*;



public class SecurityEmployee extends Employee{
    public SecurityEmployee(int id, String name)
    {
        super(id, name);
        System.out.println("A Security just created!\n");
    }

    @Override
    public void workOn(PassengerCompartment pc)
    {
        System.out.println("Security checks PassengerComaprtment!");

        if(pc.hasInside())
            System.out.println("    Security checks internal space!");
    }

    @Override
    public void workOn(CargoBay cb) {
        System.out.println("Security checks CargoBay!");

        if(cb.hasInside())
            System.out.println("Security checks EquipmentCompartment of CargoBay!");
    }

    @Override
    public void workOn(EquipmentCompartment eq) {
        System.out.println("Security checks EquipmentCompartment!");
    }

    @Override
    public void workOn(Plane plane) {
        // work in Cargo
        workOn(plane.getCargo());
        // work in Equipment
        for(int i = 0; i < 3; i++)
            workOn(plane.getEqCompartment(i));
        //work in Passengers area
        for(int j = 0; j < plane.getRooms(); j++)
            workOn(plane.getPassCompartment(j));
    }

    @Override
    public void report() 
    {
        System.out.println("Plane processed for " + getName() +
        "\nSecurity Report: Everything OK!\n");
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
