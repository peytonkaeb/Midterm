class PredictionObserver implements Observer {

    private int predictedA;
    private int predictedB;
    private int correctPredictions = 0;
    private int totalGames = 0;
    private int totalError = 0;

    @Override
    public void update(String teamA, String teamB, int scoreA, int scoreB, int quarter, boolean finished) {

        predictedA = scoreA + (4 - quarter) * 25;
        predictedB = scoreB + (4 - quarter) * 25;

        if (finished) {
            totalGames++;

            if ((predictedA > predictedB && scoreA > scoreB) ||
                (predictedB > predictedA && scoreB > scoreA)) {
                correctPredictions++;
            }

            totalError += Math.abs(scoreA - predictedA) + Math.abs(scoreB - predictedB);
        }
    }

    public void printPrediction() {
        System.out.println("Predicted Final Score: " + predictedA + " - " + predictedB);
    }

    public void printStats() {
        System.out.println("Correct Predictions: " + correctPredictions);
        if (totalGames > 0)
            System.out.println("Average Error: " + (totalError / totalGames));
    }
}
