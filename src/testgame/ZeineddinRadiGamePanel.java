/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testgame;

import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author abood
 */
public class ZeineddinRadiGamePanel extends JPanel {

    private BufferedImage backgroundImage;
    private BufferedImage playerImage;
    ZeineddinRadiLinkedlist<Point> pathPoints;
    ZeineddinRadiLinkedlist<Point> board;
    int score = 0;
    private int playerPosition = 0;
    int dice;
    String user;
    JLabel showing;
    JLabel score2;
    private boolean isMoving = false;

    public ZeineddinRadiGamePanel(String nameuser) {

        try {
            backgroundImage = ImageIO.read(getClass().getResource("/testgame/images/p2.jpg"));
            playerImage = ImageIO.read(getClass().getResource("/testgame/images/p3.png"));
        } catch (IOException e) {
            System.out.println("Error loading background image!");
        }

//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                System.out.println("Mouse clicked at: (" + e.getX() + ", " + e.getY() + ")");
//            }
//        });
        this.setLayout(null);
        user = nameuser;
////////////////////////////////////////////////////////////////////////////////
        showing = new JLabel();
        showing.setOpaque(true);
        showing.setBounds(300, 0, 100, 100);
        showing.setBackground(new Color(193, 230, 239));
        this.add(showing);

        JLabel scoreL = new JLabel("score:");
        Font f1 = new Font("Serif", Font.ITALIC, 30);
        scoreL.setFont(f1);
        scoreL.setBounds(3, 0, 100, 40);
        scoreL.setBackground(new Color(193, 230, 239));
        scoreL.setForeground(Color.black);
        scoreL.setOpaque(true);
        this.add(scoreL);

        JLabel levelL = new JLabel("level: 1");
        Font f2 = new Font("Serif", Font.ITALIC, 30);
        levelL.setFont(f2);
        levelL.setBounds(3, 40, 300, 50);
        levelL.setBackground(new Color(193, 230, 239));
        levelL.setForeground(Color.black);
        levelL.setOpaque(true);
        this.add(levelL);

        JLabel usernameL = new JLabel("username:" + nameuser);
        usernameL.setFont(f2);
        usernameL.setBounds(3, 80, 300, 60);
        usernameL.setBackground(new Color(193, 230, 239));
        usernameL.setForeground(Color.black);
        usernameL.setOpaque(true);
        this.add(usernameL);

        score2 = new JLabel();
        score2.setFont(f1);
        score2.setOpaque(true);
        score2.setBounds(105, 0, 170, 40);
        score2.setForeground(Color.black);
        score2.setBackground(new Color(193, 230, 239));
        this.add(score2);

////////////////////////////////////////////////////////////////////////////////
        pathPoints = new ZeineddinRadiLinkedlist<>();
        pathPoints.add(new Point(312, 153));
        pathPoints.add(new Point(373, 134));
        pathPoints.add(new Point(428, 123));
        pathPoints.add(new Point(491, 108));
        pathPoints.add(new Point(542, 106));
        pathPoints.add(new Point(608, 109));
        pathPoints.add(new Point(665, 124));
        pathPoints.add(new Point(697, 162));
        pathPoints.add(new Point(662, 198));
        pathPoints.add(new Point(608, 220));
        pathPoints.add(new Point(545, 222));
        pathPoints.add(new Point(493, 227));
        pathPoints.add(new Point(433, 227));
        pathPoints.add(new Point(378, 241));
        pathPoints.add(new Point(355, 279));
        pathPoints.add(new Point(379, 318));
        pathPoints.add(new Point(437, 330));
        pathPoints.add(new Point(494, 335));
        pathPoints.add(new Point(551, 335));
        pathPoints.add(new Point(592, 364));
        pathPoints.add(new Point(560, 407));
        pathPoints.add(new Point(510, 413));
        pathPoints.add(new Point(448, 410));
        pathPoints.add(new Point(393, 400));
        pathPoints.add(new Point(331, 389));
        pathPoints.add(new Point(281, 377));
        pathPoints.add(new Point(223, 368));
        pathPoints.add(new Point(168, 356));
        pathPoints.add(new Point(106, 357));
        pathPoints.add(new Point(54, 380));
        pathPoints.add(new Point(42, 420));
        pathPoints.add(new Point(80, 457));
        pathPoints.add(new Point(128, 480));
        pathPoints.add(new Point(183, 492));
        pathPoints.add(new Point(235, 499));
        pathPoints.add(new Point(297, 505));
        pathPoints.add(new Point(353, 504));
        pathPoints.add(new Point(412, 503));
        pathPoints.add(new Point(470, 495));
        pathPoints.add(new Point(523, 486));
        pathPoints.add(new Point(576, 472));
        pathPoints.add(new Point(627, 451));

////////////////////////////////////////////////////////////////////////////////
        board = new ZeineddinRadiLinkedlist<>();
        ZeineddinRadiNode temp = pathPoints.head;
        while (temp != null) {
            int type = pathPoints.getRandomSpotType();
            board.add((Point) temp.data, type);
            temp = temp.next;
        }

        JButton move = new JButton("Roll Dice");
        move.setBounds(763, 33, 100, 90);
        this.add(move);

        ImageIcon[] diceFaces = new ImageIcon[6];
        for (int i = 0; i < 6; i++) {
            diceFaces[i] = new ImageIcon(getClass().getResource("/testgame/images/" + (i + 1) + ".png"));
        }
        move.addActionListener(e -> {

            if (isMoving) {
                System.out.println("wait");
                return;
            }

            isMoving = true;

            if (board.ptemp.next != null) {
                showing.setIcon(new ImageIcon());

                Random rand = new Random();
                final int[] count = {0};
                Timer rollAnimation = new Timer(150, null);
                rollAnimation.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e2) {
                        int temp = rand.nextInt(6);
                        move.setIcon(diceFaces[temp]);
                        count[0]++;
                        if (count[0] >= 15) {
                            ((Timer) e2.getSource()).stop();
                            dice = rand.nextInt(6) + 1;
                            move.setIcon(diceFaces[dice - 1]);
                            rollDice();

                        }
                    }
                });

                rollAnimation.start();
            }
        });

    }

    public void rollDice() {

        int target = Math.min(playerPosition + dice, board.size - 1);

        Timer timer = new Timer(300, null);
        timer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (playerPosition < target) {
                    board.move();
                    playerPosition++;
                    repaint();
                } else {
                    timer.stop();
                    scoreupdet();

                    score2.setText("" + score);
                    isMoving = false;

                    if (board.ptemp.next == null) {
                        ZeineddinRadiFiles f = new ZeineddinRadiFiles(user, "Level 1", score);
                        f.saveToFile();
                        int choice = JOptionPane.showConfirmDialog(
                                null,
                                "Do you want continue to second level?",
                                "Victory!",
                                JOptionPane.YES_NO_OPTION
                        );
                        if (choice == JOptionPane.YES_OPTION) {

                            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(ZeineddinRadiGamePanel.this);
                            currentFrame.getContentPane().removeAll();
                            ZeineddinRadiGameBoard level2Panel = new ZeineddinRadiGameBoard(user);
                            currentFrame.add(level2Panel);
                            currentFrame.revalidate();
                            currentFrame.repaint();
                        } else if (choice == JOptionPane.NO_OPTION) {
                            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(ZeineddinRadiGamePanel.this);
                            currentFrame.getContentPane().removeAll();
                            ZeineddinRadiMenu mainpage = new ZeineddinRadiMenu();
                            mainpage.revalidate();
                            mainpage.repaint();

                        }
                    }
                }
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
        if (playerImage != null && playerPosition < board.size) {
            Point p = (Point) board.ptemp.data;
            g.drawImage(playerImage, p.x, p.y, 30, 30, this);
        }
    }

    void scoreupdet() {

        switch (board.ptemp.type) {
            case 1:
                score += 10;
                showing.setIcon(new ImageIcon(getClass().getResource("/testgame/images/CHEST.png")));
                break;
            case 2:
                score -= 5;
                showing.setIcon(new ImageIcon(getClass().getResource("/testgame/images/TRAP.png")));

                break;
            case 0:
                showing.setIcon(new ImageIcon(getClass().getResource("/testgame/images/EMPTY.png")));

                break;

        }
        repaint();

    }

}
