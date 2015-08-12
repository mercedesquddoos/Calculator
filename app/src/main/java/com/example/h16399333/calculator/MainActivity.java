package com.example.h16399333.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    private int total = 0;
    private int firstNum = 0 ;
    private int secondNum = 0;
    private String oper;
    private boolean isFirstNum = true;

    public void onButtonClick(View v){
        Button btn = (Button)v;
        String value = btn.getText().toString();

        int num = Integer.parseInt(value);

        EditText etTotal = (EditText)findViewById(R.id.etTotal);

        if(isFirstNum) {
            firstNum = firstNum = num;
            etTotal.setText(Integer.toString(firstNum));
        } else{
            secondNum = secondNum = num;
            etTotal.setText(Integer.toString(secondNum));
        }

        total = total + num;

        EditText etTotal = (EditText)findViewById(R.id.etTotal);
        etTotal.setText(Integer.toString(total));
    }

    public void onClearClick(View v){

        EditText etTotal = (EditText)findViewById(R.id.etTotal);
        etTotal.setText(Integer.toString(0));
        total = 0;

    }

    public void onOperatorClick(View v){
        Button btn = (Button)v;
        oper = btn.getText().toString();
        isFirstNum = false;
    }

    public void onEqualClick(View v){
        switch(oper){
            case "+": total = firstNum + secondNum;
                break;
            case "-": total = firstNum - secondNum;
                break;
            case "*": total = firstNum * secondNum;
                break;
            default:
                break;
        }
        EditText etTotal = (EditText)findiewById(R.id.etTotal);
        etTotal.setText(Integer.toString(0));
     }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
