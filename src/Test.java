import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.*;
import java.awt.image.*;
import javax.sound.sampled.Clip;
import java.util.Random;
import java.util.Scanner;

class Main {


    /**
     * Gets the file and puts it in a JLabel
     *
     * @param pathname JPG
     * @return JLabel
     */
    private static JLabel getsimon(String pathname) {

        BufferedImage image = null;
        BufferedImage glowing = null;

        try {
            image = ImageIO.read(new File(pathname + ".jpg"));
            glowing = ImageIO.read(new File(pathname + "Glowing.jpg"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        ImageIcon imageIcon = new ImageIcon(image);
        ImageIcon glowingimageicon = new ImageIcon(glowing);
        JLabel jlabel = new JLabel();
        jlabel.setIcon(imageIcon);
        jlabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                jlabel.setIcon(glowingimageicon);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mousePressed(e);
                jlabel.setIcon(imageIcon);
            }
        });
        return jlabel;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("the dream.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame simonFrame = new JFrame("Simon");
        simonFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainpanel = new JPanel(new BorderLayout());
        JPanel npanel = new JPanel(new BorderLayout());
        JPanel spanel = new JPanel(new BorderLayout());

        JLabel jlabel = getsimon("RedSimon");
        npanel.add(jlabel, BorderLayout.EAST);
        //simonFrame.getContentPane().add(jlabel, BorderLayout.EAST);

        JLabel jlabel1 = getsimon("BlueSimon");
        npanel.add(jlabel1, BorderLayout.WEST);
        //simonFrame.getContentPane().add(jlabel1, BorderLayout.WEST);

        JLabel jlabel2 = getsimon("GreenSimon");
        spanel.add(jlabel2, BorderLayout.EAST);
        //simonFrame.getContentPane().add(jlabel2, BorderLayout.NORTH);

        JLabel jlabel3 = getsimon("YellowSimon");
        spanel.add(jlabel3, BorderLayout.WEST);
        //simonFrame.getContentPane().add(jlabel3, BorderLayout.SOUTH);

        mainpanel.add(npanel, BorderLayout.NORTH);
        mainpanel.add(spanel, BorderLayout.SOUTH);
        simonFrame.getContentPane().add(mainpanel);
        simonFrame.pack();
        simonFrame.setLocationRelativeTo(null);
        simonFrame.setVisible(true);
        simonFrame.setResizable(false);

        int GUESSES = 3;
        int BLUE = 0;
        int RED = 1;
        int GREEN = 2;
        int YELLOW = 3;
        int[] colors = new int[15];
        Random rand = new Random();
        for (int i = 0; i < GUESSES; i++) {
            int color = rand.nextInt(4);
            colors[i] = color;
        }
        for (int i = 0; i < GUESSES; i++) {
            System.out.print(String.valueOf(i));
            if (colors[i] == BLUE) {
                System.out.println("Blue");
            }
            if (colors[i] == RED) {
                System.out.println("Red");
            }
            if (colors[i] == GREEN) {
                System.out.println("Green");
            }
            if (colors[i] == YELLOW) {
                System.out.println("Yellow");
            }
        }
        boolean playing = true;
        //System.out.println("boom");
        int pass = 1;
        while (pass <= GUESSES && playing) {
            for (int i = 0; (i < GUESSES) && playing; i++) {
                System.out.println("Pass #" + pass++);
                for (int j = 0; j < i + 1 && playing; j++) {
                    System.out.println("Guess the next color!");
                    System.out.println("color #" + (j + 1));
                    String guess = scan.next();
                    if (Integer.parseInt(guess) == colors[j]) {
                        System.out.println("Good job!");
                    } else {
                        System.out.println("Game Over");
                        playing = false;

                    }
                }
            }
        }
    }
}