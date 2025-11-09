package com.example.myapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Calculator extends AppCompatActivity {
    Button one,two,three,four,five,six,seven,eight,nine,zero;
    Button plus,minus,multiply,divide,equals;
    Button btnoppara,btnclosepara,point,btnnegate;
    TextView affichage;
    TextView smalldisp;
    Button clear;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.header);
        toolbar.setOnMenuItemClickListener(item -> {
            int id = item.getItemId();

            if (id == R.id.std) {
                Snackbar.make(findViewById(R.id.main), "Mode Standard", Snackbar.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.scientifique) {
                Snackbar.make(findViewById(R.id.main), "Mode Scientifique", Snackbar.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.programmeur){
                Snackbar.make(findViewById(R.id.main),"Mode programmeur",Snackbar.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.date){
               Snackbar.make(findViewById(R.id.main),"Mode calcul de date",Snackbar.LENGTH_SHORT).show();
                return true;
            }

            return false;
        });
  //Appel de la fonction qui fait le calcul
        calculer();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    //fonction qui permet l'affichage des numéros et des opérations dans le grand display
    private void afficheExpression(String expression){
        affichage.append(expression);
    }

    private void calculer() {

        affichage = findViewById(R.id.affichage);
        smalldisp = findViewById(R.id.smalldisp);
   //bouton qui change le signe du numéro affiché dans le display
        btnnegate = findViewById(R.id.btnnegate);
        btnnegate.setOnClickListener(v -> {
            double affichagenumber = Double.parseDouble(affichage.getText().toString());
            affichagenumber *= -1;
           affichage.setText (String.valueOf(affichagenumber));
        });
        // bouton qui efface les opérations affichées dans le display
        clear=findViewById(R.id.clear);
        clear.setOnClickListener(v -> {
            affichage.setText("0");
            smalldisp.setText("");
        });


        point=findViewById(R.id.btnpoint);
        point.setOnClickListener(v -> afficheExpression("."));

        btnoppara= findViewById(R.id.btnoppara);
        btnoppara.setOnClickListener(v -> {
            if (affichage.getText().toString().equals("0")) {
                affichage.setText("");
                afficheExpression("(");
            } else {
                afficheExpression("(");
            }
        });

        btnclosepara= findViewById(R.id.btnclosepara);
        btnclosepara.setOnClickListener(v -> {
            if (affichage.getText().toString().equals("0")) {
                affichage.setText("");
                afficheExpression(")");
            } else {
                afficheExpression(")");
            }
        });

        zero= findViewById(R.id.btn0);
        zero.setOnClickListener(v -> {
                    if (affichage.getText().toString().equals("0")) {
                        affichage.setText("");
                        afficheExpression("0");
                    } else {
                        afficheExpression("0");
                    }
                });


        one = findViewById(R.id.btn1);
        one.setOnClickListener(v -> {
            if (affichage.getText().toString().equals("0")) {
                affichage.setText("");
                afficheExpression("1");
            } else {
                afficheExpression("1");
            }
        });

        two = findViewById(R.id.btn2);
        two.setOnClickListener(v -> {
            if (affichage.getText().toString().equals("0")) {
                affichage.setText("");
                afficheExpression("2");
            } else {
                afficheExpression("2");
            }
        });

        three = findViewById(R.id.btn3);
        three.setOnClickListener(v -> {
            if (affichage.getText().toString().equals("0")) {
                affichage.setText("");
                afficheExpression("3");
            } else {
                afficheExpression("3");
            }
        });

        four = findViewById(R.id.btn4);
        four.setOnClickListener(v -> {
            if (affichage.getText().toString().equals("0")) {
                affichage.setText("");
                afficheExpression("4");
            } else {
                afficheExpression("4");
            }
        });

        five = findViewById(R.id.btn5);
        five.setOnClickListener(v -> {
            if (affichage.getText().toString().equals("0")) {
                affichage.setText("");
                afficheExpression("5");
            } else {
                afficheExpression("5");
            }
        });

        six = findViewById(R.id.btn6);
        six.setOnClickListener(v -> {
            if (affichage.getText().toString().equals("0")) {
                affichage.setText("");
                afficheExpression("6");
            } else {
                afficheExpression("6");
            }
        });

        seven = findViewById(R.id.btn7);
        seven.setOnClickListener(v -> {
            if (affichage.getText().toString().equals("0")) {
                affichage.setText("");
                afficheExpression("7");
            } else {
                afficheExpression("7");
            }
        });

        eight = findViewById(R.id.btn8);
        eight.setOnClickListener(v -> {
            if (affichage.getText().toString().equals("0")) {
                affichage.setText("");
                afficheExpression("8");
            } else {
                afficheExpression("8");
            }
        });

        nine = findViewById(R.id.btn9);
        nine.setOnClickListener(v -> {
            if (affichage.getText().toString().equals("0")) {
                affichage.setText("");
                afficheExpression("9");
            } else {
                afficheExpression("9");
            }
        });

        //Les opérations
        plus = findViewById(R.id.plus);
        plus.setOnClickListener(v -> {
            if (affichage.getText().length() > 0) {
                afficheExpression("+");
                smalldisp.append(affichage.getText());
                affichage.setText("");
            }
        });

        minus = findViewById(R.id.minus);
        minus.setOnClickListener(v -> {
            if (affichage.getText().length() > 0) {
                afficheExpression("-");
                smalldisp.append(affichage.getText());
                affichage.setText("");

            }
        });

        multiply = findViewById(R.id.multiply);
        multiply.setOnClickListener(v -> {
            if (affichage.getText().length() > 0) {
                afficheExpression("*");
                smalldisp.append(affichage.getText());
                affichage.setText("");
            }
        });

        divide = findViewById(R.id.divide);
        divide.setOnClickListener(v -> {
            if (affichage.getText().length() > 0) {
                afficheExpression("/");
                smalldisp.append(affichage.getText());
                affichage.setText("");
            }
        });

        equals=findViewById(R.id.btnequals);
        equals.setOnClickListener(v -> {

            if (affichage.getText().length() > 0) {
                smalldisp.append(affichage.getText());
                Expression expression = new ExpressionBuilder(smalldisp.getText().toString()).build();
                String result = String.valueOf(expression.evaluate());
                affichage.setText(result);

            }
        });
    }






}