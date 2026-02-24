import java.util.*;

public class BasketballGame {

    private static Scoring currentGame;
    private static PredictionObserver predictor = new PredictionObserver();
    private static HistoryObserver history = new HistoryObserver();
    private static NewsObserver news = new NewsObserver();
    private static Scanner scanner = new Scanner(System.in);

    private static String[] teams = {
        "Lakers", "Celtics", "Bulls", "Heat",
        "Warriors", "Nets", "Spurs", "Suns"
    };

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1. Start New Game");
            System.out.println("2. Simulate Quarter");
            System.out.println("3. Print Current Score");
            System.out.println("4. Print Current Prediction");
            System.out.println("5. Print Prediction Stats");
            System.out.println("6. Print Finished Games");
            System.out.println("7. Generate News Title");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    startNewGame();
                    break;

                case 2:
                    if (currentGame != null)
                        currentGame.simulateQuarter();
                    break;

                case 3:
                    if (currentGame != null)
                        currentGame.printCurrentScore();
                    break;

                case 4:
                    predictor.printPrediction();
                    break;

                case 5:
                    predictor.printStats();
                    break;

                case 6:
                    history.printHistory();
                    break;

                case 7:
                    news.printTitle();
                    break;

                case 0:
                    return;
            }
        }
    }

    private static void startNewGame() {
        Random rand = new Random();
        String teamA = teams[rand.nextInt(teams.length)];
        String teamB;

        do {
            teamB = teams[rand.nextInt(teams.length)];
        } while (teamA.equals(teamB));

        currentGame = new Scoring(teamA, teamB);

        currentGame.registerObserver(predictor);
        currentGame.registerObserver(history);
        currentGame.registerObserver(news);

        System.out.println("New Game Started: " + teamA + " vs " + teamB);
    }
}
