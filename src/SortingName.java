import java.util.ArrayList;
public class SortingName {
    public SortingName(ArrayList<Data> name) {
        for (int i = 0; i < name.size() - 1; i++) {
            for (int j = 0; j < name.size() - 1-i; j++) {
                Data a = (Data)name.get(j);
                Data b = (Data)name.get(j+1);
                if (a.getName().compareTo(b.getName()) > 0) {
                    name.set(j,b);
                    name.set(j+1,a);
                }
            }
        }
    }

    
}
