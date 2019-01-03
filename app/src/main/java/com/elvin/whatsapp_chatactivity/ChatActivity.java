package com.elvin.whatsapp_chatactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.elvin.whatsapp_chatactivity.Adapter.MessageController;

import java.util.ArrayList;
import java.util.Date;

public class ChatActivity extends AppCompatActivity {
    private EditText editText;
    private RecyclerView recyclerView;
    private ArrayList<Message> messages;
    private MessageController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        messages = new ArrayList<>();
        editText = findViewById(R.id.edittext_input);
        recyclerView = findViewById(R.id.recycler);

        controller = new MessageController(messages,this);
        recyclerView.setAdapter(controller);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageButton sendButton = findViewById(R.id.button_send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendButton();
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_chat);
        setSupportActionBar(toolbar);


        Intent intent=getIntent();
        String name =intent.getStringExtra("Name");
        String title=intent.getStringExtra("Title");
        String icon=intent.getStringExtra("Icon");

        TextView textView=findViewById(R.id.textView_chat);
        ImageView imageView=findViewById(R.id.image_circle);
    }

    private void sendButton() {
        String message = editText.getText().toString();

        if (message.isEmpty()) {
            Toast.makeText(this, "Get oyanda oyna", Toast.LENGTH_SHORT).show();
            return;
        }
        Message msg = new Message(message,new Date(),true);
        messages.add(msg);
        controller.notifyDataSetChanged();
    }

}
