package GUI1_4;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Property extends Dialog implements ActionListener, ItemListener{

//	private static PropertyDialog propertyDialog = new PropertyDialog();
	Transfer transfer;

	Choice fontName = new Choice();
	Choice fontSize = new Choice();
	Choice charColor = new Choice();
	Choice bgColor = new Choice();

	Label fNameLabel = new Label("フォント:");
	Label fSizeLabel = new Label("フォントサイズ:");
	Label cColorLabel = new Label("文字色:");
	Label bColorLabel = new Label("背景色:");

	Button okButton = new Button("   OK   ");
	Button cancelButton = new Button(" Cancel ");

	String[] fontName_item = {"Times New Roman", "arial", "Dialog"};
	String[] fontSize_item = {"10", "50", "100", "150", "200"};
	String[] color_item = {"Black", "White", "Red", "Green", "Blue"};
	int item_idx = 0;
	Color[] colors = {Color.BLACK,Color.white, Color.red,Color.green,Color.blue};

	public Property(Frame owner, Transfer trans) {
		super(owner);
		this.transfer = trans;
		setModal(true);
		Panel panel = new Panel();
		GridBagLayout layout = new GridBagLayout();
		panel.setLayout(layout);
		add(panel);

		setChoices();

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		layout.setConstraints(fNameLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		layout.setConstraints(fontName, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		layout.setConstraints(fSizeLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		layout.setConstraints(fontSize, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		layout.setConstraints(cColorLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		layout.setConstraints(charColor, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.SOUTHEAST;
		layout.setConstraints(bColorLabel, gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		layout.setConstraints(bgColor, gbc);

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		layout.setConstraints(okButton, gbc);

		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.SOUTHWEST;
		layout.setConstraints(cancelButton, gbc);

		panel.add(fNameLabel);
		fontName.select(transfer.getFont().getName());
		panel.add(fontName);
		panel.add(fSizeLabel);
		fontSize.select(String.valueOf(transfer.getFontSize()));
		panel.add(fontSize);
		panel.add(cColorLabel);
		charColor.select(transfer.colorToStr(transfer.getCharColor()));
		panel.add(charColor);
		panel.add(bColorLabel);
		bgColor.select(transfer.colorToStr(transfer.getBgColor()));
		panel.add(bgColor);


		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
		panel.add(okButton);
		panel.add(cancelButton);
		setTitle("プロパティダイアログ");
		setSize(260, 150);
		setResizable(false);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				fontName.select(transfer.getFont().getName());
				fontSize.select(String.valueOf(transfer.getFontSize()));
				charColor.select(transfer.colorToStr(transfer.getCharColor()));
				bgColor.select(transfer.colorToStr(transfer.getBgColor()));
			}
		});
	}

	private void setChoices(){
		//add fontName
		for(int i = 0; i < fontName_item.length; i++){
			fontName.add(fontName_item[i]);
		}
		fontName.addItemListener(this);

		//add fontSize
		for(int i = 0; i < fontSize_item.length; i++){
			fontSize.add(fontSize_item[i]);
		}
		fontSize.addItemListener(this);

		//add colors
		for(int i = 0; i < color_item.length; i++){
			charColor.add(color_item[i]);
		}
		charColor.addItemListener(this);

		for(int i = 0; i < color_item.length; i++){
			bgColor.add(color_item[i]);
		}
		bgColor.addItemListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == okButton){
			transfer.setFont(new Font(fontName.getSelectedItem(), Font.BOLD, Integer.parseInt(fontSize.getSelectedItem())));
			transfer.setFontSize(Integer.parseInt(fontSize.getSelectedItem()));
			transfer.setCharColor(colors[charColor.getSelectedIndex()]);
			transfer.setBgColor(colors[bgColor.getSelectedIndex()]);
			transfer.setWidthAndHeight(Integer.parseInt(fontSize.getSelectedItem()));
			dispose();
		}else if(obj == cancelButton){
			dispose();
			fontName.select(transfer.getFont().getName());
			fontSize.select(String.valueOf(transfer.getFontSize()));
			charColor.select(transfer.colorToStr(transfer.getCharColor()));
			bgColor.select(transfer.colorToStr(transfer.getBgColor()));
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	}
}
