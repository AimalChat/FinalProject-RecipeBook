import java.util.ArrayList;

/**
 * Write a description of class SourceRecipes here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SourceRecipes
{
    // instance variables - replace the example below with your own
    private ArrayList<Recipe> recipes;
    private int maxWidth = 40;

    /**
     * Constructor for objects of class SourceRecipes
     */
    public SourceRecipes()
    {
        // initialise instance variables
        recipes = new ArrayList<>();
        
        Recipe recipe1 = new Recipe();
        recipe1.setRecipeName("Chocolate Chip Cookies");
        recipe1.setDescription(AutoWrapper.wrapTextByWidth("This chocolate chip cookie recipe makes dozens of cookies with crisp edges, chewy centers, and melty chocolate chips. It is truly the best!", maxWidth));
        recipe1.setRecipeAuthor("Dora");
        recipe1.setServingAmt(48);
        
        //Ingredients
        RecipeIngredient butter = new RecipeIngredient();
        butter.setIngredient("butter, softened");
        butter.setAmount(1);
        butter.setMeasurement("cup");
        recipe1.addIngredient(butter);
        
        RecipeIngredient whiteSugar = new RecipeIngredient();
        whiteSugar.setIngredient("white sugar");
        whiteSugar.setAmount(1);
        whiteSugar.setMeasurement("cup");
        recipe1.addIngredient(whiteSugar);
        
        RecipeIngredient brownSugar = new RecipeIngredient();
        brownSugar.setIngredient("packed brown sugar");
        brownSugar.setAmount(1);
        brownSugar.setMeasurement("cup");
        recipe1.addIngredient(brownSugar);
        
        RecipeIngredient egg = new RecipeIngredient();
        egg.setIngredient("eggs");
        egg.setAmount(2);
        recipe1.addIngredient(egg);
        
        RecipeIngredient vanillaExtract = new RecipeIngredient();
        vanillaExtract.setIngredient("vanilla extract");
        vanillaExtract.setAmount(2);
        vanillaExtract.setMeasurement("teaspoons");
        recipe1.addIngredient(vanillaExtract);
        
        RecipeIngredient bakingSoda = new RecipeIngredient();
        bakingSoda.setIngredient("baking soda");
        bakingSoda.setAmount(1);
        bakingSoda.setMeasurement("teaspoons");
        recipe1.addIngredient(bakingSoda);
        
        RecipeIngredient hotWater = new RecipeIngredient();
        hotWater.setIngredient("hot water");
        hotWater.setAmount(2);
        hotWater.setMeasurement("teaspoons");
        recipe1.addIngredient(hotWater);
        
        RecipeIngredient salt = new RecipeIngredient();
        hotWater.setIngredient("salt");
        hotWater.setAmount(1/2);
        hotWater.setMeasurement("teaspoon");
        recipe1.addIngredient(salt);
        
        RecipeIngredient allPurposeFlour = new RecipeIngredient();
        allPurposeFlour.setIngredient("all purpose flour");
        allPurposeFlour.setAmount(3);
        allPurposeFlour.setMeasurement("cups");
        recipe1.addIngredient(allPurposeFlour);
        
        RecipeIngredient semisweetChocolateChips = new RecipeIngredient();
        semisweetChocolateChips.setIngredient("semisweet chocolate chips");
        semisweetChocolateChips.setAmount(2);
        semisweetChocolateChips.setMeasurement("cups");
        recipe1.addIngredient(semisweetChocolateChips);
        
        RecipeIngredient choppedWalnuts = new RecipeIngredient();
        semisweetChocolateChips.setIngredient("chopped walnuts");
        semisweetChocolateChips.setAmount(1);
        semisweetChocolateChips.setMeasurement("cup");
        recipe1.addIngredient(choppedWalnuts);
        
        
        
    }
    
    
}
