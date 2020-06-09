package com.example.appaluno;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{

            SQLiteDatabase bd = openOrCreateDatabase("tbAluno", MODE_PRIVATE, null);


            bd.execSQL("CREATE TABLE IF NOT EXISTS tbAluno (nome VARCHAR, email VARCHAR, telefone VARCHAR)");

            bd.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Aline', 'aline.freitas199922@hotmail.com', '946557898')");
            bd.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Fabricio', 'fabricio.maias@live.com', '943738781')");
            bd.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Danilo', 'danilo.portuguesa@yahoo.com', '944557898')");
            bd.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Matheus', 'matheusrs.siqueira@hotmail.com', '944556717')");
            bd.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Cristiane', 'cristiane.renata2323@hotmail.com', '981874066')");
            bd.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Thiago', 'thiago.miticojovem@gmail.com', '922557897')");
            bd.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Augusto', 'augusto.corinthians120001@outlook.com', '955667788')");
            bd.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Deivid', 'deivid.sp123@gmail.com', '912345678')");
            bd.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Gabriella', 'gabriella.oliveira123@hotmail.com', '968694578')");
            bd.execSQL("INSERT INTO tbAluno(nome, email, telefone) VALUES ('Neymar', 'luiza@hotmail.com', '9466798751')");



            Cursor cursor =bd.rawQuery("SELECT nome, idade FROM tbAluno", null);

            int indiceNome =cursor.getColumnIndex("nome");
            int indiceIdade =cursor.getColumnIndex("email");
            int indiceTelefone =cursor.getColumnIndex("telefone");

            cursor.moveToFirst();

            while (cursor != null){
                Log.i("Resultado do nome: ", cursor.getString(indiceNome));
                Log.i("Resultado da idade: ", cursor.getString(indiceIdade));
                Log.i("Resultado do telefone: ", cursor.getString(indiceTelefone));

                cursor.moveToNext();
            }
        }

        catch (Exception e){
            e.printStackTrace();
        }

    }
}

