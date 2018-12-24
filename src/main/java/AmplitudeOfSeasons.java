import java.util.HashMap;
import java.util.Map;

public class AmplitudeOfSeasons {

    public static String solution(int []T) {
        int tempPointsPerSeason = T.length/4;
        int maxTemp = Integer.MIN_VALUE;
        int minTemp = Integer.MAX_VALUE;
        String maxAmplitudeSeasonName = "WINTER";
        int maxAmplitude = Integer.MIN_VALUE;
        Map<Integer, String> seasonMap = new HashMap<Integer, String>() {{
            put(1, "WINTER");
            put(2, "SPRING");
            put(3, "SUMMER");
            put(4, "AUTUMN");
        }};
        for (int i = 0; i < T.length; i++) {
            if(T[i] < minTemp) {
                minTemp = T[i];
            }
            if(T[i] > maxTemp) {
                maxTemp = T[i];
            }

            if((i + 1)%tempPointsPerSeason == 0) {
                String seasonName = seasonMap.get((i + 1)/tempPointsPerSeason);
                int seasonAmplitude = Math.abs(maxTemp - minTemp);
                if(seasonAmplitude > maxAmplitude) {
                    maxAmplitude = seasonAmplitude;
                    maxAmplitudeSeasonName = seasonName;
                }
                maxTemp = Integer.MIN_VALUE;
                minTemp = Integer.MAX_VALUE;
            }
        }
        return maxAmplitudeSeasonName;
    }

    public static void main(String[] args) {
        int T[] = {-3, -14, -5, 7, 8, 42, 8, 3};
        System.out.println(solution(T));

        int T2[] = {2, 3, -3, 1, 10, 8, 2, 5, 13, -5, 3, -18};
        System.out.println(solution(T2));
    }
}