package scuec.contest1;

import java.util.Scanner;

public class CrossBridge {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int nCases = sc.nextInt();
        sc.nextLine();
        for (; nCases>0; --nCases) {
            char[] waitQueue = sc.nextLine().toCharArray();
            
            int waitTime = 0;
            for (int i=1; i<=waitQueue.length; ++i) {
                if (waitQueue[i-1] == 'w') {
                    waitTime += 2;
                } else if (waitQueue[i-1] == 'm') {
                    ++waitTime;
                }
            }
            if (waitTime <= 30) {
                System.out.println(waitTime);
            } else {
                System.out.println("30");
            }
        }// end of for
    }
}
