import java.util.ArrayList;
import java.util.Arrays;

public class quiz3_1 {
    public static void main(String[] args) {
        // 8x8 2차원 배열 선언
        char[][] randAlpha = new char[8][8];

        // a-z 알파벳 하나 골라 배열에 저장
        char[] alphabet = new char[26];
        char temp = 'a';
        for (int i = 0; i < 26; i++) {
            alphabet[i] = temp;
            temp++;
        }

        // loop1 -> 64
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                randAlpha[i][j] = alphabet[(int) (Math.random() * 25) + 1];
            }
        }

        // 화면 출력
        System.out.println("8 X 8, 알파벳 발생 결과");
        // loop1 ->64
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(randAlpha[i][j] + "\t");
            }
            System.out.println();
        }

        // 알파벳 발생 횟수 count 배열에 저장
        int[] count = new int[26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    if (randAlpha[k][j] == alphabet[i]) {
                        count[i] += 1;
                    }
                }
            }
        }

        // 최소 발생 알파벳
        ArrayList<Character> min = new ArrayList<Character>();
        int minimum = 99;

        // count 배열 최소값 구하기
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0 && count[i] < minimum) {
                minimum = count[i];
            }
        }

        // count의 최소값 인덱스와 alphabet 배열 인덱스 비교해 최소발생알파벳 찾기
        for (int i = 0; i < 26; i++) {
            if (count[i] == minimum) {
                min.add(alphabet[i]);
            }
        }

        // 출력
        System.out.println("최소 발생 알파벳");
        System.out.println(" - 발생 빈도 : " + minimum);
        System.out.println(" - 중복 알파벳 개수 : " + min.size());
        System.out.print(" - 알파벳 : ");
        for (int i = 0; i < min.size(); i++) {
            if (i < min.size() - 1) {
                System.out.print(min.get(i) + ", ");
            } else {
                System.out.print(min.get(i));
            }
        }
        System.out.println();

        // 최대 발생 알파벳
        ArrayList<Character> max = new ArrayList<Character>();
        int maximum = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0 && count[i] > maximum) {
                maximum = count[i];
            }
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] == maximum) {
                max.add(alphabet[i]);
            }
        }
        System.out.println("최대 발생 알파벳");
        System.out.println(" - 발생 빈도 : " + maximum);
        System.out.println(" - 중복 알파벳 개수 : " + max.size());
        System.out.print(" - 알파벳 : ");
        for (int i = 0; i < max.size(); i++) {
            if (i < max.size() - 1) {
                System.out.print(max.get(i) + ", ");
            } else {
                System.out.print(max.get(i));
            }
        }
        System.out.println();

        // 오름차순 정렬
        // 2차원 배열을 1차원 배열로 변환
        char asc[] = new char[64];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                asc[(i * 8) + j] = randAlpha[i][j];
            }
        }

        // 1차원 배열 asc 오름차순으로 정렬
        Arrays.sort(asc);

        // 출력
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(asc[(i * 8) + j] + "\t");
            }
            System.out.println();
        }
    }
}