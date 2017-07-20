package com.example.mq12.radiogruopconcheckbox;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout linearMain;
    TableRow tableRow;
    CheckBox checkBox;
    Button boton;
    ArrayList<String> local = new ArrayList<String>();
    ArrayList<String> visita = new ArrayList<String>();
    List<TableRow> listTableRow = new ArrayList<TableRow>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearMain = (LinearLayout) findViewById(R.id.linearLayout);
        boton = (Button) findViewById(R.id.button);
        boton.setOnClickListener(this);
        local.add("Morelia");
        local.add("Tijuana");
        local.add("Lobos BUAP");
        local.add("Tigres");
        local.add("Leon");
        local.add("America");
        local.add("Guadalajara");
        local.add("UNAM");
        local.add("Veracruz");

        visita.add("Monterrey");
        visita.add("Cruz Azul");
        visita.add("Santos");
        visita.add("Puebla");
        visita.add("Atlas");
        visita.add("Queretaro");
        visita.add("Toluca");
        visita.add("Pachuca");
        visita.add("Necaxa");
        for (int i = 0; i < local.size(); i++) {
            tableRow = new TableRow(this);
            tableRow.setId(i);
            tableRow.setLayoutParams(new ActionBar.LayoutParams(
                    ActionBar.LayoutParams.MATCH_PARENT,
                    ActionBar.LayoutParams.WRAP_CONTENT));

            checkBox = new CheckBox(this);
            checkBox.setText(local.get(i));
            checkBox.setId((i+local.size()));
            tableRow.addView(checkBox);
           checkBox = new CheckBox(this);
            checkBox.setText("Empate");
            checkBox.setId((i+(local.size()* 2)));
            tableRow.addView(checkBox);
            checkBox = new CheckBox(this);
            checkBox.setText(visita.get(i));
            checkBox.setId((i+(local.size()* 3)));
            tableRow.addView(checkBox);
            linearMain.addView(tableRow, new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            listTableRow.add(tableRow);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                enviar();
                break;
        }
    }

    private void enviar() {
        StringBuffer mensaje = new StringBuffer();

       for( TableRow tabla: listTableRow ){

           mensaje.append("Partido No " );
             for(int index=0; index<((TableRow)tabla).getChildCount(); ++index) {
                View nextChild = ((TableRow)tabla).getChildAt(index);
                 CheckBox c = (CheckBox) findViewById(nextChild.getId());

                mensaje.append(c.getText() +" ").append(c.isChecked()+ "\n");
                Log.d("mensanje " ,"mensaje: " +  mensaje.toString());
            }
             mensaje.append("\n");


        }

        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();


    }
}
