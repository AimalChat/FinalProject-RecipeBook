import java.util.ArrayList;

/**
 * Adds basic recipes to listOfRecipes when starting the program.
 * 
 * @author Aimal
 * @version (a version number or a date)
 */
public class SourceRecipes
{
    // instance variables - replace the example below with your own
    private ArrayList<Recipe> baseRecipes;
    private int maxWidth = 40;

    /**
     * Constructor for objects of class SourceRecipes
     */
    public SourceRecipes()
    {
        // initialise instance variables
        baseRecipes = new ArrayList<>();
        
        HotRecipe recipe1 = new HotRecipe();
        recipe1.setRecipeName("Chocolate Chip Cookies");
        recipe1.setDescription(AutoWrapper.wrapTextByWidth("This chocolate chip cookie recipe makes dozens of cookies with crisp edges, chewy centers, and melty chocolate chips. It is truly the best!", maxWidth));
        recipe1.setRecipeAuthor("Dora");
        recipe1.setServingAmt(48);
        recipe1.setType("hot");
        
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
        salt.setIngredient("salt");
        salt.setAmount(0.5);
        salt.setMeasurement("teaspoon");
        recipe1.addIngredient(salt);
        
        RecipeIngredient allPurposeFlour = new RecipeIngredient();
        allPurposeFlour.setIngredient("all purpose flour");
        allPurposeFlour.setAmount(3);
        allPurposeFlour.setMeasurement("cups");
        recipe1.addIngredient(allPurposeFlour);
        
        RecipeIngredient semiSweetChocolateChips = new RecipeIngredient();
        semiSweetChocolateChips.setIngredient("semisweet chocolate chips");
        semiSweetChocolateChips.setAmount(2);
        semiSweetChocolateChips.setMeasurement("cups");
        recipe1.addIngredient(semiSweetChocolateChips);
        
        RecipeIngredient choppedWalnuts = new RecipeIngredient();
        choppedWalnuts.setIngredient("chopped walnuts");
        choppedWalnuts.setAmount(1);
        choppedWalnuts.setMeasurement("cup");
        recipe1.addIngredient(choppedWalnuts);
        
        //Steps
        RecipeStep step1 = new RecipeStep("Gather your ingredients, making sure your butter is softened, and your eggs are room temperature.");
        recipe1.addRecipeStep(step1);
        
        RecipeStep step2 = new RecipeStep("Preheat the oven to 350 degrees F (175 degrees C). Beat butter, white sugar, and brown sugar in a large bowl with an electric mixer until smooth and creamy.");
        recipe1.setCookOrBakeTime(350,"F");
        recipe1.addRecipeStep(step2);
        
        RecipeStep step3 = new RecipeStep("Beat in eggs, one at a time, then stir in vanilla.");
        recipe1.addRecipeStep(step3);
        
        RecipeStep step4 = new RecipeStep("Dissolve baking soda in hot water; add to batter along with salt and mix until combined.");
        recipe1.addRecipeStep(step4);
        
        RecipeStep step5 = new RecipeStep("Stir in flour, chocolate chips, and walnuts until a soft dough forms.");
        recipe1.addRecipeStep(step5);
        
        RecipeStep step6 = new RecipeStep("Drop rounded spoonfuls of cookie dough 2 inches apart onto ungreased baking sheets.");
        recipe1.addRecipeStep(step6);
        
        RecipeStep step7 = new RecipeStep("Bake in the preheated oven until edges are lightly browned, about 10 minutes.");
        recipe1.addRecipeStep(step7);
        
        RecipeStep step8 = new RecipeStep("Cool on the baking sheets briefly before removing to a wire rack to cool completely.");
        recipe1.addRecipeStep(step8);
        
        RecipeStep step9 = new RecipeStep("Store in an airtight container or serve immediately and enjoy!");
        recipe1.addRecipeStep(step9);
        
        //Comments
        
        Comment comment1 = new Comment("Chuck Sampson", "vERRY eXXCELLENT cOOOKIE! I worked 10 years as a baker and the recipe we used at the bake shop was similar except this recipe didn't call for any cream of tartar, so I added it to my version. I added 1/2 tspn. What it does is make the cookie crack better when baking which gives it a better appeal in appearance as appose to that smooth top looking cookie which I don't like. It doesn't do anything for flavor so if you don't care about whether its smooth or cracked then don't bother with the suggestion.", 5);
        recipe1.addComment(comment1);
        
        Comment comment2 = new Comment("Kristen", "Definitely the best chocolate chip cookies I've ever made! I make these quite often for my friends and family and am asked for the recipe all the time. I make no substitutions, but often omit the nuts (for obvious reasons-some are allergic). I'm surprised at the negative ratings I've read and offer these tips: 1) use room temperature eggs (set them in a bowl of hot water for a few minutes if they just came out of the fridge) 2) use a cookie scoop for symmetrical, consistent shape 3) line your cookie sheet with parchment paper-I only discovered this last year 4) remove cookies after 10 min 11 tops, cool for about 2-3 minutes on the sheet, then transfer to racks. That's the secret to getting that chewy, gooey goodness! Trust me, they should come out of the oven looking under-baked!! Happy baking!", 5);
        recipe1.addComment(comment2);
        
        Comment comment3 = new Comment("Raine2711", "I've been making these cookies for over ten years. They have always turned out great, I do not follow the instructions to the tee but always the measurements. Anyone who says they didn't turn out great, had to have missed a step or ingredient.", 5);
        recipe1.addComment(comment3);
        
        Comment comment4 = new Comment("sianna and Darya", "The cookie is good but not great, I was expecting a bit more. There's no crumbly texture, they're just super sweet without much flavor.", 3);
        recipe1.addComment(comment4);
        
        //Put it in
        baseRecipes.add(recipe1);
    }
    
    public ArrayList<Recipe> getRecipes()
    {
        return baseRecipes;
    }
}
