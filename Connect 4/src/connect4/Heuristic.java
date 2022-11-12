package connect4;

public class Heuristic {
    final private int rows = 6;
    final private int columns = 7;
    final private char AI = 'Y';
    final private char Player = 'R';
    final private char Empty = '.';

    public int calcHeuristic(char[][] board){
        int score = 0;
        score += connect4(board,AI) * 100;
        score -= connect4(board,Player) * 100;
        score += connect3(board,AI) * 20;
        score -= connect3(board,Player) * 20;
        score += connect2(board,AI) * 5;
        score -= connect2(board,Player) * 5;
        return score;
    }

    private int connect4(char[][] board,char piece){
        int score = 0;

        // horizontal
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns - 3; j++)
                if (board[i][j] == piece && board[i][j + 1] == piece && board[i][j + 2] == piece && board[i][j + 3] == piece)
                    score++;

        // vertical
        for (int i = 0; i < rows - 3; i++)
            for (int j = 0; j < columns; j++)
                if (board[i][j] == piece && board[i + 1][j] == piece && board[i + 2][j] == piece && board[i + 3][j] == piece)
                    score++;

        // negative diagonal
        for (int i = 3; i < rows; i++)
            for (int j = 0; j < columns - 3; j++)
                if (board[i][j] == piece && board[i - 1][j + 1] == piece && board[i - 2][j + 2] == piece && board[i - 3][j + 3] == piece)
                    score++;

        // positive diagonal
        for (int i = 0; i < rows - 3; i++)
            for (int j = 0; j < columns - 3; j++)
                if (board[i][j] == piece && board[i + 1][j + 1] == piece && board[i + 2][j + 2] == piece && board[i + 3][j + 3] == piece)
                    score++;

