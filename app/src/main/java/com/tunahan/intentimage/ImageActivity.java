package com.tunahan.intentimage;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import com.tunahan.intentimage.databinding.ActivityImageBinding;

public class ImageActivity extends AppCompatActivity {

    private ActivityImageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImageBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Bundle b = getIntent().getBundleExtra("bundle");
        byte[] bytes = b.getByteArray("photo");

        Bitmap bmp = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
        binding.imageBackground.setImageBitmap(bmp);
    }
}