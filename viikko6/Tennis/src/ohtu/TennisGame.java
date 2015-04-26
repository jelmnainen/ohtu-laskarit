package ohtu;

public class TennisGame {

    private int p1Score = 0;
    private int p2Score = 0;
    private String p1Name;
    private String p2Name;

   public TennisGame(String player1Name, String player2Name) {
        this.p1Name = player1Name;
        this.p2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1")){
            p1Score += 1;
        } else {
            p2Score += 1;
        }
    }

    public String getScore() {
        String score = "";
        if (p1Score==p2Score)
        {
            score = getNonDeuceEvenScore(score);
        }
        else if (p1Score>=4 || p2Score>=4)
        {
            score = getDeuceOrWinScore(score);
        }
        else {
            score = getNonDeuceUnevenScore(p1Score, score);
            score += "-";
            score = getNonDeuceUnevenScore(p2Score, score);
        }
        return score;
    }

    private String getDeuceOrWinScore(String score) {
        int minusResult = p1Score-p2Score;

        if (minusResult==1){
            score ="Advantage player1";
        } else if (minusResult ==-1){
            score ="Advantage player2";
        } else if (minusResult>=2) {
            score = "Win for player1";
        } else {
            score ="Win for player2";
        }

        return score;
    }

    private String getNonDeuceEvenScore(String score){
        switch (p1Score)
            {
                case 0:
                        score = "Love-All";
                    break;
                case 1:
                        score = "Fifteen-All";
                    break;
                case 2:
                        score = "Thirty-All";
                    break;
                case 3:
                        score = "Forty-All";
                    break;
                default:
                        score = "Deuce";
                    break;
            }
        return score;
    }

    private String getNonDeuceUnevenScore(int scoreInt, String scoreStr) {
        switch(scoreInt)
        {
            case 0:
                scoreStr+="Love";
                break;
            case 1:
                scoreStr+="Fifteen";
                break;
            case 2:
                scoreStr+="Thirty";
                break;
            case 3:
                scoreStr+="Forty";
                break;
        }
        return scoreStr;
    }
}
