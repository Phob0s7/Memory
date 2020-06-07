package com.snatik.matches.model;

public class BoardConfiguration {

	private static final int _6 = 6;

	public final int difficulty;
	public final int numTiles;
	public final int numTilesInRow;
	public final int numRows;
	public final int time;

	public BoardConfiguration(int difficulty) {
		this.difficulty = difficulty;
		switch (difficulty) {
		case 1:
			numTiles = _6;
			numTilesInRow = 3;
			numRows = 2;
			time = 60;
			break;
		default:
			throw new IllegalArgumentException("Select one of predefined sizes");
		}
	}
}
