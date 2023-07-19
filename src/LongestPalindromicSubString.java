import java.util.Scanner;
public class LongestPalindromicSubString {
    static String palindromicSubString(String A)
    {
        int N = A.length();
        boolean[][] isPalindrome = new boolean[N][N];
        int maxLength = 0,start = 0,end = 0;
        for (int i = 0; i < N; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                if (A.charAt(i) == A.charAt(j) && (j - i == 1 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                    if (j - i + 1 > maxLength) {
                        maxLength = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return A.substring(start, end + 1);
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String A=scanner.next();
        String subString=palindromicSubString(A);
        System.out.println(subString);
    }
}
