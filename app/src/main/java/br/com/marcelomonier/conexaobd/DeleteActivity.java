package br.com.marcelomonier.conexaobd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    EditText txt_id;
    Button btn_delete;
    DataBaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        myDb = new DataBaseHelper(this);
        txt_id = (EditText) findViewById(R.id.editText8);
        btn_delete = (Button) findViewById(R.id.button4);


        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = txt_id.getText().toString();
                int result = myDb.deleteData(id);

                Toast.makeText(DeleteActivity.this, result + ": Linha apagada", Toast.LENGTH_SHORT).show();

            }
        });


    }



}
