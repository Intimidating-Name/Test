import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.*;
class Main {
    public static void main(String[] args) {
        JFrame simonFrame = new JFrame("Simon");
        simonFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        BufferedImage REDSIMON = null;
        JPanel mainpanel = new JPanel(new BorderLayout());
        JPanel npanel = new JPanel(new BorderLayout());
        JPanel spanel = new JPanel(new BorderLayout());
        try {
            REDSIMON = ImageIO.read(new File("RedSimon.jpg"));
        } catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        ImageIcon imageicon = new ImageIcon(REDSIMON);
        JLabel jlabel = new JLabel();
        jlabel.setIcon(imageicon);
        npanel.add(jlabel, BorderLayout.EAST);
        //simonFrame.getContentPane().add(jlabel, BorderLayout.EAST);


        BufferedImage BLUESIMON = null;
        try {
            BLUESIMON = ImageIO.read(new File("BlueSimon.jpg"));
        } catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        ImageIcon imageicon1 = new ImageIcon(BLUESIMON);
        JLabel jlabel1 = new JLabel();
        jlabel1.setIcon(imageicon1);
        npanel.add(jlabel1, BorderLayout.WEST);
        //simonFrame.getContentPane().add(jlabel1, BorderLayout.WEST);

        BufferedImage GREENSIMON = null;
        try {
            GREENSIMON = ImageIO.read(new File("GreenSimon.jpg"));
        } catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        ImageIcon imageicon2 = new ImageIcon(GREENSIMON);
        JLabel jlabel2 = new JLabel();
        jlabel2.setIcon(imageicon2);
        spanel.add(jlabel2, BorderLayout.EAST);
        //simonFrame.getContentPane().add(jlabel2, BorderLayout.NORTH);

        BufferedImage YELLOWSIMON = null;
        try {
            YELLOWSIMON = ImageIO.read(new File("YellowSimon.jpg"));
        } catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
        ImageIcon imageicon3 = new ImageIcon(YELLOWSIMON);
        JLabel jlabel3 = new JLabel();
        jlabel3.setIcon(imageicon3);
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