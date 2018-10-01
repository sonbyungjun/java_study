import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileintputStreamTest {
    public static void main(String[] args) {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:/byungjun/aaa.txt");
            int data = 0;

            while ((data = fis.read()) != -1 ){ // 파일을 읽은 것이 더이상 없으면 -1 을 반환 data에 byte단위로 저장됨.
                System.out.write(data); // 숫자를 문자로 표현
                System.out.println("?");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {  // 성공이든 실패든 오는 부분
            try {
                fis.close();  // 스트림 이 열려있으니 닫음.
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
