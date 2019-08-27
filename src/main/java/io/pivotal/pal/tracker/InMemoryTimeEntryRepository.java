package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{


    private Map<Long, TimeEntry> inmemoryMap = new HashMap<>();

    private Long index=0l;
    @Override
    public TimeEntry create(TimeEntry any) {
        Long id = ++index;
        any.setId(id);
        inmemoryMap.put(id,any);
        return any;
    }

    @Override
    public TimeEntry find(long timeEntryId) {
        return inmemoryMap.get(timeEntryId);
    }

    @Override
    public List<TimeEntry> list() {
        List<TimeEntry> listTo = new ArrayList<>();
        for(Long l : inmemoryMap.keySet())
            listTo.add(inmemoryMap.get(l));
        return listTo;
    }

    @Override
    public TimeEntry update(long timeEntryId, TimeEntry any) {

        if(find(timeEntryId)!=null) {
            any.setId(timeEntryId);
            inmemoryMap.put(timeEntryId, any);
            return any;
        }
        return null;
    }

    @Override
    public boolean delete(long timeEntryId) {
        if(find(timeEntryId)!=null) {
            inmemoryMap.remove(timeEntryId);
            return true;
        }
        return false;
    }
}
