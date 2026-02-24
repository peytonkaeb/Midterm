import java.util.*;

class Scoring implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private String teamA;
    private String teamB;
    private int scoreA = 0;
    private int scoreB = 0;
    private int quarter = 0;
    private boolean gameFinished = false;
    private Random rand = new Random();

    public Scoring(String teamA, String teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
    }

    public void simulateQuarter() {
        if (quarter >= 4) {
            System.out.println("Game already finished.");
            return;
        }

        quarter++;

        // Random basketball scoring (20–35 per quarter)
        scoreA += rand.nextInt(16) + 20;
        scoreB += rand.nextInt(16) + 20;

        if (quarter == 4) {
            gameFinished = true;
        }

        notifyObservers();
    }

    public void printCurrentScore() {
        System.out.println(teamA + ": " + scoreA + " | " +
                           teamB + ": " + scoreB +
                           " (Quarter " + quarter + ")");
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(teamA, teamB, scoreA, scoreB, quarter, gameFinished);
        }
    }

    public boolean isFinished() {
        return gameFinished;
    }

    public String getTeamA() { return teamA; }
    public String getTeamB() { return teamB; }
    public int getScoreA() { return scoreA; }
    public int getScoreB() { return scoreB; }
}
