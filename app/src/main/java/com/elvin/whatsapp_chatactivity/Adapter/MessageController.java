package com.elvin.whatsapp_chatactivity.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elvin.whatsapp_chatactivity.Message;
import com.elvin.whatsapp_chatactivity.R;

import java.util.ArrayList;

public class MessageController extends RecyclerView.Adapter<MessageController.MessageView> {
    private ArrayList<Message> messages;
    private Context context;

    public MessageController(ArrayList<Message> messages, Context context) {
        this.messages = messages;
        this.context = context;
    }

    @NonNull
    @Override
    public MessageController.MessageView onCreateViewHolder(@NonNull ViewGroup viewGroup, int resource) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(resource,viewGroup,false);
        return new MessageView(view);
    }

    @Override
    public int getItemViewType(int position) {
        Message message = messages.get(position);
        if (message.isFromMe())
            return R.layout.right_chats;
        else
            return R.layout.left_chats;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageController.MessageView messageView, int position) {
        Message message = messages.get(position);
        messageView.messageText.setText(message.getText());
        messageView.dateText.setText(message.getFormattedDate());
    }

    @Override
    public int getItemCount() {
        if (messages==null)
            return 0;

        return messages.size();
    }

    public class MessageView extends RecyclerView.ViewHolder{
        TextView messageText;
        TextView dateText;
        public MessageView(@NonNull View itemView) {
            super(itemView);
            dateText = itemView.findViewById(R.id.textview_time);
            messageText = itemView.findViewById(R.id.textview_message);
        }
    }
}

