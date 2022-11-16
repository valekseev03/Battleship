import java.util.Scanner;
/*
To play compile this in a java compiler (preferably eclipse) and run. You can play with an "AI" or another player. Use the console to play.
 
Sorry for any spaghetti code this was made in my sophomore year of high school, so feel free to modify it. Also feel free to view any other projects I made.
*/
 
public class MainGame {
    private int wincount = 0;
    private boolean win = false;
    
    private String[][] playerboard = new String[][] {
        {"_","_","_","_","_","_","_","_",},
        {"_","_","_","_","_","_","_","_",},
        {"_","_","_","_","_","_","_","_",},
        {"_","_","_","_","_","_","_","_",},
        {"_","_","_","_","_","_","_","_",},
        {"_","_","_","_","_","_","_","_",},
        {"_","_","_","_","_","_","_","_",},
        {"_","_","_","_","_","_","_","_",},
    };
    
    
    private String[][] playerboard2 = new String[][] {
        {"_","_","_","_","_","_","_","_",},
        {"_","_","_","_","_","_","_","_",},
        {"_","_","_","_","_","_","_","_",},
        {"_","_","_","_","_","_","_","_",},
        {"_","_","_","_","_","_","_","_",},
        {"_","_","_","_","_","_","_","_",},
        {"_","_","_","_","_","_","_","_",},
        {"_","_","_","_","_","_","_","_",},
    };
    
    
    String[][] enemyboard = new String[][] {
        {"🚢","🚢","🚢","🚢","_","_","_","_",},
        {"_","_","_","_","_","_","🚢","_",},
        {"_","_","_","_","_","_","🚢","_",},
        {"_","_","_","_","_","_","_","_",},
        {"_","_","_","_","🚢","🚢","🚢","_",},
        {"_","_","🚢","🚢","🚢","🚢","🚢","_",},
        {"_","_","_","_","_","_","_","_",},
        {"_","_","_","_","_","_","_","_",}, 
    };
    
    private int turn = 1;
    private int enemyships;
    private int playerships;
 
    public String showPlayerBoard(boolean canShow) {
    playerships = 0;
    String s = "";
    for(int i = 0; i < 8; i++) {    
        for(int j =0; j < 8; j++) {
        if((playerboard[i][j] == "🚢" && canShow == false)) {
            s += "_ ";
            playerships++;  
        }else {
            s += playerboard[i][j] + " ";
            if(playerboard[i][j] == "🚢") {
            playerships++;  
            }
            }
        }
        s += "\n";
    }
    turn++;
    return s;   
    }
    
    public String showPlayerBoard2(boolean canShow) {
        enemyships = 0;
        String s = "";
        for(int i = 0; i < 8; i++) {    
            for(int j =0; j < 8; j++) {
            if((playerboard2[i][j] == "🚢" && canShow == false)) {
                s += "_" + " "; 
                enemyships++;
            }else {
                s += playerboard2[i][j] + " ";
                if(playerboard2[i][j] == "🚢") {
                enemyships++;   
                }
                }
            }
            s += "\n";
        }
        turn++;
        return s;   
        }
    
    
    public String showEnemyBoard(boolean canShow) {
    String s = "";
    enemyships = 0;
    
    for(int i = 0; i < 8; i++) {    
        for(int j =0; j < 8; j++) {
    
        if(enemyboard[i][j] == "🚢" && canShow == false) {
            s += "_ ";
            enemyships++;
        }else {
            s += enemyboard[i][j]+ " ";
            if(enemyboard[i][j] == "🚢") {
                enemyships++;   
                }
        }
        }
        s += "\n";
    }
    return s;   
    }
    
    public String[][] setupPlayerBoard(int X1, int Y1, int X2, int Y2) {
                
        
            for(int a = 0; a < X2 - X1; a++) {
                for(int l = 0; l < Y2 - Y1; l++) {
                    if(X1 + a < 9 || Y1 + a < 9) {  
                        playerboard[X1 + a][Y1 + l] = "🚢";
                        
                        
                    }
                    
                }
            }
            
            for(int a = 0; a < Y2 - Y1; a++) {
                for(int l = 0; X2 - X1 < 1; l++) {
                    if(X1 + a < 9 || Y1 + a < 9) {  
                        playerboard[X1 + a][Y1 + l] = "🚢";
                        
                        
                    }
                }
                
        }
        
        
        return playerboard;
    }
    
