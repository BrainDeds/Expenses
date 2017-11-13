package com.example.asus.expensescalculator;


import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.net.Uri;


public class TipsAndTricks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_and_tricks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://www.entrepreneur.com/article/78994"));
                startActivity(myWebLink);
            }});

        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://www.psychologytoday.com/blog/cant-buy-happiness/201308/what-can-be-done-help-compulsive-spending-habits"));
                startActivity(myWebLink);
            }});
        Button btn3 = (Button) findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse("https://www.thebalance.com/get-control-of-your-budget-2385702"));
                startActivity(myWebLink);
            }});
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.clear();    //remove all items
        this.getMenuInflater().inflate(R.menu.tips_menu, menu);
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
        }



}


