import java.util.Scanner;
public class SafeInput {
    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";   // Set this to zero length. Loop runs until it isn't
        do
        {
            System.out.print("\n" + prompt + ": ");   // show prompt, add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }
    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return any valid int the user enters
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        int retInt = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt())
            {
                retInt = pipe.nextInt();
                pipe.nextLine();   // clear the newline from the pipe
                done = true;
            }
            else
            {
                trash = pipe.nextLine();   // read the bad input
                System.out.println("You must enter an integer, not: " + trash);
            }
        } while (!done);

        return retInt;
    }
    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return any valid double the user enters
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retDouble = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble())
            {
                retDouble = pipe.nextDouble();
                pipe.nextLine();   // clear the newline from the pipe
                done = true;
            }
            else
            {
                trash = pipe.nextLine();   // read the bad input
                System.out.println("You must enter a number, not: " + trash);
            }
        } while (!done);

        return retDouble;
    }
    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user (without the range)
     * @param low    lowest valid value (inclusive)
     * @param high   highest valid value (inclusive)
     * @return an int between low and high, inclusive
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retInt = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt())
            {
                retInt = pipe.nextInt();
                pipe.nextLine();   // clear the newline from the pipe
                if (retInt >= low && retInt <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("Number is out of range: " + retInt);
                }
            }
            else
            {
                trash = pipe.nextLine();   // read the bad input
                System.out.println("You must enter an integer, not: " + trash);
            }
        } while (!done);

        return retInt;
    }
    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user (without the range)
     * @param low    lowest valid value (inclusive)
     * @param high   highest valid value (inclusive)
     * @return a double between low and high, inclusive
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retDouble = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble())
            {
                retDouble = pipe.nextDouble();
                pipe.nextLine();   // clear the newline from the pipe
                if (retDouble >= low && retDouble <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("Number is out of range: " + retDouble);
                }
            }
            else
            {
                trash = pipe.nextLine();   // read the bad input
                System.out.println("You must enter a number, not: " + trash);
            }
        } while (!done);

        return retDouble;
    }
    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return true for yes (Y/y), false for no (N/n)
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean retValue = false;
        boolean done = false;
        String response = "";

        do
        {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine();

            if (response.equalsIgnoreCase("Y"))
            {
                retValue = true;
                done = true;
            }
            else if (response.equalsIgnoreCase("N"))
            {
                retValue = false;
                done = true;
            }
            else
            {
                System.out.println("You must enter Y or N, not: " + response);
            }
        } while (!done);

        return retValue;
    }
    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @param regEx  the regular expression the input must match
     * @return a String that matches the regEx pattern
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String retString = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();

            if (retString.matches(regEx))
            {
                done = true;
            }
            else
            {
                System.out.println("Invalid input: " + retString);
            }
        } while (!done);

        return retString;
    }
}


