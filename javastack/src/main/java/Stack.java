public class Stack {

    public static void method1(int a){
        a = a + 1;
        method2(a);
        System.out.println("method1 실행완료 : " + a);
    }

    private static void method2(int a) {
        a = a + 1;
        method3(a);
        System.out.println("method2 실행완료 : " + a);
    }

    private static void method3(int a) {
        a = a + 1;
        System.out.println("method3 실행완료 : " + a);
    }

    public static void main(String[] args) {

        int a = 20; // 지역변수
        method1(a);
        System.out.println("메인메소드 실행완료 : " + a);

    }
}