        return score;

    }
    private int connect3(char[][] board,char piece) {
        int score = 0;

        // horizontal
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns - 3; j++){
                if (board[i][j] == Empty && board[i][j + 1] == piece && board[i][j + 2] == piece && board[i][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i][j + 1] == Empty && board[i][j + 2] == piece && board[i][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i][j + 1] == piece && board[i][j + 2] == Empty && board[i][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i][j + 1] == piece && board[i][j + 2] == piece && board[i][j + 3] == Empty)
                    score++;
            }
        }

        // vertical
        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == Empty && board[i + 1][j] == piece && board[i + 2][j] == piece && board[i + 3][j] == piece)
                    score++;
                if (board[i][j] == piece && board[i + 1][j] == Empty && board[i + 2][j] == piece && board[i + 3][j] == piece)
                    score++;
                if (board[i][j] == piece && board[i + 1][j] == piece && board[i + 2][j] == Empty && board[i + 3][j] == piece)
                    score++;
                if (board[i][j] == piece && board[i + 1][j] == piece && board[i + 2][j] == piece && board[i + 3][j] == Empty)
                    score++;
            }
        }

        // negative diagonal
        for (int i = 3; i < rows; i++) {
            for (int j = 0; j < columns - 3; j++) {
                if (board[i][j] == Empty && board[i - 1][j + 1] == piece && board[i - 2][j + 2] == piece && board[i - 3][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i - 1][j + 1] == Empty && board[i - 2][j + 2] == piece && board[i - 3][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i - 1][j + 1] == piece && board[i - 2][j + 2] == Empty && board[i - 3][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i - 1][j + 1] == piece && board[i - 2][j + 2] == piece && board[i - 3][j + 3] == Empty)
                    score++;
            }
        }

        // positive diagonal
        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < columns - 3; j++) {
                if (board[i][j] == Empty && board[i + 1][j + 1] == piece && board[i + 2][j + 2] == piece && board[i + 3][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i + 1][j + 1] == Empty && board[i + 2][j + 2] == piece && board[i + 3][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i + 1][j + 1] == piece && board[i + 2][j + 2] == Empty && board[i + 3][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i + 1][j + 1] == piece && board[i + 2][j + 2] == piece && board[i + 3][j + 3] == Empty)
                    score++;
            }
        }
        return score;
    }

    private int connect2(char[][] board,char piece) {
        int score = 0;

        // horizontal
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns - 3; j++){
                if (board[i][j] == Empty && board[i][j + 1] == Empty && board[i][j + 2] == piece && board[i][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i][j + 1] == Empty && board[i][j + 2] == piece && board[i][j + 3] == Empty)
                    score++;
                if (board[i][j] == piece && board[i][j + 1] == piece && board[i][j + 2] == Empty && board[i][j + 3] == Empty)
                    score++;
                if (board[i][j] == Empty && board[i][j + 1] == piece && board[i][j + 2] == piece && board[i][j + 3] == Empty)
                    score++;
                if (board[i][j] == Empty && board[i][j + 1] == piece && board[i][j + 2] == Empty && board[i][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i][j + 1] == Empty && board[i][j + 2] == Empty && board[i][j + 3] == piece)
                    score++;
            }
        }

        // vertical
        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == Empty && board[i + 1][j] == Empty && board[i + 2][j] == piece && board[i + 3][j] == piece)
                    score++;
                if (board[i][j] == piece && board[i + 1][j] == Empty && board[i + 2][j] == piece && board[i + 3][j] == Empty)
                    score++;
                if (board[i][j] == piece && board[i + 1][j] == piece && board[i + 2][j] == Empty && board[i + 3][j] == Empty)
                    score++;
                if (board[i][j] == Empty && board[i + 1][j] == piece && board[i + 2][j] == piece && board[i + 3][j] == Empty)
                    score++;
                if (board[i][j] == Empty && board[i + 1][j] == piece && board[i + 2][j] == Empty && board[i + 3][j] == piece)
                    score++;
                if (board[i][j] == piece && board[i + 1][j] == Empty && board[i + 2][j] == Empty && board[i + 3][j] == piece)
                    score++;
            }
        }

        // negative diagonal
        for (int i = 3; i < rows; i++) {
            for (int j = 0; j < columns - 3; j++) {
                if (board[i][j] == Empty && board[i - 1][j + 1] == Empty && board[i - 2][j + 2] == piece && board[i - 3][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i - 1][j + 1] == Empty && board[i - 2][j + 2] == piece && board[i - 3][j + 3] == Empty)
                    score++;
                if (board[i][j] == piece && board[i - 1][j + 1] == piece && board[i - 2][j + 2] == Empty && board[i - 3][j + 3] == Empty)
                    score++;
                if (board[i][j] == Empty && board[i - 1][j + 1] == piece && board[i - 2][j + 2] == piece && board[i - 3][j + 3] == Empty)
                    score++;
                if (board[i][j] == Empty && board[i - 1][j + 1] == piece && board[i - 2][j + 2] == Empty && board[i - 3][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i - 1][j + 1] == Empty && board[i - 2][j + 2] == Empty && board[i - 3][j + 3] == piece)
                    score++;
            }
        }

        // positive diagonal
        for (int i = 0; i < rows - 3; i++) {
            for (int j = 0; j < columns - 3; j++) {
                if (board[i][j] == Empty && board[i + 1][j + 1] == Empty && board[i + 2][j + 2] == piece && board[i + 3][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i + 1][j + 1] == Empty && board[i + 2][j + 2] == piece && board[i + 3][j + 3] == Empty)
                    score++;
                if (board[i][j] == piece && board[i + 1][j + 1] == piece && board[i + 2][j + 2] == Empty && board[i + 3][j + 3] == Empty)
                    score++;
                if (board[i][j] == Empty && board[i + 1][j + 1] == piece && board[i + 2][j + 2] == piece && board[i + 3][j + 3] == Empty)
                    score++;
                if (board[i][j] == Empty && board[i + 1][j + 1] == piece && board[i + 2][j + 2] == Empty && board[i + 3][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i + 1][j + 1] == Empty && board[i + 2][j + 2] == Empty && board[i + 3][j + 3] == piece)
                    score++;
            }
        }
        return score;
    }
}
