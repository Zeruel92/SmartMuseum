package smartmuseumtable;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TableListener implements ListSelectionListener{
    private Museo m;
    private JTable tab;
    public TableListener(Museo m, JTable tab){
        this.m=m;
        this.tab=tab;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
     String selezione= tab.getValueAt(tab.getSelectedRow(), 0).toString();
        JOptionPane.showMessageDialog(null,selezione);
    }
    
}
