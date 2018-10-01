import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

class ChatThread implements Runnable{

    private Socket socket;
    private HashMap<String, Object> hm;
    private  String id;
    private  BufferedReader br;
    private boolean initFlag = false;

    public ChatThread(Socket socket, HashMap<String, Object> hm){
        this.socket = socket;
        this.hm = hm;

        try {
            // 소켓으로 내뱉는 스트림을 만듬.                          // 1바이트 스트림 아웃풋
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            // 소켓에 있는걸 빨아들이는 스트림을 만듬                         // 1바이트 스트림 인풋
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            id = br.readLine(); // \n \r 만날때까지 읽는다.

            broadCast(id+"님이 접속하셨습니다. "+getTime());
            System.out.println("접속한 사용자의 아이디 : "+id);

            synchronized (hm){
                //hm을 수정하는 쓰레드를 하나만 접근하도록 막아준다.
                hm.put(id, pw);
            }
            initFlag = true;


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        String line =  null;
        try {
            while ((line = br.readLine()) != null) {
                if(line.equals("/quit")){
                    break;
                }
                if(line.indexOf("/to") == 0){
                    sendMessage(line);
                }else {
                    broadCast(id+" : "+line);
                }
            }
        }catch (Exception e){

        }



    }
}

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(10001);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
