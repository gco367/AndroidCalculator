package com.hfad.androidcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import java.text.DecimalFormat;

public class MainActivity extends Activity {

    // Hold the numbers used in the calculations.
    private double firstValue = 0;
    private double secondValue = 0;

    // Available operations.
    private enum Operation {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION,
        NULL_OPERATION
    }

    /* Holds the operation chosen by the user.
     * Receives the value "NULL_OPERATION" when
     * the current operation is undefined. */
    private Operation currentOperation = Operation.NULL_OPERATION;

    // Indicates if the calculator is displaying a result.
    private boolean displayingResult = false;

    // Used to format the result, displaying up to 5 decimal places.
    private DecimalFormat decimalFormat = new DecimalFormat("#.#####");

    // Runs when the application is created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Display layout to the user.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Clear number and user input views.
        clearScreen();

    }

    // Runs when button7 is clicked.
    public void onClickButton7(View view){

        // If displaying a result, clear number and user input views.
        if(displayingResult) clearScreen();
        // Add the selected digit to the number and user input views.
        inputDigit("7");

    }

    // Runs when button8 is clicked.
    public void onClickButton8(View view){

        // If displaying a result, clear number and user input views.
        if(displayingResult) clearScreen();
        // Add the selected digit to the number and user input views.
        inputDigit("8");

    }

    // Runs when button9 is clicked.
    public void onClickButton9(View view){

        // If displaying a result, clear number and user input views.
        if(displayingResult) clearScreen();
        // Add the selected digit to the number and user input views.
        inputDigit("9");

    }

    // Runs when buttonAdd is clicked.
    public void onClickButtonAdd(View view){

        // Define "ADDITION" as the current operation.
        currentOperation = Operation.ADDITION;
        // Add operation symbol to the user input view and clear the number view.
        inputOperation();

    }

    // Runs when button4 is clicked.
    public void onClickButton4(View view){

        // If displaying a result, clear number and user input views.
        if(displayingResult) clearScreen();
        // Add the selected digit to the number and user input views.
        inputDigit("4");

    }

    // Runs when button5 is clicked.
    public void onClickButton5(View view){

        // If displaying a result, clear number and user input views.
        if(displayingResult) clearScreen();
        // Add the selected digit to the number and user input views.
        inputDigit("5");

    }

    // Runs when button6 is clicked.
    public void onClickButton6(View view){

        // If displaying a result, clear number and user input views.
        if(displayingResult) clearScreen();
        // Add the selected digit to the number and user input views.
        inputDigit("6");

    }

    // Runs when buttonSubtract is clicked.
    public void onClickButtonSubtract(View view){

        // Define "SUBTRACTION" as the current operation.
        currentOperation = Operation.SUBTRACTION;
        // Add operation symbol to the user input view and clear the number view.
        inputOperation();

    }

    // Runs when button1 is clicked.
    public void onClickButton1(View view){

        // If displaying a result, clear number and user input views.
        if(displayingResult) clearScreen();
        // Add the selected digit to the number and user input views.
        inputDigit("1");

    }

    // Runs when button2 is clicked.
    public void onClickButton2(View view){

        // If displaying a result, clear number and user input views.
        if(displayingResult) clearScreen();
        // Add the selected digit to the number and user input views.
        inputDigit("2");

    }

    // Runs when button3 is clicked.
    public void onClickButton3(View view){

        // If displaying a result, clear number and user input views.
        if(displayingResult) clearScreen();
        // Add the selected digit to the number and user input views.
        inputDigit("3");

    }

    // Runs when buttonMultiply is clicked.
    public void onClickButtonMultiply(View view){

        // Define "MULTIPLICATION" as the current operation.
        currentOperation = Operation.MULTIPLICATION;
        // Add operation symbol to the user input view and clear the number view.
        inputOperation();

    }

    // Runs when buttonDot is clicked.
    public void onClickButtonDot(View view){

        // If displaying a result, clear number and user input views.
        if(displayingResult) clearScreen();
        // Check if the user has previously entered a digit.
        // If not, add a zero to the user input and number views.
        TextView number = (TextView) findViewById(R.id.number);
        if(number.getText().toString().equals("")){
            inputDigit("0");
        }
        // Add a dot to the user input and number views.
        inputDigit(".");

    }

    // Runs when Button0 is clicked.
    public void onClickButton0(View view){

        // If displaying a result, clear number and user input views.
        if(displayingResult) clearScreen();
        // Add the selected digit to the number and user input views.
        inputDigit("0");

    }

    // Runs when ButtonEqual is clicked.
    public void onClickButtonEqual(View view){

        // Retrieve reference to number and user input views.
        TextView number = (TextView) findViewById(R.id.number);
        TextView userInput = (TextView) findViewById(R.id.userInput);
        // If number view is empty, set secondValue as zero.
        // Otherwise, save the value of number view in secondValue.
        if(number.getText().toString().equals("")){
            secondValue = 0;
            userInput.setText((userInput.getText() + "0"));
        }
        else secondValue = Double.parseDouble((String) number.getText());
        // Clear number view.
        number.setText("");
        // Add ' = ' to the user input view.
        userInput.setText((userInput.getText() + " = "));
        // Holds the result of the calculation.
        String result;
        // Perform the calculation and update number and user input views
        // with the result.
        switch (currentOperation){
            case ADDITION:
                result = decimalFormat.format((firstValue + secondValue));
                number.setText(result);
                userInput.setText((userInput.getText() + result));
                displayingResult = true;
                break;
            case SUBTRACTION:
                result = decimalFormat.format((firstValue - secondValue));
                number.setText(result);
                userInput.setText((userInput.getText() + result));
                displayingResult = true;
                break;
            case MULTIPLICATION:
                result = decimalFormat.format((firstValue * secondValue));
                number.setText(result);
                userInput.setText((userInput.getText() + result));
                displayingResult = true;
                break;
            case DIVISION:
                // Check for division by zero.
                if(secondValue == 0){
                    // Reset views and show error message.
                    CharSequence errorMessage = "Error: division by zero!";
                    int toastDuration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(this, errorMessage, toastDuration);
                    toast.show();
                    number.setText("");
                    userInput.setText("");
                    displayingResult = false;
                }
                else{
                    result = decimalFormat.format((firstValue / secondValue));
                    number.setText(result);
                    userInput.setText((userInput.getText() + result));
                    displayingResult = true;
                }
                break;
            case NULL_OPERATION:
                // User did not select an operation before pressing buttonEqual.
                // Reset views and show error message.
                CharSequence errorMessage = "Please enter one number, an operation" +
                        " and another number, then press =";
                int toastDuration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(this, errorMessage, toastDuration);
                toast.show();
                number.setText("");
                userInput.setText("");
                displayingResult = false;
                break;
        }
        // Reset operands and current operation.
        firstValue = 0;
        secondValue = 0;
        currentOperation = Operation.NULL_OPERATION;

    }

    // Runs when ButtonDivide is clicked.
    public void onClickButtonDivide(View view){

        // Define "DIVISION" as the current operation.
        currentOperation = Operation.DIVISION;
        // Add operation symbol to the user input view and clear the number view.
        inputOperation();

    }

    // Runs when ButtonClear is clicked.
    public void onClickButtonClear(View view){

        // Reset views, operands and current operation variable.
        TextView userInput = (TextView) findViewById(R.id.userInput);
        TextView number = (TextView) findViewById(R.id.number);
        userInput.setText("");
        number.setText("");
        firstValue = 0;
        secondValue = 0;
        currentOperation = Operation.NULL_OPERATION;

    }

    // Adds a digit to the user input and number views.
    private void inputDigit(String digit){

        TextView userInput = (TextView) findViewById(R.id.userInput);
        TextView number = (TextView) findViewById(R.id.number);
        userInput.setText((userInput.getText() + digit));
        number.setText((number.getText() + digit));

    }

    // Adds operation symbol to the user input view and clear the number view.
    private void inputOperation(){

        // Retrieve reference to number and user input views.
        TextView number = (TextView) findViewById(R.id.number);
        TextView userInput = (TextView) findViewById(R.id.userInput);
        // If number view is empty, set firstValue as zero.
        if(number.getText().toString().equals("")){
            firstValue = 0;
            userInput.setText("0");
        }
        else{
            // Otherwise, save the value of number view in firstValue.
            if(displayingResult){
                // If a result is being displayed, put it in user input view.
                userInput.setText(number.getText());
                displayingResult = false;
            }
            firstValue = Double.parseDouble((String) number.getText());
        }
        // Clear number view.
        number.setText("");
        // Add symbol to user input view.
        switch (currentOperation){
            case ADDITION:
                userInput.setText((userInput.getText() + " + "));
                break;
            case SUBTRACTION:
                userInput.setText((userInput.getText() + " - "));
                break;
            case MULTIPLICATION:
                userInput.setText((userInput.getText() + " * "));
                break;
            case DIVISION:
                userInput.setText((userInput.getText() + " / "));
                break;
        }

    }

    // Clears user input and number views.
    private void clearScreen(){

        TextView number = (TextView) findViewById(R.id.number);
        number.setText("");
        TextView userInput = (TextView) findViewById(R.id.userInput);
        userInput.setText("");
        displayingResult = false;

    }

    // Runs when buttonSend is clicked.
    public void onClickButtonSend(View view){

        // Create intent to call activity from another app.
        Intent intent = new Intent(Intent.ACTION_SEND);
        // Add user input information to the intent.
        intent.setType("text/plain");
        TextView userInput = (TextView) findViewById(R.id.userInput);
        intent.putExtra(Intent.EXTRA_TEXT, userInput.getText().toString());
        // Create chooser to allow the user to choose the messaging app.
        Intent chosenIntent = Intent.createChooser(intent, getString(R.string.chooser_title));
        // Start messaging activity.
        startActivity(chosenIntent);

    }

}
