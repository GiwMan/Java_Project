package employees;

import planes.*;

public abstract class Employee implements Cloneable{
    private int eId;
    private String eName;

    public Employee(int id, String name)
    {
        super();
        System.out.println("An Employee just created!");
        this.eId = id;
        this.eName = name;
    }

    public abstract void workOn(PassengerCompartment pc);
    public abstract void workOn(CargoBay cb);
    public abstract void workOn(EquipmentCompartment eq);
    public abstract void workOn(Plane pl);
    public abstract void report();

    //abstract void workOn(Plane);

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object x) {

        if(x == this)
            return true;
        
        if( (x == null) || 
        (x.getClass() != this.getClass() ) )
            return false;
        // Downcast
        Employee temp = (Employee) x;

        if(this.eId == temp.getId())
        {
            if(temp.getName() == this.eName)
                return true;
        }
        return false;
    }

    protected boolean identical(Object x)
    {
        return this == x;
    }

    @Override
    public String toString() 
    {
        return "Object/Employee/" +  getClass().getName();
    }

    public void setId(int id) 
    {
        eId = id;
    }

    public void setName(String name)
    {
        eName = name;
    }

    public int getId()
    {
        return eId;
    }

    public String getName()
    {
        return eName;
    }
}
