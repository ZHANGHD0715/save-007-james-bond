package com.haidong.saveJamasBond;

import org.junit.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;
import java.util.List;

public class LakeTest {

    @Test
    public void should_return_true_when_given_two_spots_with_short_distance() {
        List<Spot> spots = new ArrayList<>();
        Spot spotA = new Spot(1, 2);
        Spot spotB = new Spot(2, 3);

        spots.add(spotA);
        spots.add(spotB);

        Lake lake = new Lake(spots);
        Assert.that(lake.canJump(spotA, spotB), "Can Jump");
    }

    @Test
    public void should_return_false_when_given_two_spots_with_long_distance() {
        Spot spotA = new Spot(1, 2);
        Spot spotB = new Spot(4, 6);

        List<Spot> spots = new ArrayList<Spot>() {{
            add(spotA);
            add(spotB);
        }};

        Lake lake = new Lake(spots);
        Assert.that(!lake.canJump(spotA, spotB), "Can Not Jump");
    }

    @Test
    public void should_return_true_when_given_spot_closer_to_edge() {
        List<Spot> spots = new ArrayList<>();
        Spot spot = new Spot(11, 0);

        spots.add(spot);

        Lake lake = new Lake(spots);
        Assert.that(lake.isSafe(spot), "Is Safe");
    }

    @Test
    public void should_return_false_when_given_spot_far_from_edge() {
        List<Spot> spots = new ArrayList<>();
        Spot spot = new Spot(4, 0);

        spots.add(spot);

        Lake lake = new Lake(spots);
        Assert.that(!lake.isSafe(spot), "Is Not Safe");
    }
}
