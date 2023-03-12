import java.util.Scanner;

public class quiz06 {
    public static void main(String[] args) {
        while (true) {
            // 0 ~ 9 사이 정수 3개 난수로 생성(Math.rand())
            int random[] = new int[3];
            for (int i = 0; i < random.length; i++) {
                random[i] = (int) (Math.random() * 9);
                // 중복 값 검사
                for (int j = 0; j < i; j++) {
                    if (random[i] == random[j]) {
                        i--;
                    }
                }
            }
            // 시도횟수 출력
            int count = 1;
            int strike = 0;
            int ball = 0;
            int out = 0;
            int temp = 0;
            while (count < 5) {
                System.out.println("시도횟수 : " + count);
                // 정수 3개 입력받기
                Scanner sc = new Scanner(System.in);
                System.out.println("정수 3개를 입력하세용~~^__^");
                int input[] = new int[3];
                for (int i = 0; i < input.length; i++) {
                    input[i] = sc.nextInt();
                }
                // 판정
                for (int i = 0; i < random.length; i++) {
                    for (int j = 0; j < input.length; j++) {
                        // strike -> 같은 자릿수, 난수 값 == 입력값
                        if (i == j && random[i] == input[j]) {
                            strike++;
                            temp++;
                        } else if (i != j && random[i] == input[j]) { // ball -> 다른 자릿수, 난수 값 == 입력값
                            ball++;
                            temp++;
                        }
                    }
                }
                if (temp == 0) {
                    out++;
                    System.out.println("Out: 아웃" + out + "번");
                }
                // 결과 출력
                if (strike != 0) {
                    System.out.print(strike + " strike ");
                }
                if (ball != 0) {
                    System.out.print(ball + " ball ");
                }
                System.out.println();
                // 종료
                // lose -> 시도횟수 >= 5 || strike이나 out == 2
                count++;
                temp = 0;
                if (count == 5) {
                    System.out.println("게임횟수 초과");
                    System.out.println("아까비~~~졌네용..");
                    System.out.print("정답은: ");
                    for (int i = 0; i < random.length; i++) {
                        System.out.print(random[i] + " ");
                    }
                    System.out.print("입니다.\n");
                    System.out.println("계속하려면 아무 키나 누르십시오 . . . ");
                    String anyKey = "";
                    anyKey = sc.next();
                    if (anyKey != "") {
                        count = 1;
                        break;
                    } else {
                        break;
                    }
                } else if (strike == 2 || out == 2) {
                    System.out.println("아까비~~~졌네용..");
                    System.out.print("정답은: ");
                    for (int i = 0; i < random.length; i++) {
                        System.out.print(random[i] + " ");
                    }
                    System.out.print("입니다.\n");
                    System.out.println("계속하려면 아무 키나 누르십시오 . . . ");
                    String anyKey = "";
                    anyKey = sc.next();
                    if (anyKey != "") {
                        count = 1;
                        break;
                    } else {
                        break;
                    }
                }
                if (count < 5 && strike == 3) { // win -> 난수 값 == 입력값 (자리 순서대로)
                    System.out.println("WIN!");
                }
            }
        }
    }
}
