
/*
CSE 17
Christopher Mallalieu
cpm220
Permutation Calculator
Program #7
*/
package prog7;

/**
 *
 * @author christophermallalieu
 */
public class Prog7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] a;
        if (args.length < 1) {
            System.out.println("Integer required on command line.");
            System.exit(1);
        }
        int n = Integer.parseInt(args[0]);
        a = new int[n];
        for (int i=0; i < n; ++i) {
            a[i] = i+1;
        }
        Permutations perm = new Permutations(a);
        Permutation[] perms = perm.permute();
        for (Permutation p : perms) {
            System.out.println(p.toString());
        }
        System.out.println();
        bubbleSort(perms);
        for (Permutation p : perms) {
            System.out.println(p.toString());
        } 
    }
    
    
    private static void bubbleSort (Comparable[] a) { //array of permutations
        boolean needNextLoop = true;
        
        for (int i = a.length - 1; i > 0 && needNextLoop; --i) {
            needNextLoop = false;
            
            for (int j = 0; j < i; ++j) {
                if (a[j].compareTo(a[j + 1]) == 1) {
                    Comparable temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    needNextLoop = true;
                }
            }
        }
    }
}
