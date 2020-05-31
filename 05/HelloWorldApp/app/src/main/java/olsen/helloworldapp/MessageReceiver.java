package olsen.helloworldapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MessageReceiver extends AppCompatActivity {

    protected static String TAG = "ScriptureActivity";
    String book;
    String chapter;
    String verse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_receiver);

        Intent intent = getIntent();

        TextView scripText = findViewById(R.id.recd_message);
        book = intent.getStringExtra("book");
        chapter = intent.getStringExtra("chapter");
        verse = intent.getStringExtra("verse");

        Log.d(TAG, "Received intent with " + book + " " + chapter + ":" + verse);
        scripText.setText(book + " " + chapter + ":" + verse);
    }

    public void saveScripture(View view) {

        // store data in SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        // Editor Object will write to file
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("book", book);
        myEdit.putString("chapter", chapter);
        myEdit.putString("verse", verse);
        myEdit.commit();

        Toast.makeText(getApplicationContext(), "Scripture Saved", Toast.LENGTH_LONG).show();
    }

}
