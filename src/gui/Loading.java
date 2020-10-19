package gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;


public class Loading extends JFrame {
    JLabel label=new JLabel("") ;
    public Loading(String update){
        this.setTitle("Loading");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                run2(update);
            }
        });
    }
    public void terminate() {
        this.dispose();
    }
    public void updateUI(){
        this.repaint();
        this.revalidate();
    }
    public void setText(String update){
      label.setText(update);
      this.repaint();
    }
    public void run2(String update) {
        label=new JLabel(update);
        JPanel bgPanel = new BgPanel("./res/images/loadingbg.gif");
        label.setFont(new Font("TimesRoman", Font.PLAIN, 22));
        label.setBounds(new Rectangle(20,20,40,40));
        this.setIconImage(new ImageIcon("./res/images/favicon.png").getImage());
        this.setResizable(false);
        bgPanel.add(label);
        this.setMinimumSize(new Dimension(MainGui.width-200,MainGui.height-200));
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent winEvt) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dispose();
            }
        });
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        this.add(bgPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


}
