package com.tpv13.costa.nuno.quizv1;

/**
 * Created by Nuno on 01-12-2016.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDbHelper_game extends SQLiteOpenHelper
{

    //Nome e versao da base de dados
    private static final String DATABASE_NAME ="mydatabase_quiz.db";
    private static final int DATABASE_VERSION = 1;

    public MyDbHelper_game(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        try{

            // cria a tabela Niveis
            db.execSQL("CREATE TABLE Niveis("+
                    "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Nome VARCHAR(200) NOT NULL, " +
                    "Descricao VARCHAR(200) NOT NULL)");
            dadosIniciais_Niveis(db);

            // cria a tabela Categorias
            db.execSQL("CREATE TABLE Categorias("+
                    "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Descricao VARCHAR(200) NOT NULL)");
            dadosIniciais_Categorias(db);


            // cria a tabela Perguntas
            db.execSQL("CREATE TABLE Perguntas("+
                                "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                "Niveis_Id INTEGER NOT NULL, " +
                                "Categorias_Id INTEGER NOT NULL, " +
                                "Pergunta VARCHAR(200) NOT NULL, " +
                                "Pontuacao INTEGER NOT NULL)");
            dadosIniciais_Perguntas(db);

            // cria a tabela Respostas
            db.execSQL("CREATE TABLE Respostas("+
                    "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Perguntas_Id INTEGER NOT NULL, " +
                    "Descricao VARCHAR(200) NOT NULL, " +
                    "Correta VARCHAR(1) NOT NULL)");
            dadosIniciais_Respostas(db);


            // cria a tabela Utilizadores
            db.execSQL("CREATE TABLE Utilizadores("+
                    "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Username VARCHAR(10) NOT NULL, " +
                    "Password VARCHAR(10) NOT NULL)");

            // cria a tabela Users_Ranking
            db.execSQL("CREATE TABLE Users_Ranking("+
                    "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "Utilizadores_Id INTEGER NOT NULL, " +
                    "Niveis_Id INTEGER NOT NULL, " +
                    "PontucaoTotal INTEGER NOT NULL, " +
                    "RespostasDadasTotal INTEGER NOT NULL, " +
                    "RespostasCertasTotal INTEGER NOT NULL)");



            //db.execSQL("INSERT INTO tblPessoas(Nome, Idade, Sexo, Descicao, Imagem) VALUES ('Rosa', '10', 'F', 'Ela mesmo', 'c:/img/Rosa.jpg');");
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
//        dropAll(db);
//        onCreate(db);
    }

    private void dadosIniciais_Niveis(SQLiteDatabase db){

        db.execSQL("INSERT INTO Niveis (Nome, Descricao) VALUES ('Principiante', 'Perguntas mais acessíveis. Permite conhecer melhor até passar a um nível mais dificil.');");
        db.execSQL("INSERT INTO Niveis (Nome, Descricao) VALUES ('Intermédio', 'Perguntas de um grau de dificuldade superior ao nível Principienate.');");
        db.execSQL("INSERT INTO Niveis (Nome, Descricao) VALUES ('Master', 'Perguntas de um grau de dificuldade elevado.');");
    }

    private void dadosIniciais_Categorias(SQLiteDatabase db){
        db.execSQL("INSERT INTO Categorias (Descricao) VALUES ('Desporto');");
        db.execSQL("INSERT INTO Categorias (Descricao) VALUES ('Ciencia');");
        db.execSQL("INSERT INTO Categorias (Descricao) VALUES ('Cinema');");
        db.execSQL("INSERT INTO Categorias (Descricao) VALUES ('Musica');");
        db.execSQL("INSERT INTO Categorias (Descricao) VALUES ('Politica');");
        db.execSQL("INSERT INTO Categorias (Descricao) VALUES ('ESTGF');");
    }

    private void dadosIniciais_Perguntas(SQLiteDatabase db){

        db.execSQL("INSERT INTO Perguntas (Niveis_Id, Categorias_Id, Pergunta, Pontuacao) VALUES (1,6,'Em que cidade se situa a ESTGF?',1 );");
        db.execSQL("INSERT INTO Perguntas (Niveis_Id, Categorias_Id, Pergunta, Pontuacao) VALUES (1,6,'Como é que conhecido o edíficio onde a escola funciona?',1 );");
        db.execSQL("INSERT INTO Perguntas (Niveis_Id, Categorias_Id, Pergunta, Pontuacao) VALUES (3,6,'Qual a data do primeiro dia de aulas da ESTGF',3 );");
        db.execSQL("INSERT INTO Perguntas (Niveis_Id, Categorias_Id, Pergunta, Pontuacao) VALUES (2,5,'Em que ano se inaugurou a ESTGF?',2 );");
        db.execSQL("INSERT INTO Perguntas (Niveis_Id, Categorias_Id, Pergunta, Pontuacao) VALUES (2,6,'Qual o primeiro curso a ser leccionada na ESTGF',2 );");
        db.execSQL("INSERT INTO Perguntas (Niveis_Id, Categorias_Id, Pergunta, Pontuacao) VALUES (2,6,'Qual o primeiro ano da Licenciatura Bietápica em Engenharia Informática',2 );");
    }

    private void dadosIniciais_Respostas(SQLiteDatabase db){
        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (1,'Felgueiras','S' );");
        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (1,'Porto','N' );");
        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (1,'Guimarães','N' );");
        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (1,'Braga','N' );");

        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (2,'Curral dos Caprinos','N' );");
        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (2,'Casa do Curral','S' );");
        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (2,'Quinta de Felgueiras','N' );");
        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (2,'Edificio Prof. João Gomes','N' );");

        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (3,'17 de Outubro de 1998','N' );");
        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (3,'17 de Novembro de 1998','N' );");
        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (3,'17 de Outubro de 1999','N' );");
        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (3,'17 de Novembro de 1999','S' );");

        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (4,'1998','N' );");
        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (4,'1999','S' );");
        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (4,'2000','N' );");
        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (4,'2001','N' );");

        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (5,'Licenciatura em Segurança e Qualidade no Trabalho','N' );");
        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (5,'Licenciatura Bietápica em Engenharia Informática ','N' );");
        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (5,'Licenciatura Bietápica em Solicitadoria','N' );");
        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (5,'Licenciatura Bietápica em Ciências','S' );");

        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (6,'1998','N' );");
        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (6,'1999','N' );");
        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (6,'2000','N' );");
        db.execSQL("INSERT INTO Respostas ( Perguntas_Id, Descricao, Correta) VALUES (6,'2001','S' );");
    }


}
