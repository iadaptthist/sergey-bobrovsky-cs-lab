import java.util.*;

public class Level1
{
    public static String MassVote(int N, int [] Votes)
      {
        int totalVotes = 0;
        int maxVotes = 0;
        int winner = 1;
        int winnersCount = 1;

        for (int i = 0; i < N; i++) {
            totalVotes += Votes[i];

            if (i == 0) {
                maxVotes = Votes[i];
            } else if (Votes[i] > maxVotes) {
                maxVotes = Votes[i];
                winner = i + 1;
                winnersCount = 1;
            } else if (Votes[i] == maxVotes) {
                winnersCount++;
            }
        }

        if (winnersCount > 1) {
            return "no winner";
        }

        double winnerVoteShare = (double) maxVotes / totalVotes * 100;
        double roundedVoteShare = Math.round(winnerVoteShare * 1000.0) / 1000.0;

        if (roundedVoteShare > 50.0) {
            return "majority winner " + winner;
        } else {
            return "minority winner " + winner;
        }
    }
}

