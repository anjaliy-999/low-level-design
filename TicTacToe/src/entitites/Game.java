package entitites;

import enums.GameStatus;
import enums.Symbol;
import exceptions.InvalidMoveException;

public class Game {
    private final Board board;
    private  final Player playerX;
    private final Player playerO;
    private Player currentPlayer;
    private GameStatus status;

    public Game(Player playerX, Player playerO, int boardSize) {
        this.board = new Board(boardSize);
        this.playerX = playerX;
        this.playerO = playerO;
        currentPlayer = playerX; // start with X
        this.status = GameStatus.IN_PROGRESS;
    }

    public void makeMove(int row, int col) {
        // check status of game, should be in progress
        if(status != GameStatus.IN_PROGRESS) {
            throw new InvalidMoveException("Game is already over");
        }
        // validate move
        board.validatePosition(row, col);
        if(!board.isCellEmpty(row, col)) {
            throw new InvalidMoveException("Cell is not empty");
        }

        // place symbol
        board.placeSymbol(row, col, currentPlayer.getSymbol());

        // check win
        if(checkWin(row, col, currentPlayer.getSymbol())) {
            status = currentPlayer.getSymbol() == Symbol.O ? GameStatus.WINNER_O : GameStatus.WINNER_X;
        }

        // check draw
        if(board.isFull()) {
            status = GameStatus.DRAW;
            return;
        }

        // switchPlayer
        switchPlayer();
    }

    private boolean checkWin(int row, int col, Symbol symbol) {
        int size = board.getSize();
        if (isRowComplete(row, symbol)) return true;
        if (isColumnComplete(col, symbol)) return true;

        if (row == col && isMainDiagonalComplete(symbol))
            return true;

        if (row + col == size - 1 && isAntiDiagonalComplete(symbol))
            return true;
        return false;
    }

    private boolean isRowComplete(int row, Symbol symbol) {
        int size = board.getSize();

        for (int col = 0; col < size; col++) {
            if (board.getCell(row, col).getSymbol() != symbol)
                return false;
        }
        return true;
    }

    private boolean isColumnComplete(int col, Symbol symbol) {
        int size = board.getSize();

        for (int row = 0; row < size; row++) {
            if (board.getCell(row, col).getSymbol() != symbol)
                return false;
        }
        return true;
    }

    private boolean isMainDiagonalComplete(Symbol symbol) {
        int size = board.getSize();

        for (int i = 0; i < size; i++) {
            if (board.getCell(i, i).getSymbol() != symbol)
                return false;
        }
        return true;
    }

    private boolean isAntiDiagonalComplete(Symbol symbol) {
        int size = board.getSize();

        for (int i = 0; i < size; i++) {
            if (board.getCell(i, size - 1 - i).getSymbol() != symbol)
                return false;
        }
        return true;
    }


    private void switchPlayer() {
        if(currentPlayer == playerO) {
            currentPlayer = playerX;
        } else {
            currentPlayer = playerO;
        }
    }

    public GameStatus getStatus() { return status; }

    public Player getWinner() {
        if(status == GameStatus.WINNER_O) return playerO;
        else if(status == GameStatus.WINNER_X) return playerX;
        return null;
    }

    public void printBoard() {
        board.printboard();;
    }

}
