

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class RecipeTest.
 *
 * @author  Alex
 * @version (a version number or a date)
 */
public class RecipeTest
{
    private Recipe recipe1;
    private SourceRecipes sourceRe1;
    private java.util.ArrayList<Recipe> arrayLis1;
    private HotRecipe hotRecip1;

    /**
     * Default constructor for test class RecipeTest
     */
    public RecipeTest()
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
        sourceRe1 = new SourceRecipes();
        arrayLis1 = sourceRe1.getRecipes();
        hotRecip1 = (HotRecipe)arrayLis1.getFirst();
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
    public void testCommentRating()
    {
        Recipe recipe1 = new Recipe("Mac and Cheese", "Aimal Shah", "A simple yet delectable dish.", 4);
        Comment comment1 = new Comment("Alex", "it's bad", 1);
        Comment comment2 = new Comment("Alex", "it's good", 5);
        Comment comment3 = new Comment("Alex", "it's good", 5);
        recipe1.addComment(comment1);
        recipe1.addComment(comment2);
        recipe1.addComment(comment3);
        recipe1.printDetails();
        assertEquals("3.7", recipe1.getAverageRating(), "0.1");
    }

    @Test
    public void testAddComment()
    {
        Comment comment1 = new Comment("Lol43211", "eh", 3);
        hotRecip1.addComment(comment1);
        assertEquals(5, hotRecip1.getCommentsSize());
    }

    @Test
    public void testAddIngredient()
    {
        RecipeIngredient recipeIn1 = new RecipeIngredient(3.0, "cups", "sprinkles");
        hotRecip1.addIngredient(recipeIn1);
        assertEquals(12, hotRecip1.getIngredientsSize());
    }

    @Test
    public void testAddSteps()
    {
        RecipeStep recipeSt1 = new RecipeStep("Drink water");
        hotRecip1.addRecipeStep(recipeSt1);
        assertEquals(10, hotRecip1.getStepsSize());
    }

    @Test
    public void testGetters()
    {
        assertEquals("Dora", hotRecip1.getAuthor());
        assertEquals("4.5", hotRecip1.getAverageRating());
        assertEquals("Chocolate Chip Cookies", hotRecip1.getName());
    }
}







