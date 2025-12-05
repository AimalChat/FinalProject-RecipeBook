

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ColdRecipeTest.
 *
 * @author  Alex
 * @version (a version number or a date)
 */
public class ColdRecipeTest
{
    private ColdRecipe coldReci1;

    /**
     * Default constructor for test class ColdRecipeTest
     */
    public ColdRecipeTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        coldReci1 = new ColdRecipe("Cookies", "Aimal", "Philidelphian cookies from a good cook.", 6);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testInvalidChillTime()
    {
        ColdRecipe coldReci1 = new ColdRecipe("Cookies", "Aimal", "Philidelphian cookies from a good cook.", 6);
        coldReci1.setChillTime(-300);
        assertEquals(0, coldReci1.getChillTime());
    }

    @Test
    public void TestValidChillTime()
    {
        coldReci1.setChillTime(360);
        assertEquals(360, coldReci1.getChillTime());
    }
}


