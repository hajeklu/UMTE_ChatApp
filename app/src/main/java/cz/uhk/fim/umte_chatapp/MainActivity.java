package cz.uhk.fim.umte_chatapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText troom;
    private EditText tname;
    private Button bjoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        troom = findViewById(R.id.textName);
        tname = findViewById(R.id.textRoom);
        bjoin = findViewById(R.id.btnJoin);

        SharedPreferences sharedPreferences = getSharedPreferences("credentials", MODE_PRIVATE);

        Log.w("CREDENTIALS", "NAME " + sharedPreferences.getString("name", ""));
        Log.w("CREDENTIALS", "ROOM " + sharedPreferences.getString("room", ""));

        String name = sharedPreferences.getString("name", "");
        String room = sharedPreferences.getString("room", "");

        if (name.length() > 3 && room.length() > 3) {
            startActivity(name, room);
        }


        bjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = tname.getText().toString();
                String room = troom.getText().toString();

                if (name.length() < 3) {
                    showError(getString(R.string.errorShortName));
                    return;
                }

                if (room.length() < 3) {
                    showError(getString(R.string.errorShortRoom));
                    return;
                }

                SharedPreferences sharedPreferences = getSharedPreferences("credentials", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("name", name);
                editor.putString("room", room);

                editor.commit();

                startActivity(name, room);
            }
        });

    }

    private void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    private void startActivity(String name, String room) {
        Intent intent = new Intent(MainActivity.this, RoomActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("room", room);
        startActivity(intent);
        finish();
    }
}
