// import java.util.ArrayList;s
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class updater implements ActionListener{
    JTable table;
    DefaultTableModel model;
    String type;
    public updater(JTable table, DefaultTableModel model, String type)
    {
        this.table = table;
        this.model = model;
        this.type = type;
    }

    public void actionPerformed(ActionEvent e) {
        int rows = table.getSelectedRow();
        model.removeRow(rows);
        ArrayList<Data> data = new ArrayList<>();
        int rowsAvail = table.getRowCount();
        for(int i = 0 ; i < rowsAvail ; i++)
            data.add(new Data((String)model.getValueAt(i, 0), (int)model.getValueAt(i, 1)));
        dataHandler temp = new dataHandler(type);
        temp.setData(data);
        temp.UploadData();
    }
}
