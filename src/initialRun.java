import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class initialRun {
    initialRun(DefaultTableModel model, ArrayList<Data> datas)
    {
        for(int i = 0 ; i < datas.size() ; i++)
        {
            Data temp = datas.get(i);
            model.addRow(new Object[]{temp.getName(), temp.getQuan()});
        }
    }
}
