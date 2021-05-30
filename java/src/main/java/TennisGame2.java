
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    public String P1res = "";
    public String P2res = "";

    public TennisGame2() {
    }

    public String getString(){
        String score = "";
        if (is1Case())
            score = getStringFor1Case();

        if (is2Case())
            score = getString2Case();

        if (is3Case())
            score = getString3Case();

        if (is4Case())
            score = getString4Case();

        if (is5Case())
            score = getString5Case();

        if (P1point==P2point && P1point>=3)
            score = "Deuce";

        if (firstPlayerHasAdvantage(P1point, P2point))
            score = "Advantage player1";

        if (firstPlayerHasAdvantage(P2point, P1point))
            score = "Advantage player2";
        
        if (firstPlayerWins(P1point, P2point))
            score = "Win for player1";

        if (firstPlayerWins(P2point, P1point))
            score = "Win for player2";

        return score;
    }

    private boolean is5Case() {
        return P2point>P1point && P2point < 4;
    }

    private boolean is4Case() {
        return P1point>P2point && P1point < 4;
    }

    private boolean is3Case() {
        return P2point > 0 && P1point==0;
    }

    private boolean is2Case() {
        return P1point > 0 && P2point==0;
    }

    private boolean is1Case() {
        return P1point == P2point && P1point < 4;
    }

    private boolean firstPlayerHasAdvantage(int firstPlayerPoint, int secondPlayerPoint) {
        return firstPlayerPoint > secondPlayerPoint && secondPlayerPoint >= 3;
    }

    private boolean firstPlayerWins(int firstPlayerPoint, int secondPlayerPoint) {
        return firstPlayerPoint >= 4 && secondPlayerPoint >= 0 && (firstPlayerPoint - secondPlayerPoint) >= 2;
    }

    private String getString5Case() {
        if (P2point==2)
            P2res="Thirty";
        if (P2point==3)
            P2res="Forty";
        if (P1point==1)
            P1res="Fifteen";
        if (P1point==2)
            P1res="Thirty";
        return P1res + "-" + P2res;
    }

    private String getString4Case() {
        if (P1point==2)
            P1res="Thirty";
        if (P1point==3)
            P1res="Forty";
        if (P2point==1)
            P2res="Fifteen";
        if (P2point==2)
            P2res="Thirty";
        return P1res + "-" + P2res;
    }

    private String getString3Case() {
        setP2resValueAccordingToP2Point();
        P1res = "Love";
        return P1res + "-" + P2res;
    }

    private void setP2resValueAccordingToP2Point() {
        if (P2point==1)
            P2res = "Fifteen";
        if (P2point==2)
            P2res = "Thirty";
        if (P2point==3)
            P2res = "Forty";
    }

    private String getString2Case() {
        setP1resValueAccordingToP1point();
        P2res = "Love";
        return P1res + "-" + P2res;
    }

    private void setP1resValueAccordingToP1point() {
        if (P1point==1)
            P1res = "Fifteen";
        if (P1point==2)
            P1res = "Thirty";
        if (P1point==3)
            P1res = "Forty";
    }

    private String getStringFor1Case() {
        switch (P1point){
            case 0:
                return  "Love-All";
            case 1:
                return  "Fifteen-All";
            case 2:
                return  "Thirty-All";
            default:
                return "-All";
        }
    }

    public void increasePlayerPoint(String player) {
        if (player.equals("player1"))
            P1point++;
        else
            P2point++;
    }
}