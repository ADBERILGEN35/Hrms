package kodlamaio.Hrms.core.utilities.results;

public class WarningDataResult<T> extends DataResult<T> {
    public WarningDataResult(T data, String message) {
        super(data, false, message);
    }

    public WarningDataResult(T data) {
        super(data, false);
    }

    public WarningDataResult(String message) {
        super(null, false, message);
    }

    public WarningDataResult() {
        super(null, false);
    }
}