package pack3;

import static pack1.Fish.STAR;

/** Scenario 2: static import of one constant — use {@code STAR} without {@code Fish.} prefix. */
public class Test2 {

    public static void main(String[] args) {
        System.out.println(STAR);
    }
}
