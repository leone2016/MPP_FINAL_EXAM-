import java.util.*;

public class Beverage {

    private static Optional<Map.Entry<String,Integer>> parseSugarEntry(Map.Entry<String,String> entry) {
        try {
            int grams = Integer.parseInt(entry.getValue());
            return Optional.of(Map.entry(entry.getKey(), grams));
        } catch (NumberFormatException ex) {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {


        Map<String, String> beverageSugarMap = Map.ofEntries(
                Map.entry("Cold Brew Coffee", "0"),
                Map.entry("Iced Green Tea", "12"),
                Map.entry("Sparkling Water", "N/A"),
                Map.entry("Lemonade", "28"),
                Map.entry("Berry Smoothie", "N/A"),
                Map.entry("Chai Latte", "22"),
                Map.entry("Coconut Water", "15"),
                Map.entry("Apple Juice", "34"),
                Map.entry("Classic Soda", "40"),
                Map.entry("Orange Juice", "23"),
                Map.entry("Detox Green Smoothie", "16")
        );

        beverageSugarMap.entrySet().stream()
                .map(Beverage::parseSugarEntry)
                .flatMap(Optional::stream)
                .filter(e -> {
                    String n = e.getKey().toLowerCase();
                    return n.contains("juice") || n.contains("smoothie");
                }).filter(e -> e.getValue() < 30)
                .sorted(Comparator
                .comparingInt(Map.Entry<String,Integer>::getValue)
                .thenComparing(Map.Entry::getKey))
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

//    .sorted(Comparator
//                    .comparingInt(Map.Entry<String,Integer>::getValue)
//                .thenComparing(Map.Entry::getKey))
}
