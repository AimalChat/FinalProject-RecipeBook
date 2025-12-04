

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class RecipeIngredientTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RecipeIngredientTest
{
    /**
     * Default constructor for test class RecipeIngredientTest
     */
    public RecipeIngredientTest()
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
    public void TestIngredientConstructor1()
    {
        RecipeIngredient recipeIn1 = new RecipeIngredient(0, "ml", "ketchup");
    }
    
    @Test
    public void TestIngredientConstructor2()
    {
        RecipeIngredient recipeIn1 = new RecipeIngredient(1, "ice", "ice cube");
        assertEquals(false, recipeIn1.validMeasurement("ice"));
    }

    @Test
    public void TestIngredientConstructor3()
    {
        RecipeIngredient recipeIn1 = new RecipeIngredient(50, "tsp", "salt");
    }

    @Test
    public void TextIngredientConstructor4()
    {
        RecipeIngredient recipeIn1 = new RecipeIngredient(0, "ice cubes");
    }
}





