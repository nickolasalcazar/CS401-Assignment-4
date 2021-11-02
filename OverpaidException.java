/**
 * Exception thrown for when a Payment overpays to an order.
 */
public class OverpaidException extends Exception {
	public OverpaidException(String message) { super(message); }
}