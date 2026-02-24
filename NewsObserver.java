class NewsObserver implements Observer {

    private String lastTitle = "";

    @Override
    public void update(String teamA, String teamB, int scoreA, int scoreB, int quarter, boolean finished) {

        if (finished) {
            int diff = Math.abs(scoreA - scoreB);
            String winner = scoreA > scoreB ? teamA : teamB;
            String loser = scoreA > scoreB ? teamB : teamA;

            String type = diff > 15 ? "in a landslide" : "in a tightly contested game";

            lastTitle = winner + " beat " + loser + " by " + diff + " points " + type;
        }
    }

    public void printTitle() {
        System.out.println("News: " + lastTitle);
    }
}
