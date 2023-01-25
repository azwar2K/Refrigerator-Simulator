import java.util.ArrayList;
public class SortingQuantity{
public  SortingQuantity(ArrayList<Data> quantity) {
    for (int i = 0; i < quantity.size() - 1; i++) {
        for (int j = 0; j < quantity.size() - 1 - i; j++) {
                Data a = quantity.get(j);
                Data b = quantity.get(j+1);
            if (a.getQuan() > b.getQuan()) {
                quantity.set(j,b);
                quantity.set(j+1,a);
            }
        }
        }
    }

    
}
