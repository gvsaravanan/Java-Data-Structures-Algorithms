import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class VaultRatGraph {

    static int row, col, startRow, startCol, moves, valsInRow, valsInNextRow;
    static char[][] map;
    static boolean[][] visited;
    static boolean end;
    static int[] dirR = {-1, 1, 0, 0}, dirC = {0, 0, 1, -1};
    static Queue<Integer> rowQ, colQ;

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new File("rat.dat"));
        int num = s.nextInt();
        VaultRatGraph maze = new VaultRatGraph(s.nextInt(), s.nextInt());

        for (int r = 0; r < row; r++) {
            String line = s.nextLine();
            for (int c = 0; c < col; c++) {
                map[row][col] = line.charAt(c);
            }
        }

        int ans = maze.solve();

        if (ans == -1) {
            System.out.println("Oh Rem please help me");
        } else {
            System.out.println(ans + " seconds");
        }
    }

    public VaultRatGraph(int r, int c) {
        row = r;
        col = c;
        map = new char[r][c];
        visited = new boolean[r][c];
        startRow = 0;
        startCol = 0;
        moves = 0;
        valsInRow = 0;
        valsInNextRow = 1;
        end = false;
        rowQ = new LinkedList<>();
        colQ = new LinkedList<>();
    }

    public int solve() {
        rowQ.add(startRow);
        colQ.add(startCol);
        visited[startRow][startCol] = true;

        while (rowQ.size() > 0) {
            int r = rowQ.remove();
            int c = colQ.remove();

            if (map[r][c] == 'E') {
                end = true;
                break;
            }

            explore(r, c);
            valsInRow--;

            if (valsInRow == 0) {
                valsInRow = valsInNextRow;
                valsInNextRow = 0;
                moves++;
            }
        }

        if (end) {
            return moves;
        }
        return -1;
    }

    public void explore(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int rr = r + dirR[i];
            int cc = c + dirC[i];

            if (rr < 0 || cc < 0) {
                continue;
            }

            if (rr >= row || cc >= col) {
                continue;
            }

            if (visited[r][c]) {
                continue;
            }

            if (map[r][c] == 'G') {
                continue;
            }

            rowQ.add(rr);
            colQ.add(cc);
            visited[r][c] = true;
            valsInNextRow++;
        }
    }
}
