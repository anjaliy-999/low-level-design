package entitites;

import enums.Symbol;

public class Cell {
    private Symbol symbol;
    Cell() {
        this.symbol = Symbol.Empty;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public boolean isEmpty() {
        return symbol == Symbol.Empty;
    }
}

// Cell -> Symbol : Attribute