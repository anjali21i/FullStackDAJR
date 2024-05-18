package com.core.fullstack.SystemDesign;

import java.util.Scanner;

// Model
class TicTacToeModel {
    private char[][] board;
    private final char EMPTY_CELL = '-';
    private final char PLAYER_X = 'X';
    private final char PLAYER_O = 'O';
    private int size;

    public boolean isEmptyCell(int row, int col) {
        if(row==0 && col== 0) {
            return true;
        }
        return false;
    }

    public TicTacToeModel(int size) {
        this.size = size;
        this.board = new char[size][size];
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = EMPTY_CELL;
            }
        }
    }

    public void setMove(int row, int col, char player) {
        board[row][col] = player;
    }

    public boolean isWinner(char player) {
        // Check rows and columns
        for (int i = 0; i < size; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public boolean isDraw() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == EMPTY_CELL) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// View
class TicTacToeView {
    public void displayBoard(TicTacToeModel model) {
        model.printBoard();
    }

    public void displayWinner(char player) {
        System.out.println("Player " + player + " wins!");
    }

    public void displayDraw() {
        System.out.println("It's a draw!");
    }

    public int[] getPlayerMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row (1-3):");
        int row = scanner.nextInt() - 1;
        System.out.println("Enter column (1-3):");
        int col = scanner.nextInt() - 1;
        return new int[] { row, col };
    }
}

// Controller
class TicTacToeController {
    private TicTacToeModel model;
    private TicTacToeView view;
    private char currentPlayer;

    public TicTacToeController(TicTacToeModel model, TicTacToeView view) {
        this.model = model;
        this.view = view;
        this.currentPlayer = 'X';
    }

    public void playGame() {
        view.displayBoard(model);
        while (true) {
            int[] move = view.getPlayerMove();
            int row = move[0];
            int col = move[1];
            if (isValidMove(row, col)) {
                model.setMove(row, col, currentPlayer);
                view.displayBoard(model);
                if (model.isWinner(currentPlayer)) {
                    view.displayWinner(currentPlayer);
                    break;
                }
                if (model.isDraw()) {
                    view.displayDraw();
                    break;
                }
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    private boolean isValidMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && model.isEmptyCell(row, col)) {
            return true;
        }
        return false;
    }
}

// Main class
public class TicTacToe {
    public static void main(String[] args) {
        TicTacToeModel model = new TicTacToeModel(3);
        TicTacToeView view = new TicTacToeView();
        TicTacToeController controller = new TicTacToeController(model, view);
        controller.playGame();
    }
}

class Test {

    public static void main(String[] args) {

        System.out.println("1" + 1 + 1);

        System.out.println(1 + 1 + "1");

    }

}