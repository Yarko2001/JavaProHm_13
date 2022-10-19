package com.hillel.javapro;

public class Main {

  public static void main(String[] args) {

    FileNavigator fileNavigator = new FileNavigator();
    fileNavigator.add(new FileData("/resources", "file211.txt", 155L));
    fileNavigator.add(new FileData("/resources", "file222.txt", 120L));
    fileNavigator.add(new FileData("/resources/new", "newFile_1.txt", 110L));
    fileNavigator.add(new FileData("/resources", "file333.txt", 300L));
    fileNavigator.add(new FileData("/resources/new", "newFile_2.txt", 130L));

    System.out.println("Find: " + fileNavigator.find("/resources"));
    System.out.println("Find: " + fileNavigator.find("/resources/new_resources"));

    System.out.println("Filter by size: " + fileNavigator.filterBySize(160L));

    System.out.println("Sort by size: " + fileNavigator.sortBySize());

    System.out.println("Remove: " + fileNavigator.remove("/resources/new_resources"));

  }

}
