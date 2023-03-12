import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.NA;

public class Exam1 {
    public static void main(String[] args) {
        // 정수 N 입력(3~5)
        Scanner scan = new Scanner(System.in);
        System.out.println("정수 N을 입력하시오(3 ~ 5) : ");
        int n = scan.nextInt();
        // 값 검사 - 유효하지 않은 값 입력 시 재입력
        while (true) {
            if (n < 3 || n > 5) {
                System.out.println("유효하지 않은 값입니다. 다시 입력하시오(N : 3 ~ 5) : ");
                n = scan.nextInt();
            } else {
                break;
            }
        }

        // 정수형(n X n) 2차원 배열 선언
        int nArray[][] = new int[n][n];
        // 2차원 배열 내 난수 저장(-10 ~ 30)
        int tempArr[] = new int[n * n];
        // 중복 제거
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i] = (int) ((Math.random() * 40) - 10);
            for (int j = 0; j < i; j++) {
                if (tempArr[i] == tempArr[j]) {
                    i--;
                }
            }
        }
        for (int i = 0; i < nArray.length; i++) {
            for (int j = 0; j < nArray[i].length; j++) {
                nArray[i][j] = tempArr[(n * j) + i];
            }
        }

        // 각 열, 행, 대각선 별 최대, 최소, 중간값
        // 테이블 정렬
        int nArray2[][] = new int[n][n];
        int tempInt = 0;
        for (int i = 0; i < nArray.length; i++) {
            for (int j = 0; j < nArray[i].length; j++) {
                nArray2[i][j] = nArray[i][j];
            }
        }
        for (int i = 0; i < nArray2.length; i++) {
            for (int j = 0; j < nArray2[i].length; j++) {
                for (int k = 0; k < j; k++) {
                    if (nArray2[i][j] < nArray2[i][k]) {
                        tempInt = nArray2[i][j];
                        nArray2[i][j] = nArray2[i][k];
                        nArray2[i][k] = tempInt;
                    }
                }
            }
        }

        // 열 최대, 최소, 중간
        for (int i = 0; i < n; i++) {
            System.out.print("\t");
        }
        System.out.println("\t\t\t최소값\t최대값\t중간값");
        for (int i = 0; i < nArray2.length; i++) {
            System.out.print("\t\t");
            for (int j = 0; j < nArray2[i].length; j++) {
                System.out.print(nArray[i][j] + "\t");
            }
            System.out.print("\t" + nArray2[i][0] + "\t" + nArray2[i][n - 1] + "\t" + nArray2[i][n / 2]);
            System.out.println();
        }
        // 대각선(왼->오) 최대, 최소, 중간
        int cross[] = new int[3];
        cross[0] = nArray[0][0];
        cross[1] = nArray[n / 2][n / 2];
        cross[2] = nArray[n - 1][n - 1];
        for (int i = 0; i < cross.length; i++) {
            for (int j = 0; j < i; j++) {
                if (cross[i] < cross[j]) {
                    tempInt = cross[i];
                    cross[i] = cross[j];
                    cross[j] = tempInt;
                }
            }
        }

        // 대각선(오->왼) 최대, 최소, 중간
        int cross2[] = new int[3];
        cross2[0] = nArray[0][n - 1];
        cross2[1] = nArray[n / 2][n / 2];
        cross2[2] = nArray[n - 1][0];
        for (int i = 0; i < cross2.length; i++) {
            for (int j = 0; j < i; j++) {
                if (cross2[i] < cross2[j]) {
                    tempInt = cross2[i];
                    cross2[i] = cross2[j];
                    cross2[j] = tempInt;
                }
            }
        }
        // 행 최대, 최소, 중간
        // 출력
        System.out.print("최소값\t" + cross2[0] + "\t");
        int min = 99;
        for (int i = 0; i < nArray.length; i++) {
            if (nArray[i][0] < min) {
                min = nArray[i][0];
            }
        }
        for (int i = 0; i < nArray.length; i++) {
            if (nArray[i][0] == min) {
                for (int j = 0; j < nArray[i].length; j++) {
                    System.out.print(nArray[i][j] + "\t");
                }
            }
        }
        System.out.println(cross[0] + "\t" + cross[2] + "\t" + cross[1]);
        System.out.print("최대값\t" + cross2[2] + "\t");
        int max = 0;
        for (int i = 0; i < nArray.length; i++) {
            if (nArray[i][0] > max) {
                max = nArray[i][0];
            }
        }
        for (int i = 0; i < nArray.length; i++) {
            if (nArray[i][0] == max) {
                for (int j = 0; j < nArray[i].length; j++) {
                    System.out.print(nArray[i][j] + "\t");
                }
            }
        }

        // 2차원 배열 전체 기준으로 구간별 숫자 발생 빈도 히스토그램
        // 출력
    }
}