/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog7;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author christophermallalieu
 */
public class Permutations {
    private int[] currentPerm;
    private int numGenerated;
    private Permutation[] allPermArray;
    
    public Permutations (int[] currentPerm) {
    this.currentPerm = currentPerm;
    int allPermLength = factorial(currentPerm.length);
    allPermArray = new Permutation[allPermLength];
    }
    
    private int factorial (int n) {
        int fact = 1;
        for (int i = n; i > 0; i--) {
            fact *= i;
        }
        return fact;
    }
    
    public void rotate (int i1, int i2) {
        ArrayList <Integer> rotateArray = new ArrayList<>();
        for (int i : currentPerm) {
            rotateArray.add(i);
        }
        for (int j = i1; j < i2; j++) {
            int temp = rotateArray.get(rotateArray.size() - 1);
            for (int k = rotateArray.size() - 1; k > 0; k--) {
                rotateArray.set(k, rotateArray.get(k - 1));
            }
            rotateArray.set(0, temp);
        }
        currentPerm = rotateArray.stream().mapToInt(i->i).toArray();
    }
    
    private void permute (int n) {
        for (int i = 0; i < n - i + 1; i++) {
            for (int j = i + 1; j <= n; j++) {
                permute(currentPerm[j]);
                rotate(i, n);
                allPermArray[j] = new Permutation(currentPerm);
            } 
        }
    }
    
    public Permutation[] permute() {
        permute(0);
        return allPermArray;
    }
}
