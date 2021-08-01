package Demo.hello.client;

import Demo.hello.slice.PrinterPrx;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.ObjectPrx;
import com.zeroc.Ice.Util;

import java.util.Scanner;

public class PrinterClient {
    public static void main(String[] args) {
        Communicator communicator = null;

        communicator = Util.initialize(args);

        System.out.println("---client---start");

        ObjectPrx proxy  = communicator.stringToProxy("SimplePrinter:default -p 1000");

        PrinterPrx printerPrx = PrinterPrx.checkedCast(proxy);
        //代理調用方法
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            printerPrx.printString(s);
        }


        communicator.destroy();

        System.out.println("client destory");

    }
}
