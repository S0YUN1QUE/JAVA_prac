import java.util.Scanner;

interface Stock {
    // 차량 ID값 출력, 리스트에 저장될 때 1씩 증가
    int getID();

    // 차종 구분
    String getType();

    // 제품명
    String getProductName();

    // 제품 색상
    String getProductColor();

    // 제품 가격
    int getProductPrice();
}

class StockMngr {
    // 중고차 저장 리스트
    Stock stock_list[];
    int id = 0;

    public StockMngr(int argStockBucketSize) {
        stock_list = new Stock[argStockBucketSize];
    }

    // 중고차 리스트에 저장, 반환값은 현재 저장 중고차 수
    int insertStock(Stock argStock) {
        stock_list[id] = argStock;
        return id += 1;
    }

    void printStockList() {

    }

    void printStockList(String argType) {

    }
}

class Cars implements Stock {
    public int id;
    public String type, name, color;
    public int price;

    public int getID() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getProductName() {
        return name;
    }

    public String getProductColor() {
        return color;
    }

    public int getProductPrice() {
        return price;
    }
}

class SUV extends Cars {
    public int suvID() {
        return getID();
    }

    public String getType() {
        return "SUV";
    }

    public String suvName() {
        return getProductName();
    }

    public String suvColor() {
        return getProductColor();
    }

    public int suvPrice() {
        return getProductPrice();
    }
}

class Sedan extends Cars {
    public int sedanID() {
        return getID();
    }

    public String getType() {
        return "SUV";
    }

    public String sedanName() {
        return getProductName();
    }

    public String sedanColor() {
        return getProductColor();
    }

    public int sedanPrice() {
        return getProductPrice();
    }
}

class Sorento extends SUV {
    Sorento(int argPrice, String argColour) {
        name = "Sorento";
        price = argPrice;
        color = argColour;
    }
}

class GV80 extends SUV {
    GV80(int argPrice, String argColour) {
        name = "GV80";
        price = argPrice;
        color = argColour;
    }
}

class EV6 extends Sedan {
    EV6(int argPrice, String argColour) {
        name = "EV6";
        price = argPrice;
        color = argColour;
    }
}

class G90 extends Sedan {
    G90(int argPrice, String argColour) {
        name = "G90";
        price = argPrice;
        color = argColour;
    }
}

public class CarStockManagementProg {
    static StockMngr myStock;

    public CarStockManagementProg() {
        myStock = new StockMngr(10);
    }

    public static void main(String[] args) {
        String type, name, colour;
        int price, menu;
        SUV suv = new SUV();
        Sedan sedan = new Sedan();

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("1. 자동차 입력");
            System.out.println("2. 전체 자동차 목록 출력 : 입력 순서로 출력");
            System.out.println("3. SUV 자동차 목록 출력");
            System.out.println("4. SEDAN 자동차 목록 출력");
            System.out.println("5. 프로그램 종료");
            menu = scan.nextInt();

            if (menu == 1) {
                System.out.print("차종 : ");
                type = scan.next();
                System.out.print("차명 : ");
                name = scan.next();
                System.out.print("가격 : ");
                price = scan.nextInt();
                System.out.print("색깔 : ");
                colour = scan.next();
                insertCar(type, name, price, colour);
            } else if (menu == 2) {
                myStock.printStockList();
            } else if (menu == 3) {
                myStock.printStockList(suv.getType());
            } else if (menu == 4) {
                myStock.printStockList(sedan.getType());
            } else if (menu == 5) {
                System.out.println("프로그램 종료");
                break;
            }
        }
    }

    static int insertCar(String argType, String argName, int argPrice, String argColor) {
        if (argName.equals("Sorento")) {
            Sorento sorento = new Sorento(argPrice, argColor);
            return myStock.insertStock(sorento);
        } else if (argName.equals("GV80")) {
            GV80 gv80 = new GV80(argPrice, argColor);
            return myStock.insertStock(gv80);
        } else if (argName.equals("EV6")) {
            EV6 ev6 = new EV6(argPrice, argColor);
            return myStock.insertStock(ev6);
        } else {
            G90 g90 = new G90(argPrice, argColor);
            return myStock.insertStock(g90);
        }

    }
}