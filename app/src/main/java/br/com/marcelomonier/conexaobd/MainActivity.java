package br.com.marcelomonier.conexaobd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper myDb;


    EditText edit_nome, edit_sobrenome, edit_profissao;
    Button btn_enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DataBaseHelper(this);

        edit_nome = (EditText) findViewById(R.id.editText4);
        edit_sobrenome = (EditText) findViewById(R.id.editText5);
        edit_profissao = (EditText) findViewById(R.id.editText2);

        btn_enviar = (Button) findViewById(R.id.button);

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = edit_nome.getText().toString();
                String surname = edit_sobrenome.getText().toString();
                String profession = edit_profissao.getText().toString();


                //Acionando o método para inserir dados
                Boolean result =  myDb.inserirDados(name, surname, profession);

                if (result == true){
                    Toast.makeText(MainActivity.this, "Dados inseridos com sucesso", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(MainActivity.this, "Erro ao inserir dados", Toast.LENGTH_SHORT).show();

                }


            }
        });


    }
}
