package com.elvin.whatsapp_chatactivity.Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elvin.whatsapp_chatactivity.ChatActivity;
import com.elvin.whatsapp_chatactivity.ChatItem;
import com.elvin.whatsapp_chatactivity.R;
import com.elvin.whatsapp_chatactivity.TabActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatRecycelrAdapter extends RecyclerView.Adapter<ChatRecycelrAdapter.ChatViewHolder> {
    private List<ChatItem> items;
    private Context context;


    public ChatRecycelrAdapter(List<ChatItem> items, Context context) {
        this.items = items;
        this.context = context;
    }
    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View rootView = inflater.inflate(R.layout.item_chats, viewGroup, false);
        return new ChatViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder chatViewHolder, int i) {
        final ChatItem item = items.get(i);
        chatViewHolder.name.setText(item.getName());
        chatViewHolder.title.setText(item.getTitle());
        chatViewHolder.icon.setBackgroundResource(R.drawable.untitled);
        chatViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context,ChatActivity.class);
                intent.putExtra("Name",item.getName());
                intent.putExtra("Title",item.getTitle());
                intent.putExtra("Icon",item.getIcon());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        if (items == null)
            return 0;
        return items.size();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private CircleImageView icon;
        private TextView title;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView_person_name);
            icon = itemView.findViewById(R.id.icon_person_image);
            title=itemView.findViewById(R.id.textView_person_text);
        }
    }
}
