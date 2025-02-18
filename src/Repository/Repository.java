package Repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * A generic repository class that stores and manages a list of items.
 * It provides methods for adding, deleting, updating, finding, and retrieving items based on specific conditions.
 *
 * @param <T> The type of the items stored in the repository.
 */
public class Repository<T> {
    private ArrayList<T> items;

    /**
     * Constructor that initializes the repository with an empty list of items.
     */
    public Repository() {
        this.items = new ArrayList<>();
    }
    /**
     * Adds a new item to the repository.
     *
     * @param item The item to be added to the repository.
     */
    public void addItem(T item) {
        items.add(item);
    }
    /**
     * Deletes an item from the repository that matches the specified condition.
     *
     * @param condition The condition that the item must match to be deleted.
     * @return {@code true} if an item was removed, {@code false} otherwise.
     */
    public boolean deleteItem(Predicate<T> condition) {
        return items.removeIf(condition);
    }
    /**
     * Finds the first item in the repository that matches the specified condition.
     *
     * @param condition The condition that the item must match.
     * @return An {@link Optional} containing the found item, or an empty {@link Optional} if no item matches the condition.
     */
    public Optional<T> findItem(Predicate<T> condition) {
        return items.stream().filter(condition).findFirst();
    }
    /**
     * Returns all items currently stored in the repository.
     *
     * @return A list containing all the items in the repository.
     */
    public ArrayList<T> getAllItems() {
        return items;
    }

    /**
     * Updates the first item that matches the specified condition with the provided new item.
     *
     * @param condition The condition that the item must match to be updated.
     * @param newItem The new item that will replace the matched item.
     * @return {@code true} if the item was updated, {@code false} otherwise.
     */
    public boolean updateItem(Predicate<T> condition, T newItem) {
        for (int i = 0; i < items.size(); i++) {
            if (condition.test(items.get(i))) {
                items.set(i, newItem);
                return true;
            }
        }
        return false;
    }
}

