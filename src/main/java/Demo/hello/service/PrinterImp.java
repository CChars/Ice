package Demo.hello.service;

import Demo.hello.slice.Printer;
import com.zeroc.Ice.Current;

public class PrinterImp implements Printer {
    @Override
    public void printString(String s, Current current) {
        System.out.println(s);
    }
}
