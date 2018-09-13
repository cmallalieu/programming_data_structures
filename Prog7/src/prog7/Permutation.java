/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog7;
import java.util.Arrays;

/**
 *
 * @author christophermallalieu
 */
public class Permutation implements Comparable <Permutation> {
    private int[] intList;
    
    public Permutation (int[] intInput) {
        this.intList = Arrays.copyOf(intInput, intInput.length);
    }
    
    @Override
    public int compareTo (Permutation p1) {
        int i = 0;
        while (this.intList[i] == p1.intList[i] && i < this.intList.length - 1) {
            i++;
        }
        if (this.intList[i] > p1.intList[i] && i <= this.intList.length) {
            return 1;
        } else if (this.intList[i] < p1.intList[i] && i <= this.intList.length) {
            return -1;
        } else {
            return 0;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder listString = new StringBuilder();
        for (int i : intList) {
            listString.append(i);
            listString.append(" ");
        }
        return listString.toString();
    }
}
