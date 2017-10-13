

package app;

import java.text.DateFormat;

public class DatePick {
    //https://stackoverflow.com/questions/30235183/how-do-we-disable-editing-options-on-jdatechooser
    public static void dcSetReadOnly(com.toedter.calendar.JDateChooser chooser){
        com.toedter.calendar.JTextFieldDateEditor editor = (com.toedter.calendar.JTextFieldDateEditor) chooser.getDateEditor();
        editor.setEditable(false);
    }
    
    //https://stackoverflow.com/questions/21012751/get-jdatechooser-date-to-jlabel
    public static String dcGetDate(com.toedter.calendar.JDateChooser chooser){
        java.util.Date date = chooser.getDate();
        return DateFormat.getDateInstance().format(date);
    }
}
