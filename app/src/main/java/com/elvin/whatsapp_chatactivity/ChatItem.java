package com.elvin.whatsapp_chatactivity;

public class ChatItem {
    private String icon;
    private String name;
    private String title;

    public ChatItem(String icon, String name, String title) {
        this.icon = icon;
        this.name = name;
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
