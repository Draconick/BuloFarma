package br.com.bulofarma.bulofarma;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.bulofarma.bulofarma.dados.RepositorioAdministrador;
import br.com.bulofarma.bulofarma.modelo.Administrador;

/**
 * Created by Victor Hugo on 11/05/2016.
 */
public class MainActivity extends Activity {
    private int contador;
    private List<Administrador> administradorList;
    private RepositorioAdministrador repositorioAdministrador;
    private Administrador administrador;
    private boolean login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        repositorioAdministrador = new RepositorioAdministrador(this);
        administradorList = new ArrayList<>();
        contador = 0;
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarAdministradores();
        contador = 0;
        login = false;
    }

    public void carregarAdministradores(){
        administradorList = repositorioAdministrador.listar();
    }
    public void verBula(View view){
        activityVerBula();
    }
    private void activityVerBula(){
        Intent it = new Intent(this,VerBulaActivity.class);
        startActivity(it);
    }

    public void menuAdmin(View view){
      contador++;
      activityMenuAdmin(contador);
    }
    private void activityMenuAdmin(int contador){
        switch (contador){
            case 1:case 2:case 3:case 4:case 5:case 6:case 7:case 8:
                Toast.makeText(getApplicationContext(),R.string.menu_principal,
                        Toast.LENGTH_SHORT).show();
                break;
            case 9:
                Toast.makeText(getApplicationContext(),
                        R.string.aviso_menu_admin,Toast.LENGTH_LONG).show();
                break;
            case 10:
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View edtEntryView = inflater.inflate(R.layout.alert_dialog_admin,null);
                final EditText edtLogin = (EditText) edtEntryView.findViewById(R.id.login_admin);
                final EditText edtSenha = (EditText) edtEntryView.findViewById(R.id.senha_admin);

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.modo_admin);
                builder.setView(edtEntryView);
                builder.setPositiveButton(R.string.login, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String strlogin = edtLogin.getText().toString();
                        String strSenha = edtSenha.getText().toString();
                        administrador = new Administrador(strlogin,strSenha);
                        logarAdministrador(administrador);
                    }
                });
                builder.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
                break;
        }
    }

    private void logarAdministrador(Administrador administrador){
        for(Administrador a : administradorList){
            if(administrador.getLogin().equalsIgnoreCase(a.getLogin()) &&
                    administrador.getSenha().equals(a.getSenha())){
                Intent it = new Intent(this, DashboardAdmin.class);
                startActivity(it);
                Toast.makeText(this,R.string.admin_login_sucesso, Toast.LENGTH_SHORT).show();
                login = true;
                contador = 0;
            }
        }
        if(!login){
            Toast toast = Toast.makeText(this,R.string.login_erro,Toast.LENGTH_SHORT);
            toast.show();
            contador = 0;
        }
    }
    public void configuracoes(View view){

    }
    public void bulaFavorita(View view){

    }
    public void listarAlarmes(View view){

    }
}
