package com.amycap93.week5_dialogs;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    Configuration configuration;
    //below code replaces the need to do :findviewbyid
    @BindView(R.id.btn_date_ma) Button dateBtn;
    @BindView(R.id.textView_ma) TextView tv;
    @BindView(R.id.activity_main) LinearLayout rootLayout;

    int numOfViews=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //need the following line. Must pass the context through this bind method.
        //figured this out from "null object" error
        ButterKnife.bind(this);

        configuration=getResources().getConfiguration();

        dateBtn.setOnClickListener(new MyLstnr());

        ScrollView scrollView = new ScrollView(this);
        LinearLayout subLayer = new LinearLayout(this);

        if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
            subLayer.setOrientation(LinearLayout.HORIZONTAL);
        else
            subLayer.setOrientation(LinearLayout.VERTICAL);


        for(int i=0; i<numOfViews; i++){
            Button btn=new Button(this);
            btn.setText("Btn"+i);
            btn.setWidth(20);
            btn.setHeight(10);
            subLayer.addView(btn);
        }
        scrollView.addView(subLayer);
        rootLayout.addView(scrollView);
    }

    class MyLstnr implements View.OnClickListener{
        @ Override
        public void onClick(View view){
            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener(){
                @Override
                public void onDateSet(DatePicker datePicker,int year, int month, int day){
                    tv.setText(""+year);
                }

                },2016,0,0);

            //MISSING SOMETHING HERE

            datePickerDialog.show();
        }
    }


    public void showAlert(View view){
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("the title of the alert")
                    .setMessage("Message body to go in this area......")
                    .setPositiveButton("Agreee", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertBuilder.show();
    }


}
