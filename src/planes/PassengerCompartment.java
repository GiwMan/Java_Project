package planes;

import planes.PlaneComponent;
import employees.*;


public class PassengerCompartment extends PlaneComponent {
    private PassengerCompartment internalSpace;
    private int comp_i;

    @Override
    public void process(Employee e)
    {
        e.workOn(this);
    }

    @Override
    public void ready_check(int i)
    {
        if(hasInside())
        {
            System.out.println("    Internal Space " + internalSpace.comp_i +" of PC @" + comp_i + " is OK!");
            
            if(internalSpace.hasInside())
                internalSpace.ready_check(comp_i);
            //internalSpace.ready_check(comp_i);
            System.out.println("PC @" + comp_i+ " is OK!");
            return;
        }

        System.out.println("PC @" + comp_i+ " is OK!");
    }

    PassengerCompartment(int id, int n)
    {
        super(id);
        this.comp_i = n;
        System.out.println("A PassengerCompartment just created!");
        
        internalSpace = null;
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
        String s = super.toString() + getClass().getName() + " " + Integer.toString(getId()) +
            " with comp_i = " + Integer.toString(comp_i);

        if(hasInside())
            s = s + "\n Internal Space: " + Integer.toString(internalSpace.comp_i) + " " +  internalSpace.toString();    
        //s = s + "\n Internal Space : " + Integer.toString(internalSpace.getId());
        
        return s;
        //return super.toString() + getClass().getName()+ " : " +  Integer.toString(getId());
    }
    

    public PassengerCompartment getInternalSpace()
    {
        return internalSpace;
    }

    public void setInternalSpace(int id)
    {
        internalSpace = new PassengerCompartment(id,1);
        internalSpace.comp_i = 1;
    }

    public boolean hasInside()
    {
        return internalSpace != null;
    }
}