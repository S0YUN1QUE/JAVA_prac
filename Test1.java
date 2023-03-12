interface EngineBracket {
    boolean startEngine();

    boolean stopEngine();

    int accerleration();

    int decelaration();
}

class BEngine implements EngineBracket {
    int currentVelocity = 0;
    boolean isEngineOn = false;

    @Override
    public boolean startEngine() {
        if (isEngineOn == false) {
            System.out.println("엔진 시동");
            return isEngineOn = true;
        } else {
            System.out.println("엔진 동작 중, 명령 무시");
            return false;
        }
    }

    @Override
    public boolean stopEngine() {
        if (isEngineOn == true) {
            System.out.println("엔진 정지");
            return isEngineOn = false;
        } else {
            System.out.println("엔진 정지 상태, 명령 무시");
            return true;
        }
    }

    @Override
    public int accerleration() {
        return ++currentVelocity;
    }

    @Override
    public int decelaration() {
        if (currentVelocity == 0) {
            return 0;
        } else {
            return --currentVelocity;
        }
    }
}

class HCar {
    HCar(EngineBracket argEngine) {
        myEngine = argEngine;
    }

    EngineBracket myEngine;

    void engineOn() {
        myEngine.startEngine();
    }

    void engineOff() {
        myEngine.stopEngine();
    }

    int speedUp() {
        return myEngine.accerleration();
    }

    int speedDown() {
        return myEngine.decelaration();
    }
}

public class Test1 {
    public static void main(String[] args) {
        HCar myCar = new HCar(new BEngine());

        myCar.engineOff(); // 엔진 정지 상태, 명령 무시
        myCar.engineOn(); // 엔진 시동
        System.out.println("Speed up : " + myCar.speedUp()); // Speed up : 1
        System.out.println("Speed up : " + myCar.speedUp()); // Speed up : 2
        System.out.println("Speed down : " + myCar.speedDown()); // Speed down : 1
        System.out.println("Speed down : " + myCar.speedDown()); // Speed down : 0
        System.out.println("Speed down : " + myCar.speedDown()); // Speed down : 0
        myCar.engineOn(); // 엔진 동작 중, 명령 무시
        myCar.engineOff(); // 엔진 정지
    }
}
