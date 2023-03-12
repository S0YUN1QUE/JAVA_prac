import java.util.Scanner;

public class quiz11 {
    public static void permutation(int arr[], int depth, int n) {
        int temp;
        int result[] = new int[n];

        if (depth == n) {
            for (int i = 0; i < n; i++) {
                result[i] = arr[i];
            }
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + "\t");
            }
            System.out.println();
            if (result.length > n) {
                for (int i = 0; i < result.length; i++) {
                    if (i + 1 > n) {
                        result[i] = -1;
                    }
                }
            }
            return;
        }

        for (int i = depth; i < arr.length; i++) {
            temp = arr[depth];
            arr[depth] = arr[i];
            arr[i] = temp;
            permutation(arr, depth + 1, n);
            temp = arr[depth];
            arr[depth] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        // 양의 정수 N 입력받기
        Scanner scan = new Scanner(System.in);
        System.out.println("양의 정수 값을 입력하세요");
        int n = scan.nextInt();
        // N >= 1 && N <= 5
        while (true) {
            if (n < 1 || n > 5) {
                System.out.println("다시 입력하세요(1 <= N >= 5)");
                n = scan.nextInt();
            } else {
                break;
            }
        }
        // N 크기 배열 생성
        int nArr[] = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = i + 1;
        }

        // 발생 가능한 경우의 수
        int cases = 1;
        for (int i = 1; i <= n; i++) {
            cases *= i;
        }
        System.out.print("발생 가능한 경우의 수 : " + cases);
        System.out.println();
        // 순서에 상관 있게 숫자 나열(중복 허용)
        permutation(nArr, 0, n);
    }
}
