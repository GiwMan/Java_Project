package planes;

import planes.PrivateCompartment;
import employees.Employee;


public class EquipmentCompartment extends PrivateCompartment {

    @Override
    public void process(Employee e)
    {
        e.workOn(this);
    }

    @Override
    public void ready_check(int i)
    {
        if(i != -1)
            System.out.println("EComp @" + ++i + " is OK!");
        else
            System.out.println("    EComp of CB is OK!");
    }

    public EquipmentCompartment(int id) 
    {
        super(id);
        System.out.println("An EquipmentCompartment just created!");
    }

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
        PrivateCompartment temp = (PrivateCompartment) x;

        if(this.getId() == temp.getId())
        {
            return true;
        }
        return false;
    }

    public boolean identical(Object x) {
        return x == this;
    }

    @Override
    public String toString()
    {
        return super.toString() + " : " +  Integer.toString(getId());
    }
    
}