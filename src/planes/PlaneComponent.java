package planes;

import employees.*;

public abstract class PlaneComponent implements Cloneable{
    private int compId;

    abstract void process(Employee e);
    abstract void ready_check(int i);

    public PlaneComponent(int id)
    {
        super();
        this.compId = id;
        System.out.println("A PlaneComponent just created!");
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

        if(this.compId == temp.getId())
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
       return "Object/PlaneComponent/"; //+ getClass().getName();
    }
    

    public void setId(int id)
    {
        compId = id;
    }

    public int getId()
    {
        return compId;
    }

}
