package Notes;

import Note.Notes;

public class Note500 extends Notes {
    public Note500(int noteCount) {
        super(noteCount, 500); // Constructor with fixed note value of 500
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