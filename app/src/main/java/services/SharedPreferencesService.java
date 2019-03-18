package services;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

public class SharedPreferencesService extends AppCompatActivity {
    private static SharedPreferences sharedPreferences;

    public static SharedPreferences getInstance(){
        if(sharedPreferences == null){
      //      sharedPreferences = getSharedPreferences("credentials", MODE_PRIVATE);
        }
        return sharedPreferences;
    }

    private SharedPreferencesService(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }
}
