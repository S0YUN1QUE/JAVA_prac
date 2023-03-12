import java.util.HashSet;
import java.util.Scanner;

public class quiz5 {
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
        boolean b = true;
        while (b == true) {
            char search[] = new char[input.length()];
            char temp[] = new char[input.length()];
            input.getChars(0, input.length(), search, 0);
            HashSet<Integer> idx = new HashSet<Integer>();
            int count = 0;
            int sCount = 0;
            for (int i = 0; i < temp.length; i++) {
                temp[i] = '0';
            }
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words[i].length; j++) {
                    if (words[i][j] == ' ') {
                        count = 0;
                        for (int l = 0; l < temp.length; l++) {
                            if (temp[l] == search[l]) {
                                count++;
                            }
                            temp[l] = '0';
                        }
                        if (count == temp.length) {
                            idx.add(i + 1);
                            sCount++;
                        }
                    }
                    if (words[i][j] != '0') {
                        for (int k = 0; k < search.length; k++) {
                            if (temp[k] == '0' && words[i][j] == search[k]) {
                                temp[k] = search[k];
                                break;
                            }
                        }
                    }
                }
                count = 0;
                for (int l = 0; l < temp.length; l++) {
                    if (temp[l] == search[l]) {
                        count++;
                    }
                    temp[l] = '0';
                }
                if (count == temp.length) {
                    sCount++;
                    idx.add(i + 1);
                }
            }
            // 없는 경우 재입력(반복)
            if (sCount == 0) {
                System.out.println("찾을 수가 없습니다. 검색할 문자열을 입력하세요");
                input = sc.nextLine();
            } else {
                System.out.println(input + "을(를) 찾았습니다.");

                // 검색된 단어 줄, 총 검색 횟수 출력
                System.out.print("검색된 라인 수 : ");
                Object[] index = idx.toArray();
                for (int i = 0; i < index.length; i++) {
                    if (i < index.length - 1) {
                        System.out.print(index[i] + ", ");
                    } else {
                        System.out.print(index[i]);
                    }
                }
                System.out.println();
                System.out.println("검색된 횟수 : " + sCount);

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
}
