package gri.riverjach.videostore;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {

    @Test
    public void regularMovie_OneDay() throws Exception{
        Customer customer = new Customer();
        customer.addRental("RegularMovie",1);
        assertEquals(1.5, customer.getRentalFee(), 0.001);
        assertEquals(1,customer.getRenterPoints());

    }

}
