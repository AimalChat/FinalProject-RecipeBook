

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
    public void TestCommentRating()
    {
        Recipe recipe2 = new Recipe("Mac and Cheese", "Aimal Shah", "A simple yet delectable dish.", 4);
        Comment comment1 = new Comment("Alex", "its bad", 1);
        Comment comment2 = new Comment("Alex", "its good", 5);
        Comment comment3 = new Comment("Alex", "its good", 5);
        RecipeBook recipeBo1 = new RecipeBook("Alex");
        recipeBo1.comment();
        recipeBo1.comment();
        CommandWords commandW1 = new CommandWords();
        assertEquals(true, commandW1.isCommand("SELECT, 1"));
        assertEquals(true, commandW1.getCommandWord("select"));
        assertEquals(true, CommandWord.valueOf("SELECT"));
        CommandWords commandW2 = new CommandWords();
        assertEquals(true, CommandWord.values());
        CommandWord sELECT1 = CommandWord.valueOf("SELECT");
        assertEquals(true, sELECT1);
        Command command1 = new Command(sELECT1, "1");
        recipeBo1.select(command1);
        recipeBo1.comment();
        recipeBo1.comment();
        recipeBo1.comment();
        CommandWord vIEW1 = CommandWord.valueOf("VIEW");
        assertEquals(true, vIEW1);
        Command command2 = new Command(vIEW1, "details");
        recipeBo1.view(command2);
    }
}

