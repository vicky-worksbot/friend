package view;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.TicketLogic;
public class Main {
	public static List<input> trainlist=new ArrayList<>();
	static Scanner sc=new Scanner(System.in);
	static Main m=new Main();
	static TicketLogic tl=new TicketLogic();
	
	public static void main(String[] args) {
			
		trainlist.add(new input('A','B',7,4,0,0,0,0,0,0,0,0,0,0,0,1,2,1));
		m.welcomedisplay();
	}
	public void welcomedisplay()
	{
		System.out.println("1.Booking\n2.Cancel\n3.BookedTickets\n4.AvailableTrains\n5.Exit");
		int in=sc.nextInt();
		switch(in)
		{
		case 1:
		{
			m.Booking();
			break;
		}
		case 2:
		{
			m.cancel();
			break; 
		}
		case 3:
		{
			m.BookedTickets();
			break;
		}
		case 4:
		{
			m.AvailableTrains();
			break;
		}
		case 5:
		{
			System.out.println("Thank you");
			break;
		}
		default:
			System.out.println("Invalid Input ....Please try again");
			break;
		}
	}
	public void Booking()
	{
		boolean s=true;
		while(s)
		{
			System.out.println("Enter your name");
			String name=sc.next();
			System.out.println("Enter your age");
			int age=sc.nextInt();
			System.out.println("Enter your preference");
			String preference=sc.next();
			System.out.println("Enter your startingpoint");
			char s1=sc.next().charAt(0);
			System.out.println("Enter your Endingpoint");
			char e1=sc.next().charAt(0);
			tl.Book(name,age,preference,s1,e1);
			System.out.println("Do you want to booking continue or not?    Enter(Y/N)");
			char cb=sc.next().charAt(0);
			if(cb=='Y')
			{
				Booking();
				s=false;
			}else if(cb=='N')
			{
				s=false;
				m.welcomedisplay();
			}
		}
	}
	public void cancel()
	{
		System.out.print("Enter your Customer ID");
		int cid2=sc.nextInt();
		tl.cancel(cid2);
	}
	
	
	public void AvailableTrains() {
		System.out.println("Enter Stating point");
		char a=sc.next().charAt(0);
		System.out.println("Enter your Ending point");
		char b=sc.next().charAt(0);
		for(input t:trainlist) {
			if(t.getSpoint()==a) {
				if(t.getEpoint()==b) {
					System.out.println(t);
				}
			}
		}
		m.welcomedisplay();
	}
	
	
	public void BookedTickets()
	{
		System.out.println("Enter your starting point");
		char a=sc.next().charAt(0);
		System.out.println("Enter your ending point");
		char b=sc.next().charAt(0);
		
		/*
		 * for(input t:trainlist) { if(t.getSpoint()==a) { if(t.getEpoint()==b) {
		 * if(t.getUpperCount()>0)
		 * System.out.println("Upper Booked "+t.getUpperCount());
		 * if(t.getMiddleCount()>0)
		 * System.out.println("Middle Booked "+t.getMiddleCount());
		 * if(t.getLowerCount()>0)
		 * System.out.println("Lower Booked "+t.getLowerCount());
		 * if(t.getSideupperCount()>0)
		 * System.out.println("Sideupper Booked "+t.getSideupperCount());
		 * if(t.getSideLowerCount()>0)
		 * System.out.println("Sidelower Booked "+t.getSideLowerCount());
		 * if(t.getRACCount()>0) System.out.println("RAC Booked"+t.getRACCount());
		 * if(t.getWaitingListCount()>0)
		 * System.out.println("WaitingList Booked "+t.getWaitingListCount()); } } }
		 */
		System.out.println(tl.ractic);
		System.out.println(tl.passtic);
		System.out.println(tl.waittic);
	}
								
}