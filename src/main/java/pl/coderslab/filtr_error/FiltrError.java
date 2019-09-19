package pl.coderslab.filtr_error;



public class FiltrError {

    private String path;
    private String message;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FiltrError(String path, String message) {
        this.path = path;
        this.message = message;
    }

    public FiltrError() {
    }
}
