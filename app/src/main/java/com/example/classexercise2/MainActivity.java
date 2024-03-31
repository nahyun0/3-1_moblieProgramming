package com.example.classexercise2;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Date;

public class MainActivity extends AppCompatActivity {

    MainFragment mainFragment;
    MenuFragment menuFragment;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = (TextView) findViewById(R.id.text);
        Button startButton = (Button) findViewById(R.id.startButton1);
        Button button2 = (Button) findViewById(R.id.button2);

        //날짜 쓰게 하는 거 클릭시간이랑
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            //클릭시 저 함수 연동
            public void onClick(View v) {
                updateTime();
            }
        });

        //java 내에서 setText써서 텍스트 바꾸기
        String a = "202235013";
        text.setText(a);

        ScrollView scrollView = (ScrollView) findViewById(R.id.myScrollView1);


        //!!!!!!! 옵션 메뉴는 툴바를 꼭 만든 후에 쓰는 거 였다....!!!! 밑 두줄과 xml 가서 toolbar 디자인 코드 필수
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, mainFragment).commit();
        menuFragment = new MenuFragment();
    }
    public void onFragmentChanged(int index) {
        if (index == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, menuFragment).commit();
        } else if (index == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, mainFragment).commit();
        }
    }


    //Opetion Menu
    public boolean onCreateOptionsMenu(Menu menu) { //메뉴가 처음 호출될때 생성
       MenuInflater inflater = getMenuInflater();
       inflater.inflate(R.menu.activity_main4, menu);//menu.xml이름 에서 메뉴 항목을 가져와서 지정된 Menu 객체(menu)에 추가 의미
        return true; //이 메서드는 메뉴를 생성, 화면에 표시
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        /*
        switch (id) {
            case R.id.menu_refresh:
                Toast.makeText(this, "새로고침 메뉴가 선택 됨", Toast.LENGTH_SHORT).show(); //이 activity 끝나면 끝나도 됨!!
                break;
            case R.id.menu_search:
                Toast.makeText(this, "검색 메뉴가 선택 됨", Toast.LENGTH_SHORT).show(); //이 activity 끝나면 끝나도 됨!!
                break;

            case R.id.menu_settings:
                Toast.makeText(this, "설정 메뉴가 선택 됨", Toast.LENGTH_SHORT).show(); //이 activity 끝나면 끝나도 됨!!
                break;

        }
*/

        if (id == R.id.menu_refresh) {
            Toast.makeText(this, "새로고침 메뉴가 선택 됨", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.menu_search) {
            Toast.makeText(this, "검색 메뉴가 선택 됨", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.menu_settings) {
            Toast.makeText(this, "설정 메뉴가 선택 됨", Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }

    //날짜쓰게 하는 거 밑에 updateTime 함수 꼭 같이 써준다 .
    private void updateTime(){
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setText(new Date().toString());
    }



    //맨 처음 창에서 start 버튼을 눌렀을 때 start! (button1 클릭시 mainActivity2 연결)
    public void startButtonClicked(View v){
        //밑에 안내문 살포시 뜨게 하는 거
        Toast.makeText(this,"버튼이 눌렸어요", Toast.LENGTH_LONG).show();

        //새로운 창 실행 시 실행될 java 파일 연결
        // intent 는 컴포넌트 간 통신을 맡고 있는 것
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    // button3 ( CheckBox 쓰인 버튼 ) -> MainActivity3 연결

    public void CheckButtonClicked(View v) {
        //밑에 안내문 살포시 뜨게 하는 거
        Toast.makeText(this, "버튼이 눌렸어요", Toast.LENGTH_LONG).show();

        //새로운 창 실행 시 실행될 java 파일 연결
        // intent 는 컴포넌트 간 통신을 맡고 있는 것
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

    //WebView 버튼
public void CheckButton4Clicked(View v) {
    //밑에 안내문 살포시 뜨게 하는 거
    Toast.makeText(this, "버튼이 눌렸어요", Toast.LENGTH_LONG).show();

    //새로운 창 실행 시 실행될 java 파일 연결
    // intent 는 컴포넌트 간 통신을 맡고 있는 것
    Intent intent = new Intent(this, MainActivity4.class);
    startActivity(intent);
}

    public void CheckButton5Clicked(View v) {
        //밑에 안내문 살포시 뜨게 하는 거
        Toast.makeText(this, "버튼이 눌렸어요", Toast.LENGTH_LONG).show();

        //새로운 창 실행 시 실행될 java 파일 연결
        // intent 는 컴포넌트 간 통신을 맡고 있는 것
        Intent intent = new Intent(this, MainActivity5.class);
        startActivity(intent);
    }

    public void CheckButton6Clicked(View v) {
        //밑에 안내문 살포시 뜨게 하는 거
        Toast.makeText(this, "버튼이 눌렸어요", Toast.LENGTH_LONG).show();

        //새로운 창 실행 시 실행될 java 파일 연결
        // intent 는 컴포넌트 간 통신을 맡고 있는 것
        Intent intent = new Intent(this, MainActivity6.class);
        startActivity(intent);
    }

}