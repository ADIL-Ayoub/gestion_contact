package com.ensah.core.services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class TempService {

    public TempService(){
        System.out.println("constructor of TempSrvice");
    }

    @PostConstruct
    public void after(){
        System.out.println("after construct");
    }

    @PreDestroy
    public void before(){
        System.out.println("before destroy");
    }
}
