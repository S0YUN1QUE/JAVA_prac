import java.util.Scanner;

class Snail {
    int arr[][];
    int temp = 1;
    int x, y;
    int r = 1;

    Snail(int n) {
        arr = new int[n][n];
    }

    public void clockSnail() {
        x = 0;
        y = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                y += r;
                arr[x][y] = temp;
                temp++;
            }

            for (int j = 0; j < (arr.length - 1) - i; j++) {
                x += r;
                arr[x][y] = temp;
                temp++;
            }

            r *= -1;
        }
    }

    public void counterClockSnail() {
        x = -1;
        y = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                x += r;
                arr[x][y] = temp;
                temp++;
            }

            for (int j = 0; j < (arr.length - 1) - i; j++) {
                y += r;
                arr[x][y] = temp;
                temp++;
            }

            r *= -1;
        }
    }

    public void printSnail() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

public class quiz08 {
    public static void main(String[] args) {
        // N 행렬 크기 N 입력
        Scanner sc = new Scanner(System.in);
        System.out.println("행렬 N의 크기를 입력하세요:");
        int n = sc.nextInt();
        // 2~10 이외 예외처리
        while (true) {
            if (n < 2 || n > 10) {
                System.out.println("다시 입력하세요(2~10):");
                n = sc.nextInt();
            } else {
                break;
            }
        }

        Snail s = new Snail(n);

        // 생성 방향 입력(시계/반시계)
        System.out.println("달팽이 행렬의 생성 방향은(1: 시계, 2: 반시계):");
        int r = sc.nextInt();

        // 출력
        if (r == 1) {
            s.clockSnail();
        } else if (r == 2) {
            s.counterClockSnail();
        }
        s.printSnail();
    }
}