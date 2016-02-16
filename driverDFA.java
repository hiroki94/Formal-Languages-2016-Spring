import java.io.*;

public class Lab2Filter {
    public static void main(String[] args) 
            throws IOException {
        Lab2 m = new Lab2(); // The DFA
        BufferedReader in =  // Standard input
            new BufferedReader(new InputStreamReader(System.in));
       // Read and echo lines until EOF
        String s = in.readLine();
        while (s!=null) {
            m.reset();
            m.process(s);
            if (m.accepted()) System.out.println(s);
            s = in.readLine();
        } 
    }
    
}