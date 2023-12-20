public interface SortStrategy {
    void sort(int[] numbers);
}

public class BubbleSort implements SortStrategy {
    public void sort(int[] numbers) {
        int n = numbers.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (numbers[j] > numbers[j+1]) {
                    // Hoán đổi numbers[j+1] và numbers[i]
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
    }
}

public class SelectionSort implements SortStrategy {
    public void sort(int[] numbers) {
        int n = numbers.length;
        for (int i = 0; i < n-1; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (numbers[j] < numbers[min]) {
                    min = j;
                }
            }
            int temp = numbers[min];
            numbers[min] = numbers[i];
            numbers[i] = temp;
        }
    }
}

public class NumberSorter {
    private SortStrategy strategy;

    public NumberSorter(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] numbers) {
        strategy.sort(numbers);
    }
}

public class Main {
    public static void main(String[] args) {
        int[] array = {4, 2, 3, 1, 5};

        NumberSorter sorter = new NumberSorter(new BubbleSort());
        sorter.sort(array);

        sorter = new NumberSorter(new SelectionSort());
        sorter.sort(array);
    }
}

