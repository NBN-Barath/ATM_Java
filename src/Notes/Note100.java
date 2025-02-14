package Notes;

import Note.Notes;

// Concrete class for 100-value notes, extending abstract Notes class
public class Note100 extends Notes {
    public Note100(int noteCount) { // Constructor initializes count with a fixed value of 100
        super(noteCount, 100);
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
//        return  super.clone();
//    }
}