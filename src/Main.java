import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Data data = InputReader.readFile("input/a_example.txt");

        //combine all verticals to slides
        double totalTagCount = 0;
        for (Integer amount : data.tagCount.values()) {
            totalTagCount += amount;
        }
        Map<Integer, Double> tagPercentages = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : data.tagCount.entrySet()) {
            tagPercentages.put(entry.getKey(), entry.getValue() / totalTagCount);
        }


        double totalSlidePerc = 0.0;
        for (Slide slide : data.verticalPhotos) {
            for (int tag : slide.tags) {
                slide.percentage += tagPercentages.get(tag);
            }
            totalSlidePerc += slide.percentage;
        }
        List<Slide> sortedVerticals = data.verticalPhotos.stream().sorted((Comparator.comparingDouble(o -> o.percentage))).collect(Collectors.toList());
        for (int i = 0; i < Math.floor(sortedVerticals.size()/2.0); i++) {
            Slide firstSlide = sortedVerticals.get(i);
            Slide lastSlide = sortedVerticals.get(sortedVerticals.size() - i - 1);

            Set<Integer> tags = new HashSet<>();
            for (int tag : firstSlide.tags) {
                tags.add(tag);
            }
            for (int tag : lastSlide.tags) {
                tags.add(tag);
            }

            int[] tagz = new int[tags.size()];
            int a = 0;
            for (Integer tag : tags) {
                tagz[a++] = tag;
            }
            data.slides.add(new Slide(firstSlide.id + " " + lastSlide.id, tagz));
        }



    }
}
