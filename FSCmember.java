public class FSCmember {

	// Variables
	private int arrivalTime;
	private int timeStarted;
	private int ID;
	private String firsName;
	private String lastName;
	private String code;
	private int minutesRemaining;
	private FSCmember next;
	private int minutes;

	// Constructors
	public FSCmember() {
		this.arrivalTime = arrivalTime;
		this.timeStarted = timeStarted;
		this.ID = ID;
		this.firsName = firsName;
		this.lastName = lastName;
		this.code = code;
		this.minutesRemaining = minutesRemaining;
		this.next = next;
	}

	public FSCmember(int arrivalTime, int ID, String firsName, String lastName, String code, int minutesRemaining, int minutes) {
		this.arrivalTime = arrivalTime;
		this.ID = ID;
		this.firsName = firsName;
		this.lastName = lastName;
		this.code = code;
		this.minutesRemaining = minutesRemaining;
		this.minutes = minutes;
		this.next = null;

	}

	public FSCmember(int arrivalTime, int ID, String firsName, String lastName, String code, int minutesRemaining, FSCmember next) {
		this.arrivalTime = arrivalTime;
		this.timeStarted = timeStarted;
		this.ID = ID;
		this.firsName = firsName;
		this.lastName = lastName;
		this.code = code;
		this.minutesRemaining = minutesRemaining;
		this.next = next;
	}

	// Getters and setters
	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getTimeStarted() {
		return timeStarted;
	}

	public void setTimeStarted(int timeStarted) {
		this.timeStarted = timeStarted;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getFirsName() {
		return firsName;
	}

	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getMinutesRemaining() {
		return minutesRemaining;
	}

	public void setMinutesRemaining(int minutesRemaining) {
		this.minutesRemaining = minutesRemaining;
	}

	public FSCmember getNext() {
		return next;
	}

	public void setNext(FSCmember next) {
		this.next = next;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
}
