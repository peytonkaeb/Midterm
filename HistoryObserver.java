import java.util.*;

class HistoryObserver implements Observer {

    private List<String> finishedGames = new ArrayList<>();

    @Override
    public void update(String teamA, String teamB, int scoreA, int scoreB, int quarter, boolean finished) {
        if (finished) {
            String result = teamA + " " + scoreA + " - " + scoreB + " " + teamB;
            finishedGames.add(result);
        }
    }

    public void printHistory() {
        System.out.println("\nFinished Games:");
        for (String game : finishedGames) {
            System.out.println(game);
        }
    }
}
