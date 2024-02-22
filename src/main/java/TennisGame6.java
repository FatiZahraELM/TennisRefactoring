public class TennisGame6 implements TennisGame {
    private final String player1Name;
    private final String player2Name;
    private int player1Score;
    private int player2Score;

    public TennisGame6(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            player1Score++;
        else
            player2Score++;

    }

    public String getScore()
    {
        String result;

        if (player1Score == player2Score)
        {
            // tie score
            String tieScore;
            switch (player1Score)
            {
                case 0:
                    tieScore = "Love-All";
                    break;
                case 1:
                    tieScore = "Fifteen-All";
                    break;
                case 2:
                    tieScore = "Thirty-All";
                    break;
                default:
                    tieScore = "Deuce";
                    break;
            }

            result = tieScore;
        }
        else if (player1Score >= 4 || player2Score >= 4)
        {
            // end-game score
            String endGameScore;

            if (player1Score - player2Score == 1) {
                endGameScore = "Advantage " + player1Name;
            } else if (player1Score - player2Score == -1) {
                endGameScore = "Advantage " + player2Name;
            } else if (player1Score - player2Score >= 2) {
                endGameScore = "Win for " + player1Name;
            } else {
                endGameScore = "Win for " + player2Name;
            }

            result = endGameScore;
        }
        else
        {
            // regular score
            String regularScore;

            String score1 =  resultPlayer(player1Score);

            String score2 =  resultPlayer(player2Score);

            regularScore = score1 + "-" + score2;

            result = regularScore;
        }

        return result;
    }
    private String resultPlayer(int points) {
        String score="" ;
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
