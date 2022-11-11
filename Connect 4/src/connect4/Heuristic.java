package connect4;

public class Heuristic {
    final private int LENGTH = 6;
    final private int WIDTH  = 7;
    final private char AI = 'R';
    final private char Player = 'Y';
    final private char Empty = '-';

    public int calcHeuristic(char[][] board){
        int score = 0;
        score += connect4(board,AI) * 10;
        score -= connect4(board,Player) * 10;
        score += connect3(board,AI) * 5;
        score -= connect3(board,Player) * 5;
        score += connect2(board,AI) * 3;
        score -= connect2(board,Player) * 3;
        return score;
    }

    private int connect4(char[][] board,char piece){
        int score = 0;


        // horizontal
        for (int i = 0; i < LENGTH; i++)
            for (int j = 0; j < WIDTH - 3; j++)
                if (board[i][j] == piece && board[i][j + 1] == piece && board[i][j + 2] == piece && board[i][j + 3] == piece)
                    score++;

        // vertical
        for (int i = 0; i < LENGTH - 3; i++)
            for (int j = 0; j < WIDTH; j++)
                if (board[i][j] == piece && board[i + 1][j] == piece && board[i + 2][j] == piece && board[i + 3][j] == piece)
                    score++;

        // negative diagonal
        for (int i = 3; i < LENGTH; i++)
            for (int j = 0; j < WIDTH - 3; j++)
                if (board[i][j] == piece && board[i - 1][j + 1] == piece &&
                        board[i - 2][j + 2] == piece && board[i - 3][j + 3] == piece)
                    score++;

        // positive diagonal
        for (int i = 0; i < LENGTH - 3; i++)
            for (int j = 0; j < WIDTH - 3; j++)
                if (board[i][j] == piece && board[i + 1][j + 1] == piece &&
                        board[i + 2][j + 2] == piece && board[i + 3][j + 3] == piece)
                    score++;

        return score;

    }
    private int connect3(char[][] board,char piece) {
        int score = 0;


        // horizontal
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < WIDTH - 3; j++){
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
        for (int i = 0; i < LENGTH - 3; i++) {
            for (int j = 0; j < WIDTH; j++) {
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
        for (int i = 3; i < LENGTH; i++) {
            for (int j = 0; j < WIDTH - 3; j++) {
                if (board[i][j] == Empty && board[i - 1][j + 1] == piece &&
                        board[i - 2][j + 2] == piece && board[i - 3][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i - 1][j + 1] == Empty &&
                        board[i - 2][j + 2] == piece && board[i - 3][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i - 1][j + 1] == piece &&
                        board[i - 2][j + 2] == Empty && board[i - 3][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i - 1][j + 1] == piece &&
                        board[i - 2][j + 2] == piece && board[i - 3][j + 3] == Empty)
                    score++;
            }
        }

        // positive diagonal
        for (int i = 0; i < LENGTH - 3; i++) {
            for (int j = 0; j < WIDTH - 3; j++) {
                if (board[i][j] == Empty && board[i + 1][j + 1] == piece &&
                        board[i + 2][j + 2] == piece && board[i + 3][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i + 1][j + 1] == Empty &&
                        board[i + 2][j + 2] == piece && board[i + 3][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i + 1][j + 1] == piece &&
                        board[i + 2][j + 2] == Empty && board[i + 3][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i + 1][j + 1] == piece &&
                        board[i + 2][j + 2] == piece && board[i + 3][j + 3] == Empty)
                    score++;
            }
        }
        return score;
    }

    private int connect2(char[][] board,char piece) {
        int score = 0;


        // horizontal
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < WIDTH - 3; j++){
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
        for (int i = 0; i < LENGTH - 3; i++) {
            for (int j = 0; j < WIDTH; j++) {
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
        for (int i = 3; i < LENGTH; i++) {
            for (int j = 0; j < WIDTH - 3; j++) {
                if (board[i][j] == Empty && board[i - 1][j + 1] == Empty &&
                        board[i - 2][j + 2] == piece && board[i - 3][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i - 1][j + 1] == Empty &&
                        board[i - 2][j + 2] == piece && board[i - 3][j + 3] == Empty)
                    score++;
                if (board[i][j] == piece && board[i - 1][j + 1] == piece &&
                        board[i - 2][j + 2] == Empty && board[i - 3][j + 3] == Empty)
                    score++;
                if (board[i][j] == Empty && board[i - 1][j + 1] == piece &&
                        board[i - 2][j + 2] == piece && board[i - 3][j + 3] == Empty)
                    score++;
                if (board[i][j] == Empty && board[i - 1][j + 1] == piece &&
                        board[i - 2][j + 2] == Empty && board[i - 3][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i - 1][j + 1] == Empty &&
                        board[i - 2][j + 2] == Empty && board[i - 3][j + 3] == piece)
                    score++;
            }
        }

        // positive diagonal
        for (int i = 0; i < LENGTH - 3; i++) {
            for (int j = 0; j < WIDTH - 3; j++) {
                if (board[i][j] == Empty && board[i + 1][j + 1] == Empty &&
                        board[i + 2][j + 2] == piece && board[i + 3][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i + 1][j + 1] == Empty &&
                        board[i + 2][j + 2] == piece && board[i + 3][j + 3] == Empty)
                    score++;
                if (board[i][j] == piece && board[i + 1][j + 1] == piece &&
                        board[i + 2][j + 2] == Empty && board[i + 3][j + 3] == Empty)
                    score++;
                if (board[i][j] == Empty && board[i + 1][j + 1] == piece &&
                        board[i + 2][j + 2] == piece && board[i + 3][j + 3] == Empty)
                    score++;
                if (board[i][j] == Empty && board[i + 1][j + 1] == piece &&
                        board[i + 2][j + 2] == Empty && board[i + 3][j + 3] == piece)
                    score++;
                if (board[i][j] == piece && board[i + 1][j + 1] == Empty &&
                        board[i + 2][j + 2] == Empty && board[i + 3][j + 3] == piece)
                    score++;
            }
        }
        return score;
    }


}
