import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class App {
    static ArrayList<Integer> aCombination;
    static ArrayList<Integer> playerCombination;
    public static void main(String[] args) throws Exception {
        aCombination = new ArrayList<Integer>();
        playerCombination = new ArrayList<Integer>();
        final int TIMES = 10;
        for (int j = 0; j < 4; j++) {
            aCombination.add(generate(6));
        }

        System.out.println(aCombination);

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < TIMES; i++) {
            System.out.print(String.format("\n-> Enter the guess %d: ", i + 1));
            Pattern pattern = Pattern.compile("^[1-6]{4}$");
            Integer guessednumber = sc.nextInt();
            if(!pattern.matcher(guessednumber.toString()).find()) {
                throw new Exception("the Guessed number shold be between 1 and 6");
            }

            String pc[] = String.valueOf(guessednumber).split("");
            for (String element : pc) {
		        playerCombination.add(Integer.parseInt(element));
		    }

            if (aCombination.equals(playerCombination)) {
	            System.out.println("# # # #");
	            break;
	        }

            for (int k = 0; k < 4; k++ ) {
                if(aCombination.get(k) == playerCombination.get(k)) {
                    System.out.print("# ");
                    playerCombination.set(k,0);
                }

		    	for(int n : aCombination) {
		    		if(playerCombination.get(k) == n ) {
		    			System.out.print("O ");
		    		}
		    	}
		    }
            playerCombination.clear();
        }
        sc.close();
    }

    private static int generate(int max) {
        return 1 + (int)(Math.random() * max);
    }
}
