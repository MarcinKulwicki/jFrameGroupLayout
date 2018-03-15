/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appframe;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author marcin
 */
public class AppFrame extends JFrame{

    

    public AppFrame(String name, int widthWindow, int heightWindow){
        this.setTitle(name);
        this.setSize(widthWindow, heightWindow);
        
        
        
        //CENTROWANIE RAMKI
        int szer = Toolkit.getDefaultToolkit().getScreenSize().width;
        int wys = Toolkit.getDefaultToolkit().getScreenSize().height;
        
        int szerRam = this.getWidth();
        int wysRam = this.getHeight();
        
        this.setLocation((szer-szerRam)/2, (wys-wysRam)/2);
        //*****//
        
        this.initComponents();
        
        
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        
    
    
    
    public void initComponents(){
        atakuj = new JButton("Atakuj");
        zmienPrzeciwnika = new JButton("Zmien Przeciwnika");
        uleczSie = new JButton("Ulecz sie");
        zakoncz = new JButton("Zakoncz gre bohaterem");
        
        zakoncz.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                AppFrame.this.dispose();
                
            }
            
        });
        JButton tak = ButtonCreate("TAK");
        JButton nie = ButtonCreate("NIE");
        JButton moze = ButtonCreate("Może");
        
        
        //LAYOUT GRUOP
        
        this.getContentPane().setLayout(layout);
        //*****//
        
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                .addComponent(atakuj,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,300)
                .addGroup(
                layout.createParallelGroup()
                        .addComponent(zmienPrzeciwnika,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,300)
                        .addComponent(uleczSie,zmienPrzeciwnika.getWidth(),zmienPrzeciwnika.getWidth(),300)
                )
                .addGroup(
                    layout.createParallelGroup()
                    .addComponent(tak)
                    .addComponent(nie)
                    .addComponent(moze)
                )
                .addContainerGap(10,Short.MAX_VALUE)   
                .addComponent(zakoncz,10,GroupLayout.DEFAULT_SIZE,200)
        
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                     .addComponent(atakuj)
                     .addComponent(zmienPrzeciwnika)
                     .addComponent(tak)
                )
                .addGroup(layout.createParallelGroup()
                
                .addComponent(uleczSie)   
                .addComponent(nie)
                )
                .addComponent(moze)
                .addContainerGap(10,Short.MAX_VALUE)
                
                .addComponent(zakoncz,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, 100)
        );
        
        
        
        
    }
    JButton atakuj;
    JButton zmienPrzeciwnika;
    JButton uleczSie;
    JButton zakoncz;
    GroupLayout layout = new GroupLayout(getContentPane());
    
 
    
    private JButton ButtonCreate(String name){
            Color k= Color.BLUE;
            JButton button = new JButton(name);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println(e.getActionCommand());
                }
            });
        
            return button;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new AppFrame("MainFrame",600,600).setVisible(true);
    }
    
}
