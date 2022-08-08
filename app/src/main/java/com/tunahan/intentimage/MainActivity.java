package com.tunahan.intentimage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;

import com.tunahan.intentimage.databinding.ActivityMainBinding;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }

    public void sendButton(View view){

        Bitmap bitmap = ((BitmapDrawable)binding.imageBee.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] bytearray = stream.toByteArray();

        Intent intent = new Intent(getApplicationContext(),ImageActivity.class);
        Bundle bundle = new Bundle();
        bundle.putByteArray("photo",bytearray);
        intent.putExtra("bundle",bundle);
        startActivity(intent);
        finish();


    }
}