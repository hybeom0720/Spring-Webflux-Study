package sample.webflux.demo.randomnumber.domain;

import java.util.List;
import java.util.Random;

public class RandomNumbers {

    private List<Integer> figures;

    public RandomNumbers(List<Integer> figures) {
        this.figures = figures;
    }

    public void fillRandomNumbers() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            figures.add(random.nextInt());
        }
    }

    public List<Integer> getFigures() {
        return figures;
    }
}
