public class quiz09_3 {
    public static void main(String[] args) {
        int index = indexOf(new String("abcdefg").toCharArray(), new String("cde").toCharArray());

        System.out.println(index);
    }

    public static int indexOf(char arg1[], char arg2[]) {
        int index = -1;
        // arg1 : 검색 대상 문자열
        // arg2 : 찾을 문자열
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

        // arg1에서 arg2 문자열 찾을 경우 시작 인덱스 값 리턴

        // 찾는 문자열 없을 경우 -1
        return index;
    }
}
