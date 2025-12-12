Recipe Book

Project Title:
Recipe Book

Purpose of Project:
Store recipes and print information about each recipe when needed.

Version / Date:
2025-12-11

How to Start This Project:

1.Download the Zip file containing this project and extract all files.

2.Open Command Prompt and use the commands dir and cd to enter the newly extracted folder in your Downloads.

You may need to do this twice depending on how your system nests extracted folders.

3.Once inside the folder, your Command Prompt should say something like:

C:\Users\YOURACCOUNT\Downloads\FinalProject-RecipeBook-master\FinalProject-RecipeBook-master>

4.Run:

javac RecipeBook.java

5.After it loads, start the program with:

java RecipeBook


6.You’ll be asked to write your name. Please do so.
You are now inside the program.

Authors:

Aimal Nangyalai Shah & Alex Laurin

How and What to Do to Contribute to This Project:

Please make sure that you do credit us.
Though do as you please — this code was made purely to learn the basics of Java.
Modify, duplicate, share.

But most importantly, have fun!

User Instructions:
Important Things to Note

INCOMPLETE PROJECT!

Known Limitations
1. Ingredient Formatting

The program relies on ingredients being entered in a strict format:
(amount, measurement, ingredient)
Typos, extra commas, or missing fields may cause errors or require re-entry.

2. Measurement Units

Only a predefined set of units is recognized (cup, teaspoon, units, etc.).
Custom or non-standard units are not supported.

3. Scalability

Designed for console input; not optimized for large recipe collections or multi-user usage.

4. Editing / Removing Recipes

Creation works, but editing or removing existing recipes is not fully implemented.

5. Input Case Sensitivity

Some inputs are normalized (like ingredient names), but other commands rely on exact spelling or phrasing.

6. Error Handling

While validation exists, some edge cases
(like zero ingredients, negative amounts)
are handled only with printed messages and may interrupt workflow.

7. User Interface

Text-based UI may be unintuitive for some users; no graphical interface is provided.

8. Persistence

Recipes are stored in memory; if the program is closed, unsaved recipes will be lost unless saving/loading functionality is added.

As of Now (2025-12-11)

You cannot edit nor remove any aspect of recipes.

In Create Mode, if you write an incorrect input, you will be stuck with it. Type "exit" to restart.

Allowed Measurements When Creating an Ingredient:
teaspoon
tablespoon
cup
quart
gallon
pinch
pint
milliliter
liter
tsp
tbsp
ml
ltr
milliliters
teaspoons
tablespoons
cups
quarts
gallons
pinches
liters
unit
units

Available Commands:

-When Viewing a Recipe

Comment → write a comment with a rating attached

Favorite → add to a favorited recipes list

Convert → write: convert <number of servings>

View → look at comments, steps, ingredients, details, or the recipe again

-When in Menu:

Select → select a recipe

Favorites → see the list of favorited recipes

Create → enter Create Mode

-When in Create Mode:

Add → add elements to the recipe

Confirm → confirm the recipe just created


Future Implementations

Creating a better interface when I develop my skills enough

Adding a way to save recipes

Making it possible to share recipes online and see real-time comments

Work in Progress

Adding both edit and remove commands

Better validation and error handling

Flexibility in writing and inputting data

Text formatting