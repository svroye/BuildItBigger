package com.example.jokelibrary;


import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import sun.rmi.runtime.Log;

public class MyJoke {

    public ArrayList<String> jokes = new ArrayList<>();
    private int counter;

    public MyJoke() {
        this.jokes.add("Why haven't you ever seen any elephants hiding up trees? " +
                "Because they're really, really good at it.");
        this.jokes.add("We have a strange custom in our office. The food has names there. Yesterday for example " +
                "I got me a sandwich out of the fridge and its name was \"Michael\".");
        this.jokes.add("Grandpa, why don't you have any life insurance?\n" +
                        "So you can all be really sad when I die.");
        this.jokes.add("Knock, knock.\n" +
                        "Who's there?\n" +
                        "The love of your life.\n" +
                        "Liar! Chocolate can't speak!");

    }


    public String getJoke(){
        int index = (int) (Math.random()*jokes.size());
        return jokes.get(index);
    }

}
