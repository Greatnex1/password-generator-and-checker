import java.util.Scanner;

public class Originator {
    Elements element;

    public static Scanner keyboard;

    public Originator(Scanner scan) {
        keyboard = scan;
    }
    public Originator(boolean IncludeUpper, boolean IncludeLower, boolean IncludeNumber, boolean IncludeSymbol){
        element = new Elements(IncludeUpper,IncludeLower,IncludeNumber,IncludeSymbol);

    }
    public void mainDisplay(){
        System.out.println("Welcome to iPassword Generator");

        printOptions();

        String userOption = "-1";
        while(!userOption.equals("4")){
            userOption = keyboard.next();

            switch (userOption){
                case "1" -> {
                    requestPassword();
                    printOptions();
                }
                case "2" -> {
                    checkPassword();
                    printOptions();
                }
                case "3" -> {
                    displayUsefulInfo();
                    printOptions();
                }
                case "4" ->
                    printQuitMessage();
                    default -> {
                        System.out.println();
                        System.out.println("Kindly select one of the available commands");
                        printOptions();
                    }
            }
        }
    }

    private void checkPassword() {
        String input ;
        final Scanner in = new Scanner(System.in);

        System.out.print("\nEnter your password:");
        input = in.nextLine();

        final Password p = new Password(input);

        System.out.println(p.calculateScore());

      //  in.close();
    }

    private void printQuitMessage() {

        System.out.println("Program Closed");
    }

    private void displayUsefulInfo() {
        System.out.println();
        String output = """
                -- Use a minimum password length of 8 or more characters if permitted
                
                --Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted
                
                -- Generate passwords randomly where feasible
                
                -- Avoid using the same password twice (e.g., across multiple user accounts and/or software systems
                Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences,
                usernames, relative or pet names, romantic links (current or past and biographical information
                (e.g., ID numbers, ancestors' names or dates.
                
                -- Avoid using information that the user's colleagues and/or acquaintances might know to be associated with the user\
                
                -- Do not use passwords which consist wholly of any simple combination of the aforementioned weak components
                                
                """;
        System.out.println(output);
    }

    private Password GeneratePassword(int length){
        final StringBuilder build = new StringBuilder("");

        final int elementLength = element.getElements().length();

        int max =elementLength - 1;
        int min = 0;
        int range = max - min + 1;

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * range) + min;
            build.append(element.getElements().charAt(index));
        }

        return new Password(build.toString());
    }

    private void requestPassword() {
        boolean IncludeUpper = false;
        boolean IncludeLower = false;
        boolean IncludeNum = false;
        boolean IncludeSym = false;

        boolean correctParams = false;

        System.out.println();

        String hello = """
                Hello There! Welcome to iPassword Originator
                answer the following questions by typing Yes  or No
                """;
        System.out.println(hello);

        do {
            String input = keyboard.nextLine();
            System.out.println("Do you want Lowercase letters \"abcd...\" to be used? ");
            input = keyboard.nextLine();
            if (isInclude(input)) IncludeLower = true;

            System.out.println("Do you want Uppercase letters \"ABCD...\" to be used? ");
            input = keyboard.nextLine();

            if (isInclude(input)) IncludeUpper = true;

            System.out.println("Do you want Numbers \"1234...\" to be used? ");
            input = keyboard.nextLine();

            if (isInclude(input)) IncludeNum = true;

            System.out.println("Do you want Symbols \"!@#$...\" to be used? ");
            input = keyboard.nextLine();

            if (isInclude(input)) IncludeSym = true;
//No Build Selected
            if (!IncludeUpper && !IncludeLower && !IncludeNum && !IncludeSym) {
                System.out.println("You have selected no characters to generate your " +
                        "password at least one of your answers should be Yes");
                correctParams = true;
            }
            System.out.println("Great! Now enter the length of the password you'll like to generate");
            int length = keyboard.nextInt();

             Originator generator = new Originator(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
      final Password password = generator.GeneratePassword(length);

         System.err.println("Your generated password is -> " + password);
            System.out.println();
            System.out.println("Pls keep this password safe");

        } while (correctParams);
        }


    private boolean isInclude(String Input) {
        if (Input.equalsIgnoreCase("yes")) {
            return true;
        } else {
            if (!Input.equalsIgnoreCase("no")) {
                PasswordRequestError();
            }
            return false;
        }
    }

    private void PasswordRequestError() {
        System.out.println("You have entered something incorrect let's go over it again \n");

    }

    private void printOptions() {
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Enter 1 ->> Password Generator");
        System.out.println("Enter 2 ->> Password Strength Check");
        System.out.println("Enter 2 ->> Useful Information");
        System.out.println("Enter 3 ->> Quit");
        System.out.println("----------------------------------------");

        System.out.print("Choice:");

    }
}

