import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int playerNumber = 0;
        String userRequest = "";
        String userAnswer = "Y";

        String[] playerNames = {"Warren Moon", "Charley Trippi", "Bronco Nagurski", "Brett Favre",
                "Donovan McNabb", "Rolf Benirschke", "John Elway", "Steve Young", "Drew Brees", "Fran Tarkenton",
        "Larry Fitzgerald" , "Tom Brady", "Dan Marino", "Dan Fouts", "Bart Starr",
                "Joe Montana" , "Phillip Rivers" , "Peyton Manning" , "Johnny Unitas" , "Barry Sanders"};
        String[] playerPosition = {"QB", "HB/QB", "FB", "QB", "QB", "K", "QB", "QB", "QB", "QB" ,
                "WR", "QB", "QB", "QB", "QB", "QB" , "QB" , "QB" , "QB" , "RB"};
        String[] playerTeams = {"Oilers", "Cardinals", "Bears", "Packers", "Eagles",
                "Chargers", "Broncos", "49ers", "Saints", "Vikings", "Cardinals", "Patriots",
                "Dolphins", "Chargers", "Packers" , "49ers" , "Chargers" , "Colts" , "Colts" , "Lions"};
        int[] gamesPlayed = {208, 99, 97, 302, 167, 121, 234, 169, 233, 246, 202, 237, 242, 181,
                196, 292, 180, 266, 211, 153};

        System.out.println("Football Greats to Wear Jersey Numbers 1-10");

        do {
            try {
                System.out.println("\nPlease enter a jersey number from 1-10 to find out " +
                        "what player wore that number:");
                playerNumber = scan.nextInt();
                scan.nextLine();
                System.out.println("The greatest football player to wear jersey number "
                        + playerNumber + ", was " + playerNames[playerNumber - 1] + ".");
                System.out.println("\nWhat would you like to know about this football player? "
                        + "\nEnter 'player position, 'player team' or 'games played'.");
                userRequest = scan.nextLine();

                determinesDataRequest(playerNumber, userRequest, playerNames, playerPosition, playerTeams, gamesPlayed);

                // Catches exceptions when the integer is less than 1 and greater than 10.
            } catch (IndexOutOfBoundsException e) {
                System.out.println("You did not enter a number from 1-10.");
                // Catches exception when a decimal is entered,
            } catch (InputMismatchException e) {
                System.out.println("You entered a decimal, it is not a valid jersey number.");
                scan.nextLine();
            }
            System.out.println("\nWould you like to learn more about another player? Y/N : ");
            userAnswer = scan.nextLine();
        } while (userAnswer.equalsIgnoreCase("y"));
    }

    private static void determinesDataRequest(int playerNumber, String userRequest, String[] playerNames,
                                              String[] playerPosition, String[] playerTeams, int[] gamesPlayed) {
        if (userRequest.contains("position")) {
            System.out.println(playerNames[playerNumber - 1] + " was a "
                    + playerPosition[playerNumber - 1] + ".");
        } else if (userRequest.contains("team")) {
            System.out.println(playerNames[playerNumber - 1] + " is most known for playing for the "
                    + playerTeams[playerNumber - 1] + ".");
        } else if (userRequest.contains("games")) {
            System.out.println(playerNames[playerNumber - 1] + " has played "
                    + gamesPlayed[playerNumber - 1] + " total career games.");
        } else {
            System.out.println("Data does not exist.");
        }
    }
}


