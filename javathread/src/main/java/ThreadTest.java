public class ThreadTest extends Thread {

    int no; // 스레드 고유 번호

    public ThreadTest(int no){
        this.no = no;
    }

    @Override
    public void run() {
        System.out.println(no+"번 쓰레드 시작");
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(no+"번 쓰레드 종료");
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10 ; i++){
            Thread t = new ThreadTest(i);
            t.start();
        }

        System.out.println("메인 쓰레드 종료");
    }
}
