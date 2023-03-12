import java.util.Scanner;

public class quiz7_2 {
    public static void main(String[] args) {
        // 16진수 값 입력 (최대 20자)
        Scanner scn = new Scanner(System.in);
        char hexa[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'A', 'B',
                'C', 'D', 'E', 'F' };
        String input = scn.next();
        char buffer[];
        char tempArr[];
        while (true) {
            // 조건 안 맞는 값 -> 재입력
            if (input.length() > 20) {
                System.out.println("최대 20자까지 입력할 수 있습니다. 재입력 하세요.");
                input = scn.next();
            }
            // 입력값 검사 - 유효범위(숫자 0-9 문자 a-f)
            buffer = new char[input.length()];
            tempArr = new char[input.length()];
            input.getChars(0, input.length(), buffer, 0);
            for (int i = 0; i < buffer.length; i++) {
                for (int j = 0; j < hexa.length; j++) {
                    if (buffer[i] == hexa[j]) {
                        tempArr[i] = buffer[i];
                    }
                }
            }
            // 조건 안 맞는 값 -> 재입력
            for (int i = 0; i < tempArr.length; i++) {
                if (tempArr[i] != buffer[i]) {
                    System.out.println("유효하지 않은 16진수입니다. 재입력 하세요.");
                    System.out.println();
                    input = scn.next();
                    break;
                } else {
                    input = "";
                }
            }
            if (input == "") {
                break;
            }
        }

        // 2진수, 8진수, 10진수 변환
        int hexArr[] = new int[buffer.length];
        // char형을 int형으로 변환
        for (int i = 0; i < buffer.length; i++) {
            switch (buffer[i]) {
                case '1':
                    hexArr[i] = 1;
                    break;
                case '2':
                    hexArr[i] = 2;
                    break;
                case '3':
                    hexArr[i] = 3;
                    break;
                case '4':
                    hexArr[i] = 4;
                    break;
                case '5':
                    hexArr[i] = 5;
                    break;
                case '6':
                    hexArr[i] = 6;
                    break;
                case '7':
                    hexArr[i] = 7;
                    break;
                case '8':
                    hexArr[i] = 8;
                    break;
                case '9':
                    hexArr[i] = 9;
                    break;
                case 'a':
                    hexArr[i] = 10;
                    break;
                case 'b':
                    hexArr[i] = 11;
                    break;
                case 'c':
                    hexArr[i] = 12;
                    break;
                case 'd':
                    hexArr[i] = 13;
                    break;
                case 'e':
                    hexArr[i] = 14;
                    break;
                case 'f':
                    hexArr[i] = 15;
                    break;
                case 'A':
                    hexArr[i] = 10;
                    break;
                case 'B':
                    hexArr[i] = 11;
                    break;
                case 'C':
                    hexArr[i] = 12;
                    break;
                case 'D':
                    hexArr[i] = 13;
                    break;
                case 'E':
                    hexArr[i] = 14;
                    break;
                case 'F':
                    hexArr[i] = 15;
                    break;
            }
        }
        // 10진수 변환
        int decArr[] = new int[hexArr.length];
        for (int i = 0; i < hexArr.length; i++) {
            decArr[i] = hexArr[i];
        }
        int decimal = 0;
        for (int i = 0; i < decArr.length; i++) {
            if (i != decArr.length - 1) {
                for (int j = i; j < decArr.length - 1; j++) {
                    decArr[i] *= 16;
                }
            }
            decimal += decArr[i];
        }
        // 2진수 변환
        String bin = "";
        int tempNum = decimal;
        while (true) {
            if (tempNum % 2 == 0) {
                bin += "0";
            } else {
                bin += "1";
            }
            tempNum = tempNum / 2;
            if (tempNum == 1) {
                bin += "1";
                break;
            }
        }
        char binChar[] = new char[bin.length()];
        bin.getChars(0, bin.length(), binChar, 0);
        char tempChar = '0';
        for (int i = 0; i < binChar.length / 2; i++) {
            tempChar = binChar[i];
            binChar[i] = binChar[binChar.length - 1 - i];
            binChar[binChar.length - 1 - i] = tempChar;
        }
        // 8진수로
        int oct[];
        tempNum = decimal;
        if (binChar.length % 3 == 0) {
            oct = new int[binChar.length / 3];
        } else if (binChar.length % 3 == 1) {
            oct = new int[(binChar.length + 2) / 3];
        } else {
            oct = new int[(binChar.length + 1) / 3];
        }
        for (int i = 0; i < oct.length; i++) {
            if (tempNum % 8 == 0) {
                oct[i] = 0;
            } else {
                oct[i] = tempNum % 8;
            }
            tempNum = tempNum / 8;
            if (tempNum < 8) {
                oct[i + 1] = tempNum;
                break;
            }
        }
        for (int i = 0; i < oct.length / 2; i++) {
            tempNum = oct[i];
            oct[i] = oct[oct.length - 1 - i];
            oct[oct.length - 1 - i] = tempNum;
        }
        // 출력
        System.out.print("이진수 : ");
        for (int i = 0; i < binChar.length; i++) {
            System.out.print(binChar[i]);
        }
        System.out.println();
        System.out.print("팔진수 : ");
        for (int i = 0; i < oct.length; i++) {
            System.out.print(oct[i]);
        }
        System.out.println();
        System.out.print("십진수 : " + decimal);
    }
}
