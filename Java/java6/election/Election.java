package java6.election;

import java6.election.candidate.Candidate;

public class Election{
    private int[] voteCounts;
    public Election(){}
    public void addVote(election.candidate.Candidate a){

    }
    public void addVotes(election.candidate.Candidate a, int b){

    }
    private int getCandidateCountWithMoreVotesThan(int b){
        return 0;
    }
    public election.candidate.Candidate[] getCandidatesWithMoreVotesThan(int b){
        return new election.candidate.Candidate[]{};
    }
    public election.candidate.Candidate getWinner(){
        return java6.election.candidate.Candidate.MAX;
    }
    private int getWinningIdx(){
        return 0;
    }
}