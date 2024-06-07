import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static int findSmallestTicket(int N, int[] soldTickets) {
        Set<Integer> soldSet = new HashSet<>();
        for (int ticket : soldTickets) {
            soldSet.add(ticket);
        }
        
        int ticketNumber = 1;
        while (soldSet.contains(ticketNumber)) {
            ticketNumber++;
        }
        
        return ticketNumber;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] soldTickets = new int[N];
        String[] tokens = reader.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            soldTickets[i] = Integer.parseInt(tokens[i]);
        }
        reader.close();
        
        System.out.println(findSmallestTicket(N, soldTickets));
    }
}
