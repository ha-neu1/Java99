package Taxi;

class Taxi {
    //  필드
    int taxinum; //택시 번호
    int refuel = 15; //주유량
    int nowspeed = 0; //현재속도
    int basicDistance = 5; //기본 거리
    int distanceToDestination; //목적지까지 거리
    int basicFare = 2800; //기본 요금
    int fare = 500; //거리당 요금

    String drivable = "일반"; //택시 상태

    //택시 번호 생성
    Taxi() {
        this.taxinum = (int) (Math.random() * 1000 + 1);
        System.out.println("택시 번호: " + taxinum);
        isDrivable();
    }

    //택시 상태
    boolean isDrivable() {
        if (refuel >= 10) {
            System.out.println("운행 가능");
            return true;
        } else {
            System.out.println("운행 불가능");
            return false;
        }
    }

    boolean run() {
        if (isDrivable() && drivable.equals("일반")) {
            drivable = "운행 중";
        } else {
            drivable = "탑승 불가";
        }
        return false;
    }

    //속도 변경
    void changeSpeed(int acceleration) {
        if (drivable.equals("운행 중")) {
            nowspeed += acceleration;
            System.out.println("현재 속도: " + nowspeed);
        }
    }

    //택시 요금
    int isFareTo(int distanceToDestination) {
        this.distanceToDestination = distanceToDestination;
        if (distanceToDestination > basicDistance) {
            basicFare += (distanceToDestination - basicDistance) * fare;
        } else {
            return basicFare;
        }
        System.out.println("최종 요금: " + basicFare);
        return basicFare;
    }
}

public class Main {
    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        taxi.run();
        taxi.changeSpeed(20);
        taxi.changeSpeed(50);
        taxi.isFareTo(10);
    }
}