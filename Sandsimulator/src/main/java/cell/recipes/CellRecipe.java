package cell.recipes;

import cell.CellType;

public class CellRecipe {
	public final CellType firstIngredient;
	public final CellType secondIngredient;
	
	public final CellType firstResult;
	public final CellType secondResult;
	
	public final float reactionChance;
	
	CellRecipe(CellType firstIngredient, CellType secondIngredient, CellType firstResult, CellType secondResult, float reactionChance){
		this.firstIngredient = firstIngredient;		//First ingredient required to run the reaction
		this.secondIngredient = secondIngredient;	//Second ingredient required to run the reaction
		
		//this.result = result;
		this.firstResult = firstResult;				//What the first ingredient will turn into after reaction
		this.secondResult = secondResult;			//What the second ingredient will turn into after reaction
		
		this.reactionChance = reactionChance;		//The chance of the reaction to happen each frame
	}
}
