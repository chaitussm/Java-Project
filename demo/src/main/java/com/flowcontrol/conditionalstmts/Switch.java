package com.flowcontrol.conditionalstmts;

public class Switch {

    //The switch statement is a control flow statement that allows you to execute different blocks of code based on the value of a variable or expression. 
    // It is an alternative to using multiple if-else statements when you have a variable that can take on multiple values.
    public static void main(String[] args) {
        int day = 3;
        String dayName;

        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day";
        }

        System.out.println("The day is: " + dayName); // Output: The day is: Wednesday

        // Important points to remember:
        // 1. The switch statement evaluates the expression and compares it against the values specified in the case labels.
        // 2. Each case label must be a constant expression (e.g., a literal, a final variable, or an enum constant).
        // 3. The break statement is used to exit the switch block after a matching case is executed. If you omit the break statement, the execution will continue to the next case (known as "fall-through").
        // 4. The default case is optional and will be executed if none of the cases match the expression.
        // default an dcase are optional empty switch statement is also valid in Java, but it will not do anything and it will not cause any error.
        // switch statement can also be used with char, byte, short, int, String and enum data types, but it cannot be used with long, float, double and boolean data types.
        // if we want to write any staement such as print staement also we have metniotn in the case or default block then we have to use {} to enclose the statements otherwise it will cause a compilation error because the switch statement does not allow multiple statements without using {} to enclose them.   
        // we can write defaault case anywhere in the switch block, it does not have to be at the end of the switch block, but it is a good practice to write it at the end of the switch block to improve readability and maintainability of the code.
        // case label cannot be duplicated 
        // case label must be in the range of the data type of the switch expression, for example if the switch expression is of type byte then the case label must be in the range of -128 to 127, if the switch expression is of type char then the case label must be in the range of 0 to 65535, if the switch expression is of type int then the case label must be in the range of -2147483648 to 2147483647, if the switch expression is of type String then the case label must be a string literal or a final variable that holds a string literal.
        //case 1: We cannot use switch statement with long data type
        //long l = 10L;
        //switch (l) { // This will cause a compilation error because switch statement does not allow long data type
        //    case 10L:
        //        System.out.println("Long value is 10");
        //        break;
        //    default:
        //        System.out.println("Long value is not 10");
        //}
        //case 2: We cannot use switch statement with float data type
        //float f = 10.5f;
        //switch (f) { // This will cause a compilation error because switch statement does not allow float data type
        //    case 10.5f:
        //        System.out.println("Float value is 10.5");
        //        break;
        //    default:
        //        System.out.println("Float value is not 10.5");
    }
    
}
