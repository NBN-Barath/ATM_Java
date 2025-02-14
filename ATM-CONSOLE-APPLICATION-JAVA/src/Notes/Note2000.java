package Notes;

import Note.Notes;

// Concrete class for 2000-value notes
public class Note2000 extends Notes {
    public Note2000(int noteCount) {
        super(noteCount, 2000); // Constructor with fixed note value of 2000
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
