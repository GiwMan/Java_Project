package planes;

import planes.PrivateCompartment;
import employees.Employee;


public class CargoBay extends PrivateCompartment {

    @Override
    public void process(Employee e)
    {
        e.workOn(this);
    }

    @Override
    public void ready_check(int i)
    {
        System.out.println("CB @" + ++i + " is OK!");

        if(hasInside())
            eqArea.ready_check(-1);
    }

    private EquipmentCompartment eqArea;

    public CargoBay(int id) 
    {
        super(id++);
        System.out.println("A CargoBay just created!\n");

        eqArea = new EquipmentCompartment(id);
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
        PlaneComponent temp = (PlaneComponent) x;

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
    

    public EquipmentCompartment getEqArea()
    {
        return eqArea;
    }

    public void setEqArea(EquipmentCompartment eq) 
    {
        eqArea = eq;
    }

    public boolean hasInside()
    {
        return eqArea != null;
    }
}