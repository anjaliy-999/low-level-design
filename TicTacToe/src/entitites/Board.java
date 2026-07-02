package entitites;

import enums.Symbol;
import exceptions.InvalidMoveException;

public class Board {
    private final Cell[][] grid;
    private final int size;

    public Board(int size) {
        this.size = size;
        this.grid = new Cell[size][size];
        initialize();
    }

    private void initialize() {
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    public void validatePosition(int row, int col) {
        boolean isValid = row>=0 && row<size && col>=0 && col<size;
        if(!isValid) {
            throw new InvalidMoveException("Row or Col is invalid, please retry.");
        }
    }

    public boolean isCellEmpty(int row, int col) {
        return grid[row][col].getSymbol() == Symbol.Empty;
    }

    public void placeSymbol(int row, int col, Symbol symbol) {
        validatePosition(row, col);
        grid[row][col].setSymbol(symbol);
    }

    public boolean isFull() {
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(grid[i][j].getSymbol() == Symbol.Empty) return false;
            }
        }
        return true;
    }

    public void printboard() {
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                System.out.print(grid[i][j].getSymbol() + " ");
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

}
