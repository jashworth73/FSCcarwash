public class FSCvouchers {
	private FSCvoucher top;

	// Constructors
	public FSCvouchers(FSCvoucher top) {
		this.top = top;
	}

	// Getter
	public FSCvoucher getTop() {
		return top;
	}

	// Setter
	public void setTop(FSCvoucher top) {
		this.top = top;
	}

	//
	// boolean | isEmpty()
	//
	public boolean isEmpty() {
		return top == null;
	}

	public void PrintStack() {
		PrintStack(top);
	}
	//
	// void | PrintStack(StackNode)
	//
	private void PrintStack(FSCvoucher top) {
		// We need to traverse...so we need a help ptr
		FSCvoucher helpPtr = top;
		// Traverse to correct insertion point
		while (helpPtr != null) {
			// Print the data value of the node
			System.out.print("\t" + helpPtr.getFirstName() + " " + helpPtr.getLastName() + "(" + helpPtr.getID() + ")");
			// Step one node over
			helpPtr = helpPtr.getNext();
		}
		System.out.println();
	}

	public boolean search(int data) {
		return search(top, data);
	}
	//
	// boolean | search(StackNode, int)
	//
	private boolean search(FSCvoucher p, int data) {
		// To search, we must traverse. Therefore, we need helpPtr.
		FSCvoucher helpPtr = p;
		while (helpPtr != null) {
			if (helpPtr.getID() == data)
				return true;
			helpPtr = helpPtr.getNext(); // step one node over
		}
		return false;
	}

	//
	// void | push(int)
	//
	public void push(int arrivalTime, int ID, String firstName, String lastName, String Code, int timeStarted, int timeFinished) {
		top = push(top, arrivalTime, ID, firstName, lastName, Code, timeStarted, timeFinished);
	}
	//
	// StackNode | push(StackNode, int)
	//
	private FSCvoucher push(FSCvoucher top, int arrivalTime, int ID, String firstName, String lastName, String Code, int timeStarted, int timeFinished) {
		// Make a new StackNode with "data" as the data value
		// and set the "next" of this new node to the same address as top
		// * This is the same as addToFront() method for Linked Lists.
		top = new FSCvoucher(arrivalTime, ID, firstName, lastName, Code, timeStarted, timeFinished, top);

		// Now, return the newly updated top.
		return top;
	}

	//
	// StackNode | pop()
	//
	public FSCvoucher pop() {
		// Save a reference to the current top node (because we will change where top points to)
		FSCvoucher temp = top;

		// Now, invoke the pop method with top as a parameter.
		// This method will return a new top node.
		top = pop(top);

		// Finally, return temp, which is the previous top node that we just "popped" off the list.
		return temp;
	}
	//
	// StackNode | pop(StackNode)
	//
	private FSCvoucher pop(FSCvoucher top) {
		// Set top equal to the next node.
		// This will make top point to the 2nd node instead of the first node.
		top = top.getNext();

		// return the address/reference of the new top node
		return top;
	}

	//
	// int | peek()
	//
	public int peek() {
		// Invoke the peek method with top as a parameter
		int topValue = peek(top);

		// return topValue
		return topValue;
	}
	//
	// int | peek(StackNode)
	//
	private int peek(FSCvoucher top) {
		// Return the data value of the top node.
		// You can see that we do NOT pop. We are only returning the data value.
		return top.getID();
	}
}
