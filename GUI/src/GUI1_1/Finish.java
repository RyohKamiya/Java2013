package GUI1_1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Finish extends WindowAdapter{
	public void windowClosing(WindowEvent e){   //×を押されたときの処理
	       System.exit(0);
	    }
}
