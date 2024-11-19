import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.HashMap;

import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 모스 부호 매핑

        Map<String, Character> morseMap = new HashMap<>();

        morseMap.put(".-", 'A'); morseMap.put("-...", 'B'); morseMap.put("-.-.", 'C');

        morseMap.put("-..", 'D'); morseMap.put(".", 'E'); morseMap.put("..-.", 'F');

        morseMap.put("--.", 'G'); morseMap.put("....", 'H'); morseMap.put("..", 'I');

        morseMap.put(".---", 'J'); morseMap.put("-.-", 'K'); morseMap.put(".-..", 'L');

        morseMap.put("--", 'M'); morseMap.put("-.", 'N'); morseMap.put("---", 'O');

        morseMap.put(".--.", 'P'); morseMap.put("--.-", 'Q'); morseMap.put(".-.", 'R');

        morseMap.put("...", 'S'); morseMap.put("-", 'T'); morseMap.put("..-", 'U');

        morseMap.put("...-", 'V'); morseMap.put(".--", 'W'); morseMap.put("-..-", 'X');

        morseMap.put("-.--", 'Y'); morseMap.put("--..", 'Z');

        morseMap.put(".----", '1'); morseMap.put("..---", '2'); morseMap.put("...--", '3');

        morseMap.put("....-", '4'); morseMap.put(".....", '5'); morseMap.put("-....", '6');

        morseMap.put("--...", '7'); morseMap.put("---..", '8'); morseMap.put("----.", '9');

        morseMap.put("-----", '0'); morseMap.put("--..--", ','); morseMap.put(".-.-.-", '.');

        morseMap.put("..--..", '?'); morseMap.put("---...", ':'); morseMap.put("-....-", '-');

        morseMap.put(".--.-.", '@');

        // 입력 받기

        int N = Integer.parseInt(br.readLine()); // 문자열 길이

        String[] morseCode = br.readLine().split(" "); // 공백으로 분리된 모스 부호

        StringBuilder decodedMessage = new StringBuilder();

        for (String code : morseCode) {

            decodedMessage.append(morseMap.get(code));

        }

        // 결과 출력

        System.out.println(decodedMessage.toString());

    }

}

