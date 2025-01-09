package DSA;

public class BigOExamples {
    public static void main(String[] args) {
        long t0 = System.currentTimeMillis();
        for(int i=0; i< 1000; i++);
        long t1 = System.currentTimeMillis();
        System.out.println(t1-t0);
        int[] a = new int[]{1,2,3,4,5};
        findPairs(a);
    }

    public static void findPairs(int[] a) {
        for(int i =0; i<a.length; i++) {
            for(int j =0; j<a.length;j++) {
                System.out.println("Pair is "+ a[i] + " and "+a[j]);
            }
        }
    }
}
