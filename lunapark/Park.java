package lunapark;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;import org.omg.CosNaming._BindingIteratorImplBase;;

public class Park extends Frame implements ActionListener {
	class we extends WindowAdapter{
		public void windowClosing(WindowEvent arg0) {dispose();}
	}
	Worker[] r;
	Panel hdPanel;
	TextField tf[]=new TextField[3];
	Panel ft=new Panel();
	Label l[]=new Label[3];
	Choice c=new Choice();
	Button button=new Button("Add");
	Checkbox ch=new Checkbox();
	
	public Park(Worker rr[]) {super("Port Aventura");
	r=rr;
	setBounds(500,100,600,300);
	tf[0]=new TextField("John",8);	
	tf[1]=new TextField("25",4);	
	tf[2]=new TextField("190",4);	
	l[0]=new Label("Name:");
	l[1]=new Label("Age:");
	l[2]=new Label("Height:");addWindowListener(new we());
	for (int i = 0; i < 3;i++) {ft.add(l[i]);ft.add(tf[i]);}
	ft.add(c);ft.add(ch);ft.add(button);button.addActionListener(this);
	hdPanel=new Panel(new GridLayout(1,rr.length));
	for (int i = 0; i < rr.length; i++) {
		hdPanel.add(rr[i].getV().getPanel());hdPanel.setBackground(Color.red);
		c.addItem(""+rr[i].getV().getNameR());
	}
	Panel p1=new Panel(new GridLayout());
	p1.add(hdPanel);
	add(p1,BorderLayout.CENTER);
	add(ft,BorderLayout.SOUTH);
	setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Add")) {
label:		for (int i = 0; i < r.length; i++) {
				if ((r[i].getV().getNameR()).equals(c.getItem(c.getSelectedIndex()))) {
					r[i].getQuene().add(new Ticket(new Visitor(tf[0].getText(), Integer.parseInt(tf[1].getText()), Integer.parseInt(tf[2].getText())), r[i].getV(), ch.getState()));                              
					break label;
				}
			}
			
		}
	}
}
