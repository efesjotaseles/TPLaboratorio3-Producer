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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }

    public int getDueDay() {
        return dueDay;
    }

    public void setDueDay(int dueDay) {
        this.dueDay = dueDay;
    }

    public int getGoalCash() {
        return goalCash;
    }

    public void setGoalCash(int goalCash) {
        this.goalCash = goalCash;
    }
}
