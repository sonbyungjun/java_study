import java.io.*;

public class CharacterStreamTest {
    public static void main(String[] args) {

        FileInputStream fis = null; // 바이트 기반 인풋 스트림
        InputStreamReader isr = null;


        FileOutputStream fos = null;  // 바이트 기반 아웃풋스트림
        OutputStreamWriter osw = null;
        try {
            fis = new FileInputStream("c:/byungjun/aaa.txt");
            isr = new InputStreamReader(fis); // 바이트단위로 읽어온 스트림을 2바이트로 변환

            fos = new FileOutputStream("c:/byungjun/bbb.txt");
            osw = new OutputStreamWriter(fos);

            char [] buffer = new char[512];
            int readCount = 0;

            while ( (readCount = isr.read(buffer)) != -1 ){ // read(buffer) 는 배열 길이만큼 읽는것
                osw.write(buffer, 0, readCount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
                isr.close();
//                fos.close();
                osw.close();
            }catch (Exception e){

            }
        }
    }
}
