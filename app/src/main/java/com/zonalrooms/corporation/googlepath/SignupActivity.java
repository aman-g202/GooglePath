package com.zonalrooms.corporation.googlepath;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.zonalrooms.corporation.googlepath.pojo.Result;
import com.zonalrooms.corporation.googlepath.rest.ApiClient;
import com.zonalrooms.corporation.googlepath.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by DELL on 3/28/2017.
 */

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    EditText name,mobile,gender,address;
    Button signup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        name = (EditText)findViewById(R.id.editTextname);
        mobile = (EditText)findViewById(R.id.editTextmobile);
        gender = (EditText)findViewById(R.id.editTextgender);
        address = (EditText)findViewById(R.id.editTextaddress);
        signup = (Button)findViewById(R.id.finalsignupbutton);
        signup.setOnClickListener(this);

    }

    public void signup(){
        ApiInterface apiservice = ApiClient.getClient().create(ApiInterface.class);
        Call<Result> call = apiservice.updateUser(new PutDetails(name.getText().toString(),mobile.getText().toString(),gender.getText().toString(),address.getText().toString()));
       call.enqueue(new Callback<Result>() {
           @Override
           public void onResponse(Call<Result> call, Response<Result> response) {
               int statuscode = response.code();
               String get = response.body().getResult();
               Toast.makeText(SignupActivity.this,get,Toast.LENGTH_LONG).show();
           }

           @Override
           public void onFailure(Call<Result> call, Throwable t) {
                Log.e("Failed",t.toString());
           }
       });

    }

    @Override
    public void onClick(View v) {
        if(v == signup){
            signup();
        }
    }
    public static class PutDetails{

        String name,mobileno,gender,address;
        PutDetails(String name,String mobileno,String gender,String address){
            this.name = name;
            this.mobileno = mobileno;
            this.gender = gender;
            this.address = address;cm
        }

    }

}
