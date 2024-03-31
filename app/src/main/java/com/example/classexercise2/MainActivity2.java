package com.example.classexercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    private Context context;
    // 밑에 처럼 안만들고 바로 넣어도 돼!!
   // private int duration = Toast.LENGTH_SHORT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView labelUserName = (TextView) findViewById(R.id.textView1) ;
        EditText textUserName = (EditText) findViewById(R.id.editText);
        String Username = textUserName.getText().toString();

        EditText textUserEmail = (EditText) findViewById(R.id.editText2);
        //String Useremail = text.getText().toString();

        Button login = (Button) findViewById(R.id.login);
        context = getApplicationContext();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = textUserName.getText().toString();
                if(userName.compareTo("NaHyun Kim")==0){ //true면
                    labelUserName.setText("OK, Please wait..");
                    Toast.makeText(context, "Hi! "+userName , Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(context, userName+" is not a valid User", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
    public void BackButtonClicked(View v){
        //안내 뜨게 하는 거
        Toast.makeText(this,"돌아갑니다", Toast.LENGTH_LONG).show();

        finish(); //맨처음 화면으로 돌아가고
        //다른 곳으로 연결하고 싶으면 intent 코드 두줄 활용 !
    }
}