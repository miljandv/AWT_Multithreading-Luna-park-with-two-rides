package lunapark;

public class Worker extends Thread {
	private int earnings;
	private String name;
	private Ride v;
	private Quene quene=new Quene();
	public Worker(String na,Ride v1) {v=v1;name=na;start();}
	public String getNameR() {
		return name;
	}
	public synchronized Ride getV() {
		return v;
	}
	public Quene getQuene() {
		return quene;
	}
	public void run() {try {
		while(!interrupted()) {
			Ticket k=quene.get();
			if(v.get_cangoonride(k.getVisitor())) {v.add_visitor(k.getVisitor());earnings+=k.getPrice();}
		}
	}catch (InterruptedException e) {}
	}
	public void w_interrupt() {interrupt();}
}
