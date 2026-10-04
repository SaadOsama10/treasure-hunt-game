package testgame;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ZeineddinRadiMenu extends JFrame {

    String usernamef;
    ZeineddinRadiBinarySearchTree bst = new ZeineddinRadiBinarySearchTree();
    boolean whichpanel;

    public ZeineddinRadiMenu() {

        setTitle("Treasure Hunt Adventure");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

/////////////////////////////////////start_panel/////////////////////////////////////////////////        
        JPanel start_panel = new JPanel();
        start_panel.setSize(900, 600);
        start_panel.setLayout(null);
        start_panel.setBackground(Color.WHITE);
        this.add(start_panel);

        ImageIcon background = new ImageIcon(getClass().getResource("/testgame/images/p6.jpg"));
        JLabel background1 = new JLabel(background);
        background1.setBounds(0, 0, 900, 600);
        start_panel.add(background1);

        JButton start_Game = new JButton("Start Game");
        start_Game.setBounds(290, 300, 300, 70);
        start_Game.setBackground(new Color(66, 160, 180));
        start_Game.setForeground(Color.WHITE);
        start_Game.setFocusPainted(false);
        start_Game.setBorder(BorderFactory.createLineBorder(new Color(170, 210, 225), 5));
        start_Game.setFont(new Font("Arial", Font.BOLD, 20));
        start_Game.setContentAreaFilled(false);
        start_Game.setOpaque(true);
        background1.add(start_Game);

        JButton score_board = new JButton("Score Board");
        score_board.setBounds(290, 380, 300, 70);
        score_board.setBackground(new Color(66, 160, 180));
        score_board.setForeground(Color.WHITE);
        score_board.setFocusPainted(false);
        score_board.setBorder(BorderFactory.createLineBorder(new Color(170, 210, 225), 5));
        score_board.setFont(new Font("Arial", Font.BOLD, 20));
        score_board.setContentAreaFilled(false);
        score_board.setOpaque(true);
        background1.add(score_board);
////////////////////////////////////user_panel//////////////////////////////////////////////////
        JPanel user_panel = new JPanel();
        user_panel.setSize(900, 600);
        user_panel.setLayout(null);
        user_panel.setBackground(Color.WHITE);
        this.add(user_panel);

        JLabel background2 = new JLabel(background);
        background2.setBounds(0, 0, 900, 600);
        user_panel.add(background2);

        JLabel username = new JLabel("Username :");
        username.setFont(new Font("Arial", Font.BOLD, 30));
        username.setBounds(130, 300, 200, 70);
        background2.add(username);

        JTextField userText = new JTextField();
        userText.setBounds(300, 300, 300, 70);
        userText.setFont(new Font("Arial", Font.PLAIN, 18));
        background2.add(userText);

        JButton enter = new JButton("Enter");
        enter.setBounds(300, 380, 300, 70);
        enter.setBackground(new Color(66, 160, 180));
        enter.setForeground(Color.WHITE);
        enter.setFocusPainted(false);
        enter.setBorder(BorderFactory.createLineBorder(new Color(170, 210, 225), 5));
        enter.setFont(new Font("Arial", Font.BOLD, 20));
        enter.setContentAreaFilled(false);
        enter.setOpaque(true);

        background2.add(enter);

        start_panel.setVisible(true);
        user_panel.setVisible(false);

        start_Game.addActionListener(e -> {
            start_panel.setVisible(false);
            user_panel.setVisible(true);
            whichpanel = true;

        });
///////////////////////////////////scoreboard///////////////////////////////////////////////////

        JPanel scoreboard = new JPanel();
        scoreboard.setLayout(null);
        scoreboard.setBounds(0, 0, 900, 600);

        JLabel background3 = new JLabel(background);
        background3.setBounds(0, 0, 900, 600);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(4, 2, 10, 10));
        infoPanel.setBackground(new Color(255, 255, 255, 180));
        infoPanel.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        infoPanel.setBounds(150, 250, 600, 200);

        JLabel usernameLabel = new JLabel("Username:");
        JLabel usernamee = new JLabel("");

        JLabel scoresLabel = new JLabel("All the scores:");
        JTextArea scores = new JTextArea();
        scores.setLineWrap(true);
        scores.setWrapStyleWord(true);
        scores.setEditable(false);
        JScrollPane scroll = new JScrollPane(scores);

        JLabel bestLabel = new JLabel("Best score:");
        JLabel best = new JLabel("");

        JLabel worstLabel = new JLabel("Worst score:");
        JLabel worst = new JLabel("");

        background3.add(infoPanel);
        scoreboard.add(background3);
        this.add(scoreboard);
        infoPanel.add(usernameLabel);
        infoPanel.add(usernamee);
        infoPanel.add(scoresLabel);
        infoPanel.add(scroll);
        infoPanel.add(bestLabel);
        infoPanel.add(best);
        infoPanel.add(worstLabel);
        infoPanel.add(worst);

        infoPanel.setVisible(false);

        score_board.addActionListener(e -> {
            start_panel.setVisible(false);
            user_panel.setVisible(true);
            whichpanel = false;
        });

        enter.addActionListener(e -> {
            if (!userText.getText().isEmpty()) {
                usernamef = userText.getText();
                usernamee.setText(usernamef);
            } else {
                JOptionPane.showMessageDialog(null, "you have to fill username first");

                return;
            }

            if (whichpanel) {
                dispose();
                JFrame gameFrame = new JFrame("Treasure Game");
                gameFrame.setSize(900, 600);
                gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gameFrame.setLocationRelativeTo(null);
                gameFrame.setResizable(false);
                gameFrame.add(new ZeineddinRadiGamePanel(usernamef));
                gameFrame.setVisible(true);

            } else {
                scoreboardfun();
                user_panel.setVisible(false);
                infoPanel.setVisible(true);
                this.revalidate();
                this.repaint();
            }
            if (!bst.inOrder().isEmpty()) {
                scores.setText(bst.inOrder());
            } else {
                scores.setText("No scores available.");
            }

            if (bst.getMax() != null) {
                best.setText(bst.getMax().score + " " + bst.getMax().level);
            } else {
                best.setText("No scores available.");
            }

            if (bst.getMin() != null) {
                worst.setText(bst.getMin().score + " " + bst.getMin().level);
            } else {
                worst.setText("No scores available.");
            }

        });

        setVisible(true);
    }

    public void scoreboardfun() {
        File file = new File("score.txt");
        try {
            Scanner s = new Scanner(file);
            while (s.hasNextLine()) {
                String line = s.nextLine().trim();
                if (!line.isEmpty()) {
                    String[] parts = line.split(",");
                    if (parts[0].trim().equalsIgnoreCase(usernamef)) {
                        bst.traversal(Integer.parseInt(parts[2].trim()), usernamef, parts[1].trim());
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + ex.getMessage());
        }

    }

}
