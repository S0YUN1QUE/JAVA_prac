public class quiz09_1 {
    public static void main(String[] args) {
        char value1[] = { 'h', 'e', 'l', 'l', 'o' };
        char value2[] = { ' ', 'w', 'o', 'r', 'l', 'd' };

        char values[] = concatenate(value1, value2);

        System.out.println(values);
    }

    public static char[] concatenate(char arg1[], char arg2[]) {
        // arg1 + arg2 결과 값 반환 메서드
        char argValues[] = new char[arg1.length + arg2.length];
        for (int i = 0; i < argValues.length; i++) {
            if (i < arg1.length) {
                argValues[i] = arg1[i];
            } else {
                argValues[i] = arg2[i - arg1.length];
            }
        }
        return argValues;
    }
}
