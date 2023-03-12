import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class quiz5copy {
    public static void main(String[] args) {
        // 입력받을 문자열 라인 수 입력
        Scanner sc = new Scanner(System.in);
        System.out.println("입력 문자열의 줄(Line) 수를 입력하세요!");
        int line = sc.nextInt();

        // 라인 당 글자 수 입력
        System.out.println("한 줄(Line)의 글자 수를 입력하세요!");
        int letters = sc.nextInt();
        sc.nextLine();

        // 2차원 배열 생성
        char[][] words = new char[line][letters];

        // 문자열 입력 받아 배열에 저장
        for (int i = 0; i < line; i++) {
            char buffer[] = new char[letters];
            System.out.println((i + 1) + " 번째 라인의 문자열을 입력하세요.");
            String str = sc.nextLine();
            str.getChars(0, str.length(), buffer, 0);
            words[i] = buffer;
        }

        // 검색할 단어 입력
        System.out.println("검색할 문자열을 입력하세요.");
        String input = sc.nextLine();

        // 찾는 문자열 있는 경우 출력
        char search[] = new char[input.length()];
        input.getChars(0, input.length(), search, 0);
        char sWord[] = new char[input.length()];
        boolean b = true;
        while (b == true) {
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words[i].length; j++) {
                    for (int k = 0; k < search.length; k++) {
                        if (search[k] == words[i][j]) {
                            sWord[k] = search[k];
                        }
                    }
                    if (words[i][j] == ' ') {
                        break;
                    }
                }
            }
            for (int i = 0; i < search.length; i++) {
                if (search[i] != sWord[i]) {
                    // 없는 경우 재입력(반복)
                    System.out.println("찾을 수가 없습니다. 검색할 문자열을 입력하세요.");
                    input = sc.nextLine();
                    break;
                }
            }
            System.out.println(input + "을(를) 찾았습니다.");
            // 검색된 단어 줄, 총 검색 횟수 출력
            int count = 0;
            String change = "";
            String temp = "";
            ArrayList<ArrayList<String>> changeArr = new ArrayList<ArrayList<String>>();
            for (int i = 0; i < words.length; i++) {
                ArrayList<String> ca = new ArrayList<String>();
                for (int j = 0; j < words[i].length; j++) {
                    temp += Character.toString(words[i][j]);
                }
                ca.add(temp);
                changeArr.add(ca);
                temp = "";
            }
            for (int i = 0; i < sWord.length; i++) {
                change += Character.toString(sWord[i]);
            }
            System.out.print("검색된 라인 수 : ");
            for (int i = 0; i < changeArr.size(); i++) {
                for (int j = 0; j < changeArr.get(i).size(); j++) {
                    if ((changeArr.get(i)).contains(change)) {
                        count++;
                        if (i < changeArr.size() - 1) {
                            System.out.print((i + 1) + ", ");
                        } else {
                            System.out.print(i + 1);
                        }
                    }
                }
            }
            System.out.println();
            System.out.println("검색된 횟수 : " + count);

            // 단어 개수(공백으로 구분) 출력
            int count2 = 0;
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words[0].length; j++) {
                    if (words[i][j] == ' ') {
                        count2++;
                    }
                }
                count2++;
            }
            System.out.println("총 단어 수 : " + count2);
            b = false;
            break;
        }

    }
}
