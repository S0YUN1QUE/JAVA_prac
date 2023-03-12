import java.util.Scanner;

class MyException extends Exception {
    static final int LESS = 1;
    static final int OVER = 2;
    private int errorCode = 0;

    MyException(String argMsg, int argCode) {
        // 예외 메시지, 예외 코드 저장 구현
        super(argMsg);
        errorCode = argCode;
    }

    int getExceptionCode() {
        // 예외 코드 반환 : errorCode
        return errorCode;
    }
}

class MyConsoleInput {
    // argFrom 이상, argTo 이하 값 입력 후 반환
    static int getInputValue(int argFrom, int argTo) throws MyException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        if (n < argFrom) {
            throw new MyException(argFrom + "보다 큰 수를 입력하세요", MyException.LESS);
        } else if (n > argTo) {
            throw new MyException(argTo + "보다 작은 수를 입력하세요", MyException.OVER);
        }
        return n;
    }
}

public class quiz13 {
    public static void main(String[] args) {
        while (true) {
            try {
                int inputValue = MyConsoleInput.getInputValue(2, 9);
                for (int i = 1; i <= 9; i++) {
                    System.out.println(inputValue + " X " + i + " = " + inputValue * i);
                }
                break;
            } catch (MyException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Undefined exception, Get the input value again");
            }
        }
    }
}
