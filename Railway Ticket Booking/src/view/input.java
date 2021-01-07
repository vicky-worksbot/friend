package view;
import java.util.*; 
public class input {
	private char spoint;
	private char epoint;
	private int time;
	private int totaltickets;
	private int upperCount;
	private int middleCount;
	private int lowerCount;
	private int sideupperCount;
	private int sideLowerCount;
	private int RACCount;
	private int WaitingListCount;
	private int upper;
	private int middle;
	private int lower;
	private int sideupper;
	private int sidelower;
	private int rac;
	private int wait;
	public input(char spoint, char epoint, int time, int totaltickets, int upperCount, int middleCount, int lowerCount,
			int sideupperCount, int sideLowerCount, int rACCount, int waitingListCount, int upper, int middle,
			int lower, int sideupper, int sidelower, int rac, int wait) {
		super();
		this.spoint = spoint;
		this.epoint = epoint;
		this.time = time;
		this.totaltickets = totaltickets;
		this.upperCount = upperCount;
		this.middleCount = middleCount;
		this.lowerCount = lowerCount;
		this.sideupperCount = sideupperCount;
		this.sideLowerCount = sideLowerCount;
		RACCount = rACCount;
		WaitingListCount = waitingListCount;
		this.upper = upper;
		this.middle = middle;
		this.lower = lower;
		this.sideupper = sideupper;
		this.sidelower = sidelower;
		this.rac = rac;
		this.wait = wait;
	}
	public char getSpoint() {
		return spoint;
	}
	public void setSpoint(char spoint) {
		this.spoint = spoint;
	}
	public char getEpoint() {
		return epoint;
	}
	public void setEpoint(char epoint) {
		this.epoint = epoint;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getTotaltickets() {
		return totaltickets;
	}
	public void setTotaltickets(int totaltickets) {
		this.totaltickets = totaltickets;
	}
	public int getUpperCount() {
		return upperCount;
	}
	public void setUpperCount(int upperCount) {
		this.upperCount = upperCount;
	}
	public int getMiddleCount() {
		return middleCount;
	}
	public void setMiddleCount(int middleCount) {
		this.middleCount = middleCount;
	}
	public int getLowerCount() {
		return lowerCount;
	}
	public void setLowerCount(int lowerCount) {
		this.lowerCount = lowerCount;
	}
	public int getSideupperCount() {
		return sideupperCount;
	}
	public void setSideupperCount(int sideupperCount) {
		this.sideupperCount = sideupperCount;
	}
	public int getSideLowerCount() {
		return sideLowerCount;
	}
	public void setSideLowerCount(int sideLowerCount) {
		this.sideLowerCount = sideLowerCount;
	}
	public int getRACCount() {
		return RACCount;
	}
	public void setRACCount(int rACCount) {
		RACCount = rACCount;
	}
	public int getWaitingListCount() {
		return WaitingListCount;
	}
	public void setWaitingListCount(int waitingListCount) {
		WaitingListCount = waitingListCount;
	}
	public int getUpper() {
		return upper;
	}
	public void setUpper(int upper) {
		this.upper = upper;
	}
	public int getMiddle() {
		return middle;
	}
	public void setMiddle(int middle) {
		this.middle = middle;
	}
	public int getLower() {
		return lower;
	}
	public void setLower(int lower) {
		this.lower = lower;
	}
	public int getSideupper() {
		return sideupper;
	}
	public void setSideupper(int sideupper) {
		this.sideupper = sideupper;
	}
	public int getSidelower() {
		return sidelower;
	}
	public void setSidelower(int sidelower) {
		this.sidelower = sidelower;
	}
	public int getRac() {
		return rac;
	}
	public void setRac(int rac) {
		this.rac = rac;
	}
	public int getWait() {
		return wait;
	}
	public void setWait(int wait) {
		this.wait = wait;
	}
	@Override
	public String toString() {
		return "input [spoint=" + spoint + ", epoint=" + epoint + ", time=" + time + ", totaltickets=" + totaltickets
				+ ", upper=" + upper + ", middle=" + middle + ", lower=" + lower + ", sideupper=" + sideupper
				+ ", sidelower=" + sidelower + ", rac=" + rac + ", wait=" + wait + "]";
	}
	
	
	
	}
