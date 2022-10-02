/**
 * TODO: Add your file header
 * Name:
 * ID:
 * Email:
 * Sources used: Put "None" if you did not have any external help
 * Some example of sources used would be Tutors, Zybooks, and Lecture Slides
 * 
 * 2-4 sentence file description here
 */

import java.util.Scanner;

/**
 * TODO: Add your class header (purpose and capabilities of the class)
 */
public class RPS extends RPSAbstract {
    
    /**
     * TODO: Add method header
     */
    public RPS(String[] moves) {
        this.possibleMoves = moves;
        this.playerMoves = new String[MAX_GAMES];
        this.cpuMoves = new String[MAX_GAMES];
    }
    RPSAbstract A;
    @Override
    public int determineWinner(String playerMove, String cpuMove) {
        int playerPos=returnPos(possibleMoves, playerMove);
        int cpuPos = returnPos(possibleMoves, cpuMove);
        if(playerMove.equals("q")){
            return 5;
        }
        if(isValidMove(playerMove)==false || isValidMove(cpuMove)==false){
            return INVALID_INPUT_OUTCOME;
        }
        if(cpuMove.equalsIgnoreCase(possibleMoves[0])&& playerMove.equalsIgnoreCase(possibleMoves[possibleMoves.length-1])){
            return PLAYER_WIN_OUTCOME;
        }
        if(playerMove.equalsIgnoreCase(possibleMoves[0])&& cpuMove.equalsIgnoreCase(possibleMoves[possibleMoves.length-1])){
            return CPU_WIN_OUTCOME;
        }
        else if(cpuPos-playerPos==1){
            return PLAYER_WIN_OUTCOME;
        }
        else if(playerPos-cpuPos==1){
            return CPU_WIN_OUTCOME;
        }
        else if(playerMove.equalsIgnoreCase(cpuMove)||cpuPos-playerPos>1||playerPos-cpuPos>1){
            return TIE_OUTCOME;
        }
        return 0;
    }
    /**
     * Takes the user move, the CPU move, and determines who wins.
     * @param playerMove - move of the player
     * @param cpuMove - move of the CPU
     * @return -1 for invalid move, 0 for tie, 1 for player win, 2 for cpu win
     */

    /**
     * Main method that reads user input, generates cpu move, and plays game
     * 
     * @param args - arguments passed in from command line in String form
     */
    public static void main(String[] args) {
        // If command line args are provided use those as the possible moves
        String[] moves = new String[args.length];
        if (args.length >= MIN_POSSIBLE_MOVES) {
            for (int i = 0; i < args.length; i++) {
                moves[i] = args[i];
            }
        } else {
            moves = RPS.DEFAULT_MOVES;
        }
        // Create new game and scanner
        RPS game = new RPS(moves);
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println(PROMPT_MOVE);
            String userInput = in.nextLine();
            String answer = game.genCPUMove();
            game.play(userInput, answer);
            if(userInput.equals("q")){
                break;
            }
        }
        in.close();
        // TODO: Insert the code to play the game. 
        // See the writeup for an example of the game play.
        // Hint: call the methods we/you have already written 
        // to do most of the work!
    }
}
