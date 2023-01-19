package com.service;

import com.models.Commission;
import com.models.Data;
import com.repository.CommissionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CommissionService {

    @Autowired
    CommissionRepository repository;

    public Object getAllCommission(){
        try {
            final List<Commission> CommissionList =new ArrayList<>();
            repository.findAll().forEach(CommissionList1 -> CommissionList.add(CommissionList1) );

            return new Data(CommissionList);
        }catch (Exception e){
            return new Error(e);
        }
    }

    public  Object getCommission(int id){
        try {
            return new Data(repository.findById(id).get());
        }catch (Exception e){
            return  new Error(e);
        }
    }
    public void updateCommission(Commission commission){repository.save(commission);}
}
