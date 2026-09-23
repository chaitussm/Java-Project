package pack4;

import pack1.Fish;
import static pack1.Fish.GUPPY;

/** Scenario 3: type import + static import — {@code Fish.STAR} and bare {@code GUPPY}. */
public class Test3 {

    public static void main(String[] args) {
        Fish f = Fish.STAR;
        System.out.println(GUPPY);
    }
}
