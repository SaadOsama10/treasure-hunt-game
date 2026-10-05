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

    /**
     * Where scores are stored. Desktop: score.txt in the working directory.
     * In the browser (CheerpJ) the page sets -Dtestgame.scoreFile=/files/score.txt,
     * which lives in CheerpJ's persistent virtual filesystem.
     */
    static String scoreFile() {
        return System.getProperty("testgame.scoreFile", "score.txt");
    }

    public void saveToFile() {
        try (
                FileWriter fw = new FileWriter(scoreFile(), true); PrintWriter pr = new PrintWriter(fw)) {
            pr.print(user);
            pr.print(", " + level + ", ");
            pr.println(score);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
