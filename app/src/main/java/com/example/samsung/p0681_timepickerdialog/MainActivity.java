package com.example.samsung.p0681_timepickerdialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    int DIALOG_TIME = 1,
        myHour      = 14,
        myMinute    = 35;
    TextView tvTime;

    TimePickerDialog.OnTimeSetListener myCallBack = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            myHour = hourOfDay;
            myMinute = minute;
            String massage = "Time is " + myHour + " hours " + myMinute + " minutes";
            tvTime.setText(massage);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tvTime = (TextView) findViewById(R.id.tvTime);
    }

    @SuppressWarnings("deprecation")
    public void onClickTime(View view) {
        showDialog(DIALOG_TIME);
    }

    @SuppressWarnings("deprecation")
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_TIME) {
            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    this, myCallBack, myHour, myMinute, true
            );
            return timePickerDialog;
        }
        return super.onCreateDialog(id);
    }
}
