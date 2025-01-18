package Note;

public class Notes implements Cloneable {
    protected int noteCount; // to store the count of a note
    protected int noteValue; // to store the value of the note

    protected Notes(int noteCount, int noteValue) { // constructor
        this.noteCount = noteCount;
        this.noteValue = noteValue;
    }

// getter and setter
    public int getNoteCount() {
        return noteCount;
    }

    public void setNoteCount(int noteCount) {
        this.noteCount = noteCount;
    }

    public int getNoteValue() {
        return noteValue;
    }

    public Notes clone() throws CloneNotSupportedException {
        return (Notes) super.clone();
    }

}
