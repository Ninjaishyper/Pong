import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Mainimaini {
	
	enum Message{
		Player, CPU, Ball, Move
	}

	public static void main(String[] args) {
		try {
		    Socket echoSocket = new Socket("localhost", 7000);
		    BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
		    PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);	
		    
		    String [] logs = new String[4];
		    Scanner sc = new Scanner(System.in);
		    String [] ballDetails = new String [5];
		    
		    while(true) {
		    	
		    	
		  for(int i = 0; i<4; i++) {
		    	logs[i] = in.readLine();
		    	//System.out.println(logs[i]);
		    	// Ball = 2
		  		if(i == 2) {
		  			 ballDetails = logs[i].split(" ");
		  			 System.out.println(logs[2]);
		  		}
		    }
		  	
		  movePaddle(sc, out, ballDetails);
		    	
		    }
		    
		 
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void movePaddle(Scanner sc, PrintWriter out, String [] ballData) {
		double xPos = Double.parseDouble(ballData[1]);
		double yPos = Double.parseDouble(ballData[2]);
		double xSpeed = Double.parseDouble(ballData[3]);
		double ySpeed = Double.parseDouble(ballData[4]);
		
		int moveToY = 0;
		if(ySpeed < 5.0) {
		moveToY = (int) (yPos*ySpeed /50);
		}else if(ySpeed > 5.0) {
			moveToY = (int) (yPos*ySpeed / 10);
		}else if(ySpeed > 20.0) {
			moveToY = (int) (yPos*ySpeed);
		}
    	out.println("move "+ moveToY);
    	
	}
	

}
