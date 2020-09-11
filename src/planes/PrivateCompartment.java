package planes;

import employees.*;

public abstract class PrivateCompartment extends PlaneComponent {

    abstract void process(Employee e);
    abstract void ready_check(int i);
    
    public PrivateCompartment(int prId)
    {
        super(prId);
        System.out.print("A PrivateCompartment just created!\n");
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
        return super.toString() + "PrivateCompartment/" 
            + getClass().getName();
    }
    
}