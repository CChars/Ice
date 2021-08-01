package Demo.withReturnValue.client;

import Demo.withReturnValue.slice.getPrinterPrx;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.ObjectPrx;
import com.zeroc.Ice.Util;

import java.util.Scanner;

public class getValueClient {
    public static void main(String[] args) {
        Communicator communicator = null;

//        communicator = Util.initialize(args);
        communicator = Util.initialize();

        System.out.println("---client---start");

        ObjectPrx proxy  = communicator.stringToProxy("aaaaaa:default -p 1000");

        getPrinterPrx getPrinterPrx = Demo.withReturnValue.slice.getPrinterPrx.checkedCast(proxy);
        //代理調用方法
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            String printString = getPrinterPrx.getPrintString(s);
            System.out.println("返回的值：" + printString);
            System.out.println();
        }

        communicator.destroy();

        System.out.println("client destory");
    }
}
