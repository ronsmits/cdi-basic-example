# Simple CDI example

After the discussion about CDI, the question remained what would happen if a 
bean implements two interfaces and those two interfaces are both injected. 

The code in `src/test/java/org/superbiz/cdi/basic/DoubleInterfaceServiceTest.java`
shows this.

# The test framework
To make this test as simple as possible I am using the `ejbcontainer` from the 
`javax.ejb.embedded` package with **Tomee** as implementation. This way no setup is
needed to make the tests run with the injection.
