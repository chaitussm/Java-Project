package com.collection.set.comparatorConcepts.stringbufferComparator;

import java.util.Comparator;

public class stringBufferComparator implements Comparator<StringBuffer> {

    @Override
    public int compare(StringBuffer sb1, StringBuffer sb2) {

        String str1 = sb1.toString();
        String str2 = sb2.toString();
        return str1.compareTo(str2);
    }
}
