public class Classvar {
    public static void main(String[] args) {

        User son1 = new User();
        User son2 = new User();

        son1.setName("손병준");
        son2.setName("손유빈");

        son1.pay(5);
        System.out.println(User.account);

        son2.pay(50);
        System.out.println(User.account);
    }

}


class User{
    //멤버변수 : 클래스안에 있는 변수
    //멤버변수 종류 : 클래스 변수(static) , 인스턴스 변수(static X)

//    String name; // 인스턴스 변수
//
//    static String type = "ㅇㅇㅇ사이트에서 가입한사람"; // 인스턴스에서 스태틱 변수는 접근이 불가능
//
//    public void setName(String name){  // 인스턴스 메소드
//        this.name = name;
//    }
//
//    }

    static int account = 100;
    String name;

    public void setName(String name){
        this.name = name;
    }

    public void pay(int pay){
        System.out.println(name + "이" + pay + "원 사용");
        account = account - pay;
    }


}