import java.util.ArrayList;

public class List {
    public static String[] list1 = new String[3];
    public static ArrayList<String> list2 = new ArrayList<String>();
    public static void main(String[] args) {

        String[] arr = {"dsf","fdf","dfd"};
        String[] arr1 = new String[3]; // 빈공간


        list1[0] = "손병준";
        list1[1] = "손병준1";
        list1[2] = "손병준2";

        printArrayAll(list1);


        list2.add("손병준");
        list2.add("손병준2");
        list2.add("손병준3");
//        list2.add(20);
        list2.set(0, "김병준");

        printListAll(list2);
    }

    public static void printArrayAll(String[] list1){
        for(int i = 0; i < list1.length; i++){
            System.out.println(list1[i]);
        }
    }

    public static void printListAll(ArrayList list2){
        for(int i = 0; i < list2.size(); i++){
            System.out.println(list2.get(i));
        }
    }
}
