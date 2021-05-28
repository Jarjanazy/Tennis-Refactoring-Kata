
public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;

    public TennisGame1() { }

    public void increasePlayerPoint(String playerName) {
        if (playerName.equals("player1"))
            m_score1++;
        else
            m_score2++;
    }

    public String getString() {
        if (m_score1 == m_score2)
            return getStringForEqualScores(m_score1);

        else if (m_score1>=4 || m_score2>=4)
            return getStringForScoreAbove4(m_score1 - m_score2);

        else
            return getStringForScoresBelow4(m_score1, m_score2);
    }

    private String getStringForScoresBelow4(int score1, int score2) {
        StringBuilder score  = new StringBuilder();
        for (int i = 1; i<3; i++)
        {
            if (i==1)
                score.append(getStringInLoop(score1));
            else {
                score.append("-");
                score.append(getStringInLoop(score2));
            }
        }
        return score.toString();
    }

    private String getStringInLoop(int score){
        switch(score)
        {
            case 0:
                return ("Love");
            case 1:
                return ("Fifteen");
            case 2:
                return ("Thirty");
            case 3:
                return ("Forty");
            default:
                return "";
        }
    }

    private String getStringForScoreAbove4(int score) {
        if (score==1)
            return "Advantage player1";
        else if (score ==-1)
            return "Advantage player2";
        else if (score >=2 )
            return "Win for player1";
        else
            return "Win for player2";
    }

    private String getStringForEqualScores(int score) {
        switch (score)
        {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }
}
