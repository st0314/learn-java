package vip.grmz.java1;

import java.util.ArrayList;
import java.util.List;

import static vip.grmz.java1.Color.GREEN;

/**
 * lambda de ce shi
 */
public class LambdaTest {

    /**
     * shai xuan chu lv ping guo
     * @param list
     * @return List filteredApples
     */
    public static List<Apple> filterGreenApples(List<Apple> list){
        List<Apple> filteredApples = new ArrayList<>();
        for (Apple a:
             list) {
            if(GREEN.equals(a.getColor())){
                filteredApples.add(a);
            }
        }
        return filteredApples;
    }

    /**
     * shai xuan chu zhong liang da yu 150g de ping guo
     * @param list
     * @return List filteredApples
     */
    public static List<Apple> filterWeightedApples(List<Apple> list){
        List filteredApples = new ArrayList();

        for (Apple apple:
             list) {

            if (apple.getWeight() > 150){
                filteredApples.add(apple);
            }
        }
        return filteredApples;
    }
}
