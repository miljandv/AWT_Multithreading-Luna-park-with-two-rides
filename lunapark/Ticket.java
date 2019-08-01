package lunapark;

public class Ticket {
	private Visitor visitor;
	private Ride ride;
	private boolean individual;
	public Ticket(Visitor visito, Ride v,boolean p) {visitor=visito;ride=v;individual=p;}
	public Visitor getVisitor() {
		return visitor;
	}
	public Ride getRide() {
		return ride;
	}
	public boolean isIndividual() {
		return individual;
	}
	public int getPrice() {
		return ride.getPricePerPerson()+1/2*ride.getPricePerPerson()*(individual?1:0);
	}
	public String toString() {return "Ticket["+visitor.getID()+"]";}
}
