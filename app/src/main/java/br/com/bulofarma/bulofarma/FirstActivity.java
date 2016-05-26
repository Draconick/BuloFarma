package br.com.bulofarma.bulofarma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Katrina on 23/05/2016.
 */
public class FirstActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
    }

    public void menuPrincipal(View view){
        mainActivity();
    }

    private void mainActivity(){
        Intent it = new Intent(this,MainActivity.class);
        startActivity(it);
    }
}
