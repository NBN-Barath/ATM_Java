package Note;

public abstract class Notes implements Cloneable {
    protected int noteCount; // Stores the count of a particular note denomination
    protected int noteValue; // Stores the monetary value of the note denomination

    protected Notes(int noteCount, int noteValue) { // Constructor to initialize note details
        this.noteCount = noteCount;
        this.noteValue = noteValue;
    }

    public int getNoteCount() {
        return noteCount;
    }
    public int getNoteValue() {
        return noteValue;
    }
    public void setNoteCount(int noteCount) {
        this.noteCount = noteCount;
    }



    public Notes clone() throws CloneNotSupportedException {
        return (Notes) super.clone();  // Uses the default clone() from Object
   }
}