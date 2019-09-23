package Part1;

/**
 * The class contains the Divide and Conquer-based Algorithms we are using. 
 */
public class DivideAndConquerAlgorithms {

	//----------------------------------------------
	// Class constructor
	//----------------------------------------------	
	/**
	 * Constructor of the class. Do not edit it.
	 */
	
	public DivideAndConquerAlgorithms(){}
		
	//-------------------------------------------------------------------
	// 0. iterativeDisplayElements --> Displays all elements of a MyList 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this iterative algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void iterativeDisplayElements(MyList<Integer> m){
		int scenario = 0; 
		if (m.length() == 0) 
			scenario = 1;
		else
			scenario = 2;
		switch(scenario){	
				
		case 1: 
			System.out.println("Empty MyList");
			break;
			
		case 2: 
			int size = m.length();
			System.out.println("MyList Contains the following " + size + " items: ");
			
			for (int i = 0; i < size; i++)
				System.out.println("Item " + i + ": " + m.getElement(i));
			
			break;
	
		}
		
	}

	//-------------------------------------------------------------------
	// 1. maxInt --> Computes the maximum item of MyList 
	//-------------------------------------------------------------------	
	/**
	 * The function computes the maximum item of m (-1 if m is empty). 
	 * @param m: The MyList we want to compute its maximum item.
	 * @return: The maximum item of MyList	  
	 */	
	public int maxInt(MyList<Integer> m){
		int res = 0;
		int scenario = 0; 
		
		if (m.length() == 0) { scenario = 1; }
		else { scenario = 2; }

		switch(scenario){	
		case 1: 
			res = 0;
			break;
		case 2: 
			int e0 = m.getElement(0);
			m.removeElement(0);
			res = maxInt(m);
			if (res < e0) {
				res = e0; 
			}
			m.addElement(0, e0);
			break;
			}
			return res;
		}
		

	//-------------------------------------------------------------------
	// 2. isReverse --> Computes if MyList is sorted in decreasing order 
	//-------------------------------------------------------------------	
	/**
	 * The function computes whether m is sorted in decreasing order or not.  
	 * @param m: The MyList we want to check.
	 * @return: Whether m is sorted in decreasing order or not.  
	 */	
	public boolean isReverse(MyList<Integer> m){
		boolean res = true;
		int scenario = 0; 
		
		if (m.length() <= 1) {
			scenario = 1;
			if (m.length() == 0) {
				System.out.println("ERROR: array is empty");
			}
		}
		else { scenario = 2; }
		
		switch(scenario){
		case 1:
			res = false;
			break;
			
		case 2: 
			int e0 = m.getElement(0);
			int e1 = m.getElement(1);
			//System.out.println(e0 + " <-- e0 *** e1 --> " + e1);
			if (e0 > e1){
				m.removeElement(0);
				res = isReverse(m);
				m.addElement(0, e0);
				res = true;
			}
			else
				res = false;
			
			break;
		}
		return res;	
	}

	//-------------------------------------------------------------------
	// 3. getNumAppearances --> Computes the amount of times that integer appears in MyList  
	//-------------------------------------------------------------------	
	/**
	 * The function computes the amount of times that the integer n appears in m.   
	 * @param m: The MyList we want to use.
	 * @param n: The number we want to compute its appearances for.
	 * @return: The amount of appearances of n into m  
	 */	
	public int getNumAppearances(MyList<Integer> m, int n){
		int res = 0;
		int scenario = 0; 
		
		if (m.length() == 0) 
			scenario = 1;
		else
			scenario = 2;		

		switch(scenario){	
				
		case 1: 
			res = 0;
			break;
			
		case 2: 
			int count = 0;
			int e0 = m.getElement(0);
			m.removeElement(0);
			if (e0 == n) {
				count++;
			}
			res = count + getNumAppearances(m, n); 
			m.addElement(0, e0);
			break;
		}	
		return res;	
	}
	
	//-------------------------------------------------------------------
	// 4. power --> Computes the m-est power of n
	//-------------------------------------------------------------------	
	/**
	 * The function computes n to the power of m.
	 * @param n: The base number.
	 * @param m: The power of n we want to compute
	 * @return: n to the power of m.  
	 */	
	public int power(int n, int m){
		int res = 0, retVal = 0;
		if (res == 0) {
			res = n;
		} else {
			res *= n;
		}
		if(m > 1) {
			res = res * power(n, m-1);
		}
		return res;
	}
	
	//-------------------------------------------------------------------
	// 5. lucas --> Computes the n-est term of the Lucas series
	//-------------------------------------------------------------------	
	/**
	 * The function computes the n-est term of the Lucas series
	 * @param n: The n-est term of the series we want to compute
	 * @return: The term being computed 
	 */	
	public int lucas(int n){
		int res = 0;
		int scenario = 0; 
		
		if (n == 0) 
			scenario = 1;
		else{
			if (n == 1)
				scenario = 2; 
			else
				scenario = 3;	
		}

		switch(scenario){	
				
		case 1: 
			res = 2;
			break;

		case 2: 
			res = 1;		
			break;	
			
		case 3: 
			int n1 = lucas(n-1);
			int n2 = lucas(n-2);
			res = n1 + n2; 
			break;
		}		
			
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}

	//-------------------------------------------------------------------
	// 6. drawImage --> Prints a pattern of a given length
	//-------------------------------------------------------------------	
	/**
	 * The function prints prints a pattern of a given length.
	 * *
	 * **
	 * ***
	 * ... 
	 * @param n: The length of the desired pattern
	 */	
	public void drawImage(int n){
		if (n == 0) { return; }
	    drawImage(n - 1);
	    for (int x = 1; x <= n; x++) { 
	        System.out.print("*"); 
	    }
	    System.out.print("\n"); 
	}
		
}
