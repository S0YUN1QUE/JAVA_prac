import java.util.Scanner;

public class Exam2 {
    public static void main(String[] args) {
        // 영어 단어 세 개 입력받아 배열에 저장
        Scanner scan = new Scanner(System.in);
        String word = "";
        // 배열 선언
        char words[][] = new char[3][20];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length; j++) {
                words[i][j] = '0';
            }
        }
        // 단어 입력
        char num[] = { '첫', '두', '세' };
        for (int i = 0; i < 3; i++) {
            System.out.println(num[i] + " 번째 단어를 입력하세요.");
            word = scan.next();
            while (true) {
                // 단어 글자 범위(5~20글자)
                if (word.length() < 5 || word.length() > 20) {
                    // 유효범위 이외 단어 입력 시 재입력
                    System.out.println("5 이상 20 이하 글자로 구성된 단어를 입력하세요.");
                    word = scan.next();
                } else {
                    break;
                }
            }
            // 입력받은 단어 저장
            for (int j = 0; j < word.length(); j++) {
                words[i][j] = word.charAt(j);
            }
        }

        // 3개 단어 중 하나 선택
        int randInt = (int) (Math.random() * 3);
        int wordCount = 0;
        // 출력
        System.out.print("단어 선택 완료, 게임을 시작합니다. 선택된 단어 : ");
        for (int i = 0; i < words[0].length; i++) {
            if (words[randInt][i] != '0') {
                System.out.print(words[randInt][i]);
                wordCount++;
            }
        }
        System.out.println();

        // 선택된 단어 50% blind
        char selectedWord[] = new char[wordCount];
        for (int i = 0; i < wordCount; i++) {
            selectedWord[i] = words[randInt][i];
        }
        // 단어 길이 홀수일 경우(반올림)
        if (wordCount % 2 != 0) {
            wordCount = (wordCount / 2) + 1;
        } else {
            // 짝수일 경우
            wordCount /= 2;
        }
        // 랜덤 선택 후 blind
        int randi = 0;
        for (int i = 0; i < wordCount; i++) {
            randi = (int) (Math.random() * selectedWord.length);
            // 중복 제거
            if (selectedWord[randi] == '_') {
                i--;
            } else {
                selectedWord[randi] = '_';
            }
        }

        // 게임 시작
        int count = 0;
        char alphabet = '0';
        while (true) {
            wordCount = 0;
            int count2 = 0;
            System.out.println();
            // 시도 횟수 출력
            count++;
            System.out.println(count + "번째 시도, 아래 단어를 구성하는 알파벳 한 개를 입력하세요.");
            for (int i = 0; i < selectedWord.length; i++) {
                System.out.print(selectedWord[i]);
            }
            System.out.println("\n");
            // 알파벳 한 글자 입력
            alphabet = scan.next().charAt(0);
            // 입력받은 알파벳 존재하면 해당 글자 공개
            for (int i = 0; i < selectedWord.length; i++) {
                if (words[randInt][i] == alphabet && selectedWord[i] == '_') {
                    wordCount++;
                    selectedWord[i] = words[randInt][i];
                }
            }
            // 단어 모든 글자 맞히면 게임 종료
            for (int i = 0; i < selectedWord.length; i++) {
                if (selectedWord[i] != words[randInt][i]) {
                    count2++;
                    break;
                }
            }
            if (count2 == 0) {
                System.out.print("\nClear - 선택된 단어 : ");
                for (int i = 0; i < selectedWord.length; i++) {
                    System.out.print(selectedWord[i]);
                }
                System.out.print(", 총 시도 횟수 : " + count);
                break;
            }
            if (wordCount == 0) {
                // 없으면 "없음" 출력
                System.out.println("\n단어 내 포함되지 않은 알파벳입니다.");
            } else {
                System.out.println("\n입력한 알파벳 단어 내 포함 : " + wordCount + "글자");
            }
        }

    }
}
