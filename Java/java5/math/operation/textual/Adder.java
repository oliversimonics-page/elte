package java5.math.operation.textual;

public class Adder{
    public String addAsText(String opTxt1, String opTxt2){
        try {
            int intA = Integer.parseInt(opTxt1);
            int intB = Integer.parseInt(opTxt2);
            return String.valueOf(intA + intB);
        } catch (NumberFormatException e1) {
            try {
                double doubleA = Double.parseDouble(opTxt1);
                double doubleB = Double.parseDouble(opTxt2);
                return String.valueOf(doubleA + doubleB);
            } catch (NumberFormatException e2) {
                return "Operands are not numbers.";
            }
        }
    }
}