/* 
 * Project Milestone 2 (Final)
 * 
 * Author: Hiroki Hayashi
 * 
 * Created: 05/04/16
 * 
 * Class: CMPT 440 - Formal Languages
 * Professor: Pablo Rivas-Perea
 * 
 * DFA class that supports ProjectFrame2.java
 */

import java.util.HashMap;

public class DFA {
	private int myCurrentState = q0;
	
	private static final int q0 = 0; // initial state
	private static final int q1 = 1;
	private static final int q2 = 2;
	private static final int q3 = 3;
	private static final int q4 = 4;
	private static final int q5 = 5;
	private static final int q6 = 6;
	private static final int q7 = 7;
	private static final int q8 = 8;
	private static final int q9 = 9;
	private static final int q10 = 10;
	private static final int q11 = 11;
	private static final int q12 = 12; // final state
	private static final int q13 = 13;
	private static final int q14 = 14;
	private static final int q15 = 15;
	private static final int q16 = 16;
	private static final int q17 = 17; // final state
	private static final int q18 = 18;
	private static final int q19 = 19;
	private static final int q20 = 20;
	private static final int q21 = 21;
	private static final int q22 = 22; // final state
	private static final int q23 = 23;
	private static final int q24 = 24;
	private static final int q25 = 25;
	private static final int q26 = 26;
	private static final int q27 = 27; // final state
	private static final int q28 = 28;
	private static final int q29 = 29;
	private static final int q30 = 30;
	private static final int q31 = 31;
	private static final int q32 = 32;
	private static final int q33 = 33;
	private static final int q34 = 34;
	private static final int q35 = 35;
	private static final int q36 = 36;
	private static final int q37 = 37;
	private static final int q38 = 38;
	private static final int q39 = 39;
	private static final int q40 = 40;
	private static final int q41 = 41; //error state
	
