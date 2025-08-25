package com.example.jokenpo;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imgPedra, imgPapel, imgTesoura, imgEscolhaApp;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        imgPedra = findViewById(R.id.img_pedra);
        imgPapel = findViewById(R.id.img_papel);
        imgTesoura = findViewById(R.id.img_tesoura);
        imgEscolhaApp = findViewById(R.id.img_escolha_app);
        txtResultado = findViewById(R.id.txt_resultado);

        imgPedra.setOnClickListener(v -> verificarGanhador("Pedra"));

        imgPapel.setOnClickListener(v -> verificarGanhador("Papel"));

        imgTesoura.setOnClickListener(v -> verificarGanhador("Tesoura"));

    }

    private void verificarGanhador(String escolhaUsuario) {

        String escolhaApp = escolhaApp();

        if((escolhaApp == "Pedra" && escolhaUsuario == "Tesoura") || (escolhaApp == "Papel" && escolhaUsuario == "Pedra") || (escolhaApp == "Tesoura" && escolhaUsuario == "Papel")
        ){
            txtResultado.setText(R.string.msg_derrota);
            txtResultado.setTextColor(Color.RED);

        }else if((escolhaUsuario == "Pedra" && escolhaApp == "Tesoura") || (escolhaUsuario == "Papel" && escolhaApp == "Pedra") || (escolhaUsuario == "Tesoura" && escolhaApp == "Papel")
        ){
            txtResultado.setText(R.string.msg_vitoria);
            txtResultado.setTextColor(Color.GREEN);

        }else{
            txtResultado.setText(R.string.msg_empate);
            txtResultado.setTextColor(Color.YELLOW);
        }


    }

    private String escolhaApp() {

        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        int numero = new Random().nextInt(3);
        String escolhaApp = opcoes[numero];

        switch (escolhaApp){
            case "Pedra":
                imgEscolhaApp.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imgEscolhaApp.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imgEscolhaApp.setImageResource(R.drawable.tesoura);
                break;

        }

        return escolhaApp;
    }
}