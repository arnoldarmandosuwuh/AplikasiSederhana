package com.example.aplikasisederhana;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etCoffee, etChoco, etLemon, etCappuccino;
    CheckBox cbCoffee, cbChoco, cbLemon, cbCappuccino;
    Button btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etCoffee = findViewById(R.id.etCoffeeLatte);
        etChoco = findViewById(R.id.etChocolate);
        etLemon = findViewById(R.id.etLemonTea);
        etCappuccino = findViewById(R.id.etCappuccino);
        cbCoffee = findViewById(R.id.cbCoffeeLatte);
        cbChoco = findViewById(R.id.cbHotChocolate);
        cbLemon = findViewById(R.id.cbLemonTea);
        cbCappuccino = findViewById(R.id.cbCappuccino);
        btnOrder = findViewById(R.id.btnOrder);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int price, totalPrice = 0, quantity;
                String orderSummary;
                String name = etName.getText().toString();
                orderSummary = "Customer name : " + name + "\n" + "Order : \n";

                if (cbCoffee.isChecked()) {
                    quantity = Integer.parseInt(etCoffee.getText()
                            .toString());
                    price = 4000 * quantity;
                    totalPrice += price;
                    orderSummary += cbCoffee.getText().toString() + " " + quantity + "pcs\n";
                }
                if (cbChoco.isChecked()) {
                    quantity = Integer.parseInt(etChoco.getText()
                            .toString());
                    price = 1500 * quantity;
                    totalPrice += price;
                    orderSummary += cbChoco.getText().toString() + " " + quantity + "pcs\n";
                }
                if (cbLemon.isChecked()) {
                    quantity = Integer.parseInt(etLemon.getText()
                            .toString());
                    price = 12000 * quantity;
                    totalPrice += price;
                    orderSummary += cbLemon.getText().toString() + " " + quantity + "pcs\n";
                }
                if (cbCappuccino.isChecked()) {
                    quantity = Integer.parseInt(etCappuccino.getText()
                            .toString());
                    price = 7000 * quantity;
                    totalPrice += price;
                    orderSummary += cbCappuccino.getText().toString() + " " + quantity + "pcs\n";
                }
                orderSummary += "Total Price : Rp." + totalPrice;
                /*Toast.makeText(MainActivity.this, orderSummary,
                        Toast.LENGTH_LONG).show();*/

                AlertDialog alertDialog = new AlertDialog
                        .Builder(MainActivity.this).create();
                alertDialog.setTitle("Order Summary");
                alertDialog.setMessage(orderSummary);
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                etName.setText("");
                                etCoffee.setText("");
                                etChoco.setText("");
                                etLemon.setText("");
                                etCappuccino.setText("");
                                if (cbCoffee.isChecked())
                                    cbCoffee.setChecked(false);
                                if (cbChoco.isChecked())
                                    cbChoco.setChecked(false);
                                if (cbLemon.isChecked())
                                    cbLemon.setChecked(false);
                                if (cbCappuccino.isChecked())
                                    cbCappuccino.setChecked(false);
                            }
                        });
                alertDialog.show();
            }
        });


    }
}
