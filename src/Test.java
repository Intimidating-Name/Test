import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.image.*;
import java.io.IOException;
import javax.sound.sampled.Clip;

class Main {

    /**
     * Gets the file and puts it in a JLabel
     *
     * @param pathname JPG
     * @return JLabel
     */
    private static JLabel getsimon(String pathname) {

        BufferedImage REDSIMON = null;

        try {
            REDSIMON = ImageIO.read(new File(pathname));
        } catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        ImageIcon imageicon = new ImageIcon(REDSIMON);
        JLabel jlabel = new JLabel();
        jlabel.setIcon(imageicon);
        return jlabel;
    }

    public static void main(String[] args) {

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

        JLabel jlabel = getsimon("RedSimon.jpg");
        npanel.add(jlabel, BorderLayout.EAST);
        //simonFrame.getContentPane().add(jlabel, BorderLayout.EAST);

        JLabel jlabel1 = getsimon("BlueSimon.jpg");
        npanel.add(jlabel1, BorderLayout.WEST);
        //simonFrame.getContentPane().add(jlabel1, BorderLayout.WEST);

        JLabel jlabel2 = getsimon("GreenSimon.jpg");
        spanel.add(jlabel2, BorderLayout.EAST);
        //simonFrame.getContentPane().add(jlabel2, BorderLayout.NORTH);

        JLabel jlabel3 = getsimon("YellowSimon.jpg");
        spanel.add(jlabel3, BorderLayout.WEST);
        //simonFrame.getContentPane().add(jlabel3, BorderLayout.SOUTH);

        mainpanel.add(npanel, BorderLayout.NORTH);
        mainpanel.add(spanel, BorderLayout.SOUTH);
        simonFrame.getContentPane().add(mainpanel);
        simonFrame.pack();
        simonFrame.setLocationRelativeTo(null);
        simonFrame.setVisible(true);
    }
}