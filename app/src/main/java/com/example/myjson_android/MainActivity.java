package com.example.myjson_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txtModel;
        final TextView txtColor;
        final TextView txtPrice;
        final ImageView imgModel;
        txtModel = findViewById(R.id.txtModel);
        txtColor = findViewById(R.id.txtColor);
        txtPrice = findViewById(R.id.txtPrice);
        imgModel = findViewById(R.id.ImgModel);

        Ion.with(this)
                .load("http://192.168.1.44/NewMobile/asset/img/Apple.jpg")
                .intoImageView(imgModel);
        Ion.with(this)
                .load("http://192.168.1.44/NewMobile/Json_array.php")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        txtModel.setText(result.get("model").getAsString());
                        txtColor.setText(result.get("color").getAsString());
                        txtPrice.setText(result.get("price").getAsString());
                    }
                });
    }
}
