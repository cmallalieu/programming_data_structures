/*
CSE 17
Christopher Mallalieu
cpm220
Infix to Postfix
*/
package prog6;

public class Prog6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InFixToBinaryTreeConverter fp = new InFixToBinaryTreeConverter(); 
        fp.run("( ( 6 + 2 ) - 5 ) * 8 / 2");
    }
}
