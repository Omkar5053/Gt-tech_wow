package com.gramtarang.wowdashboard.controller;

import com.gramtarang.wowdashboard.entity.TimeSheet;
import com.gramtarang.wowdashboard.entity.TimeSheetStatus;
import com.gramtarang.wowdashboard.service.TimeSheetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timesheet/")
public class TimeSheetController {
    private TimeSheetService timeSheetService;

    public TimeSheetController(TimeSheetService timeSheetService) {
        this.timeSheetService = timeSheetService;
    }
    @GetMapping("getTimeSheetByUserid")
    public List<TimeSheet> getTimeSheet(@RequestParam(value = "userId") Integer userId){
        return timeSheetService.getTimeSheet(userId);
    }
    @GetMapping("getall")
    public List<TimeSheet> getAll()
    {
        return timeSheetService.getallTimeSheets();
    }

    @PostMapping("add")
    public String addTimeSheet(@RequestBody TimeSheet timeSheet)
    {
        return timeSheetService.add(timeSheet);
    }

    @PostMapping
    public String checkTimeSheet(@RequestParam(value = "userId") Integer userId,
                                 @RequestParam(value = "timeSheetId") Integer timeSheetId,
                                 @RequestParam(value = "timeSheetStatus") TimeSheetStatus timeSheetStatus)
    {
        return timeSheetService.changeStatus(userId, timeSheetId, timeSheetStatus);
    }
}
