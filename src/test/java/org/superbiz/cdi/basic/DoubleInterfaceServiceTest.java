/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.superbiz.cdi.basic;

import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.naming.NamingException;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ronsmits
 */
public class DoubleInterfaceServiceTest {

    private static EJBContainer container;

    @Inject
    private InterfaceOne interfaceOne;
    @Inject
    private InterfaceTwo interfaceTwo;

    @BeforeClass
    public static void createEJBContainer() {
        container = EJBContainer.createEJBContainer();
    }

    @Before
    public void setupTestEnvironment() throws NamingException {
        container.getContext().bind("inject", this);
    }

    @Test
    public void testInjectionsAreDone() {
        Assert.assertNotNull(interfaceOne);
        Assert.assertNotNull(interfaceTwo);
    }

    @Test
    public void testAreTheBeansTheSame() {
        Assert.assertNotEquals("they are the same", interfaceOne, interfaceTwo);
    }

    @Test public void setTitleInBothInterfaces() {
        interfaceOne.setInterfaceOneTitle("interface one");
        interfaceTwo.setInterfaceTwoTitle("interface two");
        assertEquals("interface one", interfaceOne.getInterfaceOneTitle());
        assertEquals("interface two", interfaceTwo.getInterfaceTwoTitle());
        
    }
    @AfterClass
    public static void stopEJBContainer() {
        System.out.println("stopping container");
        container.close();
    }
}
