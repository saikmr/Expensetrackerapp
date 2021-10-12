package com.example.expensetrackerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class dashboardActivity extends AppCompatActivity {
    private Toolbar my_Feed_Toolbar;
    private CardView budgetCardView, todayCardView,weeklyCardView,monthlyCardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard_main);
        my_Feed_Toolbar = findViewById(R.id.my_Feed_Toolbar);
        setSupportActionBar(my_Feed_Toolbar);
        getSupportActionBar().setTitle("Expense Tracker");

        TextView txtView = (TextView) findViewById(R.id.totalBudgetAmountTextView);
        budgetCardView=findViewById(R.id.budgetCardView);
        todayCardView= findViewById(R.id.todayCardView);
        weeklyCardView= findViewById(R.id.weeklyCardView);
        monthlyCardView= findViewById(R.id.monthlyCardView);



        budgetCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dashboardActivity.this,BudgetActivity.class);
                startActivity(intent);

            }
        });

        todayCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dashboardActivity.this,TodaySpendingActivity.class);
                startActivity(intent);

            }
        });


        weeklyCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dashboardActivity.this,WeekSpendingActivity.class);
                intent.putExtra("type","week");

                startActivity(intent);

            }
        });

        monthlyCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dashboardActivity.this,WeekSpendingActivity.class);
                intent.putExtra("type","month");

                startActivity(intent);

            }
        });

    }
    public boolean onCreateOptionsMenu(final Menu menu){

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()== R.id.account){
            Intent intent = new Intent(dashboardActivity.this,AccountActivity.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }
}