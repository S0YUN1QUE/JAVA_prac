import java.util.Random;
import java.util.Scanner;

class Matrix {
    int matrix[][];
    int temp = 0;
    int half = 0;

    Matrix(int n) {
        matrix = new int[n][n];
        initMatrix(n);
    }

    public void initMatrix(int n) {
        int temp[] = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            temp[i] = (int) ((Math.random() * (n * n)) + 1);
            for (int j = 0; j < i; j++) {
                if (temp[i] == temp[j]) {
                    i--;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[(i * n) + j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void rotateR() {
        if (matrix.length % 2 == 0) {
            half = matrix.length % 2;
        } else {
            half = (matrix.length % 2) + 1;
        }
        for (int i = 0; i < half; i++) {
            temp = matrix[0][i];
            matrix[0][i] = matrix[i][(matrix.length - 1)];
            matrix[i][(matrix.length - 1)] = temp;
            temp = matrix[0][i];
            matrix[0][i] = matrix[(matrix.length - 1)][(matrix.length - 1) - i];
            matrix[(matrix.length - 1)][(matrix.length - 1) - i] = temp;
            temp = matrix[0][i];
            matrix[0][i] = matrix[(matrix.length - 1) - i][0];
            matrix[(matrix.length - 1) - i][0] = temp;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

public class quiz10 {
    public static void main(String[] args) {
        // 키보드로부터 정수 N입력
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        // (2~8)
        while (true) {
            if (n < 2 || n > 8) {
                System.out.println("다시 입력(2~8)");
                n = scan.nextInt();
            } else {
                break;
            }
        }
        // N X N 매트릭스 생성

        // 매트릭스 원소 1~NXN 사이 난수로 초기화
        // 중복 제거

        // 초기화 매트릭스 출력
        Matrix m = new Matrix(n);
        // 메뉴 출력
        System.out.println("1) 오른쪽으로 90도 회전");
        System.out.println("2) 왼쪽으로 90도 회전");
        System.out.println("3) 상하반전");
        System.out.println("4) 좌우반전");
        System.out.println("5) 프로그램 종료");
        int menu = scan.nextInt();

        while (true) {
            if (menu == 1) {
                m.rotateR();
                break;
            } else if (menu == 2) {

            } else if (menu == 3) {

            } else if (menu == 4) {

            } else if (menu == 5) {
                break;
            }
        }
    }
}
