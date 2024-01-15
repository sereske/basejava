/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int size = size();
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        if (r != null && r.uuid != null) {
            storage[size()] = r;
        }
    }

    Resume get(String uuid) {
        for (Resume r : getAll()) {
            if (uuid.equals(r.uuid)) {
                return r;
            }
        }
        return null;
    }

    void delete(String uuid) {
        int size = size();
        for (int i = 0; i < size; i++) {
            if (storage[i] != null && uuid.equals(storage[i].uuid)) {
                for (int j = i; j < size - 1; j++) {
                    storage[j] = storage[j + 1];
                }
                storage[size - 1] = null;
                size -= 1;
                i -= 1;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] notNullStorage = new Resume[size()];
        for (int i = 0; i < size(); i++) {
            notNullStorage[i] = storage[i];
        }
        return notNullStorage;
    }

    int size() {
        int i = 0;
        for (Resume r : storage) {
            if (r != null) {
                i++;
            }
        }
        return i;
    }
}
