package cell.recipes;

import java.util.ArrayList;
import java.util.Arrays;

import cell.CellType;

public class CellRecipes {
	
	//Just create an ArrayList full of recipes
	static final ArrayList<CellRecipe> recipes = new ArrayList<CellRecipe>() {{
		add(new CellRecipe(CellType.WATER, CellType.SALT, CellType.WATER, null, 1f));
		add(new CellRecipe(CellType.SALT_WATER, CellType.STATIC, CellType.SALT, CellType.STATIC, 2f));
		add(new CellRecipe(CellType.WATER, CellType.SOIL, null, CellType.MUD, 2f));		
		add(new CellRecipe(CellType.WATER, CellType.LAVA, CellType.STEAM, CellType.ROCK, 95f));		
		add(new CellRecipe(CellType.STEAM, CellType.STEAM, CellType.WATER, null, 2f));		
		//add(new CellRecipe(CellType.STATIC, CellType.WATER, CellType.ROCK, CellType.STEAM, 0.1f));
	}};
	
	//Returns recipes containing the parameter
	public static ArrayList<CellRecipe> getRelevantRecipies(CellType cellType){
		var relevantRecipes = new ArrayList<CellRecipe>();
		
		for (var recipe : recipes) { 		      
	           //System.out.println(recipe.firstIngredient); 	
			if (cellType == recipe.firstIngredient) {
				relevantRecipes.add(recipe);
			}
	      }
		
		return relevantRecipes;
	}
	
	public static CellRecipe getMatchingRecipe(CellType reactant1, CellType reactant2) {
		if (reactant1 == null || reactant2 == null) return null;
		
		for (var recipe : reactant1.getRecipes()) {
			if (reactant2 == recipe.secondIngredient) {
				return recipe;
			}
		}
		
		return null;
	}
	
	public static void create() {
		//Hugo B hjälpte mig med detta
		Arrays.asList(CellType.values())
		.stream()
		.forEach(cellType -> cellType.setRecipes(getRelevantRecipies(cellType)));
	}
	
}