package lunapark;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.util.ArrayList;

public class Ride extends Thread {
	private String name;
	ArrayList<Visitor> visitors;
	Panel mainPanel;
	Panel phPanel=new Panel();
	Panel totalPanel=new Panel(new BorderLayout());
	Label[][] labels;
	Panel panel;
	Label hl;
	private int cnt1,cnt2;
	Panel[][] panels;
	private int price_per_person,min_height,min_age,row,cln,time;
	public Ride(String name_,int price_,int min_v,int min_A,int row_,int cln_,int time_) {
		price_per_person=price_;
		min_height=min_v;
		min_age=min_A;
		row=row_;
		cln=cln_;name=name_;
		time=time_;
		panels=new Panel[row][cln];
		visitors=new ArrayList<>();
		mainPanel=new Panel(new GridLayout(row,cln));
		hl=new Label(name);hl.setFont(new Font("Arial",Font.BOLD,16));
		phPanel.add(hl);hl.setBackground(Color.white);
		labels=new Label[row][cln];
		totalPanel.add(phPanel,BorderLayout.CENTER);
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cln; j++) {
				labels[i][j]=new Label("-");labels[i][j].setAlignment(Label.CENTER);labels[i][j].setBackground(Color.red);
				labels[i][j].setFont(new Font("Arial",Font.BOLD,16));
				panels[i][j]=new Panel();
				panels[i][j].add(labels[i][j]);
				panels[i][j].setBackground(Color.red);
				mainPanel.add(panels[i][j]);
			}
		}
		totalPanel.add(mainPanel,BorderLayout.SOUTH);
		start();
	}
	public String getNameR(){
		return name;
	}
	public int getPricePerPerson() {
		return price_per_person;
	}
	public int getMin_height() {
		return min_height;
	}
	public int getMin_age() {
		return min_age;
	}
	public int getRow() {
		return row;
	}
	public int getCln() {
		return cln;
	}
	public int getTime() {
		return time;
	}
	private void redo() {
		if(cnt2==cln-1) {cnt1++;cnt2=0;}
		else {cnt2++;}
		System.err.println(cnt1+" "+cnt2);
	}
	public boolean get_cangoonride(Visitor p) {return (p.getAge()>=min_age && p.getHeight()>=min_height);}
	public synchronized void add_visitor(Visitor p) throws InterruptedException {
		if(!get_cangoonride(p))return;
		else if(visitors.size()==cln*row)wait();
		visitors.add(p);
		panels[cnt1][cnt2].setBackground(Color.green);
		labels[cnt1][cnt2].setBackground(Color.green);
		labels[cnt1][cnt2].setText(""+p.getID());
		redo();
	}
	public synchronized boolean ride_in_progress() {return cnt1*cnt2==cln*row;}
	public void run() {try {
		while(!interrupted()) {
			phPanel.setBackground(Color.red);hl.setBackground(Color.red);
		while(visitors.size()<cln*row)synchronized (this) {wait(2);}
			phPanel.setBackground(Color.green);hl.setBackground(Color.green);
			sleep(time);
			visitors.clear();
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < cln; j++) {
					labels[i][j].setText("-");labels[i][j].setBackground(Color.red);
					panels[i][j].setBackground(Color.red);
				}
			}
			cnt1=cnt2=0;
			synchronized (this) {notifyAll();}
		}
	}catch (InterruptedException e) {}
	}
	public void zaustavi() {interrupt();}
	public synchronized Panel getPanel() {return totalPanel;}
}
