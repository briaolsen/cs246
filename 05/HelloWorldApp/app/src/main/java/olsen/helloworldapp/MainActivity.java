package olsen.helloworldapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String book;
    String chapter;
    String verse;
    EditText bookInput;
    EditText chapterInput;
    EditText verseInput;
    Button submitButton;
    protected static String TAG = "ScriptureActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookInput = (EditText) findViewById(R.id.bookInput);
        chapterInput = (EditText) findViewById(R.id.chapterInput);
        verseInput = (EditText) findViewById(R.id.verseInput);
        submitButton = (Button) findViewById(R.id.submitButton);
    }

    public void submitScripture(View view) {

        book = bookInput.getText().toString();
        book = book.substring(0, 1).toUpperCase() + book.substring(1);
        chapter = chapterInput.getText().toString();
        verse = verseInput.getText().toString();

        Log.d(TAG, "Sent intent with " + book + " " + chapter + ":" + verse);

        Intent intent = new Intent(this, MessageReceiver.class);
        intent.putExtra("book", book);
        intent.putExtra("chapter", chapter);
        intent.putExtra("verse", verse);
        startActivity(intent);
    }

    public void loadScripture(View view) {
        SharedPreferences sp = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        bookInput.setText(sp.getString("book", ""));
        chapterInput.setText(sp.getString("chapter", ""));
        verseInput.setText(sp.getString("verse", ""));

    }

}
