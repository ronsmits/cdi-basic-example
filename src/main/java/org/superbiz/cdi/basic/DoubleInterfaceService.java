/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.superbiz.cdi.basic;

import javax.annotation.PostConstruct;

/**
 *
 * @author ronsmits
 */
public class DoubleInterfaceService implements InterfaceOne, InterfaceTwo {

    private String title;
    
    @PostConstruct
    public void init() {
        System.out.println("PostConstruct called for " + this.getClass().getCanonicalName());
    }

    @Override
    public void setInterfaceOneTitle(String title) {
        this.title = title;
    }

    @Override
    public String getInterfaceOneTitle() {
        return title;
    }

    @Override
    public void setInterfaceTwoTitle(String title) {
        this.title = title;
    }

    @Override
    public String getInterfaceTwoTitle() {
        return title;
    }
}
