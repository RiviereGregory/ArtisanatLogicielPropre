package gri.riverjach.videostore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static gri.riverjach.videostore.VideoRegistry.addMovie;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerTest {

    public static final String REGULAR_MOVIE = "RegularMovie";
    public static final String CHILDREN_MOVIE = "ChildrenMovie";
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer();
    }

    @BeforeEach
    void loadRegistry() {
        addMovie(REGULAR_MOVIE, VideoType.REGULAR);
        addMovie(CHILDREN_MOVIE, VideoType.CHILDREN);
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
        customer.addRental(REGULAR_MOVIE, 1);
        assertFeeAndPoints(150, 1);
    }

    /**
     * Exigence 2:
     * Le deuxièmes jours de location ordinaire
     * sont gratuits, mais ne donnent pas droit à aucun point
     */
    @Test
    void regularMovie_SecondDayFree() {
        customer.addRental(REGULAR_MOVIE, 2);
        assertFeeAndPoints(150, 1);
    }

    /**
     * Exigence 2:
     * Le troisième jours de location ordinaire
     * sont gratuits, mais ne donnent pas droit à aucun point
     */
    @Test
    void regularMovie_ThirdDayFree() {
        customer.addRental(REGULAR_MOVIE, 3);
        assertFeeAndPoints(150, 1);

    }

    /**
     * Exigence 3:
     * Tous les jours à compter du quatrième, le coût journalier revient
     * à 1,5 $ avec un gain de 1 point de fidélité
     */
    @Test
    void regularMovie_FourDays() {
        customer.addRental(REGULAR_MOVIE, 4);
        assertFeeAndPoints(300, 2);
    }

    /**
     * Exigence 4:
     * Les films pour enfants sont loués 1 $ par jour et rapportent 1 point
     */
    @Test
    void childrenMovie_OneDay() {
        customer.addRental(CHILDREN_MOVIE, 1);
        assertFeeAndPoints(100, 1);
    }

    /**
     * Exigence 4:
     * Les films pour enfants sont loués 1 $ par jour et rapportent 1 point
     */
    @Test
    void childrenMovie_FourDay() {
        customer.addRental(CHILDREN_MOVIE, 4);
        assertFeeAndPoints(400, 1);
    }

    /**
     * Exigence :
     * Gérer plusieurs film à la fois
     */
    @Test
    void oneRegularOneChildren_FourDay() {
        customer.addRental(REGULAR_MOVIE, 4); // 3$ + 2pts
        customer.addRental(CHILDREN_MOVIE, 4); // 4$ + 1pts

        assertFeeAndPoints(700, 3);
    }
}
