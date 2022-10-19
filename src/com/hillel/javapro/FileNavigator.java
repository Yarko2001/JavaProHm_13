package com.hillel.javapro;

import java.awt.geom.IllegalPathStateException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileNavigator {

  private final String ROOT_DIRECTORY = "/resources";
  private final Map<String, List<FileData>> fileOfMap = new HashMap<>();

  public void add(FileData file) {

    if (file.getPath().indexOf(ROOT_DIRECTORY) != 0) {
      String message = "\nAdded new file directory [" + file.getPath() + "]"
          + " is not root directory! [" + ROOT_DIRECTORY + "]";
      throw new IllegalPathStateException(message);
    }

    fileOfMap.putIfAbsent(file.getPath(), new ArrayList<>());
    fileOfMap.get(file.getPath()).add(file);

  }

  public List<FileData> find(String path) {
    return fileOfMap.get(path);
  }

  public List<FileData> findAll() {

    List<FileData> files = new ArrayList<>();

    for (List<FileData> list : fileOfMap.values()) {
      files.addAll(list);
    }
    return files;

  }

  public List<FileData> filterBySize(Long size) {

    List<FileData> files = new ArrayList<>();

    for (FileData file : findAll()) {
      if (file.getSize() <= size) {
        files.add(file);
      }
    }
    return files;

  }

  public String remove(String path) {

    fileOfMap.remove(path);
    return path;

  }

  public List<FileData> sortBySize() {

    List<FileData> fileDataList = findAll();
    Collections.sort(fileDataList);

    return fileDataList;

  }


}
