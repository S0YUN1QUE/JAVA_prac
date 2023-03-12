import java.util.Scanner;

public class quiz4_3 {
    public static void main(String[] args) {
        // 양의 정수(n) 입력 받기
        Scanner input = new Scanner(System.in);
        System.out.println("배열의 개수를 입력하세요.");
        int n = input.nextInt();

        // 입력값 검사 - n >= 1 && n <= 100
        while (n < 1 || n > 101) { // 아닐 경우 재입력
            System.out.println("1 이상의 값을 입력하세요.");
            n = input.nextInt();
            if (n > 1 && n < 101) {
                break;
            }
        }

        // 정수형 배열 선언 - n개 크기
        int[] arr = new int[n];

        // 난수(-50~50) 발생
        // 배열에 저장
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100 - 50);
            // 중복값 제거
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    i--;
                    break;
                }
            }
        }

        // 출력
        System.out.println();
        System.out.println("배열의     개수 : " + n);
        System.out.print("배열 내 난수 값 : ");
        for (int i = 0; i < arr.length; i++) {
            if (i < arr.length - 1) { // 배열 내 난수 값 출력
                System.out.print(arr[i] + ", ");
            } else {
                System.out.print(arr[i]);
            }
        }
        System.out.println();

        // 최대값
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 최소값
        int min = 99;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // 평균값 - 실수
        float avg = 0;
        for (int i = 0; i < arr.length; i++) {
            avg += (float) arr[i];
        }

        // 출력
        System.out.println("최    대     값 : " + max);
        System.out.println("최    소     값 : " + min);
        System.out.println("평    균     값 : " + avg);

        // 구간별 난수 개수 구하기
        // 난수 개수 저장할 배열 생성
        String[] section = new String[10];

        // null값 제거
        for (int i = 0; i < section.length; i++) {
            section[i] = "";
        }

        // 구간별 난수 개수 배열에 저장
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= -40) {
                section[0] += "*";
            } else if (arr[i] <= -30) {
                section[1] += "*";
            } else if (arr[i] <= -20) {
                section[2] += "*";
            } else if (arr[i] <= -10) {
                section[3] += "*";
            } else if (arr[i] <= 0) {
                section[4] += "*";
            } else if (arr[i] <= 10) {
                section[5] += "*";
            } else if (arr[i] <= 20) {
                section[6] += "*";
            } else if (arr[i] <= 30) {
                section[7] += "*";
            } else if (arr[i] <= 40) {
                section[8] += "*";
            } else if (arr[i] <= 50) {
                section[9] += "*";
            }
        }

        // 출력(히스토그램)
        System.out.println();
        System.out.println("히스토그램");
        System.out.println("-50 ~ -41 : " + section[0]);
        System.out.println("-40 ~ -31 : " + section[1]);
        System.out.println("-30 ~ -21 : " + section[2]);
        System.out.println("-20 ~ -11 : " + section[3]);
        System.out.println("-10 ~ - 1 : " + section[4]);
        System.out.println("  0 ~   9 : " + section[5]);
        System.out.println(" 10 ~  19 : " + section[6]);
        System.out.println(" 20 ~  29 : " + section[7]);
        System.out.println(" 30 ~  39 : " + section[8]);
        System.out.println(" 40 ~  50 : " + section[9]);
    }
}
