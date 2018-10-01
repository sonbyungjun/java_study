import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IteratorTest {

    public static void main(String[] args) {

        Map map1 = new HashMap();
        map1.put("이름","손병준");
        map1.put("성별","남");
        map1.put("나이","12");
        map1.put("직업","경찰");

        Iterator it = map1.entrySet().iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
