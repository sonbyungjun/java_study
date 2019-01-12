import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Human{
    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void print(){
        System.out.println(this.name+"의 나이는"+this.age+"입니다.");
    }
}

public class MainTest {
    public static void main(String[] args) {


        ArrayList<Object> cls = new ArrayList<Object>();

        Human human1 = new Human("병준1", 30);
        Human human2 = new Human("병준2", 31);
        Human human3 = new Human("병준3", 32);

        cls.add(human1);
        cls.add(human2);
        cls.add(human3);

        for(int i = 0; i < cls.size();i++){
            System.out.println(cls.get(i));
        }
    }
}