	/* 
	 * delta creates a 2D array that portrays the states as rows and grammar as columns.
	 * Rows: 
	 * q0-q41
	 * 
	 * Columns:
	 * p, r, i, n, t, space, v, a, (, ), a-z, 0-9, +, *, -, ", =, Other characters
	 * 
	 * Note: a-z excludes p, r, i, n, t, v, a.
	 */
	private int[][] delta = {
	        {q1,	q23,	q23,	q23,	q23,	q41,	q13,	q23,	q41,	q41,	q23,	q41,	q41,	q18,	q41,	q41,	q41,	q41}, //q0
	        {q41,	q2,	    q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q1
	        {q41,	q41,	q3,	    q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q2
	        {q41,	q41,	q41,	q4,	    q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q3
	        {q41,	q41,	q41,	q41,	q5,	    q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q4
	        {q41,	q41,	q41,	q41,	q41,	q6,	    q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q5
	        {q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q7,	    q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q6
	        {q41,	q41,	q41,	q41,	q41,	q8,	    q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q7
	        {q9,	q9,	    q9,	    q9,	    q9,	    q33,	q9,	    q9,	    q41,	q41,	q9,	    q10,	q41,	q41,	q41,	q30,	q41,	q41}, //q8
	        {q41,	q41,	q41,	q41,	q41,	q11,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q9
	        {q41,	q41,	q41,	q41,	q41,	q11,	q41,	q41,	q41,	q41,	q41,	q10,	q41,	q41,	q41,	q41,	q41,	q41}, //q10
	        {q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q12,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q11
	        {q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q12
	        {q41,	q41,	q41,	q41,	q41,	q41,	q41,	q14,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q13
	        {q41,	q15,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q14
	        {q41,	q41,	q41,	q41,	q41,	q16,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q15
	        {q23,	q23,	q23,	q23,	q23,	q41,	q23,	q23,	q41,	q41,	q23,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q16
	        {q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q17
	        {q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q19,	q41,	q41,	q41}, //q18
	        {q20,	q20,	q20,	q20,	q20,	q20,	q20,	q20,	q41,	q41,	q20,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q19
	        {q20,	q20,	q20,	q20,	q20,	q20,	q20,	q20,	q41,	q41,	q20,	q41,	q41,	q41,	q21,	q41,	q41,	q41}, //q20
	        {q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q22,	q41,	q41,	q41,	q41}, //q21
	        {q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q22
	        {q41,	q41,	q41,	q41,	q41,	q24,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q23
	        {q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q25,	q41}, //q24
	        {q41,	q41,	q41,	q41,	q41,	q26,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q25
	        {q27,	q27,	q27,	q27,	q27,	q41,	q27,	q27,	q41,	q41,	q27,	q35,	q41,	q41,	q41,	q37,	q41,	q41}, //q26
	        {q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q27
	        {q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q29,	q41,	q41,	q41,	q41,	q41}, //q28
	        {q41,	q41,	q41,	q41,	q41,	q36,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q29
	        {q31,	q31,	q31,	q31,	q31,	q31,	q31,	q31,	q41,	q41,	q31,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q30
	        {q31,	q31,	q31,	q31,	q31,	q34,	q31,	q31,	q41,	q41,	q31,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q31
	        {q41,	q41,	q41,	q41,	q41,	q11,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q32
	        {q41,	q41,	q41,	q41,	q41,	q11,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q33
	        {q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q32,	q41,	q41}, //q34
	        {q41,	q41,	q41,	q41,	q41,	q28,	q41,	q41,	q41,	q41,	q41,	q27,	q41,	q41,	q41,	q41,	q41,	q41}, //q35
	        {q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q27,	q41,	q41,	q41,	q41,	q41,	q41}, //q36
	        {q41,	q41,	q41,	q41,	q41,	q38,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q37
	        {q39,	q39,	q39,	q39,	q39,	q39,	q39,	q39,	q41,	q41,	q39,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q38
	        {q39,	q39,	q39,	q39,	q39,	q40,	q39,	q39,	q41,	q41,	q39,	q41,	q41,	q41,	q41,	q41,	q41,	q41}, //q39
	        {q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q27,	q41,	q41}, //q40
	        {q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41,	q41}  //q41
	};
	
	/*
	 * Below is the constructor that assigns all the 
	 * columns in the 2D array to integers.
	 */
	public DFA(){
    	charSet.put((Character)('p'), (Integer)(0));
        charSet.put((Character)('r'), (Integer)(1));
        charSet.put((Character)('i'), (Integer)(2));
        charSet.put((Character)('n'), (Integer)(3));
        charSet.put((Character)('t'), (Integer)(4));
        charSet.put((Character)(' '), (Integer)(5));
        charSet.put((Character)('v'), (Integer)(6));
        charSet.put((Character)('a'), (Integer)(7));
        charSet.put((Character)('('), (Integer)(8));
        charSet.put((Character)(')'), (Integer)(9));
        charSet.put((Character)('b'), (Integer)(10));
        charSet.put((Character)('c'), (Integer)(10));
        charSet.put((Character)('d'), (Integer)(10));
        charSet.put((Character)('e'), (Integer)(10));
        charSet.put((Character)('f'), (Integer)(10));
        charSet.put((Character)('g'), (Integer)(10));
        charSet.put((Character)('h'), (Integer)(10));
        charSet.put((Character)('j'), (Integer)(10));
        charSet.put((Character)('k'), (Integer)(10));
        charSet.put((Character)('l'), (Integer)(10));
        charSet.put((Character)('m'), (Integer)(10));
        charSet.put((Character)('o'), (Integer)(10));
        charSet.put((Character)('q'), (Integer)(10));
        charSet.put((Character)('s'), (Integer)(10));
        charSet.put((Character)('u'), (Integer)(10));
        charSet.put((Character)('w'), (Integer)(10));
        charSet.put((Character)('x'), (Integer)(10));
        charSet.put((Character)('y'), (Integer)(10));
        charSet.put((Character)('z'), (Integer)(10));
        charSet.put((Character)('0'), (Integer)(11));
        charSet.put((Character)('1'), (Integer)(11));
        charSet.put((Character)('2'), (Integer)(11));
        charSet.put((Character)('3'), (Integer)(11));
        charSet.put((Character)('4'), (Integer)(11));
        charSet.put((Character)('5'), (Integer)(11));
        charSet.put((Character)('6'), (Integer)(11));
        charSet.put((Character)('7'), (Integer)(11));
        charSet.put((Character)('8'), (Integer)(11));
        charSet.put((Character)('9'), (Integer)(11));
        charSet.put((Character)('+'), (Integer)(12));
        charSet.put((Character)('*'), (Integer)(13));
        charSet.put((Character)('-'), (Integer)(14));
        charSet.put((Character)('"'), (Integer)(15));
        charSet.put((Character)('='), (Integer)(16));
        charSet.put((Character)('!'), (Integer)(17));
        charSet.put((Character)('@'), (Integer)(17));
        charSet.put((Character)('#'), (Integer)(17));
        charSet.put((Character)('$'), (Integer)(17));
        charSet.put((Character)('%'), (Integer)(17));
        charSet.put((Character)('^'), (Integer)(17));
        charSet.put((Character)('&'), (Integer)(17));
        charSet.put((Character)('/'), (Integer)(17));
        charSet.put((Character)('>'), (Integer)(17));
        charSet.put((Character)('<'), (Integer)(17));
        charSet.put((Character)('['), (Integer)(17));
        charSet.put((Character)(']'), (Integer)(17));
        charSet.put((Character)('|'), (Integer)(17));
        charSet.put((Character)('~'), (Integer)(17));
        charSet.put((Character)('`'), (Integer)(17));
        charSet.put((Character)('\''), (Integer)(17));
        charSet.put((Character)(';'), (Integer)(17));
        charSet.put((Character)(':'), (Integer)(17));
        charSet.put((Character)('?'), (Integer)(17));
        charSet.put((Character)('.'), (Integer)(17));
        charSet.put((Character)(','), (Integer)(17));
    }
	
	private HashMap<Character, Integer> charSet = new HashMap<Character, Integer>();
	  
	public void reset(int state){
	    state = q0;
	}
	// getter for current state
	public int getCurrentState() {
		return myCurrentState;
	}
	
	// setter for current state
	public void setCurrentState(int curr) {
		this.myCurrentState = curr;
	}
	
	/*
	 *  checker() runs the DFA state by state, using the given string s.
	 *  Once it runs, it then returns the color that is associated with that state,
	 *  so that ProjectFrame can change the text color on the text editor.
	 */
	
	public String checker(String s){
		s = s.replaceAll("&nbsp;", " ");
		myCurrentState = q0;
		String color = "";
		
		for(int i = 0; i < s.length(); i++){
			myCurrentState = this.delta[myCurrentState][charSet.get(s.charAt(i))];
			switch (myCurrentState) {
				case q5:
				case q6:
				case q7:
				case q8:
				case q9:
				case q10:
				case q11:
				case q12:
				case q30:
				case q31:
				case q32:
				case q33:
				case q34:	color = "orange";
							break;
				case q16:
				case q15:
				case q17:	color = "blue";
							break;
				case q19:
				case q20:
				case q21:
				case q22:	color = "green";
							break;
				case q23:
				case q24:
				case q25:
				case q26:
				case q27:	
				case q28:
				case q29:
				case q35:
				case q36:
				case q37:
				case q38:
				case q39:
				case q40:	color = "blue2";
							break;
				case q41:	color = "red";
							break;
				default:	color = "black";
							break;
			}
		}
		return color;
	}
}