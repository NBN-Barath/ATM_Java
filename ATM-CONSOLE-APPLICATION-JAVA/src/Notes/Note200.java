package Notes;

import Note.Notes;

// Concrete class for 200-value notes
public class Note200 extends Notes {
    public Note200(int noteCount) {
        super(noteCount, 200); // Constructor with fixed note value of 200
    }

    @Override
    public int getNoteCount() {
        return noteCount;
    }

    @Override
    public void setNoteCount(int noteCount) {
        this.noteCount = noteCount;
    }

    @Override
    public int getNoteValue() {
        return noteValue;
    }

//    @Override
//    public Notes clone() throws CloneNotSupportedException {
//        return (Notes) super.clone();
//    }
}