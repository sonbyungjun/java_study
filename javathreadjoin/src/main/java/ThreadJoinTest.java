public class ThreadJoinTest extends Thread {

    int no;

    public ThreadJoinTest(int no){
        this.no = no;
    }

    public void run(){
        System.out.println(no+"번 쓰레드 시작");
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(no+"번 쓰레드 종료");
    }

    public static void main(String[] args) {

        for(int i = 0 ; i < 10; i++){
            Thread t = new ThreadJoinTest(i);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("메인 쓰레드 종료");

    }

}
