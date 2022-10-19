package com.hillel.javapro;

public class FileData implements Comparable<FileData> {

  private final String path;
  private final String name;
  private final Long size;

  public FileData(String path, String name, Long size) {
    this.path = path;
    this.name = name;
    this.size = size;
  }

  public String getPath() {
    return path;
  }

  public Long getSize() {
    return size;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public int compareTo(FileData o) {
    return (int) (size - o.size);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    FileData fileData = (FileData) o;

    if (path != null ? !path.equals(fileData.path) : fileData.path != null) {
      return false;
    }
    if (name != null ? !name.equals(fileData.name) : fileData.name != null) {
      return false;
    }
    return size != null ? size.equals(fileData.size) : fileData.size == null;
  }

  @Override
  public int hashCode() {
    int result = path != null ? path.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (size != null ? size.hashCode() : 0);
    return result;
  }
}
