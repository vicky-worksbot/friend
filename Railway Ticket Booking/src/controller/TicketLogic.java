package controller;
import java.util.*;
import view.Main;
import view.input;
import Model.TicketCount;

public class TicketLogic {
	int cid=0;
	static int ticketCount=0;
	static Main m=new Main();
	public static List<TicketCount> ractic=new ArrayList<>();
	public static List<TicketCount> waittic=new ArrayList<>();
	public static  Map<Integer,TicketCount> passtic=new HashMap<>();
	
	public void Book(String name,int age,String preference,char sp,char ep)
	{
		input t=isAvail(sp,ep);
		if(t==null)
		{
			System.out.println("No train is available for your starting and Ending point");
		}else
		{
			if(preference.equalsIgnoreCase("upper"))
				ticketCount=t.getUpper();
			else if(preference.equalsIgnoreCase("middle"))
				ticketCount=t.getMiddle();
			else if(preference.equalsIgnoreCase("lower"))
				ticketCount=t.getLower();
			else if(preference.equalsIgnoreCase("sideupper"))
				ticketCount=t.getSideupper();
			else {
				System.out.print("wrong preference input");
				m.Booking();
				return;
			}
			int availConform=t.getUpper()+t.getMiddle()+t.getLower()+t.getSideupper();
			t.setTotaltickets(t.getTotaltickets()+availConform+t.getRac()+t.getWait());
			if(t.getTotaltickets()>0)
			{
				if(availConform>0)
				{
					if(ticketCount==0)
					{
						System.out.println("No Ticket is available for your preference..... Please try other");
						m.Booking();
					}else{
						if(age>5){
							
							if(preference.equalsIgnoreCase("upper"))
							{
								t.setUpper(t.getUpper()-1);
								t.setTotaltickets(t.getTotaltickets()-1);
								t.setUpperCount(t.getUpperCount()+1);
								passtic.put(++cid, new TicketCount(name,age,preference,sp,sp,t,cid));
								System.out.println("Upper ticket is booked..Your Customer Id is"+cid);
							}
							else if(preference.equalsIgnoreCase("middle"))
							{
								t.setMiddle(t.getMiddle()-1);
								t.setTotaltickets(t.getTotaltickets()-1);
								t.setMiddleCount(t.getMiddleCount()+1);
								passtic.put(++cid, new TicketCount(name,age,preference,sp,ep,t,cid));
								System.out.println("The middle ticket is booked your customer id is "+cid);
							}
							else if(preference.equalsIgnoreCase("lower"))
							{
								if(age>60)
								{
									t.setLower(t.getLower()-1);
									t.setTotaltickets(t.getTotaltickets()-1);
									t.setLowerCount(t.getLowerCount()+1);
									passtic.put(++cid, new TicketCount(name,age,preference,sp,ep,t,cid));
									System.out.println("Lower berth ticket is booked ...your customerid is"+cid);
								}
								else if(age<=5)
								{
									System.out.println("No tickets for infants.... Lower berth allocated for parents");
									t.setLower(t.getLower()-1);
									t.setTotaltickets(t.getTotaltickets()-1);
									t.setLowerCount(t.getLowerCount()+1);
									passtic.put(++cid, new TicketCount(name,age,preference,sp,ep,t,cid));
									System.out.println("Lower berth ticket is booked ....Your customerid is"+cid);
								}
								else {
									System.out.println("Lower berth is only for infants with parents.... and age greater than 60");
									System.out.println("please give other preference");
									m.Booking();
								}
							}
							else if(preference.equalsIgnoreCase("sideupper"))
							{
								t.setSideupper(t.getSideupper()-1);
								t.setTotaltickets(t.getTotaltickets()-1);
								t.setSideupperCount(t.getSideupperCount()+1);
								passtic.put(++cid, new TicketCount(name,age,preference,sp,ep,t,cid));
								System.out.println("side upper ticket is booked....Your customer id is "+cid);
							}
						}else{	
							System.out.println("No tickets for infants");
						}
					}
			}else {
				//goto rac
				if(age>5)
				{
					if(t.getRac()>0)
					{
						System.out.println("No confirm ticket is available ... only RAC booking");
						if(t.getSidelower()>0) {
							t.setSidelower(t.getSidelower()-1);
							t.setSideLowerCount(t.getSideLowerCount()+1);
							t.setTotaltickets(t.getTotaltickets()-1);
							t.setRac(t.getRac()-1);
							t.setRACCount(t.getRACCount()+1);
							ractic.add(new TicketCount(name,age,preference,sp,ep,t,++cid));
							passtic.put(cid, new TicketCount(name,age,preference,sp,ep,t,cid));
							System.out.println("RAC side lower ticket is booked"+cid);
						}
						else if(t.getSidelower()==0) {
							t.setTotaltickets(t.getTotaltickets()-1);
							t.setRac(t.getRac()-1);
							t.setRACCount(t.getRACCount()+1);
							ractic.add(new TicketCount(name,age,preference,sp,ep,t,++cid));
							passtic.put(cid, new TicketCount(name,age,preference,sp,ep,t,cid));
							System.out.println("RAC is booked seating details send later"+cid);
						}
					}else if(t.getRac()==0){
						//go to waiting list
						if(age>5) {
							if(t.getWait()>0) {
								t.setTotaltickets(t.getTotaltickets()-1);
								t.setWait(t.getWait()-1);
								t.setWaitingListCount(t.getWaitingListCount()+1);
								System.out.println("only waiting ticket is available");
								waittic.add(new TicketCount(name,age,preference,sp,ep,t,++cid));
								passtic.put(cid, new TicketCount(name,age,preference,sp,ep,t,cid));
								System.out.println("Waiting List is Booked Seating Details will send Later-" + cid);
							}else if(t.getWait()==0){
								System.out.println("No ticket is available for in this train");
							}
						}else {
							System.out.println("No tickets for infants");
						}
					}
				}else {
					System.out.println("No tickets for infants");
				}
			}
	}else {
		System.out.println("No tickets is availble for in this train");
	}
}
}
	public input isAvail(char sp,char ep)
	{
		for(input s:Main.trainlist)
		{
			if(s.getSpoint()==sp)
			{
				if(s.getEpoint()==ep)
				{
					return s;
				}
			}
		}
		return null;
	}
	public void cancel(int cid2)
	{
		for(TicketCount t:ractic) {
			if(cid2==t.getcid()) {
				input t3=t.getT();
				
				if(!waittic.isEmpty())
				{
					ractic.add(waittic.get(0));//waiting list removed and store the to the rac space
					waittic.remove(0);
					t3.setRac(t3.getRac()+1);
					t3.setRACCount(t3.getRACCount()+1);
					t3.setRac(t3.getRac()-1);
					t3.setWait(t3.getWait()+1);
					t3.setWaitingListCount(t3.getWaitingListCount()-1);
					System.out.println("waiting list to rac moved");
				}
				t3.setRACCount(t3.getRACCount()-1);
				t3.setRac(t3.getRac()+1);
				passtic.remove(cid2);
				ractic.remove(t);
				System.out.println("rac cid"+t.getcid()+"removed");
				m.welcomedisplay();
				return;
			}
		}
		for(TicketCount t:waittic)
		{
			if(cid2==t.getcid())
			{
				input t3=t.getT();
				t3.setWait(t3.getWait()+1);
				t3.setWaitingListCount(t3.getWaitingListCount()-1);
				passtic.remove(cid2);
				waittic.remove(t);
				System.out.println("waiting list cid id"+t.getcid()+"is removed");
				m.welcomedisplay();
				return;
			}
		}
		
		
		for(Map.Entry<Integer,TicketCount> map:  passtic.entrySet()) {
			if(cid2==map.getKey()){
				if(passtic.containsKey(cid2)){
					TicketCount m1=passtic.get(cid2);
					String s=m1.getPreference();
					input m2=m1.getT();
					
					if(s.equalsIgnoreCase("upper")) {
						m2.setUpper(m2.getUpper()+1);
						m2.setUpperCount(m2.getUpperCount()-1);
					}
					else if(s.equalsIgnoreCase("middle")) {
						m2.setMiddle(m2.getMiddle()+1);
						m2.setMiddleCount(m2.getMiddleCount()-1);
					}
					else if(s.equalsIgnoreCase("lower")) {
						m2.setLower(m2.getLower()+1);
						m2.setLowerCount(m2.getLowerCount()-1);
					}
					else if(s.equalsIgnoreCase("sideupper"))
					{
						m2.setSideupper(m2.getSideupper()+1);
						m2.setSideupperCount(m2.getSideupperCount()-1);
					}
					else if(s.equalsIgnoreCase("sidelower")) {
						m2.setSidelower(m2.getSidelower()+1);
						m2.setSideLowerCount(m2.getSideLowerCount()-1);
					}
					
					m2.setTotaltickets(m2.getTotaltickets()-1);
					passtic.remove(cid2);
					System.out.println("Ticket"+m1.getcid()+"is removed");
					if(!ractic.isEmpty()) {
						Rac(m1,m2);
					}
				}
			}
			break;
		}
		m.welcomedisplay();
		return;
	}
		public void Rac(TicketCount m1,input m2)
		{
			TicketCount rac=ractic.get(0);
			
			if(m2.getLower()>0) {
				rac.setPreference("lower");
				m2.setLower(m2.getLower()-1);
				System.out.println("Rac to confirm lower berth ticket is booked");
			}
			else if(m2.getMiddle()>0) {
				rac.setPreference("Middle");
				m2.setMiddle(m2.getMiddle()-1);
				System.out.println("Rac to cnfirm Middle berth ticket is booked");
			}
			else if(m2.getUpper()>0) {
				rac.setPreference("upper");
				m2.setUpper(m2.getUpper()-1);
				System.out.println("RAC to confirm Upper berth ticket is booked");
			}
			else if(m2.getSideupper()>0) {
				rac.setPreference("sideupper");
				m2.setSideupper(m2.getSideupper()-1);
				System.out.println("RAC to confirm sideupper berth ticket is booked");
			}
			else if(m2.getSidelower()>0) {
				rac.setPreference("sidelower");
				m2.setSidelower(m2.getSidelower()-1);
				System.out.println("RAC to confirm SideLower ticket is Booked");
			}
			
			int c=rac.getcid();
			passtic.put(c,rac);
			ractic.remove(0);
			System.out.print(c);
			if(!waittic.isEmpty()) {
				ractic.add(waittic.get(0));
				waittic.remove(0);
				m2.setWait(m2.getWait()+1);
				m2.setWaitingListCount(m2.getWaitingListCount()-1);
				System.out.println("waiting list to RAC moved");
			}
			System.out.println(m2);
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + cid;
			result = prime * result + ((passtic == null) ? 0 : passtic.hashCode());
			result = prime * result + ((ractic == null) ? 0 : ractic.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TicketLogic other = (TicketLogic) obj;
			if (cid != other.cid)
				return false;
			if (passtic == null) {
				if (other.passtic != null)
					return false;
			} else if (!passtic.equals(other.passtic))
				return false;
			if (ractic == null) {
				if (other.ractic != null)
					return false;
			} else if (!ractic.equals(other.ractic))
				return false;
			return true;
		}
		
		
}
