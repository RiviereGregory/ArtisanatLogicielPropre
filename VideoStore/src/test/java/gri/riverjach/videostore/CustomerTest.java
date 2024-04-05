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

    /**
     * Exigence 1 :
     * Les films normaux sont loués 1,5 $ le premier jour et
     * vous collectez un point de fidelité par jour de location
     *
     * @throws Exception
     */
    @Test
    void regularMovie_OneDay() throws Exception {
        customer.addRental("RegularMovie", 1);
        assertFeeAndPoints(1.5, 1);
    }

    /**
     * Exigence 2:
     * Les deuxièmes et troisième jours de location ordinaire
     * sont gratuits, mais ne donnent pas droit à aucun point
     *
     * @throws Exception
     */
    @Test
    void regularMovie_SecondAndThirdDayFree() throws Exception {
        customer.addRental("RegularMovie", 2);
        assertFeeAndPoints(1.5, 1);
        customer.addRental("RegularMovie", 3);
        assertFeeAndPoints(1.5, 1);

    }

    /**
     * Exigence 3:
     * Tous les jours à compter du quatrième, le coût journalier revient
     * à 1,5 $ avec un gain de 1 point de fidélité
     *
     * @throws Exception
     */
    @Test
    void regularMovie_FourDays() throws Exception {
        customer.addRental("RegularMovie", 4);
        assertFeeAndPoints(3.0, 2);
    }

}
