package br.ulbra.projetocombustivel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;;

public class MainActivity extends AppCompatActivity {
    Button btnCalcular;
    EditText edtNomeV, edtPlacaV, edtDistancia, edtConsumo, edtPreco;
    TextView txtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtNomeV = findViewById(R.id.edtNomeV);
        edtPlacaV = findViewById(R.id.edtPlacaV);
        edtDistancia = findViewById(R.id.edtDistancia);
        edtConsumo = findViewById(R.id.edtConsumo);
        edtPreco = findViewById(R.id.edtPreco);
        txtRes = findViewById(R.id.txtRes);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtNomeV.getText().toString().isEmpty() || edtPlacaV.getText().toString().isEmpty() || edtDistancia.getText().toString().isEmpty()
                        || edtConsumo.getText().toString().isEmpty()|| edtPreco.getText().toString().isEmpty()) {

                    Toast.makeText(MainActivity.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                    return;
                }

                double Distancia, consumo, preco, combustivel, custo;
                Distancia = Double.parseDouble(edtDistancia.getText().toString());
                consumo = Double.parseDouble(edtConsumo.getText().toString());
                preco = Double.parseDouble(edtPreco.getText().toString());



                if (Distancia <= 0 || consumo <= 0 || preco <= 0) {
                    Toast.makeText(MainActivity.this, "Os valores devem ser maiores que zero!", Toast.LENGTH_SHORT).show();
                   return;
                }

                combustivel =  Distancia / consumo;
                custo = combustivel * preco;
                String r =
                        "Veículo: " + edtNomeV.getText().toString()+
                        "\nPlaca: " + edtPlacaV.getText().toString() +
                         "\nDistância: " + edtDistancia.getText().toString() + " km" +
                            "\nCombustível necessário: " +  Math.round(combustivel) + " L" +
                             "\nCusto da viagem: " + Math.round(custo);


                txtRes.setText (r);



            }
        });




    }

}