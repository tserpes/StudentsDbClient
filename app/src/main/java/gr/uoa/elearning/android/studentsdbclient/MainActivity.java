package gr.uoa.elearning.android.studentsdbclient;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Cursor cursor = getContentResolver().query(Uri.parse(StudentDbContract.CONTENT_URI),new String[]{StudentDbContract.KEY_FNAME,StudentDbContract.KEY_LNAME},null,null,null);
        if (cursor.moveToFirst()){
            do{
                TextView first_name = (TextView)findViewById(R.id.textView1);
                TextView last_name = (TextView)findViewById(R.id.textView2);
                first_name.setText(cursor.getString(0));
                last_name.setText(cursor.getString(1));
            }while(cursor.moveToNext());
        }
    }
}
