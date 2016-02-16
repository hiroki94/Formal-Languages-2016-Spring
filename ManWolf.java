public class Lab2 {

    //declaring states
    private static final int q0 = 0;
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

    private int state;

    /*delta() is the transition function that takes in
      an int and a char and returns the state of the result*/
    static private int delta (int s, char c) {
        switch (s) {
         case q0: switch (c) {
               case 'g': return q1;
               default: return q10;
             }
         case q1: switch (c) {
               case 'n': return q2;
               case 'g': return q0;
               default: return q10;
             }
         case q2: switch (c) {
               case 'n': return q1;
               case 'c': return q5;
               case 'w': return q3;
               default: return q10;
             }
         case q3: switch (c) {
               case 'g': return q4;
               case 'w': return q2;
               default: return q10;
             }
         case q4: switch (c) {
               case 'c': return q7;
               case 'g': return q3;
               default: return q10;
             }
         case q5: switch (c) {
               case 'g': return q6;
               case 'c': return q2;
               default: return q10;
             }
         case q6: switch (c) {
               case 'w': return q7;
               case 'g': return q5
               default: return q10;
             }
         case q7: switch (c) {
               case 'c': return q4;
               case 'w': return q6;
               case 'n': return q8;
               default: return q10;
             }
         case q8: switch (c) {
               case 'g': return q9;
               case 'n': return q7;
               default: return q10;
             }
         case q9: switch (c) {
               case 'g': return q8;
               default: return q10;
             }
         default: return q10;
       }//end switch
    }//end delta()
    
    //reset() will turn "state" back into q0
    public void reset(){
        state = q0;
    }
    
    public void process(String in) {
        for (int i = 0; i < in.length(); i++) {
            char c = in.charAt(i);
            state = delta(state, c);
        }
    }
    
    public boolean accepted() {
        return state==q0;
    }
}