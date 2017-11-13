package com.example.asus.expensescalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.asus.expensescalculator.MainActivity.getArrayVal;

public class ExpenseCalculator extends AppCompatActivity {

    ArrayList<String> item_name_list = null;
    Double[] Expenses = null;
    ListView lv = null;
    ArrayAdapter<Double> adapter= null;
    Double sum;
    List<Double> list = null;
    ListView explv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_calculator);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        /*item_name_list = getArrayVal(getApplicationContext());
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, item_name_list);
        lv = (ListView) findViewById(R.id.listview);
        lv.setAdapter(adapter);*/

        Button Add_Exp_btn = (Button) findViewById(R.id.Add_Expense);
        final EditText item_expense = (EditText) findViewById(R.id.expense_edittext);
        final EditText item_name = (EditText) findViewById((R.id.item_name_edittext));
        final TextView total_expense = (TextView)findViewById(R.id.total_expenses_box);
        final EditText tax_amt = (EditText)findViewById(R.id.tax_editText);

        Add_Exp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String e = item_expense.getText().toString().trim();
                    try {
                        Double individual_expense = 0.0;
                        individual_expense = Double.parseDouble(e);
                        sum = individual_expense;
                        total_expense.setText("$" + sum);
                    } catch (Exception a) {


                        Toast.makeText(getApplicationContext(), "Input Error", Toast.LENGTH_LONG).show();
                    }


                }

        });

        Button tax = (Button)findViewById(R.id.tax_button) ;
        tax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tax_string = tax_amt.getText().toString().trim();
                try {
                    Double added_tax = 0.0;
                    added_tax = Double.parseDouble(tax_string);
                    sum = sum*(1+added_tax/100);
                    total_expense.setText("$" + sum);
                } catch (Exception a) {
                    Toast.makeText(getApplicationContext(), "Input Error", Toast.LENGTH_LONG).show();
                }

            }
        });


        Button clear_exp_Btn = (Button) findViewById(R.id.clear_button);
        clear_exp_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sum = 0.0;
                total_expense.setText("$"+ sum);
            }
        });
    }
        @Override
        public boolean onPrepareOptionsMenu(Menu menu) {
            super.onPrepareOptionsMenu(menu);
            menu.clear();    //remove all items
            this.getMenuInflater().inflate(R.menu.calculator_menu, menu);
            return true;
        }
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();
            //Action to allow adding into the list
            if (id == R.id.action_HomeButton) {
                Intent transitionHome = new Intent(this,MainActivity.class);
                this.startActivity(transitionHome);
            }
            else if (id== R.id.action_TipsNTricks){


                Intent transition1 = new Intent(this,TipsAndTricks.class);
                this.startActivity(transition1);

            }

            else if (id == R.id.action_ExpensesCalculator){

                Intent transition2 = new Intent(this, ExpenseCalculator.class);
                this.startActivity(transition2);
            }
            return super.onOptionsItemSelected(item);



}}
