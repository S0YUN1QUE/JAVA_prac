public class quiz4_1 {
    public static void main(String[] args) {
        // 구구단 출력
        for (int i = 1; i <= 9; i++) {
            if (i % 2 == 0) { // 짝수단만 출력
                for (int j = 1; j <= 9; j++) {
                    System.out.print(i + "X" + j + "=" + i * j + "\t");
                    if (j % 3 == 0) { // 가로 한 줄에 3개씩 배치
                        System.out.println();
                    }
                }
                System.out.println();
            }
        }
    }
}