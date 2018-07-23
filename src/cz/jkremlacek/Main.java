package cz.jkremlacek;

import cz.jkremlacek.dynamic.RandomClass1;
import cz.jkremlacek.staticname.RandomClass2;

public class Main {

    public static int LIMIT = 10000;

    public static void main(String[] args) {

        String staticName = "";
        String dynamicName = "";

        //test dynamic
        long startTimeDynamic = System.nanoTime();

        for (int i = 0; i < LIMIT; i++) {
            dynamicName += new RandomClass1().getClassName();
        }

        long endTimeDynamic = System.nanoTime();

        //test static
        long startTimeStatic = System.nanoTime();

        for (int i = 0; i < LIMIT; i++) {
            staticName += new RandomClass2().getClassName();
        }

        long endTimeStatic = System.nanoTime();

        long dynamicTime = endTimeDynamic - startTimeDynamic;
        long staticTime = endTimeStatic - startTimeStatic;

        float dynamicPerItem = ((float) dynamicTime) / LIMIT;
        float staticPerItem = ((float) staticTime) / LIMIT;

        System.out.println("Dynamic time per item: \t" + dynamicPerItem / 1000 + " ms");
        System.out.println("Static time per item: \t" + staticPerItem / 1000 + " ms");
        System.out.println("Static is " + new Integer((int) (dynamicPerItem / staticPerItem)) + "-times faster.");
        System.out.println(dynamicName.equals(staticName));
    }
}
