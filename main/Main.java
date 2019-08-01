package main;
import lunapark.*;
public class Main {
public static void main(String[] args) {
 Visitor p = new Visitor("John", 25, 190);
 System.out.println("ID: " + p.getID());
 System.out.println("Age: " + p.getAge());
 System.out.println("Height: " + p.getHeight());

 Worker []workers = new Worker[] { new Worker("Michael", new Ride("Speedy", 150, 120, 15, 2, 2, 5000)),
 new Worker("John", new Ride("Kamikaze", 200, 140, 18, 3, 2, 5000)) };

 Park park = new Park(workers);
 }
} 