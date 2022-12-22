public class Elements {

    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private  static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "1234567890";

    private static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";

    private final StringBuilder builder;

    public Elements(boolean uppercasePresent, boolean lowercasePresent, boolean numbersPresent, boolean symbolsPresent) {
        builder = new StringBuilder();

        if(uppercasePresent) builder.append(UPPERCASE_LETTERS);
        if(lowercasePresent) builder.append(LOWERCASE_LETTERS);
        if(numbersPresent) builder.append(NUMBERS);
        if(symbolsPresent)builder.append(SYMBOLS);
    }

    public String getElements(){
        return builder.toString();
    }
}
