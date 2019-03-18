package cz.uhk.fim.umte_chatapp;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import services.MessagePost;
import services.OnMessagePostFailureListener;
import services.OnMessagePostSuccessListener;

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
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editTextmessage.getText().toString();

                MessagePost messagePost = new MessagePost();

                String name = sharedPreferences.getString("name", "");
                String room = sharedPreferences.getString("room", "");
                messagePost.execute(name, room, message);
                messagePost.setOnMessagePostFailureListener(new OnMessagePostFailureListener() {
                    @Override
                    public void onFailure(int code, String response) {
                        Toast.makeText(MessageActivity.this, "Something went wrong", Toast.LENGTH_LONG);
                    }
                });

                messagePost.setOnMessagePostSuccessListener(new OnMessagePostSuccessListener() {
                    @Override
                    public void onSuccess(int code, String response) {
                        finish();
                    }
                });

                finish();

                Toast.makeText(MessageActivity.this, message, Toast.LENGTH_LONG).show();
            }
        });


    }

}
