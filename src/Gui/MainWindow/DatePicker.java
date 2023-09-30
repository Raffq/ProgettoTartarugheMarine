package Gui.MainWindow;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class DatePicker  {

    public JDatePickerImpl Calendar() {
        UtilDateModel model = new UtilDateModel();
        Properties p  = new Properties();
        p.put("text.day", "Day");
        p.put("text.month", "Month");
        p.put("text.year", "Year");

        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, null);

        datePicker.getJFormattedTextField().setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        datePicker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected date from the model
                Date selectedDate = (Date) model.getValue();

                datePicker.getJFormattedTextField().setText(new SimpleDateFormat("yyyy-MM-dd").format(selectedDate));
            }
        });

        datePicker.setBounds(110, 100, 200, 25);
        datePicker.setVisible(true);

        return datePicker;
    }
}
