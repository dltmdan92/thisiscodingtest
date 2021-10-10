package dijkstra;

public class Node {
    private int target;
    private int cost;

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Node(int target, int cost) {
        this.target = target;
        this.cost = cost;
    }
}
