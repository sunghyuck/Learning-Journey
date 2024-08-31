package com.learningjourney.journey.abstractroutingdatasource;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AbstractRoutingDataSourceService {
    private final StudentRepository studentRepository;


    public void regStudent() {
        DataSourceContextHolder.setDataSourceType("WRITE_DS");
        StudentEntity student = new StudentEntity();
        student.setName("David");
        studentRepository.save(student);
    }


    public List<StudentDto> getStudentList() {
        DataSourceContextHolder.setDataSourceType("READ_DS");
        List<StudentEntity> studentEntityList = studentRepository.findAll();

        if (CollectionUtils.isEmpty(studentEntityList)) {
            return null;
        }

        return studentEntityList.stream().map(it -> new StudentDto(it.getId(), it.getName())).collect(Collectors.toList());
    }
}
