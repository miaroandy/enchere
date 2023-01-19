package com.controller;

import com.models.Commission;
import com.service.CommissionService;

import javax.xml.ws.RequestWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public class CommissionController {

    @Autowired
    CommissionService commissionService;

    @GetMapping
    private Object getAllCommission(){return commissionService.getAllCommission();}

    @GetMapping("/idcommisssion")
    private Object getAllCommission(@PathVariable("idcommission") int idcommission ){
        return commissionService.getCommission(idcommission);
    }

    @GetMapping
    private void updateCommission(@RequestBody Commission commission){
        commissionService.updateCommission(commission);
    }
}
