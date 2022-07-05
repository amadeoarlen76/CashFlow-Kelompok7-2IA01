package com.kelompok7.cashflow;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;

public class FilterActivity extends AppCompatActivity {
    EditText edit_dari, edit_sampai;
    Button btn_save;
    DatePickerDialog datePickerDialog;
    HomeActivity M = new HomeActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        edit_dari = findViewById(R.id.edit_dari);
        edit_sampai = findViewById(R.id.edit_sampai);
        btn_save = findViewById(R.id.btn_save);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        edit_dari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog = new DatePickerDialog(FilterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        NumberFormat numberFormat = new DecimalFormat("00");
                        M.edit_dari = numberFormat.format(year)+"-"+numberFormat.format((month + 1))+"-"+numberFormat.format(dayOfMonth);
                        edit_dari.setText(numberFormat.format(dayOfMonth)+"/"+numberFormat.format((month + 1))+"/"+numberFormat.format(year));
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
        edit_sampai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog = new DatePickerDialog(FilterActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        NumberFormat numberFormat = new DecimalFormat("00");
                        M.edit_sampai = numberFormat.format(year)+"-"+numberFormat.format((month + 1))+"-"+numberFormat.format(dayOfMonth);
                        edit_sampai.setText(numberFormat.format(dayOfMonth)+"/"+numberFormat.format((month + 1))+"/"+numberFormat.format(year));
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit_dari.equals("") || edit_sampai.equals("")){
                    Snackbar.make(v, "Mohon lengkapi data.", Snackbar.LENGTH_LONG).show();
                }else{
                    M.filter = true;
                    M.text_filter.setText(edit_dari.getText().toString() +" - " + edit_sampai.getText().toString());
                    finish();
                }
            }
        });





    }
}
