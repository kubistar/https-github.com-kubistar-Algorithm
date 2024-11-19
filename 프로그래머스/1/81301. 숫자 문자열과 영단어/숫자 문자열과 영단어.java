import java.util.HashMap;

import java.util.Map;

public class Solution {

    public int solution(String s) {

        Map<String, String> numMap = new HashMap<>();

        numMap.put("zero", "0");

        numMap.put("one", "1");

        numMap.put("two", "2");

        numMap.put("three", "3");

        numMap.put("four", "4");

        numMap.put("five", "5");

        numMap.put("six", "6");

        numMap.put("seven", "7");

        numMap.put("eight", "8");

        numMap.put("nine", "9");

        

        // 문자열에서 영단어를 숫자로 치환

        for (Map.Entry<String, String> entry : numMap.entrySet()) {

            s = s.replace(entry.getKey(), entry.getValue());

        }

        

        // 문자열을 숫자로 변환하여 반환

        return Integer.parseInt(s);

    }

}

