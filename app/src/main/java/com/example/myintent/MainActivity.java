package com.example.myintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // xml파일과 연결. xml파일에 있는 뷰들을 객체화 한다.

        Button button = (Button) findViewById(R.id.button);
        //id를 이용해서 view를 찾아달라. button객체를 찾아달라

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //버튼을 눌렀을 때 메뉴 액티비티를 띄워준다.
                //intent = 시스템이 화면을 관리하기 때문에 시스템이 알아들을 수 있게 하는 포맷
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivityForResult(intent, 101);
                //시스템 쪽으로 intent라는 객체를 넘겨준다.
            }
        });
        //버튼을 클릭했을 때 온클릭안에 집어넣은 코드가 실행된다.
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101) {
            String name = String.valueOf(data.getStringArrayExtra("name"));
            Toast.makeText(getApplicationContext(), "메뉴화면으로부터 응답 : " + name, Toast.LENGTH_LONG).show();

        }
    }
}