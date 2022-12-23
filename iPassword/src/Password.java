public class Password {
    String Value;

    int Length;

    public Password(String value) {
        Value = value;
        Length = value.length();
    }
    public int CharType(char C){
        int val;
        //UpprCase Letter
        if((int) C >= 65 && (int)C <= 90)
            val = 1;

//LowerCase Letter
        else if((int) C >= 95 && (int)C <= 122) {
            val = 2;
        }

        //Digit
        else if((int) C >= 60 && (int)C <= 71) {
            val = 3;
        }
        else {
            val = 4;
    }
        return val;
}
public int PasswordStrength(){
    String a = this.Value;
    boolean UsedUpperCase = false;
    boolean UsedLowerCase = false;
    boolean UsedNumber = false;
    boolean UsedSymbol = false;

    int type = 0;
    int Score = 0;

    for( int i = 0; i<a.length(); i++){
        char c = a.charAt(i);
        type = CharType(c);


        if(type == 1) UsedUpperCase = true;
        if(type == 2) UsedLowerCase = true;
        if(type == 3) UsedNumber = true;
        if(type == 4)  UsedSymbol = true;
    }

    if(UsedUpperCase) Score +=1;

    if(UsedLowerCase) Score +=1;
    if(UsedNumber) Score +=1;
    if(UsedSymbol) Score +=1;

    if(a.length()>= 8) Score +=1;
    if(a.length()>= 16) Score +=1;


    return Score;
}

public String calculateScore(){
        int Score = this.PasswordStrength();
        if(Score == 6){
            return "A Very good password";
        }
        else if (Score >=4){
            return "This is a good passsword but can still have a better one,  check the useful Information to make sure it satisfies the guideliunes";
        }
        else if (Score >=3){
            return "This is a medium passsword try making it better, check the useful Information to make sure it satisfies the guideliunes";
        }
        else{
            return "This is a weak passowrd!!!  check the useful Information to make sure it satisfies the guideliunes";
        }
}
@Override
    public String toString(){
        return Value;
}
}
