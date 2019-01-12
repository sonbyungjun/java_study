import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainTest {
    public static void main(String[] args) {

        String[] user = {"aaa", "aaa", "aaa"};
        String[] user1 = {"bbb", "bbb", "bbb"};
        String[] user2 = {"ccc", "ccc", "ccc"};
        String[] user3 = {"ddd", "ddd", "ddd"};

        String[] list = {};

        int a = 3;

        String name = "손병준";

        boolean b = true;

        char c = 'a';

        double d = 0.2024;

        int[] e = {1,2,3,4};

        String[] f = {"aa", "aa", "aa"};

        String[][] g = {
            {"aaa", "aaa", "aaa"},
        };

        String[][] asd = new String[3][3];

//        {
//            {"aaa","aaa","aaa"},
//            {"bbb","bbb","bbb"},
//            {"ccc","ccc","ccc"}
//        }
//
//        asd[2][2];

        asd[0][0] = "aaa";
        asd[0][1] = "aaa";
        asd[0][2] = "aaa";

        asd[1][0] = "bbb";
        asd[1][1] = "bbb";
        asd[1][2] = "bbb";

        asd[2][0] = "ccc";
        asd[2][1] = "ccc";
        asd[2][2] = "ccc";

//        for(int i = 0; i < asd.length; i++){
//            for(int j = 0; j< asd[i].length; j++){
//                System.out.println(asd[i][j]);
//            }
//        }

        String[] gg = new String[4];

        Map<String, String> aaa = new HashMap<String, String>();

        aaa.put("id", "aaa");
        aaa.put("pw", "aaa");
        aaa.put("name", "aaa");

        System.out.println(aaa.get("id"));

        Map<String[], String[]> cccc = new HashMap<String[], String[]>();

        String[]Map<String, String> sagfs = new String[]Map<String, String>;

//        문자열배열을 배열에 넣는것 String[][]
//        String[] => []
        Map<String, String>[] gggg = new Map[]{
                aaa,
                new HashMap(),
        };

        String[][] aaaaa = ;

//        for(int i = 0; i < list.size(); i++){
//            for(int j = 0; j < user.length; j++) {
//                System.out.println(list.get(i));
//            }
//        }

    }
}
