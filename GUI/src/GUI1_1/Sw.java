package GUI1_1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Event;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sw extends Frame implements ActionListener{
    public Sw(){
        this.setSize(200, 90);		//フレーム生成
        //Do you have fuck'in time?ボタン生成
        Button button1;
        button1=new Button("TIME");
        this.add(button1, BorderLayout.NORTH);
        //this.setVisible(true);
        //EXITボタン生成
        Button button2;
        button2=new Button("EXIT");
        this.add(button2, BorderLayout.SOUTH);
        this.setVisible(true);
        this.addWindowListener(new Finish());

    }

    //ボタン処理
    public boolean action(Event e,Object o){
    	//もし"Do you have fuck'in time?"ボタンが押されたらif文の中の動作をする
    	if(o.equals("TIME")){
    		new Clock();
         }
    	if(o.equals("EXIT")){
    		System.exit(0);
         }
         return true;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}
}