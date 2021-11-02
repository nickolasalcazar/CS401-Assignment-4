/**
 * Exception thrown for when an assigned Order ID already exists.
 */
public class DuplicateIdException extends Exception {
	public DuplicateIdException(String message) { super(message); }
}