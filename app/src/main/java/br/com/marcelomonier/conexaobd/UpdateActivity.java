package br.com.marcelomonier.conexaobd;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    DataBaseHelper myDb;
    EditText txtId, txtName, txtSobrenome, txtProfissao;
    Button btn_atualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        txtId = (EditText) findViewById(R.id.editText);
        txtName = (EditText) findViewById(R.id.editText3);
        txtSobrenome = (EditText) findViewById(R.id.editText6);
        txtProfissao = (EditText) findViewById(R.id.editText7);

        btn_atualizar = (Button) findViewById(R.id.button3);

        btn_atualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClickMe2();
//                String id = txtId.getText().toString();
//                String nome = txtName.getText().toString();
//                String sobrenome = txtSobrenome.getText().toString();
//                String profissao = txtProfissao.getText().toString();
//
//                Boolean result = myDb.updateData(id, nome, sobrenome, profissao);
//
//                if (result == true){
//                    Toast.makeText(UpdateActivity.this, "Dados atualizados com sucesso!", Toast.LENGTH_SHORT).show();
//                } else{
//                    Toast.makeText(UpdateActivity.this,"Dados não atualizados", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });


            }


            private void ClickMe2() {

                String id2 = txtId.getText().toString();
                String nome2 = txtName.getText().toString();
                String sobrenome2 = txtSobrenome.getText().toString();
                String job2 = txtProfissao.getText().toString();

                Boolean result = myDb.updateData(id2, nome2, sobrenome2, job2);

                if (result == true) {
                    Toast.makeText(UpdateActivity.this, "Dados atualizados com sucesso!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UpdateActivity.this, "Dados não atualizados", Toast.LENGTH_SHORT).show();
                }

            }

        });
    }
}

