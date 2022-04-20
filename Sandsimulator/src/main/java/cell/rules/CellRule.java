package cell.rules;

public interface CellRule {
	
	boolean isStatic(); 				//If the cell is static, then the updater will simply ignore this.
	int gravity();						//Gravity 
	int spreadFactor();					//For liquids, how far the liquid can move horizontally.
	float moveChance();					//How big the chance for moving each frame is.
	
	public boolean moveDiagonally();	//Can the cell move diagonally? (Behavior that solids/powders use)
	public boolean moveHorizontally();	//Can the cell move horizontally? (Behavior that liquids use)
}