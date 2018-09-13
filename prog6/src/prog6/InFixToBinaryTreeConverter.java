/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog6;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 *
 * @author christophermallalieu
 */
public class InFixToBinaryTreeConverter {
    
    private List <String> inFix;
    private List <String> stack;
    private List <Node> btstack;
    private String expression;
    
    public InFixToBinaryTreeConverter() {
        this.inFix = new LinkedList <>();
        this.btstack = new ArrayList<>();
        this.stack = new ArrayList<>();
    }
    
    public List<String> createInFix (String expression) {
        this.expression = expression;
        String[] charStrings = (expression.split("\\s"));
        for (String s: charStrings) {
            inFix.add(s);
        }
        return inFix;
    }
    
    public boolean isNumber (String oneChar) {
        char tempChar = oneChar.charAt(0);
        return Character.isDigit(tempChar);
        }

    public boolean isOperator (String oneChar) {
        char tempChar = oneChar.charAt(0);
        switch (tempChar) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
            default:
                return false;
        }
    }
    
    public boolean isLParen (String oneChar) {
        return oneChar.equals("(");
    }
    
    public boolean isRParen (String oneChar) {
        return oneChar.equals(")");
    }
    
    public boolean isHigherPrecedence (String oneChar, String twoChar) {
        int op1 = 0;
        int op2 = 0;
        char operator1 = oneChar.charAt(0);
        char operator2 = twoChar.charAt(0);
        switch (operator1) {
            case '*':
            case '/':
                op1 = 1;
                break;
            case '+':
            case '-':
                op1 = 2;
                break;
        } switch (operator2) {
            case '*':
            case '/':
                op2 = 1;
                break;
            case '+':
            case '-':
                op2 = 2;
                break;
        } return op1 <= op2;
    }
    
    public String pop(List<String> stack) {
        String top = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return top;
    }
    
    public Node createBinaryTree (List<String> inFix) {
        stack.add(0, "(");
        inFix.add(")");
        
        while (inFix.isEmpty() == false) {
            for (int i = 0; i < inFix.size(); i++) {
                String currentString = inFix.get(i);
                if (isNumber(currentString) == true) {
                    int nodeVal = Integer.valueOf(currentString);
                    btstack.add(0, new Node(nodeVal));
                } else if (isLParen(currentString) == true) {
                    stack.add(0, currentString);
                } else if (isOperator(currentString) == true) {
                   List <String> removedElement = new ArrayList<>();
                    while (isOperator(stack.get(stack.size() - 1)) == true) {
                        String poppedOperator = inFix.get(stack.size() - 1);
                        if (isHigherPrecedence(stack.get(stack.size() - 1), poppedOperator) == true) {
                            removedElement.add(poppedOperator);
                            Node btNode = new Node(poppedOperator);
                            btNode.right = btstack.get(0);
                            btNode.left = btstack.get(1);
                            btstack.subList(0, 1).clear();
                            btstack.add(0, btNode);
                        } else {
                            break;
                        }
                    }
                    int index = 0;
                    for (String s: removedElement) {
                    stack.remove(i);
                    i++;
                }
                stack.add(0, currentString);
              } else if (isRParen(currentString) == true) {
                  List<String> removedElement = new ArrayList<>();
                  while (isOperator(stack.get(stack.size() - 1)) == true) {
                      String poppedOperator = inFix.get(stack.size() - 1);
                      if (isLParen(poppedOperator) == false) {
                          removedElement.add(poppedOperator);
                          Node btNode = new Node(poppedOperator);
                          btNode.right = btstack.get(0);
                          btNode.left = btstack.get(1);
                          btstack.subList (0, 1).clear();
                          btstack.add(0, btNode);
                      } else {
                          break;
                      }
                  }
                  int j = 0;
                  for (String s: removedElement) {
                      stack.remove(j);
                      j++;
                  }
                  stack.remove(0);
              }   
            }
        }
        Node root = btstack.get(0);
        return root;
     }
    public void run (String expression) {
        inFix = createInFix(expression);
        Node tree = createBinaryTree(inFix);
    }
}

