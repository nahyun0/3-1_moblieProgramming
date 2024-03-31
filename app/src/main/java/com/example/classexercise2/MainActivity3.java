package com.example.classexercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity3 extends AppCompatActivity {
    CheckBox chkCream;
    CheckBox chkSugar;
    Button BtnPay;

    RadioGroup coffeType;
    RadioButton radDecaf;
    RadioButton radEspresso;
    RadioButton radColombin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        coffeType = (RadioGroup) findViewById(R.id.RadoiGroup1);
        radDecaf = (RadioButton) findViewById(R.id.RadioButton1);
        radEspresso = (RadioButton) findViewById(R.id.RadioButton2);
        radColombin = (RadioButton) findViewById(R.id.RadioButton3);


        chkCream = (CheckBox) findViewById(R.id.chkCream);
        chkSugar = (CheckBox) findViewById(R.id.chkSugar);
        BtnPay = (Button) findViewById(R.id.btnPay);

        BtnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "Coffee";

                int radioId = coffeType.getCheckedRadioButtonId();
                if (radDecaf.getId() == radioId) {
                    msg = "Decaf " + msg;
                }
                if (radEspresso.getId() == radioId) {
                    msg = "Espresso " + msg;
                }
                if (radColombin.getId() == radioId) {
                    msg = "Colombin " + msg;
                }

                //크림 check 가 되면
                if (chkCream.isChecked()) {
                    msg += " & cream ";
                }

                //설탕 check 가 되면
                if (chkSugar.isChecked()) {
                    msg += " & sugar ";
                }

                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }

        });


        // * 로그(log)란 - 코드의 흐름을 파악한 위한 정보 출력 .
        // * 로그캣(logcat) - 출력되는 로그들을 모아서 보는 도구입니다.
        chkCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "Coffee";

                if (chkCream.isChecked()) {
                    msg += " & cream ";
                }

                else{
                    Log.d("notCheckCream","Cream 선택 안 함."); //logcat 내에서 볼 수 있다.
                }

                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }

        });

        chkSugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = "Coffee";

                if (chkCream.isChecked()) {
                    msg += " & Sugar ";
                }



                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }

        });


      //Box 상태가 변경 되었을 때 (눌림, 안눌림) 같이
        chkCream.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (buttonView.getId() == R.id.chkCream) {
                    if (isChecked) {
                        Toast.makeText(getApplicationContext(), "눌림", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "안눌림", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });


        //CoffType인 그룹 내 후보 (눌림, 안눌림)
        coffeType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                    if (checkedId == R.id.RadioButton1) {
                        Toast.makeText(getApplicationContext(), "Click Decaf", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "not Click Decaf", Toast.LENGTH_SHORT).show();
                    }
                 }

               // Log.d("chk", "id" +ckeckId);

        });
    }
    public void BackButtonClicked(View v){
        //안내 뜨게 하는 거
        Toast.makeText(this,"돌아갑니다", Toast.LENGTH_LONG).show();

        finish(); //맨처음 화면으로 돌아가고
        //다른 곳으로 연결하고 싶으면 intent 코드 두줄 활용 !
    }
}