package services;

import android.os.AsyncTask;
import android.util.Log;

import java.net.HttpURLConnection;
import java.net.URL;

public class MessagePost extends AsyncTask<String, Void, Boolean> {

    private OnMessagePostSuccessListener onMessagePostSuccessListener;
    private OnMessagePostFailureListener onMessagePostFailureListener;

    public static String getUrl(String room) {
        return "http://uhk.alesberger.cz/chat/send.php?room=" + room;
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        String name = strings[0];
        String room = strings[1];
        String message = strings[2];

        try {
            URL url = new URL(MessagePost.getUrl("umte"));

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("POST");


            String query = "sender=" + name + "&recipient=all&message=" + message;
            byte[] posetDatabytes = query.getBytes("UTF-8");

            httpURLConnection.setDoInput(true);
            httpURLConnection.getOutputStream().write(posetDatabytes);
            int response = httpURLConnection.getResponseCode();
            onPosetExecute(response == 200);

            if (response == 200) {
                Log.w("MESSAGE POST", "RESPONSE: " + response);
                return true;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public OnMessagePostSuccessListener getOnMessagePostSuccessListener() {
        return onMessagePostSuccessListener;
    }

    public void setOnMessagePostSuccessListener(OnMessagePostSuccessListener onMessagePostSuccessListener) {
        this.onMessagePostSuccessListener = onMessagePostSuccessListener;
    }

    public OnMessagePostFailureListener getOnMessagePostFailureListener() {
        return onMessagePostFailureListener;
    }

    public void setOnMessagePostFailureListener(OnMessagePostFailureListener onMessagePostFailureListener) {
        this.onMessagePostFailureListener = onMessagePostFailureListener;
    }

    public void onPosetExecute(Boolean success) {
        if (success) {
            onMessagePostSuccessListener.onSuccess(200, "");
        } else {
            onMessagePostFailureListener.onFailure(400, "");
        }
    }
}
