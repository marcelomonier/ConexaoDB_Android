package br.com.marcelomonier.conexaobd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {


    ImageView img_user, img_addUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        img_user = (ImageView) findViewById(R.id.imageView2);
        img_addUser = (ImageView) findViewById(R.id.imageView);


        img_addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(i);


            }
        });

        img_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MenuActivity.this, UsersActivity.class);
                startActivity(i);


            }
        });


    }
}
