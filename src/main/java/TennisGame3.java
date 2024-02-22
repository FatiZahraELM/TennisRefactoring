
public class TennisGame3 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame3(String player1Name, String player2Name) {
        Player player1 = new Player(player1Name);
        Player player2 = new Player(player2Name);
        this.player1 = player1;
        this.player2 = player2;


    }
    public String getScore() {
        String s;
        if (player1.getPoints() < 4 && player2.getPoints() < 4 && (player1.getPoints() + player2.getPoints()) < 6) {
            String[] scores = new String[] { "Love", "Fifteen", "Thirty", "Forty" };
            s = scores[player1.getPoints()];
            return (player1.getPoints() == player2.getPoints()) ? s + "-All" : s + "-" + scores[player2.getPoints()];
        } else {
            if (player1.getPoints() == player2.getPoints())
                return "Deuce";
            s = player1.getPoints() > player2.getPoints() ? player1.getName() : player2.getName();
            return ((player1.getPoints()-player2.getPoints())*(player1.getPoints()-player2.getPoints()) == 1) ? "Advantage " + s : "Win for " + s;
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName()))
            this.player1.setPoints(player1.getPoints()+1) ;
        if (playerName.equals(player2.getName()))
            this.player2.setPoints(player2.getPoints()+1) ;
        
    }

}
