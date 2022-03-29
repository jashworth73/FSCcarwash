import java.util.*;

public class FSCcarwash {

	// Main
    public static void main(String[] args) throws Exception{

		// Variables required for keeping track of days and size
		Scanner input = new Scanner(System.in);
		int queueSize = input.nextInt();
		int days = input.nextInt();

		// Intro
		System.out.print("Welcome to the FSC Car Clean Simulator\n");

		// Loops number of days provided
		for (int i = 0; i < days ; i++){
			// Key variables for building members and setting up program
			FSCmember wash = null;
			int washTime = input.nextInt();
			int waxTime = input.nextInt();
			int vacuumTime = input.nextInt();
			int numCustomers = input.nextInt();
			String dayType = "AM";

			// Creates data structures required for program
			FSCcarCleanQ outside = new FSCcarCleanQ();
			FSCcarCleanQ queue = new FSCcarCleanQ();
			Stack<FSCvoucher> stack = new Stack<FSCvoucher>();
			System.out.println("");

			// Loop to add customer objects
			for (int j = 0; j < numCustomers; j++){

				// Saves time from input and creates the initial time
				int time = input.nextInt();
				int hour = 10;
				int minute = 0;

				// Calculating time of arrival
				hour += time / 60;
				minute += time % 60;
				if (minute >= 60){
					hour += 1;
					minute = minute % 60;
				}
				if (hour >= 13){
					hour = hour % 12;
				}

				// Totals time
				time = (hour*100) + minute;

				// More variables to save and use later
				int ID = input.nextInt();
				String firstName = input.next();
				String lastName = input.next();
				String code = input.next();
				int minutes_remaining;

				// Calculating time of service depending on voucher given
				if (code.equals("W")){
					minutes_remaining = washTime;
				}
				else if (code.equals("WW")){
					minutes_remaining = washTime + waxTime;
				}
				else{
					minutes_remaining = washTime + waxTime + vacuumTime;
				}

				// Adding members to queues
				outside.enqueue(new FSCmember(time, ID, firstName, lastName, code, minutes_remaining, null));
			}

			// Sets up real time and passing minutes to keep track of time during the day
			int realTime = 1000;
			int minutes_passed = 0;

			// Prints the current day
			System.out.print("**********\n");
			System.out.printf("Day %s:\n", i+1);
			System.out.print("**********\n\n");

			// Loops while the queues have content and its not past 4
			while (minutes_passed < 360 && (!outside.isEmpty() || !queue.isEmpty() || wash != null)){

				// Checks if there is a car currently in the wash
				if (wash != null){

					// Checks if the car is done washing or has time remaining
					if (wash.getMinutesRemaining() > 1){
						wash.setMinutesRemaining(wash.getMinutesRemaining()-1);
					}

					// If time is up then continue
					else{

						// Getting time and printing the member entering the queue
						String tempTime;
						if (realTime / 100 < 10){
							tempTime = " " + realTime / 100;
						}
						else{
							tempTime = "" + realTime / 100;
						}

						// Prints information about car being washed
						System.out.printf("%s:%02d %s:  The car for %s %s is now finished.\n", tempTime, ((realTime % 100) % 60), dayType, wash.getFirsName(), wash.getLastName());
						System.out.printf("           Waiting time in line: %d minutes\n", wash.getTimeStarted() - wash.getMinutes());
						System.out.printf("           Service time: %d minutes\n", minutes_passed - wash.getTimeStarted());
						System.out.printf("           Total time: %d minutes\n", (wash.getTimeStarted() - wash.getMinutes()) + (minutes_passed - wash.getTimeStarted()));

						// Empties the wash and adds next car in line
						wash = null;
						if (!queue.isEmpty()){
							wash = queue.dequeue();
							wash.setTimeStarted(minutes_passed);
							System.out.printf("%s:%02d %s:  %s %s has now started Class %s service.\n", tempTime, (realTime % 100) % 60, dayType, wash.getFirsName(), wash.getLastName(), wash.getCode());

							// Adds voucher to stack upon entering the wash
							stack.push(new FSCvoucher(wash.getArrivalTime(), wash.getID(), wash.getFirsName(), wash.getLastName(), wash.getCode(), 10, wash.getTimeStarted() + wash.getMinutesRemaining()));
						}
					}
				}

				// While there are items in the outside loop
				while (!outside.isEmpty()){

					// If the current time is the time of arrival for the next car in the outside queue
					if (realTime == outside.peek()){

						// Checks for minion being the front of the line
						if (outside.getFront().getCode().equals("Z")){
							lowlyMinion(stack, realTime, dayType);
							outside.dequeue();
						}

						// Adds member to queue if queue is not full
						else if (queue.getNumCustomers() < queueSize){

							// Removes member from outside queue and adds them to wash queue + sets time entered
							FSCmember temp = outside.dequeue();
							temp.setMinutes(minutes_passed);
							queue.enqueue(temp);

							// Getting time and printing the member entering the queue
							String tempTime;
							if (temp.getArrivalTime() / 100 < 10){
								tempTime = " " + temp.getArrivalTime() / 100;
							}

							else{
								tempTime = "" + temp.getArrivalTime() / 100;
							}

							// if wash is empty then adds the car
							if (wash == null){

								// Prints the car entering wash and sets time while removing it from the queue
								System.out.printf("%s:%02d %s:  %s %s arrived at the FSC Car Clean and immediately started Class %s service.\n", tempTime, temp.getArrivalTime()%100, dayType, temp.getFirsName(), temp.getLastName(), temp.getCode());
								wash = temp;
								wash.setTimeStarted(minutes_passed);
								queue.dequeue();

								// Adds voucher to stack
								stack.push(new FSCvoucher(temp.getArrivalTime(), temp.getID(), temp.getFirsName(), temp.getLastName(), temp.getCode(), 10, temp.getTimeStarted() + temp.getMinutesRemaining()));
							}

							// If wash is full, just adds car to queue
							else{
								System.out.printf("%s:%02d %s:  %s %s arrived at the FSC Car Clean and entered Wash Queue.\n", tempTime, temp.getArrivalTime()%100, dayType, temp.getFirsName(), temp.getLastName());
							}
						}

						// Sends member away if queue is full
						else{
							FSCmember temp = outside.dequeue();

							// Gets time and prints departure
							String tempTime;
							if (temp.getArrivalTime() / 100 < 10){
								tempTime = " " + temp.getArrivalTime() / 100;
							}
							else{
								tempTime = "" + temp.getArrivalTime() / 100;
							}

							// Prints the customers defeat
							System.out.printf("%s:%02d %s:  %s %s arrived at the FSC Car Clean. Unfortunately, the Wash Queue is full, and the customer left disappointed.\n", tempTime, temp.getArrivalTime()%100, dayType, temp.getFirsName(), temp.getLastName());
						}
					}

					// Breaks the while loop if no conditions are met
					else{
						break;
					}
				}

				// Checks if it is AM or PM
				if (realTime >= 1200){
					dayType = "PM";
				}

				// Increments time and adjusts it accordingly
				if (realTime != 1259){
					realTime += 1;
					if (realTime % 100 >= 60){
						realTime = (realTime + 100) - 60;
					}
					if (realTime >= 1200){
						dayType = "PM";
					}
				}

				// Sets time to 1pm when time is met
				else {
					realTime = 100;
					dayType = "PM";
				}

				// Increments time passed
				minutes_passed += 1;
			}

			// At end of day, sets time to 4 (closing time) and empties stack
			realTime = 400;
			lowlyMinion(stack, realTime, dayType);
			System.out.println("");
		}
    }

	// Method for calling the minion
	public static void lowlyMinion (Stack<FSCvoucher> stack, int time, String dayType){

		// Calculated time as a string
		String tempTime;
		if (time / 100 < 10){
			tempTime = " " + time / 100;
		}
		else{
			tempTime = "" + time / 100;
		}

		// Checks if stack is empty
		if (stack.isEmpty()){
			System.out.printf("%s:%02d %s:  LOWLY Minion came but found the voucher box empty.\n", tempTime, ((time % 100) % 60), dayType);
		}

		// Minion empties the stack and prints the names of the customers
		else {
			System.out.printf("%s:%02d %s:  LOWLY Minion came and collected the following vouchers:\n", tempTime, ((time % 100) % 60), dayType);
			while (!stack.isEmpty()){

				FSCvoucher tempPop = stack.pop();
				System.out.printf("           %s %s (%d)\n", tempPop.getFirstName(), tempPop.getLastName(), tempPop.getID());
			}
		}
	}
}
