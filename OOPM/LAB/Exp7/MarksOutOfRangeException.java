package Lab.Exp7;

public class MarksOutOfRangeException extends Exception 
{
    private static final long serialVersionUID = 1L;
    
    public MarksOutOfRangeException ()
    {
        super ("Marks are outside of the range 1-100, please enter correct marks");
    }
}

