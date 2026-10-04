/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testgame;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 *
 * @author abood
 */
public class ZeineddinRadiFiles {

    String user;
    String level;
    int score;

    public ZeineddinRadiFiles(String user, String level, int score) {
        this.user = user;
        this.level = level;
        this.score = score;

    }

    public void saveToFile() {
        try (
                FileWriter fw = new FileWriter("score.txt", true); PrintWriter pr = new PrintWriter(fw)) {
            pr.print(user);
            pr.print(", " + level + ", ");
            pr.println(score);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
