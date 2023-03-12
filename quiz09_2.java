public class quiz09_2 {
    public static void main(String[] args) {
        boolean result = compareTo(new String("문자열1").toCharArray(), new String("문자열2").toCharArray());

        System.out.println(result ? "같음" : "다름");
    }

    public static boolean compareTo(char arg1[], char arg2[]) {
        boolean compare = true;
        // arg1, arg2 문자열 비교
        if (arg1.length != arg2.length) {
            compare = false;
        } else {
            for (int i = 0; i < arg1.length; i++) {
                if (arg1[i] != arg2[i]) {
                    compare = false;
                    break;
                }
            }
        }

        // 일치 -> 참, 아니면 거짓 반환
        return compare;
    }
}