    public String[][] setupPlayer2Board(int X1, int Y1, int X2, int Y2) {
        
            for(int a = 0; a < X2 - X1; a++) {
                for(int l = 0; l < Y2 - Y1; l++) {
                    if(X1 + a < 9 || Y1 + a < 9) {  
                        playerboard2[X1 + a][Y1 + l] = "🚢";
                        
                        
                    }
                    
                }
            }
            
            for(int a = 0; a < Y2 - Y1; a++) {
                for(int l = 0; X2 - X1 < 1; l++) {
                    if(X1 + a < 9 || Y1 + a < 9) {  
                        playerboard2[X1 + a][Y1 + l] = "🚢";
                        
                        
                    }
                }
            }   
        
        
        
        return playerboard2;
    }
    
    
    public String[][] fireatEnemyBoard(int X, int Y){
        String s[][] = enemyboard;
        
        if(enemyboard[X][Y] == "🚢") {
        s[X][Y] = "💥";
        enemyships--;
        }
        else{
        s[X][Y] = "💦";   
        }
        
        if(enemyships <= 0) {
            System.out.println("You Win!"); 
            win = true;
            }
        return s;
    }
    
    public String[][] fireatPlayer1Board(int X, int Y){
        String s[][] = playerboard;
        
        if(playerboard[X][Y] == "🚢") {
        s[X][Y] = "💥";
        playerships--;
        }
        else{
        s[X][Y] = "💦";   
        }
        
        if(playerships == 0 && wincount == 0) {
            System.out.println("You Win!");
            win = true;
            wincount++;
            }
        return s;
    }
    
    public String[][] fireatPlayer2Board(int X, int Y){
        String s[][] = playerboard2;
        
        if(playerboard2[X][Y] == "🚢") {
        s[X][Y] = "💥";
        enemyships--;
        }
        else{
        s[X][Y] = "💦";   
        }
        
        if(enemyships == 0 && wincount == 0) {
            System.out.println("You Win!"); 
            wincount++;
            win = true;
            }
        return s;
    }
    
    public String[][] fireatPlayerBoard(){
        String s[][] = playerboard;
        int X = (int)(Math.random()*8);
        int Y = (int)(Math.random()*8);
        
        if(playerboard[X][Y] == "🚢") {
        s[X][Y] = "💥";
        playerships--;
        }
        else{
        s[X][Y] = "💦";   
        }
        
        if(playerships == 0) {
        System.out.println("You Lose!");    
        win = true;
        }
        return s;
    
    }
    
    public boolean detectWin() {
    boolean b = false;
    if(win == true || playerships <= 0 || enemyships <=0) {
    b = true;   
    }
    return b;
    }
 
