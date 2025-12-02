

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class HotRecipeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HotRecipeTest
{
    private HotRecipe hotRecip1;

    

    /**
     * Default constructor for test class HotRecipeTest
     */
    public HotRecipeTest()
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
        hotRecip1 = new HotRecipe("Philidelphian cookies from a good cook.", "Cookies", "Philidelphian cookies from a good cook.", 6);
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
    public void testValidBakeTime()
    {
        hotRecip1.setCookOrBakeTime(350, "F");
        assertEquals("ºF", hotRecip1.getTempatureType());
        assertEquals(350, hotRecip1.getHeat());
    }

    @Test
    public void testBorderForC()
    {
        hotRecip1.setCookOrBakeTime(290, "C");
        assertEquals(290, hotRecip1.getHeat());
        assertEquals("ºC", hotRecip1.getTempatureType());
    }

    @Test
    public void testZeroBorderforC()
    {
        hotRecip1.setCookOrBakeTime(0, "C");
        assertEquals(0, hotRecip1.getHeat());
        assertEquals("ºC", hotRecip1.getTempatureType());
        assertEquals(true, hotRecip1.validateHeat(0, "ºC"));
    }
}





