
import javax.swing.*;
import java.awt.*;
public class test {
    private JFrame fr;
    private JMenuBar mb;
    private JMenu m1, m2, m3, m4;
    private JMenuItem mi1, mi2, mi3, mi4, mi5;
    private JDesktopPane desktopPane;
    private JInternalFrame frame1, frame2, frame3;
    public test() {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (Exception e){
            e.printStackTrace();
        }
        fr = new JFrame("SubMenuItem Demo");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mb = new JMenuBar();
        m1 = new JMenu("File");
        m2 = new JMenu("Edit");
        m3 = new JMenu("View");
        
        m4 = new JMenu("New");
        mi1 = new JMenuItem("Window");
        mi2 = new JMenuItem("Message");
        
        mi3 = new JMenuItem("Open");
        mi4 = new JMenuItem("Save");
        mi5 = new JMenuItem("Exit");
        
        
        fr.setJMenuBar(mb);
        mb.add(m1);
        m1.add(m4);
        m1.addSeparator();
        m4.add(mi1);
        m4.addSeparator();
        m4.add(mi2);
        m1.add(mi3);
        m1.addSeparator();
        m1.add(mi4);
        m1.addSeparator();
        m1.add(mi5);
        mb.add(m2);
        mb.add(m3);
        
        desktopPane = new JDesktopPane();
        frame1 = new JInternalFrame("Application 01", true, true, true, true);        frame1 = new JInternalFrame("Application 01", true, true, true, true);
        frame2 = new JInternalFrame("Application 02", true, true, true, true);
        frame3 = new JInternalFrame("Application 03", true, true, true, true);
        frame1.setSize(300, 300);
        frame1.setVisible(true);
        frame2.setSize(300, 300);
        frame2.setVisible(true);
        frame3.setSize(300, 300);
        frame3.setVisible(true);
        
        desktopPane.add(frame1);
        desktopPane.add(frame2);
        desktopPane.add(frame3);
        desktopPane.add(new testroom("1"));
        desktopPane.setVisible(true);
        
        desktopPane.setBackground(Color.BLACK);
        fr.add(desktopPane);
        fr.setSize(1000, 1000);
        fr.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        new test();
    }
}
