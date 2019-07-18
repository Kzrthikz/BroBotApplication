package com.example.brobotapp;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.applozic.mobicommons.commons.core.utils.Utils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import io.kommunicate.KmChatBuilder;
import io.kommunicate.Kommunicate;
import io.kommunicate.callbacks.KmCallback;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String APP_ID = "3cb2ef8fe32b5a1e6ea390c04a81822";

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //view objects
    private TextView textViewUserEmail;
    private ImageView chatbot;
    private ImageView relaxationStrategies;
    private ImageView todo;
    private Button buttonLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if (firebaseAuth.getCurrentUser() == null) {
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views
        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        chatbot = (ImageView) findViewById(R.id.chatbot) ;
        relaxationStrategies = (ImageView) findViewById(R.id.relaxtionStrategies);
        todo = (ImageView) findViewById(R.id.todo);

        //displaying logged in user name
        textViewUserEmail.setText("Welcome " + user.getEmail());

        //adding listener to button
        buttonLogout.setOnClickListener(this);
        chatbot.setOnClickListener(this);
        relaxationStrategies.setOnClickListener(this);
        todo.setOnClickListener(this);
        Kommunicate.init(this, "3cb2ef8fe32b5a1e6ea390c04a81822");
    }

    @Override
    public void onClick(View view) {
        //if logout is pressed
        if (view == buttonLogout) {
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }
        if(view == chatbot) {
            new KmChatBuilder(this).launchChat(new KmCallback() {
                @Override
                public void onSuccess(Object message) {
                    Utils.printLog(ProfileActivity.this, "ChatTest", "Success : " + message);
                }

                @Override
                public void onFailure(Object error) {
                    Utils.printLog(ProfileActivity.this, "ChatTest", "Failure : " + error);
                }
            });
        }
        if(view == relaxationStrategies) {
            startActivity(new Intent(this, RelaxationActivity.class));
        }
        if(view == todo) {
            startActivity(new Intent(this, ToDoActivity.class));
        }

        /*new KmChatBuilder(this).launchChat(new KmCallback() {
            @Override
            public void onSuccess(Object message) {
                Utils.printLog(ProfileActivity.this, "ChatTest", "Success : " + message);
            }

            @Override
            public void onFailure(Object error) {
                Utils.printLog(ProfileActivity.this, "ChatTest", "Failure : " + error);
            }
        });*/
    }


}