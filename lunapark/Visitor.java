package lunapark;

public class Visitor {
	private static int ID_;
	private int ID=ID_++;
	public int getID() {
		return ID;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getHeight() {
		return height;
	}
	private String name;
	private int age,height;
	public Visitor(String s,int i,int j) {name=s;age=i;height=j;}

}
