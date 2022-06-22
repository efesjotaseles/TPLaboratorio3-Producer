package GameEntities;

public class GameState {
    private Player player;
    private int currentDay;
    private int dueDay;
    private int goalCash;

    public GameState(int dueDay, int goalCash) {
        player = null;
        currentDay = 1;
        this.dueDay = dueDay;
        this.goalCash = goalCash;
    }

    public GameState() {
        player = null;
        currentDay = 1;
        dueDay = -1;
        goalCash = -1;
    }
}
