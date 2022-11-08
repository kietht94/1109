package com.example.testlan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {
    ListView myListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView=findViewById(R.id.listView);
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase db= dbHelper.getWritableDatabase();

        Cursor cursor= db.rawQuery("select*from Departtb",null);

        String[]from={"name"};

        int[] to={android.R.id.text1,android.R.id.text2};

        SimpleCursorAdapter adapter =new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,cursor,from,to,0);

        myListView.setAdapter(adapter);

    }
    public void newAdd(View view){
        Intent intent =new Intent(getApplication(),AddDepartment.class);

        intent.putExtra("kbn","");
        startActivity(intent);
    }
}

/* Button changeButton = findViewById(R.id.seniadddepartment);
        //ボタン押下時
        changeButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //add department Activityに画面遷移
                Intent intent = new Intent(getApplication(), AddDepartment.class);
                startActivity(intent);
            }
        });*/