package Note;

// Abstract class Notes, serves as a base for different note denominations
public abstract class Notes implements Cloneable {
    protected int noteCount; // Stores the count of a particular note denomination
    protected int noteValue; // Stores the monetary value of the note denomination

    protected Notes(int noteCount, int noteValue) { // Constructor to initialize note details
        this.noteCount = noteCount;
        this.noteValue = noteValue;
    }

    // Abstract methods to be implemented by subclasses
    public abstract int getNoteCount();
    public abstract void setNoteCount(int noteCount);
    public abstract int getNoteValue();

   public Notes clone() throws CloneNotSupportedException {
        return (Notes) super.clone();  // Uses the default clone() from Object
   }
}