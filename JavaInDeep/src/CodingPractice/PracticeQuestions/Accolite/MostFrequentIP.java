package CodingPractice.PracticeQuestions.Accolite;

import java.util.*;

public class MostFrequentIP {
    public static String getMostFrequentIP(List<String> logs) {

        Map<String, Integer> ipCount = new HashMap<>();

        String ipRegex = "^(\\d+\\.\\d+\\.\\d+\\.\\d+)";

        for (String log : logs) {

            String ip = log.split(" - ")[0].trim();

            ipCount.put(ip, ipCount.getOrDefault(ip, 0) + 1);
        }


        int maxCount = Collections.max(ipCount.values());

        List<String> mostFrequentIPs = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : ipCount.entrySet()) {
            if (entry.getValue() == maxCount) {
                mostFrequentIPs.add(entry.getKey());
            }
        }

        Collections.sort(mostFrequentIPs);


        return String.join(",", mostFrequentIPs);
    }

    public static void main(String[] args) {

        List<String> logs = Arrays.asList(
                "10.0.0.1 - GET 2020-08-24",
                "10.0.0.1 - GET 2020-08-24",
                "10.0.0.2 - GET 2020-08-24"
        );


        String result = getMostFrequentIP(logs);
        System.out.println(result);
    }
}
