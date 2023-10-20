import java.util.*;

public class Tic {
    static String[] board;
    static String turn;

    // static String checkWinner();
// Check winner method will
    static String checkWinner(){
        for(int a = 0;a<8;a++){
            String line = null;
            switch(a){
                case 0:
                line = board[0] + board[1]+ board[2];
                break;
                case 1:
                line = board[3]+board[4]+board[5];
                break;
                case 2:
                line = board[6]+board[7]+board[8];
                break;
                case 3:
                line = board[0]+board[3]+ board[6];
                break;
                case 4:
                line = board[1] + board[4] + board[7];
                break;
                case 5:
                line = board[2] + board[5] + board[8];
                break;
                case 6:
                line = board[0] + board[4] + board[8];
                break;
                case 7:
                line = board[2] + board[4] + board[6];
                break;
             }
            //  For X winner
            if(line.equals("XXX")){
                return "X";
            }
            else if(line.equals("OOO")){
                return "O";
            }
        
        }
        
        for(int a = 0; a<9; a++){
            if(Arrays.asList(board).contains(String.valueOf(a +1))){
                break;
            }
            else if(a == 8){
                return "draw";
            }

            
        }
        // To enter x or O AT EXACT PLACE ON BOARD
        System.out.println(turn + " 's turn; enter a slot number to place"
        + turn + " in:");
        return null;

    }
    // to print out on the board
    // |--|--|--|
    // | 1|2 | 3|
    // |4 |5 |6 |
    // | 7| 8| 9|

    static void printBoard(){
        System.out.println(" |---|---|---| ");
        System.out.println(" | " + board[0] + " | " +
        board[1] + "| " + board[2] + " | ");
        System.out.println("|------------|");
        System.out.println("| " + board[3]+ " | " + board[4] + " | " + board[5] + " | ");
        System.out.println("|-----------|");
        System.out.println(" | " + board[6] + " | " +  board[7] + " | " + board[8] + " | ");
        System.out.println("|---|---|---|");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        board = new String[9];
        turn = "X";
        String winner = null;
        for(int a = 0;a<9;a++){
            board[a]= String.valueOf(a+1);
        }
        // eXCEPTION HANDLING 
        // nUMiNPUT WILL TAKE INPUT FROM USER
        // IF ITS IS NOT IN RANGE OF 1 TO 9 THEN IT WILL SHOW AN ERROR "iNVALID INPUT"
        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printBoard();
        System.out.println("X will play first. Enter a slot number to place X in :");
        
        while(winner==null){
            int numInput;
            

            try{
                numInput = sc.nextInt();
                if(!(numInput > 0 && numInput <=9)){
                    System.out.println("Invalid input; re-enter slot number:");
                    continue;
                }
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input; re-enter slot number:");
                continue;
            }
            /*THIS GAME HAS TWO PALYER X AND O.
             * HERE IS LOGIC TO DECIDE THE TURN
             */
            if(board[numInput-1].equals(String.valueOf(numInput))){
                board[numInput - 1] = turn;
                if(turn.equals("X")){
                    turn = "O";
                }
                else{
                    turn = "X";
                }
                printBoard();
                winner = checkWinner();
            }
            else{
                System.out.println("Slot already taken;re-enter slot number:");

            }
        }
        /*IF NO ONE WILL WIN OR LOOSE BOTH PLAYER X OR O 
         * THEN THERE IS A LOGIC TO PRINT "DRAW".
        */
        if(winner.equalsIgnoreCase("draw")){
            System.out.println("It's a draw! Thanks for palying Game.");
        }
        /*FOR WINNER TO DISPLAY CONGRATULATION! MESSAGE. */
        else{
            System.out.println("Congratulations! " + winner + " 's have won! Thanks for playing.");
        }
        sc.close();
    }
}
    /*--End of code  */

    



