import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // Step 1: Split input by "::"
        String[] parts = input.split("::", -1);

        // Array to hold the 8 groups of the final IPv6 address
        String[] groups = new String[8];
        Arrays.fill(groups, "0000");

        // Step 2: Handle left and right parts of "::"
        if (parts.length == 1) {
            // No "::" in the input
            fillGroups(groups, parts[0].split(":"));
        } else {
            // There is "::" in the input
            String[] left = parts[0].isEmpty() ? new String[0] : parts[0].split(":");
            String[] right = parts[1].isEmpty() ? new String[0] : parts[1].split(":");

            fillGroups(groups, left);
            fillGroupsFromRight(groups, right);
        }

        // Step 3: Print the final result
        StringBuilder result = new StringBuilder();
        for (String group : groups) {
            if (result.length() > 0) {
                result.append(":");
            }
            result.append(group);
        }
        System.out.println(result.toString());
    }

    private static void fillGroups(String[] groups, String[] values) {
        for (int i = 0; i < values.length; i++) {
            groups[i] = expandGroup(values[i]);
        }
    }

    private static void fillGroupsFromRight(String[] groups, String[] values) {
        int startIndex = groups.length - values.length;
        for (int i = 0; i < values.length; i++) {
            groups[startIndex + i] = expandGroup(values[i]);
        }
    }

    private static String expandGroup(String group) {
        // Expands the given group to 4 digits with leading zeros
        StringBuilder expanded = new StringBuilder(group);
        while (expanded.length() < 4) {
            expanded.insert(0, '0');
        }
        return expanded.toString();
    }
}
