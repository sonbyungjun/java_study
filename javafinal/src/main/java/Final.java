public class Final {


    public static void main(String[] args) {
        User user1 = new Man();
        System.out.println(user1.bornYear);
        user1.printBornYear();
        user1.printBornYear2();
    }
}

final class User{ // 상수 클래스가 되면 상속이 안된다.

    final int bornYear = 2018; // 상수

    public final void printBornYear(){  // 상수 메소드는 오버라이드가 안됨.
        System.out.println(bornYear+"년도 출생");
    }

    public void printBornYear2(){
        System.out.println(bornYear+"년도 출생 입니다.");
    }
}


class Man extends User{

    char gender = 'M';

    @Override
    public void printBornYear2() {
        System.out.println(bornYear+"년도 출생 입니다."+ gender + " 입니다.");
    }


}