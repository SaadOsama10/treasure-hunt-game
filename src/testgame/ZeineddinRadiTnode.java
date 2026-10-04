/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testgame;

/**
 *
 * @author abood
 */
public class ZeineddinRadiTnode {

    int score;
    String username;
    String level;
    ZeineddinRadiTnode left;
    ZeineddinRadiTnode right;

    public ZeineddinRadiTnode(String username, String level, int score) {
        this.username = username;
        this.level = level;
        this.score = score;
        this.right = null;
        this.left = null;
    }

}
