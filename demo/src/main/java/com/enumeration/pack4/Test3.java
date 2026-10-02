package com.enumeration.pack4;

import static com.enumeration.pack1.Fish.GUPPY;

import com.enumeration.pack1.Fish;

/** Scenario 3: type import + static import — {@code Fish.STAR} and bare {@code GUPPY}. */
public class Test3 {

    public static void main(String[] args) {
        Fish f = Fish.STAR;
        System.out.println(GUPPY);
    }
}
