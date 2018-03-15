/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appframe;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
        
        /**Stworzylem klase Zegar ktora implementuje interfejs ActionListner dlatego moge podac go do Klasy Timer ktora przyjmuje delay oraz ActionListner
         * 
         */
        czasLabel = new JLabel("00:00:00");
        ActionListener zegar = new Zegar();
        Timer stoper = new Timer(1000, zegar);
        stoper.start();
        
        
        /**Klasa anonimowa (bez nazwy, pozawala wykonac mi 1 metode ktora zamyka w tym wypadku program
         * 
         */
        zakoncz.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                AppFrame.this.dispose();
                
            }
            
        });
        JButton tak = ButtonCreate("TAK");
        JButton nie = ButtonCreate("NIE");
        JButton moze = ButtonCreate("Może");
        wybor = new JLabel("Hero says: ");
        
        
        //LAYOUT GRUOP
        
        this.getContentPane().setLayout(layout);
        //*****//
        
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addContainerGap(10, 10)
                        .addGroup(layout.createParallelGroup()
                        .addComponent(czasLabel,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE)
                        .addComponent(atakuj,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,300)       
                        )
                        
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
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup()
                        .addComponent(zakoncz,10,GroupLayout.DEFAULT_SIZE,200)
                        .addComponent(wybor)
                )
                        
                
        
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                     .addComponent(atakuj)
                     .addComponent(zmienPrzeciwnika)
                     .addComponent(tak)
                     .addComponent(wybor)
                )
                .addGroup(layout.createParallelGroup()
                
                .addComponent(uleczSie)   
                .addComponent(nie)
                )
                .addComponent(moze)
//                    
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup()
                .addGap(10)
                        .addComponent(czasLabel,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE)
                        .addComponent(zakoncz,GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, 100)
                )
        );
        
        
        
        
    }
    JButton atakuj;
    JButton zmienPrzeciwnika;
    JButton uleczSie;
    JButton zakoncz;
    JLabel wybor;
    JLabel czasLabel;
    
    GroupLayout layout = new GroupLayout(getContentPane());
    
    
    /**
     * Klasa ktora implementuje actionListnera, instrukcje w nim sa wykonywane co sekunde (patrz na TIMER)
     */
    
    class Zegar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            GregorianCalendar kal = new GregorianCalendar();
            String sec = ""+kal.get(Calendar.SECOND);
            String h = ""+kal.get(Calendar.HOUR_OF_DAY);
            String min = ""+kal.get(Calendar.MINUTE);
            
            if (Integer.parseInt(h)<10)
                h = "0"+h;
            if (Integer.parseInt(min)<10)
                min = "0"+min;
            if (Integer.parseInt(sec)<10)
                sec = "0"+sec;
            
            czasLabel.setText("Time: "+h+":"+min+":"+sec);
            
        }
        
    }
    
    private JButton ButtonCreate(String name){
            JButton button = new JButton(name);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    wybor.setText("Hero says: "+System.lineSeparator()+e.getActionCommand()); 
                    
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
