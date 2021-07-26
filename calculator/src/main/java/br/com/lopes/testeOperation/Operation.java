package br.com.lopes.testeOperation;

import lombok.Getter;
import lombok.Setter;

public enum Operation {

    SUM(new OperationSum()),
    MINUS(new OperationSubtraction()),
    MULT(new OperationMultiplication()),
    DIV(new OperationDivision());

    @Getter
    private MathOperation mathOperation;

    Operation(MathOperation mathOperation) {
        this.mathOperation = mathOperation;
    }

}
