package Project.application.user;

import Item.Item;

public class Users implements Observer {

    private String name;

    // EFFECTS: constructs an email subscriber with name
    public Users(String name){
        this.name = name;
    }

    public String getName(){ return name; }

    public void update(Item item){
        System.out.println("TO: " + getName() + ": A new item is updated to the public calendar!! \n"
        + "Item is: " + item.getItemStr() +"\n");
    }
}
