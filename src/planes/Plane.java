package planes;

import java.util.ArrayList;

import employees.*;
import counter.*;

public class Plane {
    private int planeId;
    private int plCapacity,
                plRooms;
    private String plTitle, 
                    plDesc;
    private CargoBay plCb;
    private ArrayList<EquipmentCompartment> plEq;
    private ArrayList<PassengerCompartment> plPc;

    public Plane(Counter counter, int capacity, 
    int rooms, String title, String desc)
    {   // An object is created
        counter.increment();

        this.planeId = counter.getCounter();
        this.plCapacity = capacity;
        this.plRooms = rooms;
        this.plTitle = title;
        this.plDesc = desc;
        // Cargo is created
        counter.increment();

        plCb = new CargoBay(counter.getCounter());

        plEq = new ArrayList<EquipmentCompartment>(3);
        for(int i = 0; i < 3; i++)
        {
            counter.increment();
            plEq.add(new EquipmentCompartment(counter.getCounter()));
        }

        plPc = new ArrayList<PassengerCompartment>(plRooms);
        for(int j = 0; j < plRooms; j++)
        {
            counter.increment();
            plPc.add(new PassengerCompartment(counter.getCounter(),j+1));

            if(Math.round(Math.random()) == 1)
            {
                counter.increment();
                plPc.get(j).setInternalSpace(counter.getCounter());
            }
        }

        System.out.println("A plane just created!");

    }
    
    public Plane(int id, int capacity, int rooms,
        String title, String desc) 
    {
        this.planeId = id;
        this.plCapacity = capacity;
        this.plRooms = rooms;
        this.plTitle = title;
        this.plDesc = desc;

        plCb = new CargoBay(++id);

        plEq = new ArrayList<EquipmentCompartment>(3);
        for(int i = 0; i < 3; i++)
            plEq.add(new EquipmentCompartment(++id));

        plPc = new ArrayList<PassengerCompartment>(plRooms);
        for(int j = 0; j < plRooms; j++)
        {
            plPc.add(new PassengerCompartment(++id,j+1));

            if(Math.round(Math.random()) == 1)
                plPc.get(j).setInternalSpace(++id);
        }

        System.out.println("A plane just created!");
    }
    @Override
    public String toString()
    {
        //return 
        String s = "\nObject/" + getClass().getName() + " :\n" +
        "planeId = " + Integer.toString(planeId) +"\n" + "plTitle = " + plTitle 
        + "\n"+ "plDesc = " + plDesc + "\n" + plCb.toString() + "\n";

        for(int i = 0; i < 3; i++)
        {
            s = s + plEq.get(i).toString() + "\n";
        }

        for(int j =0; j < plRooms; j++)
        {
            s = s + plPc.get(j).toString() + "\n";
        }

        return s;
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
        Plane temp = (Plane) x;

        if(this.planeId == temp.getId())
        {
            if(temp.getCapacity() == this.plCapacity)
            {
                if(this.plRooms == temp.getRooms())
                {
                    if(this.getTitle() == temp.getTitle())
                    {
                        if(this.getDesc() == temp.getDesc())
                        {
                            for(int i = 0; i < 3; i++)
                            {
                                if(this.plEq.get(i).equals(temp.getEqCompartment(i)))
                                {

                                }else // different equipment area
                                    return false;
                            }

                            for(int j = 0; j < this.plRooms; j++)
                            {
                                if(this.plPc.get(j).equals(temp.getPassCompartment(j)))
                                {

                                }else
                                    return false;
                            }
                            if(this.getCargo().equals(temp.getCargo()))
                                return true;
                            else
                                return false;
                        }
                    }
                }
            }
                return true;
        }
        return false;
    }

    protected boolean identical(Object x)
    {
        return this == x;
    }

    // Getters
    public int getId() 
    {
        return planeId;
    }

    public int getCapacity() 
    {
        return plCapacity;
    }

    public int getRooms()
    {
        return plRooms;
    }

    public String getTitle()
    {
        return plTitle;
    }

    public String getDesc()
    {
        return plDesc;
    }

    public EquipmentCompartment getEqCompartment(int i)
    {
        return plEq.get(i);
    }

    public PassengerCompartment getPassCompartment(int i)
    {
        return plPc.get(i);
    }

    public CargoBay getCargo()
    {
        return plCb;
    }

    // Setters
    public void setId(int id)
    {
        planeId = id;
    }

    public void setCapacity(int cap)
    {
        plCapacity = cap;
    }

    public void setRooms(int n)
    {
        plRooms = n;
    }

    public void setTitle(String title)
    {
        plTitle = title;
    }

    public void setDesc(String desc)
    {
        plDesc = desc;
    }

    public void setCargo(CargoBay cb)
    {
        plCb = cb;
    }

    // process
    public void process(Employee e) {
        e.workOn(this);

/*
        plCb.ready_check(0);
        // Equipment Ready
        for(int i = 0; i < 3; i++)
            plEq.get(i).ready_check(i);
        // Passengers area
        for(int j = 0; j < plRooms; j++)
            plPc.get(j).ready_check(j);

        e.report();

        System.out.println("Plane ready to take off!");*/
    }

    public void process(ArrayList<Employee> e)
    {   // Security
        process(e.get(0));
        e.get(0).report();
        // MaintenanceEmployee
        process(e.get(1));
        e.get(1).report();
        // Cleaner
        process(e.get(2));
        e.get(2).report();
        // Cargo Ready
        plCb.ready_check(0);
        // Equipment Ready
        for(int i = 0; i < 3; i++)
            plEq.get(i).ready_check(i);
        // Passengers area
        for(int j = 0; j < plRooms; j++)
            plPc.get(j).ready_check(j);

        System.out.println("Plane ready to take off!");
    }
}