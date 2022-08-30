package Abstract;

public abstract class AId {
    protected String id;

    public String getId() {
        return id;
    }

    public boolean setId(String obj) {
            this.id = this.id + obj;
        return true;
    }
}
