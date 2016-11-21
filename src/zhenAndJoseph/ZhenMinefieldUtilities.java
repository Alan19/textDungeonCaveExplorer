package zhenAndJoseph;

import pyramidExplorer.CaveExplorer;

public class ZhenMinefieldUtilities {
	static boolean isValidTile(boolean[][] mines, int row, int col) {
		if(row >= 0 && col >= 0 && row < mines.length && col < mines[0].length){
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void printPic(String[][] pic){
		for (String[] row : pic) {
			for (String col : row) {
				System.out.print(col);
			}
			System.out.println();
		}
	}
	
	static int getNonNegativeIntegerInput(int fieldSize) {
		String integerString = CaveExplorer.in.nextLine();
		boolean isInteger = false;
		boolean isPositive = false;
		int value = 0;
		while(!isInteger || !isPositive){
			try{
				value = Integer.parseInt(integerString);
				//will not continue if an error above is thrown
				isInteger = true;//exits loop if entry is valid
				if(value < 0 || value > fieldSize){
					isPositive = false;
					CaveExplorer.print("You must enter an non-negative integer.");
					integerString = CaveExplorer.in.nextLine();
				}
				else{
					isPositive = true;
				}
			}catch(NumberFormatException e){
				CaveExplorer.print("You must enter an non-negative integer.");
				integerString = CaveExplorer.in.nextLine();
			}
		}
		return value;
	}
	
	static boolean allStandardTilesRevealed(boolean[][] mines, boolean revealedTiles[][]) {
		//Returns true if all non mine tiles are revealed
		for (int row = 0; row < mines.length; row++) {
			for (int col = 0; col < mines[row].length; col++) {
				if(!revealedTiles[row][col] && !mines[row][col]){
					return false;
				}
			}
		}
		return true;
	}
}
