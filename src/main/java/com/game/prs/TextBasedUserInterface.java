package com.game.prs;

import java.util.Scanner;

public class TextBasedUserInterface {
  private final Scanner scanner = new Scanner(System.in);

  public void display(String string) {
    display(string, true);
  }

  public void display(String string, boolean newLine) {
    if (newLine) {
      System.out.println(string);
    } else {
      System.out.print(string);
    }
  }

  public void displayEmptyLine() {
    System.out.println();
  }

  public String readUserInput() {
    return scanner.next();
  }
}

