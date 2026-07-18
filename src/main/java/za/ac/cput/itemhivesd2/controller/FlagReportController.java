package za.ac.cput.itemhivesd2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.itemhivesd2.service.FlagReportService;
import za.ac.cput.itemhivesd2.domain.FlagReport;

/*Flag Report Controller Class
Kelly Pauline Nolte(218275358)
Date:19.July.2026*/
@RestController
@RequestMapping("/flagreport")
public class FlagReportController {

    private final FlagReportService service;

    @Autowired
    public FlagReportController(FlagReportService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public FlagReport create(@RequestBody FlagReport flagReport) {
        return service.create(flagReport);
    }

    @GetMapping("/read/{id}")
    public FlagReport read(@PathVariable String id) {
        return service.read(id);
    }

    @PutMapping("/update")
    public FlagReport update(@RequestBody FlagReport flagReport) {
        return service.update(flagReport);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}//end of class
