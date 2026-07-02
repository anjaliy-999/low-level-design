package entitites;

import enums.Symbol;

public class Player {
    private final Symbol symbol;
    private final String name;

    public Player(String name, Symbol symbol) {
        if(symbol == Symbol.Empty) {
            throw new IllegalArgumentException("Player can not have EMPTY symbol");
        }
        this.symbol = symbol;
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }
}

// Player -> Symbol : Attribute
// symbol is just an enum