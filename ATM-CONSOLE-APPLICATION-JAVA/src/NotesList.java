import Note.Notes;
import java.util.ArrayList;
import java.util.List;

public class NotesList<N extends Notes> {

    private List<N> noteList = new ArrayList<>(); // Using ArrayList

    public List<N> getAllNoteList() {// method to get all notes
        return noteList;
    }

//    public N getSingleNote(int index) {
//        if (index >= 0 && index < noteList.size()) {
//            return noteList.get(index);
//        }
//        return null; // Handle invalid index
//    }

    public void add(N note) { // method to add notes
        if (note != null) {
            noteList.add(note);
        } else {
            System.out.println("Error: Cannot add a null note.");
        }
    }
}
