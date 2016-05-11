package br.com.bulofarma.bulofarma;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Victor Hugo on 11/05/2016.
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    public void verBula(View view){
        activityVerBula();
    }
    private void activityVerBula(){
        Intent it = new Intent(this,VerBulaActivity.class);
        startActivity(it);
    }
}
