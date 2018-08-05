package com.bhatta.bp.jsonlistview;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class ShowDataActivity extends AppCompatActivity {

    int score = 0;
    int quid = 0;


    TextView txtQuestion;
    RadioButton rda,rdb,rdc;
    Button butNext;


    SQLiteHelper sqLiteHelper;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    ListAdapter listAdapter ;
    ListView LISTVIEW;
    ArrayList<String> ID_Array;
    ArrayList<String> QUESTION_Array;
    ArrayList<String> OPTA_Array;
    ArrayList<String> OPTB_Array;
    ArrayList<String> OPTC_Array;
    ArrayList<String> ANSWER_Array;
    ArrayList<String> ListViewClickItemArray = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        LISTVIEW = (ListView) findViewById(R.id.listView1);

        ID_Array = new ArrayList<String>();

        QUESTION_Array=new ArrayList<String>();
        OPTA_Array=new ArrayList<String>();
        OPTB_Array=new ArrayList<String>();
        OPTC_Array=new ArrayList<String>();
        ANSWER_Array=new ArrayList<String>();


        sqLiteHelper = new SQLiteHelper(this);

        LISTVIEW.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // TODO Auto-generated method stub

                Toast.makeText(ShowDataActivity.this, ListViewClickItemArray.get(position).toString(), Toast.LENGTH_LONG).show();

            }
        });


    }
    public void btClick(View view) {
        RadioButton dbanswer=(RadioButton)findViewById(R.id.rb_answer);

        RadioGroup grp = (RadioGroup) findViewById(R.id.radioGroup1);
        RadioButton answer = (RadioButton) findViewById(grp.getCheckedRadioButtonId());
        if (dbanswer.toString().equalsIgnoreCase (answer.getText().toString())) {
            Toast.makeText(this, "You Are ", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(this, "You Are Wrong", Toast.LENGTH_SHORT).show();

        }

           }
    @Override
    protected void onResume() {

        ShowSQLiteDBdata() ;

        super.onResume();
    }

    private void ShowSQLiteDBdata() {

        sqLiteDatabase = sqLiteHelper.getWritableDatabase();

        cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+SQLiteHelper.TABLE_NAME+"", null);

        ID_Array.clear();
        QUESTION_Array.clear();
        OPTC_Array.clear();
        OPTB_Array.clear();
        OPTA_Array.clear();
        ANSWER_Array.clear();

        if (cursor.moveToFirst()) {
            do {

                ID_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_ID)));

                //Inserting Column Name into Array to Use at ListView Click Listener Method.
                ListViewClickItemArray.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_1_question)));

                QUESTION_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_1_question)));
                OPTA_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_2_opta)));
                OPTB_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_3_optb)));
                OPTC_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_4_optc)));
                ANSWER_Array.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_5_answer)));


            } while (cursor.moveToNext());
        }

        listAdapter = new ListAdapter(ShowDataActivity.this,

                ID_Array,
                QUESTION_Array,
                OPTA_Array,
                OPTB_Array,
                OPTC_Array,
                ANSWER_Array
        );

        LISTVIEW.setAdapter(listAdapter);

        cursor.close();
    }
}