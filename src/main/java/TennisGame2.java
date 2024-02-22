import static java.lang.Math.abs;

public class TennisGame2 implements TennisGame
{
    private Player player1;
    private Player Player;

    


    public TennisGame2(String player1Name, String PlayerName) {
        Player p1= new Player(player1Name);
        Player p2= new Player(PlayerName);
        this.player1 = p1;
        this.Player = p2;
    }

    public String getScore(){
        String score = "";
        if (player1.getPoints() == Player.getPoints() ){
            if(player1.getPoints() < 3) {

                    if (player1.getPoints() == 0)
                        score = "Love";
                    if (player1.getPoints() == 1)
                        score = "Fifteen";
                    if (player1.getPoints() == 2)
                        score = "Thirty";
                    score += "-All";
                }
            else{
                score = "Deuce";
            }
        }
        else {
            String result1= resultPlayer(player1.getPoints());
            String result2=resultPlayer(Player.getPoints());
            score = result1 + "-" + result2;

        }

        if (player1.getPoints() > Player.getPoints() && Player.getPoints() >= 3)
        {

            score = "Advantage "+player1.getName();
        }
        
        if (Player.getPoints() > player1.getPoints() && player1.getPoints() >= 3)
        {
            score = "Advantage "+Player.getName();
        }
        
        if (player1.getPoints()>=4 && Player.getPoints()>=0 && (player1.getPoints()-Player.getPoints())>=2)
        {
            score = "Win for "+player1.getName();
        }
        if (Player.getPoints()>=4 && player1.getPoints()>=0 && (Player.getPoints()-player1.getPoints())>=2)
        {
            score = "Win for "+Player.getName();
        }
        return score;
    }

    
    public void PScore(Player player){
        player.setPoints(player.getPoints()+1);
    }

    public void wonPoint(String player) {
        if (player == player1.getName())
            PScore(player1);
        else
            PScore(Player);
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