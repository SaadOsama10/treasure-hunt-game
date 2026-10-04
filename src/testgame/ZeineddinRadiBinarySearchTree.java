/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testgame;

/**
 *
 * @author abood
 */
public class ZeineddinRadiBinarySearchTree {

    ZeineddinRadiTnode root;
    String scores = null;

    public void traversal(int score, String username, String level) {
        root = traversalRec(root, score, username, level);
    }

    private ZeineddinRadiTnode traversalRec(ZeineddinRadiTnode root, int score, String username, String level) {
        ZeineddinRadiTnode n = new ZeineddinRadiTnode(username, level, score);
        if (root == null) {
            return n;
        }
        if (n.score < root.score) {
            root.left = traversalRec(root.left, score, username, level);
        } else {
            root.right = traversalRec(root.right, score, username, level);
        }
        return root;

    }

    public ZeineddinRadiTnode getMin() {
        if (root == null) {
            return null;
        }
        ZeineddinRadiTnode temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    public ZeineddinRadiTnode getMax() {
        if (root == null) {
            return null;
        }
        ZeineddinRadiTnode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    public String inOrder() {
        return inOrderRec(root).trim();
    }

    private String inOrderRec(ZeineddinRadiTnode root) {
        if (root == null) {
            return "";
        }
        String left = inOrderRec(root.left);
        String current = root.score + " " + root.level + " ";
        String right = inOrderRec(root.right);

        return left + current + right;
    }
}
