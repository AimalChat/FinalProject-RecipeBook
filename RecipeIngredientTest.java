

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class RecipeIngredientTest.
 *
 * @author  Aimal
 * @version (a version number or a date)
 */
public class RecipeIngredientTest
{
    private RecipeIngredient recipeIn1;

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
        recipeIn1 = new RecipeIngredient(0.5, "cups", "flour");
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
        RecipeIngredient recipeIn1 = new RecipeIngredient(0,"units", "ice cubes");
    }

    @Test
    public void testGetters()
    {
        assertEquals(0.5, recipeIn1.getAmount(), 0.1);
        assertEquals("flour", recipeIn1.getIngredient());
        assertEquals("cups", recipeIn1.getMeasurement());
    }

    @Test
    public void testToStringMethods()
    {
        assertEquals("0.5 cups flour", recipeIn1.toString());
        RecipeIngredient recipeIn2 = new RecipeIngredient(3,"units","eggs");
        assertEquals("3 units eggs", recipeIn2.toString());
    }

    @Test
    public void testSetters()
    {
        recipeIn1.setAmount(0.7);
        recipeIn1.setIngredient("sugar");
        recipeIn1.setMeasurement("teaspoons");
        assertEquals(0.7, recipeIn1.getAmount(), 0.1);
        assertEquals("sugar", recipeIn1.getIngredient());
        assertEquals("teaspoons", recipeIn1.getMeasurement());
    }
}








