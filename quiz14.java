import java.time.LocalDateTime;
import java.util.Scanner;

class Student {
    public int id;
    public String name;
    public int gradeKor;
    public int gradeEng;
    public int gradeMath;
    private int sum;
    private float avg;
    public LocalDateTime inputDateTime;

    Student(int argId, String argName) {
        // 학생 ID, 이름 입력
        id = argId;
        name = argName;
        // 현재 날짜 시간 inputDateTime 멤버변수에 저장
        inputDateTime = LocalDateTime.now();
    }

    public void setGrade(int argKor, int argEng, int argMath) {
        // 국어, 영어, 수학 성적 저장
        gradeKor = argKor;
        gradeEng = argEng;
        gradeMath = argMath;
        // 입력 후 합계, 평균 계산해 sum, avg 멤버변수에 저장
        sum = argKor + argEng + argMath;
        avg = (float) (sum / 3.0);
    }

    public int getSum() {
        // 성적 합계 : sum 멤버변수 값 반환
        return sum;
    }

    public float getAvg() {
        // 성적 평균 : avg 멤버변수 값 반환
        return avg;
    }

    public LocalDateTime getInputDateTime() {
        // 입력 날짜 시간 : inputDateTime 멤버변수 값 반환
        return inputDateTime;
    }

    public String toString() {
        LocalDateTime date = getInputDateTime();
        // 데이터 값 출력
        return "[ id : " + id + "name : " + name + "kor : " + gradeKor + "eng : " + gradeEng + "math : " + gradeMath
                + "sum : " + sum + "avg : " + avg + "date : " + date + " ]";
    }
}

class MyList {
    Node head;
    Node tail;
    public int numOfNode;
    public float avg;

    MyList() {
        // head, tail 노드 생성
        tail = new Node(null, null);
        head = new Node(tail, null);
    }

    public int addNode(Student argValue) {
        // 입력 데이터를 리스트 제일 끝에 추가
        Node temp = head;
        while (temp.getNextNode() != tail) {
            temp = temp.getNextNode();
        }
        Node newNode = new Node(tail, argValue);
        temp.setNextNode(newNode);
        return numOfNode += 1;
    }

    public int getSize() {
        // 리스트 내 데이터 수
        return numOfNode;
    }

    public float getAvg() {
        // 평균 값 : 리스트 내 모든 Student 객체 각 평균값에 대한 전체 평균값
        Node temp = head;
        numOfNode = getSize();
        int sum = 0;

        while (temp.getNextNode() != tail) {
            sum += temp.getValue().getAvg();
            temp = temp.getNextNode();
        }

        return avg = (float) (sum / numOfNode);
    }

    public String toString() {
        // 리스트 내 모든 Student 객체 값 출력
        Node temp = head;
        String allValues = "";

        while (temp.getNextNode() != tail) {
            allValues += temp.getValue().toString();
            temp = temp.getNextNode();
            allValues += "\n";
        }
        return allValues;
    }
}

class Node {
    Node nextNode;
    Student value;

    Node(Node argNextNode, Student argValue) {
        nextNode = argNextNode;
        value = argValue;
    }

    Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node argNode) {
        nextNode = argNode;
    }

    Student getValue() {
        return value;
    }
}

public class quiz14 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("1. 학생 성적 입력");
            System.out.println("2. 학생 목록 출력(입력 순)");
            System.out.println("3. 프로그램 종료");
            int menu = scan.nextInt();

            if (menu == 1) {
                System.out.println("학번을 입력하세요");
                int id = scan.nextInt();
                System.out.println("이름을 입력하세요");
                String name = scan.next();
                Student stn = new Student(id, name);
            }
        }
    }
}
