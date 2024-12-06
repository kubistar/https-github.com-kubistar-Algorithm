import java.io.*;

import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        List<Integer> level = new ArrayList<>();

        for (String s : input) {

            level.add(Integer.parseInt(s));

        }

        level.sort(Collections.reverseOrder());

        int gold = 0;

        while (level.size() > 1) {

            int first = level.get(0);

            int second = level.get(1);

            gold += first + second;

            level.remove(1);

        }

        System.out.println(gold);

    }

}

