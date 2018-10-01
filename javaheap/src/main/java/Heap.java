public class Heap {

    private static int[] method1(int a) {
        int[] arr = method2(a + 1);
        arr[2] = a;
        return arr;
    }

    private static int[] method2(int a) {
        int[] arr = method3(a + 1);
        arr[1] = a;
        return arr;
    }

    private static int[] method3(int a) {
        int[] arr = new int[3];
        arr[0] = a;
        return arr;
    }


    public static void main(String[] args) {

        int[] arr = method1(100);
        for(int i = 0 ; i < arr.length ; i++){
            System.out.println(i + "번째 arr : " + arr[i]);
        }
    }


}
