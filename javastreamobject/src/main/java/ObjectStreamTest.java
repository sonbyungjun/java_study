import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Human implements Serializable { // 객체를 보낼땐 마샬링이 필요함.
    String name;
    String gender;

    public Human(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }
}

public class ObjectStreamTest {
    public static void main(String[] args) {

        List<Human> humans = new ArrayList<Human>();
        humans.add(new Human("손병준","남"));
        humans.add(new Human("손유빈","남"));

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("C:/byungjun/data.txt");
            oos = new ObjectOutputStream(fos);

            oos.writeObject(humans);
            oos.reset();

        }catch (Exception e){
            try {
                if(oos != null){
                    oos.close(); // 반대로 닫기
                }
                if(fos != null){
                    fos.close();
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
