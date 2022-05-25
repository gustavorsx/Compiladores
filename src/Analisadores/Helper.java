package Analisadores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class Helper {

    private static String palavraValida(String string) {
        return string.trim().toLowerCase().replace("\n", "");
    }

    public static List<String> getStringList(String text, String regex) {
        String[] stringArray = text.split(regex);
        List<String> list = asList(stringArray);
        List<String> stringList = new ArrayList<>(list);
        stringList.removeIf(String::isEmpty);

        return stringList.stream()
                .map(Helper::palavraValida)
                .collect(Collectors.toList());
    }

    public static Map<String, String> getStringMap(String text, String regex) {
        List<String> stringList = getStringList(text, regex);
        Map<String, String> stringMap = new HashMap<>();
        stringList.forEach(palavra -> stringMap.put(palavra, palavra));

        return stringMap;
    }
}
