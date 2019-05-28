import java.text.MessageFormat;
import java.util.Date;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author zhwanwan
 * @create 2019-05-28 11:04 AM
 */
public class MyMess_zh_CN extends ListResourceBundle {

    //定义静态资源
    private final Object[][] myData = {
            {"msg","{0} 你好!今天的日期是{1}"}
    } ;

    @Override
    protected Object[][] getContents() {
        return myData;
    }

    public static void main(String[] args) {
        //系统默认Locale
        Locale currentLocale = Locale.getDefault(Locale.Category.FORMAT);
        ResourceBundle bundle = ResourceBundle.getBundle("MyMess",Locale.getDefault());
        String msg = bundle.getString("msg");
        String message = MessageFormat.format(msg, "Java", new Date());
        System.out.println(message);

        System.out.println(Locale.getDefault().getCountry());
    }
}
