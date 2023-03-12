package com.gramtarang.wowdashboard.service;

import com.gramtarang.wowdashboard.entity.TimeSheet;
import com.gramtarang.wowdashboard.entity.TimeSheetStatus;
import com.gramtarang.wowdashboard.entity.User;
import com.gramtarang.wowdashboard.repository.TimeSheetRepository;
import com.gramtarang.wowdashboard.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeSheetService {
    private TimeSheetRepository timeSheetRepository;
    private UserRepository userRepository;

    public TimeSheetService(TimeSheetRepository timeSheetRepository,UserRepository userRepository) {
        this.timeSheetRepository = timeSheetRepository;
        this.userRepository = userRepository;
    }

    public String add(TimeSheet timeSheet) {
        timeSheet.setTimeSheetStatus(TimeSheetStatus.SUBMITTED);
        timeSheetRepository.save(timeSheet);
        return "SUCCESS";
    }

    public List<TimeSheet> getTimeSheet(Integer userId) {
        return timeSheetRepository.getTimeSheetsByUserId(userId);
    }

    public List<TimeSheet> getallTimeSheets() {
        return timeSheetRepository.findAll();
    }

    public String changeStatus(Integer userId, Integer timeSheetId, TimeSheetStatus timeSheetStatus) {
        User user = userRepository.findById(userId).get();
        TimeSheet timeSheet = timeSheetRepository.findById(timeSheetId).get();
        if(user.getRole().toString() == "ADMIN" || user.getRole().toString() == "GUIDE")
        {
            timeSheet.setTimeSheetStatus(timeSheetStatus);
            timeSheetRepository.save(timeSheet);
            return timeSheetStatus.toString();
        }
        return "UNAUTHORIZED USER";
    }
}
