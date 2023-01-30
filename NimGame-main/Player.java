//Class declaration
class Player{
    public String playerName;
    public int score;

    public Player(String a, int scoreInput){
        
        playerName = a;
        score = scoreInput;
        }
    
    public void playerTurn(){
        System.out.println("How many pieces does " + playerName + " want to take?");
    }

    public int playerScore(){
        return score;
    }

    public void setName(String newName){
        playerName = newName;
    }
    public void addScore(){
        score += 1;
    }
}
