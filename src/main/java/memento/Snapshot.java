package memento;

import java.io.File;
import java.util.LinkedList;
import java.util.List;


/**
 * Memento
 */
class Snapshot {

    private final Repository repository;

    /**
     * State
     */
    private final List<File> files = new LinkedList<File>();

    Snapshot(Repository repository) {
        this.repository = repository;
        this.files.addAll(repository.getFiles());
    }

    void revert(){
        this.repository.setFiles(files);
    }
}
