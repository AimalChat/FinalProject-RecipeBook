

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class RecipeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RecipeTest
{
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
}



