package br.com.marcelomonier.conexaobd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Profissao.db";
    public static final String TABLE_NAME = "Empregado";

    public static final String COL_1 = "ID";
    public static final String COL_2 = "NOME";
    public static final String COL_3 = "SOBRENOME";
    public static final String COL_4 = "PROFISSAO";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NOME TEXT, SOBRENOME TEXT, PROFISSAO TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

    }

    //Método para buscar todos os dados do banco sqlite
    public Cursor getAllData(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return res;
    }



    //Método para inserir dados no banco sqlite
    public boolean inserirDados (String nome, String sobrenome, String profissao){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2, nome);
        contentValues.put(COL_3, sobrenome);
        contentValues.put(COL_4, profissao);

        long result = db.insert(TABLE_NAME, null, contentValues);
        db.close();

        if (result == 1){
            return false;
        } else {
            return true;
        }



    }

    public boolean updateData(String id, String nome, String sobrenome, String profissao){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, nome);
        contentValues.put(COL_3, sobrenome);
        contentValues.put(COL_4, profissao);

        int result =db.update(TABLE_NAME, contentValues, "ID =?", new String[]{id});

        if (result > 0){

            return true;

        } else

        {
            return false;
        }



    }


    public Integer deleteData(String id){

        SQLiteDatabase db = this.getWritableDatabase();
        int i = db.delete(TABLE_NAME, "ID=?", new String[] {id});
        return i;


    }


}
