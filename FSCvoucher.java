public class FSCvoucher {

	// Needed variables
	private int arrivalTime;
	private int ID;
	private String firstName;
	private String lastName;
	private String Code;
	private int timeStarted;
	private int timeFinished;
	private FSCvoucher next;


	// Constructors
	public FSCvoucher() {
		this.arrivalTime = arrivalTime;
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.Code = Code;
		this.timeStarted = timeStarted;
		this.timeFinished = timeFinished;
		this.next = null;
	}

	public FSCvoucher(int arrivalTime, int ID, String firstName, String lastName, String Code, int timeStarted, int timeFinished) {
		this.arrivalTime = arrivalTime;
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.Code = Code;
		this.timeStarted = timeStarted;
		this.timeFinished = timeFinished;
		this.next = null;
	}

	public FSCvoucher(int arrivalTime, int ID, String firstName, String lastName, String Code, int timeStarted, int timeFinished, FSCvoucher next) {
		this.arrivalTime = arrivalTime;
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.Code = Code;
		this.timeStarted = timeStarted;
		this.timeFinished = timeFinished;
		this.next = next;
	}

	// Getters and setters
	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String Code) {
		this.Code = Code;
	}

	public int getTimeStarted() {
		return timeStarted;
	}

	public void setTimeStarted(int timeStarted) {
		this.timeStarted = timeStarted;
	}

	public int getTimeFinished() {
		return timeFinished;
	}

	public void setTimeFinished(int timeFinished) {
		this.timeFinished = timeFinished;
	}

	public FSCvoucher getNext() {
		return next;
	}

	public void setNext(FSCvoucher next) {
		this.next = next;
	}
	
	
	
}
