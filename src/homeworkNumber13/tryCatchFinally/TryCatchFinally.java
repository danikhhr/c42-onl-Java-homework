package homeworkNumber13.tryCatchFinally;

public class TryCatchFinally {
    public TryCatchFinally() {
    }

    public void realization() {
        try {
            System.out.println("блок finally не вызывается");
            System.exit(0);
        } catch (Exception e) {
        } finally {
            System.out.println("Это условие должно выполниться");
        }
    }
}
