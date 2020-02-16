package memento;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Originator
 */
public class Repository {

    private String name;

    private List<File> files;

    public Repository(String name) {
        this.files = new LinkedList<File>();
        this.name = name;
    }

    public void add(File file){
        this.files.add(file);
    }

    Snapshot commit(){
        return new Snapshot(this);
    }

    public String getName() {
        return name;
    }

    public List<File> getFiles() {
        return files;
    }

    void setFiles(List<File> files) {
        this.files = files;
    }
}
