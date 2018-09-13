/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog6;

/**
 *
 * @author christophermallalieu
 * @param <E>
 */
public class Node <E> {
    E element;
    Node<E> left, right;
    
    public Node (E o) {
        element = o; 
        left = null;
        right = null;
    }
    
    /*public String toString0 (Node node) {
        if (node.left != null && node.right != null) {
            toString0(node.left);
            toString0(node.right);
            return 
        }
    } */
}
