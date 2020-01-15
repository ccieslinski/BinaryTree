import java.util.ArrayList;
import java.util.Random;

class Generator {
    ArrayList<Integer> CreateList(int k) {

        ArrayList<Integer> list = new ArrayList<>();

        while (list.size() < k) {
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(k * 2) + 1;
            if (list.contains(randomInt))
                continue;
            else
                list.add(randomInt);
        }
        return (list);
    } //generates list of k integers
}
