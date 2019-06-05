package com.javagda25.comparator.zadanie2;

import java.util.Comparator;

public class OfertaSprzedazyComparator implements Comparator<OfertaSprzedazy> {

    private boolean rosnacy;

    public OfertaSprzedazyComparator(boolean rosnacy) {
        this.rosnacy = rosnacy;
    }

    public int compare(OfertaSprzedazy o1, OfertaSprzedazy o2) {
        if (rosnacy) {
            return Double.compare(o1.getCena(), o2.getCena());
        } else {
            return Double.compare(o2.getCena(), o1.getCena());
        }
    }
}
