package memento;


/**
 * Caretaker
 */
public class Scm {

    private Snapshot snapshot;

    public void commit(Repository repository){
        this.snapshot = repository.commit();
    }

    public void revert(){
        if(snapshot!=null){
            snapshot.revert();
        }
    }


}
