package cz.uhk.fim.umte_chatapp;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MessageActivity extends AppCompatActivity {

    private Button sendBtn;
    private EditText editTextmessage;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        setTitle("Message");

        sharedPreferences = getSharedPreferences("credentials", MODE_PRIVATE);

        sendBtn = findViewById(R.id.sendbtn);
        editTextmessage = findViewById(R.id.messageText);

        prepareAsyncTask();

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editTextmessage.getText().toString();

                Toast.makeText(MessageActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });


    }


    private void prepareAsyncTask() {

        new AsyncTask<String, Integer, String>() {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                super.onProgressUpdate(values);
            }

            @Override
            protected String doInBackground(String... strings) {
                return "";
            }
        }.execute("file1", "field2");
    }
}
