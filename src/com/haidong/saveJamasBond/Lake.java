package com.haidong.saveJamasBond;

import java.util.List;

public class Lake {
    private final int MAX_JUMP = 2;
    private final int MAX_EDGE = 10;

    private List<Spot> spots;
    private boolean[] visited;

    public Lake(List<Spot> spots) {
        this.spots = spots;
        this.visited = new boolean[spots.size()];
    }

    public void printSpots() {
        for (Spot spot : spots) {
            System.out.printf("Spot: %f, %f\n", spot.XAxis, spot.YAxis);
        }
    }

    public String findRoute() {
        for (int i = 0; i < spots.size(); i++) {
            if (!visited[i]) {
                if (dfs(i)) {
                    return "YES";
                }
            }
        }

        return "NO";
    }

    private Boolean dfs(int index) {
        visited[index] = true;
        if (isSafe(spots.get(index))) {
            return true;
        }

        for (int i = 0; i < spots.size(); i++) {
            if (!visited[i] && canJump(spots.get(index), spots.get(i))) {
                if (dfs(i)) {
                    return true;
                }
            }
        }

        return false;
    }

    protected boolean canJump(Spot current, Spot next) {
        float x = Math.abs(next.XAxis - current.XAxis);
        float y = Math.abs(next.YAxis - current.YAxis);

        double dis = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return dis <= MAX_JUMP;
    }

    protected boolean isSafe(Spot spot) {
        float x = Math.abs(spot.XAxis);
        float y = Math.abs(spot.YAxis);
        if (MAX_EDGE <= x && x < MAX_EDGE + MAX_JUMP) {
            return true;
        }

        if (MAX_EDGE <= y && y < MAX_EDGE + MAX_JUMP) {
            return true;
        }

        return false;
    }
}
