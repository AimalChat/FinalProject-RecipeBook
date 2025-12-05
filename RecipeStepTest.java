

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class RecipeStepTest.
 *
 * @author  Aimal
 * @version (a version number or a date)
 */
public class RecipeStepTest
{
    private RecipeStep recipeSt1;

    /**
     * Default constructor for test class RecipeStepTest
     */
    public RecipeStepTest()
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
        recipeSt1 = new RecipeStep("beat eggs");
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
    public void testGetter()
    {
        assertEquals("beat eggs", recipeSt1.getStep());
    }

    @Test
    public void testSetter()
    {
        recipeSt1.setStep("beat eggs with hand mixer.");
        assertEquals("beat eggs with hand mixer.", recipeSt1.getStep());
    }
}


