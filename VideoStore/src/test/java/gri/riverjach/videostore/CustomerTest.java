package gri.riverjach.videostore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static gri.riverjach.videostore.VideoRegistry.addMovie;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
    }

    @BeforeEach
    void loadRegistry() {
        addMovie("RegularMovie", VideoType.REGULAR);
        addMovie("ChildrenMovie", VideoType.CHILDREN);
    }

    private void assertFeeAndPoints(double fee, int point) {
        assertEquals(fee, customer.getRentalFee(), 0.001);
        assertEquals(point, customer.getRenterPoints());
    }

    /**
     * Exigence 1 :
     * Les films normaux sont loués 1,5 $ le premier jour et
     * vous collectez un point de fidelité par jour de location
     */
    @Test
    void regularMovie_OneDay() {
        customer.addRental("RegularMovie", 1);
        assertFeeAndPoints(150, 1);
    }

    /**
     * Exigence 2:
     * Les deuxièmes et troisième jours de location ordinaire
     * sont gratuits, mais ne donnent pas droit à aucun point
     */
    @Test
    void regularMovie_SecondAndThirdDayFree() {
        customer.addRental("RegularMovie", 2);
        assertFeeAndPoints(150, 1);
        customer.addRental("RegularMovie", 3);
        assertFeeAndPoints(150, 1);

    }

    /**
     * Exigence 3:
     * Tous les jours à compter du quatrième, le coût journalier revient
     * à 1,5 $ avec un gain de 1 point de fidélité
     */
    @Test
    void regularMovie_FourDays() {
        customer.addRental("RegularMovie", 4);
        assertFeeAndPoints(300, 2);
    }

    /**
     * Exigence 4:
     * Les films pour enfants sont loués 1 $ par jour et rapportent 1 point
     */
    @Test
    void childrenMovie_OneDay() {
        customer.addRental("ChildrenMovie", 1);
        assertFeeAndPoints(100, 1);
    }

}
