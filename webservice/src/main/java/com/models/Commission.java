package com.models;

import javax.persistence.*;

@Entity(name = "Commission")
public class Commission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcommission")
    private int idcommission;

    @Column(name = "commission")
    private float commission;

    public int getIdcommission(){return idcommission;}
    public void setCommission(int idcommission){this.idcommission = idcommission;}

    public float getCommission(){return commission;}
    public  void setCommission(float commission){this.commission = commission;}

    public Commission(){}

    public Commission(int idcommission,float commission){
        this.commission = commission;
        this.idcommission = idcommission;
    }
}
