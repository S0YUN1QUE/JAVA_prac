import java.util.Scanner;

public class quiz3_2 {
    public static void main(String[] args) {
        // 학생 성적 2차원 배열 생성
        int[][] scores = new int[5][8];
        // 메뉴 출력
        System.out.println("--------------------");
        System.out.println("1. 성적 입력");
        System.out.println("2. 전체 성적 출력 (평균 기준 내림차순");
        System.out.println("3. 학생 조회 후 출력");
        System.out.println("4. 종료");
        System.out.println("--------------------");

        // 사용자 입력 받기
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴 선택 : ");
        int menu = sc.nextInt();

        while (true) {
            if (menu == 1) {
                System.out.println("학번을 입력하세요 : ");
                int stnNum = sc.nextInt();
                System.out.println("국어 성적을 입력하세요 : ");
                int korean = sc.nextInt();
                System.out.println("영어 성적을 입력하세요 : ");
                int english = sc.nextInt();
                System.out.println("수학 성적을 입력하세요 : ");
                int math = sc.nextInt();
                int sum = korean + english + math;
                int avg = sum / 3;
                System.out.println("입력 값 :");
                System.out.println("학번 : " + stnNum + "국어 : " + korean + "영어 : " + english + "수학 : " + math + "총점 : "
                        + sum + "평균 : " + avg);
            }
        }

        // 1. 성적 입력
        // 기존 값이 있을 때 재입력

        // 2. 전체 성적 출력
        // 평균 기준 내림차순
        // 순위 구하기

        // 사용자 입력 받기 - 3. 학생 조회 후 출력
        // 학번 올바른지 검사
        // 성적 출력
        // 재입력 - 3회 이상 반복 시 메뉴

        // 사용자 입력 받기 - 4. 프로그램 종료
    }
}
