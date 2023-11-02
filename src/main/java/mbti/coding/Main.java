package mbti.coding;

import mbti.coding.models.Interval;
import mbti.coding.models.IntervalList;

/**
 * This is the Coding Task 2 Solution of Julian Stier - MBTI
 */
public class Main {
    public static void main(String[] args) {
        // uncomment the following lines if you want to give another input
        /*System.out.println("Please provide your input of intervals. An example could be [25,30][2,19][14,23][4,8]");
        Scanner stringScanner = new Scanner(System.in);
        String str = stringScanner.next();*/
        // you can change the following string for other inputs
        String str = "[25,30][2,19][14,23][4,8]";
        // * means The preceding expression may occur any number of times, including no times.
        // ? means The preceding expression does not occur once, it is "optional".
        String[] splited = str.split("\\[*\\,?\\]");

        IntervalList intervalList = new IntervalList();
        // convert the StringArray into an interval and add this to the IntervalList
        for (String s : splited) {
            String valuesSeperatedWithComma = s.substring(1);
            String[] touplePairStringArray = valuesSeperatedWithComma.split(",");
            intervalList.add(new Interval(Integer.parseInt(touplePairStringArray[0]), Integer.parseInt(touplePairStringArray[1])));
        }
        IntervalList result = intervalList.merge();
        System.out.println("Output:" + result);
    }

}