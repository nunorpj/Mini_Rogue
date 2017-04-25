package mini_rogue.logic;

import java.util.concurrent.ThreadLocalRandom;


public class Dice {
    private int num, num2, value;

    public Dice() {
        this.num = -1;
    }

    public void roll() {

        this.num = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        if (num == 6)
            num2 = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        else
            num2 = 0;

        if ((num == 6 && num2 == 1) || num == 1)
            value = 0;
        else
            value = num + num2;
    }

    public int getDiceNumber() {
        return value;
    }

    public int getFirtNumber() {
        return num;
    }

    public int getSecondNumber() {
        return num2;
    }
}
