public class quiz7_1 {
    public static void main(String[] args) {
        // 정수형 5x5 2차원 배열 선언
        int array[][] = new int[5][5];

        // 2차원 배열 내 1~50 사이 난수 저장
        // 1차원 배열에서 중복 제거
        int tempArray[] = new int[25];
        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = (int) ((Math.random() * 50) + 1);
            for (int j = 0; j < i; j++) {
                if (tempArray[i] == tempArray[j]) {
                    i--;
                }
            }
        }
        // 2차원 배열에 난수 저장
        int tempIndex = 0;
        // 데이터 크기 순 배열
        int temp = 0;
        for (int i = 0; i < tempArray.length; i++) {
            for (int j = 0; j < tempArray.length; j++) {
                if (i < j && tempArray[i] > tempArray[j]) {
                    temp = tempArray[i];
                    tempArray[i] = tempArray[j];
                    tempArray[j] = temp;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = tempArray[tempIndex++];
            }
        }

        System.out.println("\t\t\t\t\t최소값\t최대값\t중간값");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.print(array[i][0] + "\t" + array[i][2] + "\t" + array[i][4]);
            System.out.println();
        }
        // 행 최대, 최소, 중간값 출력
        System.out.println();
        System.out.print("최소값\t");
        for (int i = 0; i < array[0].length; i++) {
            System.out.print(array[0][i] + "\t");
        }
        System.out.println();
        System.out.print("최대값\t");
        for (int i = 0; i < array[4].length; i++) {
            System.out.print(array[4][i] + "\t");
        }
        System.out.println();
        System.out.print("중간값\t");
        for (int i = 0; i < array[2].length; i++) {
            System.out.print(array[2][i] + "\t");
        }

        // 5x5 차원 배열 기준 최대, 최소, 중간 값 출력
        System.out.println();
        System.out.println();
        System.out.println("최소값\t" + array[0][0]);
        System.out.println("최대값\t" + array[4][4]);
        System.out.println("중간값\t" + array[2][2]);
    }
}
