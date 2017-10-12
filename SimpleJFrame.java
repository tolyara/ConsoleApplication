package Package_App;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static java.awt.event.KeyEvent.VK_ESCAPE;

class SimpleJFrame {

    void runCatch() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                CatchEsc frame = new CatchEsc();
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    class CatchEsc extends JFrame {

        private JLabel label;

        CatchEsc() {
            super("CatchEsc");
            createGUI();
        }

//    public static void destroyJFrame() {
//        frame.dispose();
//    }

        void createGUI() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.setFocusable(true);

            label = new JLabel();
            label.setFont(new Font("Calibri", Font.PLAIN, 20));
            label.setHorizontalAlignment(JLabel.CENTER);

            panel.addKeyListener(new KeyAdapter() {

                public void keyReleased(KeyEvent e) {
                    label.setText(e.getKeyText(e.getKeyCode()));
                    if (e.getKeyCode() == VK_ESCAPE) {
                        System.out.println("Подсчет файлов остановлен.");
                        System.exit(0);
                    }
                }

            });

            panel.add(label, BorderLayout.CENTER);

            setPreferredSize(new Dimension(200, 200));
            getContentPane().add(panel);
        }

    }

}
