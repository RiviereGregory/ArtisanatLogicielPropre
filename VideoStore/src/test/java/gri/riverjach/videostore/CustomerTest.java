package gri.riverjach.videostore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() throws Exception {
        customer = new Customer();
    }

    private void assertFeeAndPoints(double fee, int point) {
        assertEquals(fee, customer.getRentalFee(), 0.001);
        assertEquals(point, customer.getRenterPoints());
    }

    @Test
    void regularMovie_OneDay() throws Exception {
        customer.addRental("RegularMovie", 1);
        assertFeeAndPoints(1.5, 1);
    }

}
