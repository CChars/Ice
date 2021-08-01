package Demo.withReturnValue.service;

import Demo.withReturnValue.slice.getPrinter;
import com.zeroc.Ice.Current;

public class getPrinterImp implements getPrinter {
    @Override
    public String getPrintString(String s, Current current) {
        System.out.println(s);
        return "====>這是收到的信息：" + s;
    }
}
