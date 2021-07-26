package br.com.lopes.testeOperation;

public class OperationFab {

    public Double calc(Double numberOne, Double numberTwo, String operation) {
       switch (operation) {
           case "*":
              return new OperationMultiplication().operation(numberOne,numberTwo);
           case "@":
               return new OperationDivision().operation(numberOne,numberTwo);
           case "-":
               return new OperationSubtraction().operation(numberOne,numberTwo);
           case "+":
               return new OperationSum().operation(numberOne,numberTwo);
           default:
               // ...
               return 0D;

       }


    }
}
