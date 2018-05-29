import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame  extends JFrame{
    private int dirFlag = 1 , objx = 0 , objy = 0 , objw = 220 , objh = 230 ;
    private Container cp;
    private JButton B1[][] = new JButton[1][6] ;
    private JPanel P1 = new JPanel();
    private JPanel P2 = new JPanel(new GridLayout(1,6,2,2));
    private JLabel  L1 = new JLabel();
    private boolean L1flag = false;
    private ImageIcon icon = new ImageIcon("0.png");
    private Timer T1;
    private Timer T2;
    public MainFrame(){
        init();
    }
    ///////////////////////////////////////////////////////////////////////
    private void init() {
        this.setBounds(50, 50, 490, 680);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        P1.setLayout(null);
        cp.add(P1, BorderLayout.CENTER);
        cp.add(P2, BorderLayout.SOUTH);
        P1.add(L1);
        L1.setIcon(icon);
        L1.setBounds(objx, objy,objw,objh);
        ///////////////////////////////////////////////////////////////////
        B1[0][0] = new JButton("Run");
        B1[0][1] = new JButton("↑");
        B1[0][2] = new JButton("↓");
        B1[0][3] = new JButton("←");
        B1[0][4] = new JButton("→");
        B1[0][5] = new JButton("Exit");
        ///////////////////////////////////////////////////////////////////
        L1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                L1flag = true ;
            }
        });
        P1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (L1flag){
                    T2.start();

                }
            }
        });
        ///////////////////////////////////////////////////////////////////
        B1[0][5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 6; j++) {
                P2.add(B1[i][j]);
            }
        }
        ///////////////////////////////////////////////////////////////////
        T1 = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (dirFlag) {
                    case 1:
                        if (objy - 2 > 0) {
                            objy -= 100;
                        }else {
                            dirFlag = 2 ;
                        }
                        break;
                    case 2:
                        if (objy < 600 - objh) {
                            objy += 100;
                        }else {
                            dirFlag = 1 ;
                        }
                        break;
                    //////////
                    case 3:
                        if (objx-2>0){
                            objx-=100;
                        }else {
                            dirFlag = 4 ;
                        }
                        break;
                    case 4:
                        if (objx<425-objw){
                            objx+=100;
                        }else {
                            dirFlag = 3 ;
                        }
                        break;
                    /////////
                }
                L1.setLocation(objx, objy);
            }
        });
        ///////////////////////////////////////////////////////////////////
        B1[0][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                T1.start();
            }
        });
        B1[0][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dirFlag = 1 ;
            }
        });
        B1[0][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dirFlag = 2 ;
            }
        });
        B1[0][3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dirFlag = 3 ;
            }
        });
        B1[0][4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dirFlag = 4 ;
            }
        });
    }
}