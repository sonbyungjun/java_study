import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {

        Map<String, String> human = new HashMap<String, String>();

        human.put("name", "병준");
        human.put("school", "위례중");
//        human.put("age", 12);

        System.out.println(human.get("name"));
        System.out.println(human.get("school"));
        System.out.println(human.get("age"));

        Map<String, String> human2 = new HashMap<String, String>();
        human2.put("name", "병준1");
        human2.put("school", "위례중1");
//        human2.put("age", 15);

        System.out.println(human2.get("name"));
        System.out.println(human2.get("school"));
        System.out.println(human2.get("age"));

        List humans = new ArrayList<HashMap>();
        humans.add(human);
        humans.add(human2);



    }

}
