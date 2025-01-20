import java.util.Scanner;  // Import the Scanner class

class Jeu {
    public static void main(String[] args) {
    }
    static String newPlayer(int n){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez un nom de joueur");
        return scanner.nextLine();

    }
}
