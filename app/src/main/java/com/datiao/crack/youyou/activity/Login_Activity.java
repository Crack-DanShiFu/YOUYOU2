package com.datiao.crack.youyou.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.datiao.crack.youyou.R;
import com.datiao.crack.youyou.model.User;
import com.datiao.crack.youyou.server.AccountServer;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class Login_Activity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private User loginUser;
    private TextView createBtn;
    private EditText accountName;
    private EditText accountPwd;
    private Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Logger.addLogAdapter(new AndroidLogAdapter());
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        sharedPreferences= getSharedPreferences("Login",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putBoolean("isLogin",false);
        editor.commit();
        setContentView(R.layout.login_layout);
        init();
        addListening();
    }
    private void init(){
        createBtn = findViewById(R.id.create_or);
        accountName =findViewById(R.id.loginUserNameText);
        accountPwd = findViewById(R.id.loginPasswdText);
        submitBtn = findViewById(R.id.loginSubmitBtn);
    }
    private void addListening(){
        createBtn.setOnClickListener(new CreateBtnOnClickListener());
        submitBtn.setOnClickListener(new SubmitBtnOnClickListener());
    }
    private class SubmitBtnOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String accountNameString =accountName.getText().toString();
            String accountPwdString =accountPwd.getText().toString();
            if(!(accountNameString.equals("")||accountPwdString.equals(""))){
                loginUser =new User();
                loginUser.setUserAccount(accountNameString);
                loginUser.setUserAccountPwd(accountPwdString);

                Logger.d(loginUser.getUserAccount());
                AccountServer accountServer =new AccountServer();
                Boolean result = accountServer.loginvalidation(loginUser);
                Logger.d(result);
                if(result){
                    Toast.makeText(Login_Activity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor =sharedPreferences.edit();
                    editor.putBoolean("isLogin",true);
                    editor.commit();
                    Intent intent = new Intent(Login_Activity.this,
                            MainPage_Activity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(Login_Activity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                }
            }else {
                if(accountPwdString.equals("")&&accountNameString.equals("")){
                    Toast.makeText(Login_Activity.this, "请输入账号和密码", Toast.LENGTH_SHORT).show();
                }else if (accountPwdString.equals("")){
                    Toast.makeText(Login_Activity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Login_Activity.this, "请输入账号", Toast.LENGTH_SHORT).show();
                }

            }

        }
    }
    private class CreateBtnOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Login_Activity.this,
                    Register_Activity.class);
            startActivity(intent);
        }
    }
}



