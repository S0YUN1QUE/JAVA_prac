import java.util.Scanner;

public class quiz4_2 {
    public static void main(String[] args) {
        // 정수 두 개 입력받기
        Scanner scan = new Scanner(System.in);
        System.out.println("M값을 입력하세요");
        int m = scan.nextInt();
        System.out.println("N값을 입력하세요");
        int n = scan.nextInt();

        // 출력
        if (m < n) { // m < n일 경우
            // m 에서 n까지 정수 출력
            System.out.println("M : " + m + " ~ N : " + n + "사이 정수 값은");
            for (int i = m; i <= n; i++) {
                if (i < n) {
                    System.out.print(i + ", ");
                } else {
                    System.out.print(i);
                }
            }
        } else if (m > n) { // m > n일 경우
            // n에서 m까지 정수 출력 (역순)
            System.out.println("N : " + n + " ~ M : " + m + "사이 정수 값은");
            for (int i = m; i >= n; i--) {
                if (i > n) {
                    System.out.print(i + ", ");
                } else {
                    System.out.print(i);
                }
            }
        } else { // m == n
            System.out.println("N, M 정수 값 : " + n);
        }
        System.out.println();
        System.out.println("----감사합니다----");
    }
}
