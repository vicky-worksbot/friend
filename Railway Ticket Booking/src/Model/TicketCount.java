package Model;
import view.input;
public class TicketCount {
	private String name;
	private int age;
	private String preference;
	private char start;
	private char end;
	private input t;
	private int cid;
	
	
	public TicketCount(String name, int age, String preference, char start, char end, input t,int cid) {
		super();
		this.name = name;
		this.age = age;
		this.preference = preference;
		this.start = start;
		this.end = end;
		this.t = t;
		this.cid=cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}

	public char getStart() {
		return start;
	}

	public void setStart(char start) {
		this.start = start;
	}

	public char getEnd() {
		return end;
	}

	public void setEnd(char end) {
		this.end = end;
	}

	public input getT() {
		return t;
	}

	public void setT(input t) {
		this.t = t;
	}
	public int getcid() {
		return cid;
	}
	public void setcid() {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "TicketCount [name=" + name + ", age=" + age + ", preference=" + preference + ", start=" + start
				+ ", end=" + end + ", t=" + t + ",customerid "+cid +"]";
	}
	
	
}
