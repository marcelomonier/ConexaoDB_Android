package br.com.marcelomonier.conexaobd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {


    DataBaseHelper myDb;
    EditText txt_id, txt_nome,txt_sobrenome,txt_profissao;
    Button bt_atualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        myDb = new DataBaseHelper(this);

        txt_id = (EditText) findViewById(R.id.edit_id);
        txt_nome = (EditText) findViewById(R.id.edit_nome);
        txt_sobrenome = (EditText) findViewById(R.id.edit_sobrenome);
        txt_profissao = (EditText) findViewById(R.id.edit_profissao);

        bt_atualizar = (Button) findViewById(R.id.btn_atualizar);

        bt_atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClickMe2();
            }


        });




    }


    private void ClickMe2(){

        String id = txt_id.getText().toString();
        String nome = txt_nome.getText().toString();
        String sobrenome = txt_sobrenome.getText().toString();
        String profissao = txt_profissao.getText().toString();

        Boolean result_update = myDb.updateData(id, nome, sobrenome, profissao);

        if (result_update==true){
            Toast.makeText(this, "Dado atualizado com sucesso", Toast.LENGTH_SHORT).show();

            } else{

            Toast.makeText(this, "ID não existe", Toast.LENGTH_SHORT).show();
        }



    }

}
