package Monitor;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Window.Frame;

public class MonitorPanel extends JPanel {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Frame frame = new Frame("Monitor",192*2+40,128*2+40);
	
	public JTable qTable,oTable;
	public JLabel queueLabel,supportedLabel;
	private Object queuecolumnNames[] = {"Number","Type"};
	private Object supportedcolumnNames[] = {"Number","Type"};
	public DefaultTableModel tableModel = new DefaultTableModel(null,queuecolumnNames);
	public DefaultTableModel tableModel1 = new DefaultTableModel(null,supportedcolumnNames);
	
	public MonitorPanel() {
		this.setLayout(null);
		this.setBounds(0, 0, frame.width, frame.height);

		JLabel wlabel = new JLabel("Waiting");
		wlabel.setBounds(10, 3, frame.width/2 - 20,20);
		this.add(wlabel);
		
		qTable = new JTable(tableModel);
		qTable.setBounds(10, 20, frame.width/2 - 20,frame.height-64);
		this.add(qTable);
		
		JScrollPane scrollPane= new JScrollPane(qTable);
		scrollPane.setBounds(10, 20, frame.width/2 - 20,frame.height-64);
		this.add(scrollPane);

		JLabel slabel = new JLabel("Served");
		slabel.setBounds(frame.width/2 + 10, 3, frame.width/2 - 40,20);
		this.add(slabel);
		
		oTable = new JTable(tableModel1);
		oTable.setBounds(frame.width/2 + 10, 20, frame.width/2 - 40, frame.height-64);
		this.add(oTable);
		
		JScrollPane scrollPane1= new JScrollPane(oTable);
		scrollPane1.setBounds(frame.width/2 + 10, 20, frame.width/2 - 40, frame.height-64);
		this.add(scrollPane1);

		this.setVisible(true);
		frame.add(this);
	}
}
