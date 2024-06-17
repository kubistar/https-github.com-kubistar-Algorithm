import java.util.*;
import java.util.stream.Collectors;

public class Main {

    // 두 수의 최소공배수를 계산하는 함수
    public static int lcm(int x, int y) {
        return Math.abs(x * y) / gcd(x, y);
    }

    // 두 수의 최대공약수를 계산하는 함수
    public static int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }

    // 세 수의 최소공배수를 계산하는 함수
    public static int lcmOfThree(int a, int b, int c) {
        return lcm(lcm(a, b), c);
    }

    // 적어도 세 수로 나누어지는 가장 작은 자연수를 찾는 함수
    public static int atLeastMostMultiple(List<Integer> numbers) {
        int minLcm = Integer.MAX_VALUE;
        
        // 다섯 수 중 세 수를 선택하는 모든 조합을 생성
        List<int[]> combinations = generateCombinations(numbers, 3);
        
        // 각 조합에 대해 최소공배수를 계산하고 가장 작은 값을 찾음
        for (int[] comb : combinations) {
            int a = comb[0];
            int b = comb[1];
            int c = comb[2];
            int currentLcm = lcmOfThree(a, b, c);
            if (currentLcm < minLcm) {
                minLcm = currentLcm;
            }
        }
        
        return minLcm;
    }

    // 주어진 리스트에서 r개의 조합을 생성하는 함수
    public static List<int[]> generateCombinations(List<Integer> list, int r) {
        List<int[]> combinations = new ArrayList<>();
        generateCombinationsHelper(list, r, 0, new int[r], combinations);
        return combinations;
    }

    // 조합 생성을 위한 재귀 헬퍼 함수
    private static void generateCombinationsHelper(List<Integer> list, int r, int index, int[] current, List<int[]> combinations) {
        if (index == r) {
            combinations.add(current.clone());
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            current[index] = list.get(i);
            List<Integer> newList = list.subList(i + 1, list.size());
            generateCombinationsHelper(newList, r, index + 1, current, combinations);
        }
    }

    // 메인 함수
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 입력: 다섯 개의 자연수를 입력받음
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                                      .map(Integer::parseInt)
                                      .collect(Collectors.toList());
        
        // 출력: 적어도 대부분의 배수를 출력
        System.out.println(atLeastMostMultiple(numbers));
    }
}
