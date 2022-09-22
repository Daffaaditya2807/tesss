package com.example.tablelayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Gajelas extends AppCompatActivity {
    FrameLayout frm1,frm2;
    EditText edt;
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HideTitleBar();
        setContentView(R.layout.activity_gajelas);
        cobaKlik();
    }
    private void HideTitleBar(){
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
    }

    public void cobaKlik(){

        frm1 = (FrameLayout) findViewById(R.id.frm1);
        frm2 = (FrameLayout) findViewById(R.id.frm2);
//        edt = (EditText) findViewById(R.id.cari);
        final EditText edt = (EditText) findViewById(R.id.cari);
        builder = new AlertDialog.Builder(this);

        edt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    builder.setMessage("Maaf Pencarian atas "+edt.getText()+"Tidak Tersedia").setCancelable(false).setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            edt.setText("");

                        }
                    });

                    AlertDialog alt = builder.create();
                    alt.show();

                    handled = true;
                }
                return handled;
            }
        });

        frm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setMessage("Anda Memilih SPBU").setCancelable(false).setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog alt = builder.create();
                alt.setTitle("INPO");
                alt.show();

            }
        });
        frm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder.setMessage("Anda Memilih WISATA").setCancelable(false).setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog alt = builder.create();
                alt.setTitle("INPO");
                alt.show();

            }
        });
    }
}