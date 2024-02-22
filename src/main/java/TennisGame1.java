
public class TennisGame1 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);
        this.player1 = player1;
        this.player2 = player2;


    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName()))
            player1.setPoints(player1.getPoints() + 1);
        if (playerName.equals( player2.getName()))
            player2.setPoints(player2.getPoints() + 1);
    }

    public String getScore() {
        String score;

        if (player1.getPoints() == player2.getPoints()) {
            int matchedPoint=player1.getPoints();
            score = switch (matchedPoint) {
                case 0 -> "Love-All";
                case 1 -> "Fifteen-All";
                case 2 -> "Thirty-All";
                default -> "Deuce";
            };
        } else if (player1.getPoints() >= 4 || player2.getPoints() >= 4) {
            int minusResult = player1.getPoints() - player2.getPoints();
            if (minusResult == 1) score = "Advantage "+player1.getName();
            else if (minusResult == -1) score = "Advantage "+player2.getName();
            else if (minusResult >= 2) score = "Win for "+player1.getName();
            else score = "Win for "+player2.getName();
        } else {
            String score1 = scorePlayer(player1.getPoints());
            String score2 = scorePlayer(player2.getPoints());

            score=score1+"-"+score2;

        }


        return score;
    }


    private String scorePlayer(int points) {
        String score = "";
        switch (points) {
            case 0:
                score += "Love";
                break;
            case 1:
                score += "Fifteen";
                break;
            case 2:
                score += "Thirty";
                break;
            case 3:
                score += "Forty";
                break;
        }

        return score;

    }
}