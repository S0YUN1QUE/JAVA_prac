public class quiz09_4 {
    public static void main(String[] args) {
        char result[] = replace(new String("abcdefg").toCharArray(), new String("cde").toCharArray(),
                new String("k").toCharArray());

        System.out.println(result);
    }

    public static char[] replace(char arg1[], char arg2[], char arg3[]) {
        int index = -1;
        // arg1 : 검색 대상 문자열
        // arg2 : 찾을 문자열
        // arg3 : 바꿀 문자열
        if (arg1.length > arg2.length) {
            int compare[] = new int[arg2.length];
            for (int i = 0; i < arg1.length; i++) {
                if (arg1[i] == arg2[0]) {
                    index = i;
                    for (int j = 0; j < arg2.length; j++) {
                        if (arg1[i + j] != arg2[j]) {
                            index = -1;
                            break;
                        } else {
                            compare[j] = arg1[i + j];
                        }
                    }
                }
            }

            if (index != -1) {
                for (int i = 0; i < compare.length; i++) {
                    if (compare[i] != arg2[i]) {
                        index = -1;
                        break;
                    }
                }
            }
        }

        // arg1에서 arg2 문자열 찾은 경우 문자열을 arg3로 치환
        if (index == -1) {
            // 찾는 문자열 없을 경우 arg1 값 반환
            return arg1;
        } else {
            char argValues[] = new char[(arg1.length - arg2.length) + arg3.length];
            for (int i = 0; i < argValues.length; i++) {
                argValues[i] = '0';
            }
            for (int i = 0; i < argValues.length; i++) {
                if (i < index) {
                    argValues[i] = arg1[i];
                } else if (i >= index && i - index < arg3.length) {
                    argValues[i] = arg3[i - index];
                } else {
                    argValues[i] = arg1[(i + arg2.length) - 1];
                }
            }

            return argValues;
        }

    }
}
