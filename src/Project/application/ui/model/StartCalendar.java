package Project.application.ui.model;


import Item.*;
import exception.notValidException;
import exception.outBoundException;
import exception.tooLongException;
import exception.useCommaException;
import function.FileWrite;
import user.Observer;
import user.Users;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class StartCalendar {
    private ItemManager itemManager;
    private Scanner input = new Scanner(System.in);
    private String name;
    private ListOfItems listOfItems = new ListOfItems();
    private Item item;
    private String file = "outputItems.txt";
    private FileWrite fileWrite = new FileWrite();
    private String detail;
    private Observer jessica = new Users("Jessica");
    private Observer kyle = new Users("Kyle");
    private Observer sunny = new Users("Sunny");

    public StartCalendar(String name) throws IOException {
        this.name = name;
        itemManager = new ItemManager();

        itemManager.addObserver(jessica);
        itemManager.addObserver(kyle);
        itemManager.addObserver(sunny);
    }


    private void start() throws IOException {
        fileWrite.load(file, itemManager);
        String option = "";
        boolean running = true;
        while (running) {
            System.out.println("Please select options: add, delete, browse, edit or Press q to finish it");
            option = input.nextLine();
            System.out.println("You selected: " + option);
            if (option.equals("add")) {
                boolean running1 = true;
                while(running1) {
                    try {
                        addItem();
                        running1 = false;
                    } catch (notValidException e) {
                        System.out.println("you either used comm or input too long try it again!");
                    }
                     catch (NumberFormatException a) {
                         System.out.println("You didn't put a number! " );
                    }
                }
            } else if (option.equals("browse")) {
                browseItem();
            } else if (option.equals("delete")) {
                deleteItem();
            } else if (option.equals("edit")) {
                editItem();
            } else if (option.equals("q")) {
                fileWrite.saveItemMap(itemManager,file);
                running = false;
            }
        }
        System.out.println("Bye Jessica!");
    }

    private void addItem() throws IOException, useCommaException, tooLongException {
        String index = "";
        boolean running = true;
        while (running) {
            System.out.println("Choose number what you want to do!");
            System.out.println("1. Make a new list");
            System.out.println("2. Add item in the current list");
            System.out.println("3. Go back to the menu");
            index = input.nextLine();

            if (index.equals("3")) {
                running = false;
            }
            else if(index.equals("1")){
                System.out.println("You select to make a new list");
                System.out.println("Please enter the tittle of the new list");
                //TODO: throw exception if the tittle is already exist
                String tittle = input.nextLine();
                itemManager.addKey(tittle);
                System.out.println("Okay, now let's add item to the list : " + tittle);
                if (makeNewItem(tittle)) return;

            }

            else if(index.equals("2")){
                System.out.println("Please select the list");
                itemManager.browseKey();
                String key = input.nextLine();
                System.out.println("You selected: " + key);
                if (makeNewItem(key)) return;
            }
        }
    }

    private boolean makeNewItem(String key) throws useCommaException, tooLongException, IOException {
        System.out.println("Please enter the detail");
        detail = input.nextLine();
        if (detail.contains(",")) {
            throw new useCommaException();
        }
        if (detail.length() > 100){
            throw new tooLongException();
        }
        System.out.println("please enter the deadline: yyyy enter 0000 if there is no deadline");
        String year = input.nextLine();
        String formatted;
        if(!year.equals("0000")) {
            System.out.println("please enter the deadline: Month");
            String month = input.nextLine();
            System.out.println("please enter the deadline: Day");
            String day = input.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
            Calendar date = Calendar.getInstance();
            date.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day));
            formatted = sdf.format(date.getTime());
        }
        else{
            formatted = "NO DUE DATE";
        }
        System.out.println("Is it important? enter yes or no");
        String importance = input.nextLine();
        if (year.equals("0000")) {
            item = new ItemWithoutDueDate(key, detail, "NO DUE DATE", importance);
        } else {
            item = new ItemWithDueDate(key, detail, formatted, importance);
        }

        System.out.println("Tittle: " + key + " Detail: " + detail + " Due date: " + formatted + " Important? " + importance);

        System.out.println("do you want to store it?");
        String yesOrNo = input.nextLine();
        if (yesOrNo.equals("yes")) {
            itemManager.addItem(key,item);
        } else if (yesOrNo.equals("no")) {
            System.out.println("Okay, go back to the menu !! ");
            return true;
        }
        return false;
    }


    private void browseItem() throws IOException {
        System.out.println(
                "Press 1 if you want to browse all items in the Calendar \n" +
                        "Press 2 if you want to browse a specific tittle\n" +
                        "Press 3 if you want to browse only important items");
        Integer option = input.nextInt();
        input.nextLine() ;
        if (option == 1) {
            System.out.println("Here is all items");
            itemManager.broseAllItem();
        } else if (option == 2) {
            System.out.println("Which tittle?");
            itemManager.browseKey();
            String tittle = input.nextLine();
            System.out.println("Here is items regards" + tittle);
            itemManager.browseItembyKey(tittle);
        } else if (option == 3) {
            System.out.println("Here is important items");
            itemManager.browseImportantItem();
        }
    }

    private void deleteItem() throws IOException {
        System.out.println("Please enter the tittle");
        itemManager.browseKey();
        String tittle = input.nextLine();
        itemManager.browseItembyKey(tittle);
        System.out.println("Which items you want to delete it? enter the number");
        boolean running = true;
        while (running){
            Integer number = input.nextInt();
            input.nextLine();
            try {
                //Item delteItem = listOfItems.getValue(tittle).get(number);
                //listOfItems.deleteImportantItem(delteItem);
                itemManager.deleteItem(tittle,number);
                running = false;
            } catch (outBoundException e) {
                System.out.println("You put the invalid number!!, Enter it again! ");
            }
            finally {
                System.out.println("FINALLYYYY IS HEREEEEE");
            }
        }
    }


    private void editItem() throws IOException {
        System.out.println("Please select the tittle you want to edit");
        String course = input.nextLine();
        listOfItems.printItemByCourse(course);
        System.out.println("Please select the number you want to edit");
        Integer number = input.nextInt();
        input.nextLine();
        //System.out.println("You select" + );
        System.out.println("What do you want to edit? 1)Due date");
        Integer option = input.nextInt();
        input.nextLine();
        if (option == 1) {
            System.out.println("please enter the deadline: yyyy enter 0000 if there is no deadline");
            String year = input.nextLine();
            System.out.println("please enter the deadline: Month enter no if there is no deadline");
            String month = input.nextLine();
            System.out.println("please enter the deadline: Day enter no if there is no deadline");
            String day = input.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
            Calendar date = Calendar.getInstance();
            date.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
            String formatted = sdf.format(date.getTime());
            listOfItems.getItem(course, number).editDueDate(formatted);
            System.out.println("Okay! Deleted it!!");
        }
        else {
            System.out.println("I haven't built it");
        }
    }

    public static void main(String[] args) throws IOException {
        StartCalendar startCalendar = new StartCalendar("Jessica");
        System.out.println("Jessica's 2018 WT1 Calendar!");
        startCalendar.start();
    }
}

