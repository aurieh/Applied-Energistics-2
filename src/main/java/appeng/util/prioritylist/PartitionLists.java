package appeng.util.prioritylist;

import appeng.api.config.FuzzyMode;
import appeng.api.storage.data.IAEStack;
import appeng.api.storage.data.IItemList;

public final class PartitionLists {

    // Suppresses default constructor, ensuring non-instantiability.
    private PartitionLists() {
    }

    private static final IPartitionList<?> EMPTY_LIST = new DefaultPriorityList<>();

    public static <T extends IAEStack<T>> IPartitionList<T> empty() {
        //noinspection unchecked
        return (IPartitionList<T>) EMPTY_LIST;
    }

    public static <T extends IAEStack<T>> IPartitionList<T> partitionListOf(IItemList<T> list, boolean isFuzzy, FuzzyMode mode) {
        if (list.isEmpty()) {
            return empty();
        }
        if (isFuzzy) {
            return new FuzzyPriorityList<>(list, mode, false);
        }
        return new PrecisePriorityList<>(list, false);
    }
}
