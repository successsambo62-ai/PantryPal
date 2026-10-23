PantryPal - Smart Pantry Manager
Project Overview
PantryPal is an Android application developed in Java that helps users manage pantry ingredients and discover recipes they can make using available ingredients.
The application uses a strict recipe-matching algorithm, meaning a recipe is only suggested when all required ingredients are available in sufficient quantities.
Objectives
Manage pantry inventory efficiently
Track ingredient expiry dates
Provide recipe suggestions based on available ingredients
Prevent food waste through expiry notifications
Demonstrate Android development concepts including SQLite, RecyclerView, CRUD operations, and SharedPreferences
Features
Pantry Management
Add ingredients
View pantry inventory
Delete ingredients
Store quantity, unit, and expiry date
Persistent storage using SQLite
Recipe Suggestions
15+ preloaded recipes
Strict ingredient matching
Recipe details page
Recipe ingredients and preparation steps
Expiry Tracking
Fresh ingredient indicators
Expiring soon warnings
Expired ingredient notifications
Optional exclusion of expired items from recipe matching
Settings
Enable/disable notifications
Configure expiry warning days
Hide expired ingredients from recipe results
Persist settings using SharedPreferences
Technologies Used
Java
Android Studio
SQLite Database
RecyclerView
SharedPreferences
XML Layouts
GitHub Version Control
Database Structure
PantryItem Table
Field	Type
id	INTEGER
name	TEXT
quantity	REAL
unit	TEXT
expiryDate	TEXT
Recipe Table
Field	Type
id	INTEGER
name	TEXT
steps	TEXT
RecipeIngredient Table
Field	Type
id	INTEGER
recipeId	INTEGER
ingredientName	TEXT
requiredQty	REAL
unit	TEXT
Strict Recipe Matching
A recipe is displayed only if:

Every required ingredient exists in the pantry
Quantity requirements are met
Matching units are present
Ingredients are not expired (if enabled)
Example
Pantry:

Flour 500g
Eggs 6 pcs
Milk 1000ml
Recipe:

Pancakes
Flour 200g
Eggs 2 pcs
Milk 500ml
 Pancakes appears
If Milk is removed:
Pancakes no longer appears
Installation
Clone Repository
git clone https://github.com/successsambo62-ai/PantryPal.git
Open Project
Open Android Studio
Select Open Project
Navigate to PantryPal folder
Allow Gradle to sync
Run the application
Project Structure
com.example.pantrypal
│
├── activities
│   ├── MainActivity
│   ├── AddPantryItemActivity
│   ├── DeleteIngredientActivity
│   ├── SuggestedRecipesActivity
│   ├── RecipeDetailActivity
│   └── SettingsActivity
│
├── adapters
│   ├── PantryAdapter
│   └── RecipeAdapter
│
├── database
│   └── DatabaseHelper
│
├── models
│   ├── PantryItem
│   ├── Recipe
│   └── RecipeIngredient
│
└── utils
    └── RecipeMatcher
    
Configure expiry warning days
Hide expired ingredients from recipe results
Persist settings using SharedPreferences