    public static void main(String[] args) {
    int X1;
    int X2;
    int Y1;
    int Y2;
    Scanner scan = new Scanner(System.in);
    MainGame gameboard = new MainGame();
    boolean b = true;
    boolean multiplayer = false;
    
    System.out.println("Do You Want To Play Single Player or Multiplayer (multiplayer for multi player, single player for singleplayer)");
    if(scan.next().contains("m")) {
    multiplayer = true; 
    }else{
    multiplayer = false;        
    }
    
    
    //Set Up Boards
    
    if(multiplayer == true) {
        
        System.out.println("Time To Set Up the Board (one of second coordinates must be one more than original coordinate)");
    
    for(int i = 2; i < 6; i++) { 
    System.out.println("Type First X Coordinate");
    X1 = scan.nextInt();
    System.out.println("Type Second X Coordinate");
    X2 = scan.nextInt();
    System.out.println("Type First Y Coordinate");
    Y1 = scan.nextInt();
    System.out.println("Type Second Y Coordinate");
    Y2 = scan.nextInt();
    //                  x1  y1 x2 y2    
    
    if(!(X2 - X2 == 1) & (Y2 - Y1 == i) || X2 - X1 == 1 & Y2 - Y1 == i) {
    while((X2 - X2 != 1) & (Y2 - Y1 != i) || (X2 - X1 != 1) & (Y2 - Y1 != i)) { 
        System.out.println("Invalid Input");
        System.out.println("Type First X Coordinate");
        X1 = scan.nextInt();
        System.out.println("Type Second X Coordinate");
        X2 = scan.nextInt();
        System.out.println("Type First Y Coordinate");
        Y1 = scan.nextInt();
        System.out.println("Type Second Y Coordinate");
        Y2 = scan.nextInt();    
    }
    }
    gameboard.setupPlayerBoard(X1, Y1, X2, Y2);
    System.out.println(gameboard.showPlayerBoard(true));
    }
    
    for(int j = 0; j < 50; j++) {
    System.out.println(" ");    
    }
    
    
    System.out.println("Time To Set Up the Board (it's in order of smallest to largest and one of second coordinates must be one more than original coordinate)");
    
    for(int i = 2; i < 6; i++) {
    System.out.println("Type First X Coordinate");
    X1 = scan.nextInt();
    System.out.println("Type Second X Coordinate");
    X2 = scan.nextInt();
    System.out.println("Type First Y Coordinate");
    Y1 = scan.nextInt();
    System.out.println("Type Second Y Coordinate");
    Y2 = scan.nextInt();
    //                        x1  y1 x2 y2  
    if(!(X2 - X2 == 1) & (Y2 - Y1 == i) || X2 - X1 == 1 & Y2 - Y1 == i) {
        while((X2 - X2 != 1) & (Y2 - Y1 != i) || (X2 - X1 != 1) & (Y2 - Y1 != i)) { 
            System.out.println("Invalid Input");
            System.out.println("Type First X Coordinate");
            X1 = scan.nextInt();
            System.out.println("Type Second X Coordinate");
            X2 = scan.nextInt();
            System.out.println("Type First Y Coordinate");
            Y1 = scan.nextInt();
            System.out.println("Type Second Y Coordinate");
            Y2 = scan.nextInt();    
        }
        }
    gameboard.setupPlayer2Board(X1, Y1, X2, Y2);
    System.out.println(gameboard.showPlayerBoard2(true));
    }
    
    for(int j = 0; j < 50; j++) {
        System.out.println(" ");    
        }
    
    while(gameboard.detectWin() != true) {
        while(gameboard.detectWin() != true) {
            if(b == true) {
                System.out.println("Your Board");
                System.out.println(gameboard.showPlayerBoard(true));
                System.out.println("Fire At Other Player!");
                System.out.println("Type X Coordinate");
                X1 = scan.nextInt();
                System.out.println("Type Y Coordinate");
                Y1 = scan.nextInt();    
                gameboard.fireatPlayer2Board(X1, Y1);
                System.out.println("Enemy Board");
                System.out.println(gameboard.showPlayerBoard2(false));
                
                System.out.println("Press X to Continue");
                if(scan.next().contains("X") || scan.next().contains("x")) {
                for(int j = 0; j < 50; j++) {
                    System.out.println(" ");    
                    }
                b = false;
                }
            }else {
                System.out.println("Your Board");
                System.out.println(gameboard.showPlayerBoard2(true));
                System.out.println("Fire At Other Player!");
                System.out.println("Type X Coordinate");
                X1 = scan.nextInt();
                System.out.println("Type Y Coordinate");
                Y1 = scan.nextInt();    
                gameboard.fireatPlayer1Board(X1, Y1);
                System.out.println("Enemy Board");
                System.out.println(gameboard.showPlayerBoard(false));
                
                System.out.println("Press X to Continue");
                if(scan.next().contains("X") || scan.next().contains("x")) {
                for(int j = 0; j < 50; j++) {
                    System.out.println(" ");    
                    }
                b = true;
                }
            }
        }
    }
    
    
    }
    else {
        System.out.println("Time To Set Up the Board (one of second coordinates must be one more than original coordinate)");
        
        for(int i = 2; i < 6; i++)  {
        System.out.println("Type First X Coordinate");
        X1 = scan.nextInt();
        System.out.println("Type Second X Coordinate");
        X2 = scan.nextInt();
        System.out.println("Type First Y Coordinate");
        Y1 = scan.nextInt();
        System.out.println("Type Second Y Coordinate");
        Y2 = scan.nextInt();
        if(!(X2 - X2 == 1) & (Y2 - Y1 == i) || X2 - X1 == 1 & Y2 - Y1 == i) {
            while((X2 - X2 != 1) & (Y2 - Y1 != i) || (X2 - X1 != 1) & (Y2 - Y1 != i)) { 
                System.out.println("Invalid Input");
                System.out.println("Type First X Coordinate");
                X1 = scan.nextInt();
                System.out.println("Type Second X Coordinate");
                X2 = scan.nextInt();
                System.out.println("Type First Y Coordinate");
                Y1 = scan.nextInt();
                System.out.println("Type Second Y Coordinate");
                Y2 = scan.nextInt();    
            }
            }
        //                        x1  y1 x2 y2  
        gameboard.setupPlayerBoard(X1, Y1, X2, Y2);
        
        System.out.println(gameboard.showPlayerBoard(true));
        }
        gameboard.showEnemyBoard(false);
        
        while(gameboard.detectWin() != true) {
        if(b == true) {
            System.out.println("Fire At Enemy!");
            System.out.println("Type X Coordinate");
            X1 = scan.nextInt();
            System.out.println("Type Y Coordinate");
            Y1 = scan.nextInt();    
            gameboard.fireatEnemyBoard(X1, Y1);
            System.out.println("Enemy Board");
            System.out.println(gameboard.showEnemyBoard(false));
            System.out.println("Press X to Continue");
            if(scan.next().contains("X")|| scan.next().contains("x")) {
            b = false;
            }
        }else {
            gameboard.fireatPlayerBoard();
            System.out.println("Your Board");
            System.out.println(gameboard.showPlayerBoard(true));
            b = true;
        }
        }
        
    }
    scan.close();
    }
}