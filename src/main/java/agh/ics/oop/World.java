package agh.ics.oop;

import java.util.Arrays;

public class World {
    public static void main(String[] args) {

        Animal dog = new Animal();

        MoveDirection[] res_tab = OptionParser.parse(args);
        System.out.println(Arrays.toString(res_tab));

        for (MoveDirection md : res_tab) {
            dog.move(md);
        }

        System.out.println(dog);
    }
}
