package Demo.hello.service;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;

public class PrinterService {
    public static void main(String[] args) {

        Communicator communicator = null;

        communicator = Util.initialize(args);
        ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("SimplePrinterAdapter", "default -p 1000");

        PrinterImp printerImp = new PrinterImp();

        adapter.add(printerImp,communicator.stringToIdentity("SimplePrinter"));

        adapter.activate();
        System.out.println("========================server start=======================");
        communicator.waitForShutdown();

    }
}
