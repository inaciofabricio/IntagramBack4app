package com.parse.starter.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.starter.R;
import com.parse.starter.util.ParseErros;
import com.parse.starter.util.Permissao;

public class LoginActivity extends AppCompatActivity {

    private EditText editLoginUsuario;
    private EditText editLoginSenha;
    private Button botaoLogar;

    private String[] permissoesNecessarias = new String[]{
            android.Manifest.permission.INTERNET,
            android.Manifest.permission.ACCESS_NETWORK_STATE,
            android.Manifest.permission.READ_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Permissao.validaPermissoes(2,this, permissoesNecessarias);

        editLoginUsuario = (EditText) findViewById(R.id.edit_login_usuario);
        editLoginSenha = (EditText) findViewById(R.id.edit_login_senha);
        botaoLogar = (Button) findViewById(R.id.button_logar);

        verificarUsuarioLogado();

        botaoLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = editLoginUsuario.getText().toString();
                String senha = editLoginSenha.getText().toString();

                verificarLogin(usuario,senha);
            }
        });

    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);

        for(int resultado: grantResults){
            Log.i("teste", "teste");

            if(resultado == PackageManager.PERMISSION_DENIED){
                alertaValidacaoPermissao();
            }
        }
    }

    public void alertaValidacaoPermissao(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permissões Negadas");
        builder.setMessage("Para utilizar esse app, é necessario aceitar as permissões");

    }

    private void verificarLogin(final String usuario, final String senha){
        ParseUser.logInInBackground(usuario, senha, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {

                ParseErros parseErros = new ParseErros();

                if(e == null && user != null){
                    Toast.makeText(LoginActivity.this,"Login efetuado com sucesso!",Toast.LENGTH_LONG).show();
                    abrirAreaPrincipal();
                } else if (user == null) {

                    if(usuario.equals("") || senha.equals("")){
                        String erro  = "";

                        if(usuario.equals("")){
                            erro += parseErros.getErro(302);
                        }

                        if(senha.equals("")){
                            erro += " "+parseErros.getErro(303);
                        }

                        Toast.makeText(LoginActivity.this,erro,Toast.LENGTH_LONG).show();

                    }else{
                        Toast.makeText(LoginActivity.this,parseErros.getErro(300),Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(LoginActivity.this,parseErros.getErro(301),Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void abrirCadastroUsuario(View view){
        Intent intent = new Intent(LoginActivity.this,CadastroActivity.class);
        startActivity(intent);
    }

    private void verificarUsuarioLogado(){

        if(ParseUser.getCurrentUser().getUsername() != null){
            abrirAreaPrincipal();
        }
    }

    private void abrirAreaPrincipal(){
        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}
