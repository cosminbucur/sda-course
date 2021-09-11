package com.bucur.patterns.structural.adapter.adapters;

import com.bucur.patterns.structural.adapter.round.RoundPeg;
import com.bucur.patterns.structural.adapter.square.SquarePeg;

/**
 * Adapter allows fitting square pegs into round holes.
 */
public class SquarePegAdapter extends RoundPeg {

    private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        double result;
        // Calculate a minimum circle radius, which can fit this peg.
        result = Math.sqrt(Math.pow(peg.getWidth() / 2, 2) * 2);
        return result;
    }
}
