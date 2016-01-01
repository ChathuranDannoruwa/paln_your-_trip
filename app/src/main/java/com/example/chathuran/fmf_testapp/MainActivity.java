package com.example.chathuran.fmf_testapp;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    String v1,val;
    EditText from_1;
     EditText to_1;
     EditText date_1;
    EditText date_2;
     EditText passengers;
     NumberPicker selBChld;
     Button  search_flight_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flight);


        from_1=(EditText)findViewById(R.id.from_1);
        to_1=(EditText)findViewById(R.id.to_1);
        date_1=(EditText)findViewById(R.id.date1);
        date_2=(EditText)findViewById(R.id.date2);
        passengers = (EditText)findViewById(R.id.passengers);
        selBChld = (NumberPicker)findViewById(R.id.numberPicker2);
        search_flight_submit=(Button)findViewById(R.id.search_flight_submit);





       // selBAdt.setMinValue(1);// restricted number to minimum value i.e 1
//        selBAdt.setMaxValue(31);// restricked number to maximum value i.e. 31
    //    selBChld.setMinValue(1);// restricted number to minimum value i.e 1
    //    selBChld.setMaxValue(31);// restricked number to maximum value i.e. 31
    //    selBAdt.setWrapSelectorWheel(true);
    //    selBChld.setWrapSelectorWheel(true);


        search_flight_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String from,to,passeng;
                String date1,date2;
                int selAdt,selChld,day_1,month_1,year_1,day_2,month_2,year_2;

                from=from_1.getText().toString();
                to=to_1.getText().toString();
                passeng=passengers.getText().toString();
                Toast.makeText(MainActivity.this,passeng,Toast.LENGTH_LONG).show();




            }

        });
        date_1.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    get_date(1);
                }
            }

        });
       date_2.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    get_date(2);
                }
            }

        });
       passengers.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    show_passenger();
                }
            }

        });


    }



    public void show_passenger()
    {

        final Dialog d = new Dialog(MainActivity.this);
        d.setTitle("NumberPicker");
        d.setContentView(R.layout.dialog);
        Button b1 = (Button) d.findViewById(R.id.add);
       // Button b2 = (Button) d.findViewById(R.id.button2);

        final NumberPicker adult = (NumberPicker) d.findViewById(R.id.adult);
        final NumberPicker child = (NumberPicker) d.findViewById(R.id.children);
        final NumberPicker infant = (NumberPicker) d.findViewById(R.id.infant);
        adult.setMaxValue(9); // max value 100
        child.setMaxValue(9); // max value 100
        infant.setMaxValue(9); // max value 100
        adult.setMinValue(1);   // min value 0
        child.setMinValue(0);   // min value 0
        infant.setMinValue(0);   // min value 0
        adult.setWrapSelectorWheel(false);
        child.setWrapSelectorWheel(false);
        infant.setWrapSelectorWheel(false);
    //    np.setOnValueChangedListener(this);

      b1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String adultVal, childVal, infantVal;
              adultVal = String.valueOf(adult.getValue());
              childVal = String.valueOf(child.getValue());
              infantVal = String.valueOf(infant.getValue());
              d.dismiss();
              passengers.setText(adultVal + " Adult " + childVal + " Children " + infantVal + " Infant");


              //Toast.makeText(MainActivity.this, v1, Toast.LENGTH_LONG).show();
          }
      });



     //   b2.setOnClickListener(new OnClickListener() {
     //       @Override
         //   public void onClick(View v) {
         //       d.dismiss(); // dismiss the dialog
        //    }
     //   });
        d.show();



    }
    public void get_date(final int type)
    {


       final String date1Val,date2Val ;

        final Dialog d = new Dialog(MainActivity.this);
        if(type == 1){
            d.setTitle("Select Departe date");
        }else{
            d.setTitle("Select Return Date");
        }

        d.setContentView(R.layout.select_date_popup);
        Button b1 = (Button) d.findViewById(R.id.add_date);
        // Button b2 = (Button) d.findViewById(R.id.button2);

        final DatePicker date = (DatePicker) d.findViewById(R.id.date);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int day_1,month_1,year_1,day_2,month_2,year_2;
                d.dismiss();
                if(type == 1){
                    day_1=date.getDayOfMonth();
                    month_1=date.getMonth()+1;
                    year_1=date.getYear();

                    date_1.setText(day_1+"/"+month_1+"/"+year_1);

                }else{
                    day_2=date.getDayOfMonth();
                    month_2=date.getMonth()+1;
                    year_2=date.getYear();

                    date_2.setText(day_2+"/"+month_2+"/"+year_2);
                }



                //Toast.makeText(MainActivity.this, v1, Toast.LENGTH_LONG).show();
            }
        });



        //   b2.setOnClickListener(new OnClickListener() {
        //       @Override
        //   public void onClick(View v) {
        //       d.dismiss(); // dismiss the dialog
        //    }
        //   });
        d.show();



    }
}
