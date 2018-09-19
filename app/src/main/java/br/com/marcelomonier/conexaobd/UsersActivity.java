package br.com.marcelomonier.conexaobd;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UsersActivity extends AppCompatActivity {

    DataBaseHelper myDB;
    TextView textResult;
    Button btn_getUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        myDB = new DataBaseHelper(this);

        textResult = (TextView) findViewById(R.id.idResult);
        btn_getUsers = (Button) findViewById(R.id.button2);

        btn_getUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClikMe();


            }
        });




    }

    public void ClikMe(){

        Cursor res = myDB.getAllData();
        StringBuffer stringBuffer = new StringBuffer();

        if (res != null && res.getCount()>0){

            while (res.moveToNext()){

                stringBuffer.append("Id: "+res.getString(0)+"\n");
                stringBuffer.append("Nome: "+res.getString(1)+"\n");
                stringBuffer.append("Sobrenome: "+res.getString(2)+"\n");
                stringBuffer.append("Profissão: "+res.getString(3)+"\n \n");

            }
            textResult.setText(stringBuffer.toString());
            Toast.makeText(this, "Dados lidos com sucesso!", Toast.LENGTH_SHORT).show();


        } else {

            Toast.makeText(this, "Não existe dados no banco!", Toast.LENGTH_SHORT).show();

        }


    }
}
