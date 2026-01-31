import java.util.Locale;
import java.util.Scanner;

/**
 * FileNewPatent
 * <p>
 * This program takes in input from System.in
 * performs string manipulation and returns a user String
 *
 * @author Jaiah Royal
 * @version Jan 31, 2026
 */

public class FileNewPatent {

    //List of public static final strings provided to prevent typos

    public static final String PROMPT_ONE = "Enter Patent Name:";
    public static final String PROMPT_TWO = "Enter Patent Type:";
    public static final String PROMPT_THREE = "Enter Research Cost:";
    public static final String PROMPT_FOUR = "Enter Inventor Name:";
    public static final String PROMPT_FIVE = "Enter Inventor Institution:";
    public static final String PROMPT_SIX = "Enter Institution State:";
    public static final String PROMPT_SEVEN = "Enter Institution Zip Code:";
    public static final String PROMPT_EIGHT = "Enter ACME Item Number:";
    public static final String OUTPUT = "The Assigned Patent String is ";

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //patent name
        System.out.println(PROMPT_ONE);
        String patentName = scan.nextLine().toUpperCase();
        //first two
        char first1 = patentName.charAt(0);
        char first2 = patentName.charAt(1);
        //last two
        char last1 = patentName.charAt(patentName.length() - 2);
        char last2 = patentName.charAt(patentName.length() - 1);
        String patent = "" + first1 + first2 + last1 + last2;
        
  
        //patent type
        System.out.println(PROMPT_TWO);
        String patentType = scan.nextLine().toUpperCase();
        // first char
        char type1 = patentType.charAt(0);
        //last char
        char type2 = Character.toLowerCase(patentType.charAt(patentType.length() - 1));
        patent = patent.replace(type1, type2); // changes the value of patent
        
        
        //research cost
        System.out.println(PROMPT_THREE);
        String cost = scan.nextLine();
        //remove $
        String cost4 = cost;
        if (cost4.contains("$")) {
            cost4 = cost4.replace("$", "");
        } 
        double cost2 = Double.parseDouble(cost4); //from string to double
        int cost3 = (int) (cost2 + 0.5); //double to int
        cost3 = cost3 % 1000; //mod 1000
        String researchCost = "" + cost3; // rounding
        if (researchCost.length() == 2) {
            researchCost = "0" + researchCost; //pads value
        } else if (researchCost.length() == 1) {
            researchCost = "00" + researchCost; //pads value
        }
        String patentCost = patent + researchCost;
     
        
        //inventor name
        System.out.println(PROMPT_FOUR);
        String inventorName = scan.nextLine();
        //finds index of space
        int space = inventorName.indexOf(" ");
        //first
        String inventFirst = inventorName.substring(0, space).toLowerCase();
        //last
        String inventLast = inventorName.substring(space + 1).toUpperCase();
        String patentString = inventFirst + patentCost + inventLast; // combines progress so far
        
        
        //inventor institution
        System.out.println(PROMPT_FIVE);
        String institution = scan.nextLine().toUpperCase();
        String institution2 = institution.substring(0, 2);
        String patentString1 = institution2 + patentString;
    
        //institution state
        System.out.println(PROMPT_SIX);
        String state = scan.nextLine().toUpperCase();
        //get char
        char letter1 = state.charAt(0);
        char letter2 = state.charAt(1);
        //get ASCII
        int stateInt1 = letter1 % 10;
        int stateInt2 = letter2 % 10;
        int stateInt = (stateInt1 * stateInt2);
        //pad value
        String stateOI = "" + stateInt;
        if (stateOI.length() < 2) {
            stateOI = "0" + stateOI;
        }
        String patentString2 = patentString1 + stateOI; //concatenates

         
        //institution zipcode
        System.out.println(PROMPT_SEVEN);
        String zipcode = scan.nextLine();
        //divide numbers then add.
        int sum = 0;
        for (int i = 0; i < zipcode.length(); i++) {
            int count = zipcode.charAt(i) - '0';
            sum += count;
        }
        int integer = Integer.parseInt(zipcode);
        int divide = (integer / sum) % 1000;
        
        String zipCode = "" + divide;
        if (zipCode.length() == 2) {
            zipCode = "0" + divide;
        } else if (zipCode.length() == 1) {
            zipCode = "00" + divide;
        }
        patentString2 = zipCode + patentString1 + stateOI; // combines progress so far
        
        
        //ACME item number
        System.out.println(PROMPT_EIGHT);
        String acme = scan.nextLine();
        //find hyphen
        int hyphen = acme.indexOf("-");
        String item = acme.substring(hyphen);
        String patentNumber = patentString2 + item + "-";
        
        //Step 9 (take length of inputs and add them together)
        int name1 = patentName.length();
        int type = patentType.length();
        int money = cost.length();
        int name2 = inventorName.length();
        int place = institution.length();
        int place2 = state.length();
        int number1 = zipcode.length();
        int number2 = acme.length();
        int total1 = name1 + type + money + name2;
        int total2 = place + place2 + number1 + number2;
        int total = total1 + total2;
        String total3 = "" + total;
        String result = patentNumber + total3; //concatenate to string
        
        
        //step 10 (remove any instances of "o" and "i", ignore case)
        result = result.replace("O", "0");
        result = result.replace("o", "0");
        result = result.replace("I", "1");
        result = result.replace("i", "1");

        //output message
        System.out.println(OUTPUT + result);

    } 
} 
