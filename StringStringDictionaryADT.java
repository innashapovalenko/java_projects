/**
 * A dictionary that maps a string to a string.
 */
public interface StringStringDictionaryADT {
	
	/**
	 * If Dictionary does not have an entry for key, it adds entry <key,value>.
	 * Otherwise, it replaces the value in the entry for key with this new value.
	 */
	public void put(String key, String value);
	
	/**
	 * Returns the value associated with key, if such an entry exists.
	 * If key is not found in dictionary, then this returns null.
	 */
	public String get(String key);
	
	/**
	 * Removes from Dictionary the entry with the key and returns its value.
	 * If the key does not exist, then null is returned.
	 */
	public String remove(String key);
	
	/**
	 * Returns true if and only if key is in the Dictionary
	 */
	public boolean containsKey(String key);

}
