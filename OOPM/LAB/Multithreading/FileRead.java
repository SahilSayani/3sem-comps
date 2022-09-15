public class FileRead {
    public static void main(String[] args) {
        PersonalDetails thread1 = new PersonalDetails();
        AcademicDetails thread2 = new AcademicDetails();
        thread1.start();
        thread2.start();
    }
}
