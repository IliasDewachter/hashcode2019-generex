import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Data data = InputReader.readFile("input/b_lovely_landscapes.txt");
        //Data data = InputReader.readFile("input/a_example.txt");

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
        for (int i = 0; i < Math.floor(sortedVerticals.size() / 2.0); i++) {
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

        Collections.shuffle(data.slides);

        int highestCommon = 0;
        Slide highestSlide1 = null;
        Slide highestSlide2 = data.slides.get(0);
        for (Slide slide1 : data.slides) {
            if (slide1 == highestSlide2) continue;
            int common = calculateCommon(slide1, highestSlide2);
            if (common > highestCommon) {
                highestCommon = common;
                highestSlide1 = slide1;
            }
        }
        data.slides.remove(highestSlide1);
        data.slides.remove(highestSlide2);

        Slide s3 = data.slides.get(0);
        data.slides.remove(s3);
        Slide s4 = data.slides.get(0);
        data.slides.remove(s4);

        LinkedList<Slide> result = new LinkedList<>();
        result.push(highestSlide1);
        result.push(highestSlide2);
        result.push(s3);
        result.push(s4);

        while (data.slides.size() > 0) {

            int highestScore = -1;
            Slide highestSlide = null;
            boolean isStart = false;
            for (Slide slide : data.slides) {

                //check start of snake
                {
                    Slide slide2 = result.get(0);
                    Slide slide3 = result.get(1);
                    Slide slide4 = result.get(2);
                    Slide slide5 = result.get(3);
                    int score = calculateScore(slide, slide2, slide3, slide4, slide5);
                    if (score > highestScore) {
                        highestScore = score;
                        highestSlide = slide;
                        isStart = true;
                    }
                }

                {
                    Slide slide1 = result.get(result.size() - 4);
                    Slide slide2 = result.get(result.size() - 3);
                    Slide slide3 = result.get(result.size() - 2);
                    Slide slide4 = result.getLast();
                    int score = calculateScore(slide1, slide2, slide3, slide4, slide);
                    if (score > highestScore) {
                        highestScore = score;
                        highestSlide = slide;
                        isStart = false;
                    }
                }

            }

            if (isStart) {
                result.offerFirst(highestSlide);
            } else {
                result.offerLast(highestSlide);
            }

            data.slides.remove(highestSlide);

        }


        OutputReader.writeFile(result);
    }


    public static int calculateCommon(Slide slide1, Slide slide2) {
        int common = 0;
        for (int tag : slide1.tags) {
            for (int innerTag : slide2.tags) {
                if (tag == innerTag) common++;
            }
        }
        return common;
    }

    public static int calculateScore(Slide slide1, Slide slide2, Slide slide3, Slide slide4, Slide slide5) {
        int common1 = calculateCommon(slide1, slide2);
        int common2 = calculateCommon(slide2, slide3);
        int common3 = calculateCommon(slide3, slide4);
        int common4 = calculateCommon(slide4, slide5);
        return Math.min(Math.min(common1, common2), Math.min(common3, common4));
    }
}
