package cn.taofen8.exception;

public class DAOException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DAOException() {
		super();
	}

	public DAOException(String message) {
		super(message);
	}

    public DAOException(Exception e) {
        super(e);
    }
}
