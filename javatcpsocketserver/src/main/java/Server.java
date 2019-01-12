import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

class ChatThread implements Runnable{

    private Socket socket;
    private HashMap<String, Object> onlineUsers;
    private  String id;
    private  BufferedReader br;
    private boolean initFlag = false;

    public ChatThread(Socket socket, HashMap<String, Object> onlineUsers){
        this.socket = socket;
        this.onlineUsers = onlineUsers;

        try {
            // 소켓으로 내뱉는 스트림을 만듬.                          // 1바이트 스트림 아웃풋
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            // 소켓에 있는걸 빨아들이는 스트림을 만듬                         // 1바이트 스트림 인풋
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            id = br.readLine(); // \n \r 만날때까지 읽는다.

            broadCast(id+"님이 접속하셨습니다. "+getTime());
            System.out.println("접속한 사용자의 아이디 : "+id);

            synchronized (onlineUsers){
                //onlineUsers 수정하는 쓰레드를 하나만 접근하도록 막아준다.
                onlineUsers.put(id, pw);
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
            e.printStackTrace();
        }finally {
            synchronized (onlineUsers){
                onlineUsers.remove(id);
            }
            broadCast(id+"님이 퇴장 하셨습니다. "+getTime());
                try {
                    if(socket != null){
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    public void broadCast(String msg){ // 모든 사람들에게 보내는 함수
                                                        // 키(id)를 제외한 값들만 꺼내옴
        Collection onlineUserWriteStreams = onlineUsers.values();
        Iterator iterator = onlineUserWriteStreams.iterator(); // 포문을 돌리기위해 반복자(iterator)를 사용
        while (iterator.hasNext()){ // hasNext는 다음이 있으면 true 없으면 false
            PrintWriter pw = (PrintWriter) iterator.next();  // pw 하나
            pw.println(msg);
            pw.flush(); // 출력 스트림과 버퍼에 있는 내용을 강제로 쓰게 해줌으로 인해서 스트림을 비워준다.
        }
    }

    public void sendMessage(String msg) {
        int recevierStartPoint = msg.indexOf(" ")+1; // 아이디 찾는 문자
        int recevierEndPoint = msg.indexOf(" ",recevierStartPoint);
        if(recevierEndPoint != -1){
            String recevier = msg.substring(recevierStartPoint, recevierEndPoint);
            String realMsg = msg.substring(recevierEndPoint+1);
            if(onlineUsers.get(recevier) != null){
                PrintWriter pw = (PrintWriter) onlineUsers.get(recevier); // 리시버랑 일치하는 스트림을 꺼냄
                pw.println(id + "님이 보낸 귓속말 : " + realMsg);
                pw.flush();
            }
        }
    }

    public String getTime(){
        Date date = new Date(); // 현재시간
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(date);
//        return new SimpleDateFormat("[hh:mm:ss]").format(new Date());
    }


}

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(10001);
            HashMap<String, Object> onlineUsers = new HashMap<String, Object>();
            while (true){
                System.out.println("접속을 기다리는중...");
                Socket socket = serverSocket.accept(); // accept 누가 접속할때까지 대기
                Thread thread = new Thread(new ChatThread(socket, onlineUsers));
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

