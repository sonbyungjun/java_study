import java.io.*;
import java.net.Socket;

class InputThread implements Runnable{

    private Socket socket;
    private BufferedReader br;

    public InputThread(Socket socket, BufferedReader br){
        this.socket = socket;
        this.br = br;
    }

    public void run() {
        String line;
        try {
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

public class Client {
    public static void main(String[] args) {

        int id = (int) (Math.random() * 10 * 50);
        Socket socket = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        boolean endFlg = false;

        try {
            socket = new Socket("localhost",10001);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            pw.println(id +"님");
            pw.flush();

            Thread thread = new Thread(new InputThread(socket,br));
            thread.start();

            String line = null;
            while ((line = keyboard.readLine()) != null){
                pw.println(line);
                pw.flush();
                if(line.equals("/quit")){
                    endFlg = true;
                    break;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(pw != null){
                    pw.close();
                }
                if(br != null){
                    br.close();
                }
                if(socket != null){
                    socket.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
