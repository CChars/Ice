package Demo.withReturnValue.service;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;

public class getValueService {

    public static void main(String[] args) {
        Communicator communicator = null;

//        communicator = Util.initialize(args);
        communicator = Util.initialize();
        ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("getSimplePrinterAdapter", "default -p 1000");

        getPrinterImp printerImp = new getPrinterImp();

        adapter.add(printerImp,communicator.stringToIdentity("aaaaaa"));

        adapter.activate();
        System.out.println("========================server start=======================");
        communicator.waitForShutdown();
    }
}
