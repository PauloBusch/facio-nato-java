/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author paulo
 */
public class Conexao {
    private static Conexao _conexao;
    private FirebaseOptions _options;
    public Conexao(){
        String pathAuth = "C:\\Users\\paulo\\OneDrive\\Área de Trabalho\\Projetos\\Java\\Firebase\\KeyAccount.json";
        try{
            FileInputStream serviceAccount = new FileInputStream(pathAuth);
            _options = new FirebaseOptions.Builder()
              .setCredentials(GoogleCredentials.fromStream(serviceAccount))
              .setDatabaseUrl("https://fir-7abec.firebaseio.com")
              .build();
        }catch(FileNotFoundException ex){
        
        }catch(IOException ex){
        
        }

        FirebaseApp.initializeApp(_options);
    }
    public synchronized static FirebaseDatabase getDatabase(){
        if(_conexao == null)
            _conexao = new Conexao();
        
        return FirebaseDatabase.getInstance();
    }
}
