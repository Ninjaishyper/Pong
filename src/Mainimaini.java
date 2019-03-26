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
		System.out.println("Ball x-Position : "+ballData[1]);
		System.out.println("Ball y-Position : "+ballData[2]);
		System.out.println("Ball x-Speed : "+ballData[3]);
		System.out.println("Ball y-Speed : "+ballData[4]);
		double xSpeed = Double.parseDouble(ballData[3]);
		double ySpeed = Double.parseDouble(ballData[4]);
		
		
		
		//int moveTo = Integer.parseInt(sc.nextLine());
		String moveTo = "0";
    	if(xSpeed > 0.0 && ySpeed > 0.0) {
    		moveTo = "12";
    	}else if(xSpeed < 0.0 && ySpeed < 0.0){
    		moveTo = "-30";
    	}
    	/**	{
    	}
    		if(xSpeed == 0) {
    			moveTo =" 0";
    		}
    		else if(ySpeed > 0.0 ) {
    			moveTo = "36";
    			
    		}else {
    			moveTo = "-36";
    		}
    	}
    	**/
    	out.println("move "+ moveTo);
    	
	}
	

}
