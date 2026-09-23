package pack2;

import pack1.Fish;

/** Scenario 1: type import — use {@code Fish.GUPPY}. */
public class Test1 {

    public static void main(String[] args) {
        Fish f = Fish.GUPPY;
        System.out.println(f);
    }
}
