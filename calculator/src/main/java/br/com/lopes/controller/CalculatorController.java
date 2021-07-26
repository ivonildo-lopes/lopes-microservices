package br.com.lopes.controller;

import br.com.lopes.testeOperation.MathOperation;
import br.com.lopes.testeOperation.Operation;
import br.com.lopes.testeOperation.OperationFab;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Objects;

@RestController
@RequestMapping("/calc")
public class CalculatorController implements Serializable {

    
    @GetMapping(value = "sum/{numberOne}/{numberTwo}/sim/{operation1}")
    public ResponseEntity<Double> calc(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo, @PathVariable("operation1") String operation) throws Exception{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return  ResponseEntity.ok(
                                new OperationFab()
                                .calc(converterNumber(numberOne),
                                     converterNumber(numberTwo),
                                        operation));


    }

    @GetMapping(value = "sum/{numberOne}/{numberTwo}/{operation}")
    public ResponseEntity<Double> calculo(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo, @PathVariable("operation") Operation operation) throws Exception{

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return  ResponseEntity.ok(
                operation.getMathOperation().operation(converterNumber(numberOne),converterNumber(numberTwo)));


    }

    private boolean isNumeric(String number) {
        if(Objects.isNull(number)) return false;

        String newNumber = number.replaceAll(" ","").replaceAll(",",".");
        return newNumber.matches("[+-]?\\d*(\\.\\d+)?");
    }

    private double converterNumber(String number){
        return !isNumeric(number) ? 0D : Double.parseDouble(number.replaceAll(" ","").replaceAll(",","."));
    }
}
