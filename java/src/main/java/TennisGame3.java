
public class TennisGame3 implements TennisGame {
    
    private int p2;
    private int p1;
    private final String p1N;
    private final String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getString() {
        if (bothAre4AndSumNot6(p1, p2))
            return modifyAndGetValueFromArray(new String[]{"Love", "Fifteen", "Thirty", "Forty"});
        else if (p1 == p2)
            return "Deuce";
        else
            return getAdvantage_Or_WinFor_String(p1, p2, p1N, p2N);
    }

    private String getAdvantage_Or_WinFor_String(int p1, int p2, String p1N, String p2N) {
        String largestPointString = p1 > p2 ? p1N : p2N;
        return ( squareIsEqualTo1(p1, p2) ? "Advantage " : "Win for ") + largestPointString;
    }

    private boolean squareIsEqualTo1(int p1, int p2) {
        return (p1 - p2) * (p1 - p2) == 1;
    }

    private String modifyAndGetValueFromArray(String[] array) {
        String s = array[p1];
        return (p1 == p2) ? s + "-All" : s + "-" + array[p2];
    }

    private boolean bothAre4AndSumNot6(int p1, int p2) {
        return p1 < 4 && p2 < 4 && !(p1 + p2 == 6);
    }

    public void increasePlayerPoint(String playerName) {
        if (playerName.equals("player1"))
            this.p1 += 1;
        else
            this.p2 += 1;
    }
}
