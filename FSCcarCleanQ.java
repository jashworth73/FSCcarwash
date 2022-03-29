public class FSCcarCleanQ {

	// Variables
	private FSCmember front;
	private FSCmember back;
	private int numCustomers;

	// Constructors
	public FSCcarCleanQ() {
		this.front = null;
		this.back = null;
		this.numCustomers = 0;
	}

	public FSCcarCleanQ(FSCmember front, FSCmember back, int numCustomers) {
		this.front = front;
		this.back = back;
		this.numCustomers = numCustomers;
	}

	// Getters and setters
	public FSCmember getFront() {
		return front;
	}

	public void setFront(FSCmember front) {
		this.front = front;
	}

	public FSCmember getBack() {
		return back;
	}

	public void setBack(FSCmember back) {
		this.back = back;
	}

	public int getNumCustomers() {
		return numCustomers;
	}

	public void setNumCustomers(int numCustomers) {
		this.numCustomers = numCustomers;
	}

	/* Below are MANY methods that are used on stacks.
	 *
	 * Examples:
	 * isEmpty, PUSH, POP, PEEK, and more.
	 */


	//
	// boolean | isEmpty()
	//
	public boolean isEmpty() {
		return front == null;
	}


	//
	// void | PrintQueue()
	//
	public void PrintQueue() {
		PrintQueue(front);
	}
	//
	// void | PrintQueue(QueueNode)
	//
	private void PrintQueue(FSCmember front) {
		// We need to traverse...so we need a help ptr
		FSCmember helpPtr = front;
		// Traverse to correct insertion point
		while (helpPtr != null) {
			// Print the data value of the node
			System.out.print(helpPtr.getFirsName() + ", ");
			// Step one node over
			helpPtr = helpPtr.getNext();
		}
		System.out.println();
	}


	//
	// boolean | search(int)
	//
	public boolean search(int data) {
		return search(front, data);
	}
	//
	// boolean | search(QueueNode, int)
	//
	private boolean search(FSCmember p, int ID) {
		// To search, we must traverse. Therefore, we need helpPtr.
		FSCmember helpPtr = p;
		while (helpPtr != null) {
			if (helpPtr.getID() == ID)
				return true;
			helpPtr = helpPtr.getNext(); // step one node over
		}
		return false;
	}


	//
	// void | enqueue(int)
	//
	public void enqueue(FSCmember temp) {
		this.numCustomers += 1;
		if (isEmpty()) {
			front = back = enqueue(front, back, temp);
		}
		else {
			back = enqueue(front, back, temp);
		}

	}
	//
	// QueueNode | enqueue(QueueNode, QueueNode, int)
	//
	private FSCmember enqueue(FSCmember front, FSCmember back, FSCmember temp) {
		// Make a new QueueNode with "data" as the data value

		// Now, if the list is empty, return the reference for temp
		// and save this reference into both "front" and "back"
		// Why? Since this is the only node in the queue, it will be the front and back node
		if (isEmpty()) {
			return temp;
		}
		// ELSE, the queue is not empty. We need to insert temp at the back of the queue.
		// So save the address of the new node into the next of back.
		// Then, make back "traverse" one node over, so it now points to the new back node.
		// Finally, return the updated address of back.
		else {
			back.setNext(temp);
			back = back.getNext();
			return back;
		}
	}


	//
	// QueueNode | dequeue()
	//
	public FSCmember dequeue() {
		this.numCustomers -= 1;
		FSCmember temp = front;
		front = dequeue(front);
		temp.setNext(null);
		if (front == null)
			back = null;
		return temp;
	}
	//
	// QueueNode | dequeue(QueueNode)
	//
	private FSCmember dequeue(FSCmember front) {
		front = front.getNext();
		return front;
	}


	//
	// int | peek()
	//
	public int peek() {
		// Invoke the peek method with front as a parameter
		int frontValue = peek(front);

		// return topValue
		return frontValue;
	}
	//
	// int | peek(QueueNode)
	//
	private int peek(FSCmember front) {
		// Return the data value of the front node.
		// You can see that we do NOT dequeue. We are only returning the data value.
		return front.getArrivalTime();
	}
}
