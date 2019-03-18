package services;

public interface OnMessagePostFailureListener {

    void onFailure(int code, String response);
}
