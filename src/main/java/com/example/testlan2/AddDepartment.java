package com.example.testlan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDepartment extends AppCompatActivity {

    private DBHelper helper;
    String kbn="";
    String toastMessage = "登録しました。戻るボタンを押してください";
    String toastMessage2= "登録するものがありません。";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_department);

        helper=new DBHelper(getApplicationContext());

        Intent intent =getIntent();
        String kbn = intent.getStringExtra("kbn");

        Button button = findViewById(R.id.add_button);
        View view=findViewById(R.id.Layout);

        if(kbn.length()!=0)
        {
            //
        }else
        {
         kbn="登録";
         button.setText("登録");
        }
    }

    public void add_button(View view){
        SQLiteDatabase db = helper.getWritableDatabase();

        EditText txt1=findViewById(R.id.add_edittext);

        String name =txt1.getText().toString();

        ContentValues values = new ContentValues();
        values.put("name",name);

        if(kbn=="登録"){
            if (name.length()!=0){
                db.insert("Departtb",null,values);

                toastMake(toastMessage,0,+350);
            }else{
                toastMake(toastMessage2,0,+350);
            }
        }
    }
    public  void toastMake(String message,int x,int y)
    {
        Toast toast=Toast.makeText(this,message,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,x,y);
        toast.show();
    }
    public void back(View view){
        finish();
    }
}
/* Button backButton = findViewById(R.id.backmain);
        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/