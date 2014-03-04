package GUI1_1practice;

import java.awt.*;
import java.awt.event.*;

public class Sw extends Frame{
    int a;
    static boolean b = true;
    public static void main(String[] args) {
    	Sw f = new Sw();
        f.setSize(200, 200);
        Button myb;
        myb=new Button("Hi! Do you have fuck'in time?");
        f.add(myb, BorderLayout.NORTH);
                        
        f.setVisible(b);
        f.addWindowListener(new Ad());
              
    }
    public boolean action(Event e,Object o){
        if(o.equals("Hi! Do you have fuck'in time?")){
         //ボタンAが押されたときの処理
            a++;
         }
         repaint();
         return true;
    }

    public void paint(Graphics g)
    {
        g.drawString(a+"回",50,70); 
    }
}
class Ad extends WindowAdapter
{
    public void windowClosing(WindowEvent e){
       System.exit(0);
    }
}