interface EngineBracket {
    boolean startEngine();

    boolean stopEngine();

    int acceleration();

    int deceleration();
}

class BEngine implements EngineBracket {
    int currentVelocity = 0;
    boolean isEngineOn = false;

    public boolean startEngine() {
        if (isEngineOn == false) {
            System.out.println("엔진 시동");
            isEngineOn = true;
        } else {
            System.out.println("엔진 동작 중, 명령 무시");
        }
        return isEngineOn;
    }

    public boolean stopEngine() {
        if (isEngineOn == true) {
            System.out.println("엔진 정지");
            isEngineOn = false;
        } else {
            System.out.println("엔진 정지 상태, 명령 무시");
        }
        return isEngineOn;
    }

    public int acceleration() {
        return currentVelocity += 1;
    }

    public int deceleration() {
        if (currentVelocity == 0) {
            return currentVelocity;
        } else {
            return currentVelocity -= 1;
        }
    }
}

class HCar extends BEngine {
    EngineBracket myEngine;

    public HCar(EngineBracket argEngine) {
        myEngine = argEngine;
    }

    boolean engineOn() {
        return startEngine();
    }

    boolean engineOff() {
        return stopEngine();
    }

    int speedUp() {
        return acceleration();
    }

    int speedDown() {
        return deceleration();
    }
}

public class quiz12 {
    public static void main(String[] args) {
        HCar myCar = new HCar(new BEngine());

        myCar.engineOff();
        myCar.engineOn();
        System.out.println("Speed up : " + myCar.speedUp());
        System.out.println("Speed up : " + myCar.speedUp());
        System.out.println("Speed down : " + myCar.speedDown());
        System.out.println("Speed down : " + myCar.speedDown());
        System.out.println("Speed down : " + myCar.speedDown());
        myCar.engineOn();
        myCar.engineOff();
    }
}
