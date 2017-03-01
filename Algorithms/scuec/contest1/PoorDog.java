package scuec.contest1;

import java.util.Scanner;

public class PoorDog {
    private final static int TIME_LIMIT = 20;
    private final static int[] DIR_X = {-1, 0, 1, 0};
    private final static int[] DIR_Y = {0, 1, 0, -1};
    
    private static int nRows;
    private static int nCols;
    private static int xStart;
    private static int yStart;
    private static int xEnd;
    private static int yEnd;
    private static int[][] maze;
    private static boolean[][] isVisited;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int nCases = sc.nextInt();
        for (; nCases>0; nCases--) {
            nRows = sc.nextInt();
            nCols = sc.nextInt();
            isVisited = new boolean[nRows][nCols];
            maze = new int[nRows][nCols];
            for (int i=0; i<nRows; ++i) {
                isVisited[i] = new boolean[nCols];
                maze[i] = new int[nCols];
                for (int j=0; j<nCols; ++j) {
                    maze[i][j] = sc.nextInt();
                }
            }
            xStart = sc.nextInt() - 1;
            yStart = sc.nextInt() - 1;
            xEnd = sc.nextInt() - 1;
            yEnd = sc.nextInt() - 1;
            
            if (dfs(xStart, yStart, 0)) {
                System.out.println("luck dog");
            } else {
                System.out.println("poor dog");
            }
        }// end of for
    }
    
    /**
     * 
     * @param xCurrent
     * @param yCurrent
     * @param costTime
     * @return
     */
    public static boolean dfs(int xCurrent, int yCurrent, int costTime) {
        if (xCurrent==xEnd && yCurrent==yEnd) {
            if (costTime < TIME_LIMIT) {
                return true;
            } else {
                return false;
            }
        }
        
        for (int dir=0; dir<4; ++dir) {
            int xNext = xCurrent + DIR_X[dir];
            int yNext = yCurrent + DIR_Y[dir];
            if (isInBound(xNext, yNext) && maze[xNext][yNext]==0 && !isVisited[xNext][yNext]) {
                isVisited[xNext][yNext] = true;
                if (dfs(xNext, yNext, costTime+1)) {
                    return true;
                }
                isVisited[xNext][yNext] = false;
            }
        }// end of for
        return false;
    }
    
    /**
     * check if the point is in the bound
     * @param x
     * @param y
     * @return
     */
    public static boolean isInBound(int x, int y) {
        return (x>=0 && y>=0 && x<nRows && y<nCols);
    }
}
