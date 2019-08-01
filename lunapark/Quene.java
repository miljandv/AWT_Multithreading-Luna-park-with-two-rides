package lunapark;

import java.beans.IntrospectionException;
import java.util.LinkedList;

public class Quene {
	class elem{
		Ticket k;
		elem next;
		elem(Ticket k1){next=null;k=k1;
		if(head==null)head=tail=this;
		else tail=tail.next=this;}
	}
	elem head,tail;
	public synchronized void add(Ticket k) {new elem(k);notify();}
	public synchronized Ticket get() throws InterruptedException {if(head==null)wait();
	Ticket k1=head.k;
	head=head.next;
	return k1;
	}
	public int size() {
		int s=0;
		for (elem tek=head;tek!=null;tek=tek.next)s++;
		return s;
	}
}