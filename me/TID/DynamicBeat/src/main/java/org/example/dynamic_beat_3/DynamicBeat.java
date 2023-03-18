package org.example.dynamic_beat_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DynamicBeat extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;

    private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("/images/menuBar.png")));

    private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("/images/exit_entered.png"));
    private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("/images/exit.png"));

    private Image introBackground = new ImageIcon(Main.class.getResource("/images/introBackground.jpg")).getImage();

    private JButton exitButton = new JButton(exitButtonBasicImage);


    private int mouseX, mouseY;

    public DynamicBeat() {
        setUndecorated(true);
        setTitle("My Music Beat");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(new Color(0, 0, 0, 0));
        setLayout(null);

        exitButton.setBounds(1245, 0, 30, 30);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setIcon(exitButtonEnteredImage);
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setIcon(exitButtonBasicImage);
                exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });
        add(exitButton);

        menuBar.setBounds(0, 0, 1280, 30);
        menuBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        menuBar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseX, y - mouseY);
            }
        });
        add(menuBar);


        img.setLayout(null);
        img.setBounds(0,0,1280,720);
        add(img);

        Music introMusic = new Music("introMusic.mp3", true);
        introMusic.start();
    }

//    public void paint(Graphics g) {
//        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
//        screenGraphic = screenImage.getGraphics();
//        screenDraw(screenGraphic);
//        g.drawImage(screenImage, 0, 0, null);
//    }
//
//    public void screenDraw(Graphics g) {
//        g.drawImage(introBackground, 0, 0, null);
//        paintComponents(g);
//        this.repaint();
//    }
static JPanel img = new JPanel() {
    Image background = new ImageIcon(Main.class.getResource("/images/introBackground.jpg")).getImage();
    public void paint(Graphics g) {
        g.drawImage(background,0,0,null);
    }
};

}
