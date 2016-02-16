private static final int q0 = 0;
private static final int q1 = 1;
private static final int q2 = 2;
private static final int q3 = 3;

state private int[][] delta =
    {{q1,q2},
     {q3,q1},
     {q2,q2},
     {q3,q1}};

int state = q0;

public void process(String in) {
  for (int i = 0; i < in.length(); i++) {
    char c = in.charAt(i);
    try {
      state = delta[state][c-‘a’]; //fix me
    }
    catch {ArrayIndexOutOfBoundsException ex) {
      state = delta[state][1]; // possible solution
    }
  }
}

public boolean isCorrect() {
  return state == q3
}