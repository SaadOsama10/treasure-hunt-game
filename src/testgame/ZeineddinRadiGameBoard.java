/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class ZeineddinRadiGameBoard extends JPanel {

    private BufferedImage backgroundImage;
    private BufferedImage playerImage;
    private ZeineddinRadiD_Linkedlist<Point> pathPoints;
    ZeineddinRadiD_Linkedlist<Point> board;
    int dice;
    private int playerPosition = 0;
    int score;
    JLabel showingMOV;
    JLabel showing;
    JLabel showingNUM;
    JLabel score2;
    String user;
    private boolean isMoving = false;
    int lastPosition = 0;

    ZeineddinRadiGameBoard(String nameuser) {
        user = nameuser;
        setLayout(null);
        try {
            backgroundImage = ImageIO.read(getClass().getResource("/testgame/images/final1.jpg"));
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

        JLabel l1 = new JLabel("score:");
        Font f1 = new Font("Serif", Font.ITALIC, 35);
        l1.setFont(f1);
        l1.setOpaque(false);
        l1.setBounds(700, 11, 150, 40);
        this.add(l1);
        l1.setForeground(Color.WHITE);
        JLabel l2 = new JLabel("level: 1 ");
        l2.setBounds(700, 53, 200, 50);
        l2.setOpaque(false);
        l2.setFont(f1);
        l2.setForeground(Color.WHITE);
        this.add(l2);
        JLabel l3 = new JLabel("UN :" + user);
        Font f3 = new Font("Serif", Font.ITALIC, 30);
        l3.setFont(f3);
        l3.setOpaque(false);
        l3.setBounds(700, 90, 170, 60);
        this.add(l3);
        l3.setForeground(Color.white);

        score2 = new JLabel();
        score2.setFont(f1);
        score2.setOpaque(false);
        score2.setBounds(794, 18, 50, 35);
        score2.setForeground(Color.WHITE);
        this.add(score2);

        showing = new JLabel();
        showing.setOpaque(true);
        showing.setBounds(0, 0, 100, 100);
        showing.setBackground(new Color(245, 245, 220));
        this.add(showing);

        showingMOV = new JLabel();
        showingMOV.setOpaque(true);
        showingMOV.setBounds(100, 0, 100, 100);
        showingMOV.setBackground(new Color(245, 245, 220));
        this.add(showingMOV);

        showingNUM = new JLabel();
        Font ch3 = new Font("Arial", Font.BOLD, 30);
        showingNUM.setFont(ch3);
        showingNUM.setOpaque(true);
        showingNUM.setBounds(200, 0, 200, 100);
        showingNUM.setBackground(new Color(245, 245, 220));
        showingNUM.setForeground(Color.RED);
        this.add(showingNUM);

        pathPoints = new ZeineddinRadiD_Linkedlist<>();
        // pathPoints.add(new Point(267, 484));
        pathPoints.add(new Point(369, 483));
        pathPoints.add(new Point(446, 477));
        pathPoints.add(new Point(527, 479));
        pathPoints.add(new Point(594, 480));
        pathPoints.add(new Point(682, 480));
        pathPoints.add(new Point(716, 399));
        pathPoints.add(new Point(635, 384));
        pathPoints.add(new Point(559, 380));
        pathPoints.add(new Point(469, 378));
        pathPoints.add(new Point(375, 369));
        pathPoints.add(new Point(289, 384));
        pathPoints.add(new Point(198, 352));
        pathPoints.add(new Point(111, 335));
        pathPoints.add(new Point(118, 253));
        pathPoints.add(new Point(214, 288));
        pathPoints.add(new Point(328, 297));
        pathPoints.add(new Point(417, 300));
        pathPoints.add(new Point(527, 304));
        pathPoints.add(new Point(631, 301));
        pathPoints.add(new Point(715, 266));
        pathPoints.add(new Point(651, 224));
        pathPoints.add(new Point(562, 225));
        pathPoints.add(new Point(473, 221));
        pathPoints.add(new Point(369, 217));
        pathPoints.add(new Point(289, 217));
        pathPoints.add(new Point(188, 206));
        pathPoints.add(new Point(123, 116));
        pathPoints.add(new Point(206, 132));
        pathPoints.add(new Point(308, 141));
        pathPoints.add(new Point(393, 132));
        pathPoints.add(new Point(506, 128));
        // pathPoints.add(new Point(628, 137));

        board = new ZeineddinRadiD_Linkedlist<>();
        board.add((Point) new Point(267, 484), 5, 0);
        ZeineddinRadiNode temp = pathPoints.head;
        while (temp != null) {

            int type = pathPoints.getRandomSpotType();
            if (type == 3) {
                int value = pathPoints.getRandomSpotValue();
                board.add((Point) temp.data, type, value);
            } else if (type == 4) {
                int value = pathPoints.getRandomSpotValue();
                board.add((Point) temp.data, type, -value);
            } else {
                board.add((Point) temp.data, type, 0);

            }
            temp = temp.next;

        }
        board.add((Point) new Point(628, 137), 5, 0);

        JButton moveToButton = new JButton("Roll Dice");
        moveToButton.setBounds(31, 444, 100, 100);
        this.add(moveToButton);

        moveToButton.addActionListener(e -> {
            showingMOV.setIcon(new ImageIcon());
            showing.setIcon(new ImageIcon());
            showingNUM.setText(" ");

            if (isMoving) {
                System.out.println("wait");
                return;
            }

            isMoving = true;

            ImageIcon[] diceFaces = new ImageIcon[6];
            for (int i = 0; i < 6; i++) {
                diceFaces[i] = new ImageIcon(getClass().getResource("/testgame/images/" + (i + 1) + ".png"));
            }

            Random rand = new Random();
            final int[] count = {0};
            Timer rollAnimation = new Timer(150, null);
            rollAnimation.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e2) {
                    int temp = rand.nextInt(6);
                    moveToButton.setIcon(diceFaces[temp]);
                    count[0]++;
                    if (count[0] >= 15) {
                        ((Timer) e2.getSource()).stop();
                        Random rand = new Random();
                        dice = rand.nextInt(6) + 1;
                        moveToButton.setIcon(diceFaces[dice - 1]);
                        rollDice();
                    }
                }
            });

            rollAnimation.start();
        });

        this.setVisible(true);
    }

    public void rollDice() {

        int target = Math.min(playerPosition + dice, board.size - 1);

        Timer timer = new Timer(300, null);
        timer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (playerPosition < target && board.ptemp.next != null) {
                    board.movef();
                    playerPosition++;
                    repaint();
                } else {
                    ((Timer) e.getSource()).stop();

                    scoreupdet();

                    int steps = board.ptemp.value;
                    int target = playerPosition + steps;
                    if (playerPosition == board.size - 1) {
                        System.out.println(playerPosition);
                        ZeineddinRadiFiles f = new ZeineddinRadiFiles(user, "Level 2", score);
                        f.saveToFile();
                        JOptionPane.showMessageDialog(null, "Thanks you for playing our game");
                        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ZeineddinRadiGameBoard.this);
                        frame.dispose();
                        ZeineddinRadiMenu menu = new ZeineddinRadiMenu();
                        menu.setVisible(true);
                    }

                    if (steps == 0 || target == playerPosition) {
                        isMoving = false;
                    } else {
                        if (target <= 0) {
                            showingNUM.setText("to zero !!");
                        } else if (target > board.size - 1) {
                            showingNUM.setText("you finish !!");

                        } else {
                            showingNUM.setText(" " + steps);

                        }

                        Timer delay = new Timer(4000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e2) {
                                ((Timer) e2.getSource()).stop();
                                check();

                            }
                        });
                        delay.setRepeats(false);
                        delay.start();

                        lastPosition = board.ptemp.type;

                    }
                }
            }

        });

        timer.start();
    }

    public void check() {
        int steps = board.ptemp.value;

        if (steps > 0) {
            if (playerPosition + steps < board.size) {
                board.movefor(steps);
                playerPosition += steps;
            } else {
                board.ptemp = board.tail;
                playerPosition = board.size - 1;
            }

        } else {
            if (playerPosition + steps >= 0) {
                board.moveforb(steps);
                playerPosition += steps;
            } else {
                board.ptemp = board.head;
                playerPosition = 0;
            }

        }
        int type = board.ptemp.type;

        if (!((type == 3 || type == 4) && (lastPosition == 3 || lastPosition == 4))) {
            scoreupdet();
        } else {
            showing.setIcon(new ImageIcon(getClass().getResource("/testgame/images/EMPTY.png")));

        }

        lastPosition = type;
        repaint();
        isMoving = false;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
        if (playerImage != null && playerPosition < board.size) {
            Point p = (Point) board.ptemp.data;
            g.drawImage(playerImage, p.x, p.y, 40, 40, this);
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
            case 3:
                showingMOV.setIcon(new ImageIcon(getClass().getResource("/testgame/images/FORWARD.png")));

                break;
            case 4:
                showingMOV.setIcon(new ImageIcon(getClass().getResource("/testgame/images/DAWN.png")));
                break;
        }
        score2.setText("" + score);
        repaint();

    }

}
