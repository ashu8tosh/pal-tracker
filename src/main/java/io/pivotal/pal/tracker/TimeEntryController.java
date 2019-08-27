package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class TimeEntryController {

    @Autowired
    TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository =timeEntryRepository;
    }

    @RequestMapping(value="/time-entries",method= RequestMethod.POST)
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {
      return new ResponseEntity(timeEntryRepository.create(timeEntryToCreate), HttpStatus.CREATED);

    }
    @RequestMapping(value="/time-entries/{timeEntryId}",method= RequestMethod.GET)
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId) {
       TimeEntry timeEntry = timeEntryRepository.find(timeEntryId);
        return new ResponseEntity(timeEntry, timeEntry!= null? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/time-entries")
    public ResponseEntity<List<TimeEntry>> list()
    {
        //return ResponseEntity.ok();
        return new ResponseEntity<>(timeEntryRepository.list(),HttpStatus.OK);
    }

    @RequestMapping(value="/time-entries/{timeEntryId}",method= RequestMethod.PUT)
    public ResponseEntity update(@PathVariable long timeEntryId, @RequestBody TimeEntry expected)
    {
        TimeEntry timeEntry = timeEntryRepository.update(timeEntryId,expected);
        return new ResponseEntity(timeEntry, timeEntry!= null? HttpStatus.OK:HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value="/time-entries/{timeEntryId}",method= RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable  long timeEntryId)
    {
        boolean isDeleated = timeEntryRepository.delete(timeEntryId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
