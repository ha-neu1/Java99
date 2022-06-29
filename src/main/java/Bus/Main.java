package Bus;

import jdk.jshell.Snippet;

class Bus {
    int maxpassenger = 10; //최대 승객 수
    int nowpassenger = 0; //현재 승객 수
    int fare; //요금
    int busnum; //버스 번호
    int refuel = 12; //주유량
    int nowspeed; //현재 속도
    int acceleration = 0; //가속도
    String status = "운행"; //버스 상태

    //버스 번호 생성
    Bus() {
        this.busnum = (int) (Math.random() * 1000 + 1);
        System.out.println("버스 번호 : " + busnum);
    }

    boolean isLeftGas() {
        return refuel >= 10;
    }

    boolean isOnMove() {
        return maxpassenger >= nowpassenger;
    }

    //버스 상태 변경
    boolean run() {
        if (isLeftGas()) {
            System.out.println(status + "주유량: " + refuel);
            refuel -= 2;
            return true;
        }
        if (!isLeftGas()) {
            status ="차고지행";
            System.out.println("주유가 필요하다.");
        }
        return true;
    }

    //승객 탑승
    int inPassenger(int passenger) {
        nowpassenger += passenger;
        while (isOnMove()) {
            if (status.equals("운행")) {
                System.out.println("탑승한 승객: " + passenger + " 현재 승객 수: " + nowpassenger);
            }
            break;
        }
        if (!isOnMove()) {
            System.out.println(nowpassenger-maxpassenger + " 명이 초과");

        }
        return nowpassenger;
    }

    //속도 변경
    int changeSpeed(int acceleration) {
        this.acceleration = acceleration;

        if (isLeftGas()) {
            nowspeed += acceleration;
        }
        System.out.println("현재 속도: " + nowspeed);
        return nowspeed;
    }



}


public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus();


        System.out.println(bus.status);
        bus.inPassenger(3);
        bus.run();
        bus.changeSpeed(20);
        bus.changeSpeed(-20);

        System.out.println(bus.status);
        bus.inPassenger(1);
        bus.run();
        bus.changeSpeed(30);
        bus.changeSpeed(-30);

        System.out.println(bus.status);
        bus.inPassenger(1);
        bus.run();
        bus.changeSpeed(40);
        bus.changeSpeed(-40);

    }
}