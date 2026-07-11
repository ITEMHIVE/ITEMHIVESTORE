package za.ac.cput.itemhivesd2.service;
import za.ac.cput.itemhivesd2.domain.FlagReport;

import java.util.HashMap;
import java.util.Map;

/*Flag Report Service Class
Kelly Pauline Nolte(218275358)
Date:25.July.2026*/
public class FlagReportService implements IFlagReportService {

    private final Map<String, FlagReport> flagReports = new HashMap<>();

    @Override
    public FlagReport create(FlagReport flagReport) {
        flagReports.put(flagReport.getFlagID(), flagReport);
        return flagReport;
    }

    @Override
    public FlagReport read(String id) {
        return flagReports.get(id);
    }

    @Override
    public FlagReport update(FlagReport flagReport) {
        if(flagReports.containsKey(flagReport.getFlagID())) {
            flagReports.put(flagReport.getFlagID(), flagReport);
            return flagReport;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        return flagReports.remove(id) != null;
    }
}//end of class
