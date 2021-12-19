package com.company;

public interface ICommand {
    String getName();
    String getDescription();
    String execute(String c);
}

