import java.util.ArrayList;
public class SearchName {
       
    public ArrayList<Data> search(ArrayList<Data> name, String huruf) 
    {
        ArrayList<Data> newData = new ArrayList<>();
        for(Data a : name)
            if(a.getName().contains(huruf))
                newData.add(a);
        return newData;
    }
}
