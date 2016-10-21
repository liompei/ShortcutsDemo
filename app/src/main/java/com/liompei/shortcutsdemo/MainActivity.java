package com.liompei.shortcutsdemo;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        btn= (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setupShortcuts();
            }
        });
    }


    private void setupShortcuts(){
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N_MR1) {

                Intent intent=new Intent(this,TestActivity.class);
                intent.setAction(Intent.ACTION_VIEW);
                ShortcutInfo shortcut = new ShortcutInfo.Builder(this, "id5")
                        .setShortLabel("短地址")
                        .setLongLabel("一个长长的地址")
                        .setIcon(Icon.createWithResource(this, R.drawable.ic_favorite_black_24dp))
                        .setIntent(intent)
                        .build();
                shortcutManager.addDynamicShortcuts(Arrays.asList(shortcut));
            }
        }
    }





}
