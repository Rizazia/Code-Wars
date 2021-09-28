/*
A common exercise, when you're learning a new language, is to make a guessing game. It's a great way to learn control structures, IO, the works.

This is taking the guessing game to a whole new level. This time, you're the one playing the guessing game. And the guessing game is Math.random().

The task is really simple. You make a guess, Math.random() does it's thing, and if you're right 5 times out of 5, you win!

Don't guess the same thing every time.

Hint: You guess first.
*/
import java.lang.reflect.Field;
import java.util.Random;

public class Psychic {

    static long seed = System.currentTimeMillis();
    static Random random = new Random(seed);

    static {
        setup();
    }

    public static double guess() {
        return random.nextDouble();
    }

    private static void setup() {
        try {
            Class<?> randomGeneratorClass = Class.forName("java.lang.Math$RandomNumberGeneratorHolder");

            Field randomNumberGeneratorField = randomGeneratorClass.getDeclaredField("randomNumberGenerator");
            randomNumberGeneratorField.setAccessible(true);
            Random random = (Random) randomNumberGeneratorField.get(null);

            random.setSeed(seed);
        } catch (IllegalAccessException | NoSuchFieldException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}