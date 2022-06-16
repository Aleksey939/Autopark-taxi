package org.ivanov.service.impl;

import org.ivanov.domain.entity.WorkDone;
import org.ivanov.domain.repositories.WorkDoneRepository;
import org.ivanov.service.WorkDoneService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class WorkDoneServiceImplTest {
    @InjectMocks
    private WorkDoneServiceImpl workDoneService;

    @Mock
    private WorkDoneRepository workDoneRepository;

    @Test
    public void findAllTest() {
        //given:
        final List<WorkDone> expectedResult = Arrays.asList(
                createWorkDone(1),
                createWorkDone(2)
        );

        //mocks:
        Mockito.when(workDoneRepository.findAll()).thenReturn(expectedResult);

        //when:
        final List<WorkDone> actualResult = workDoneService.findAll();

        //then:
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void findAllByCarIdTest() {
        //given:
        int carId = 1;

        final List<WorkDone> expectedResult = Arrays.asList(createWorkDone(1));

        //mocks:
        Mockito.when(workDoneRepository.findAllByCarId(carId)).thenReturn(expectedResult);

        //when:
        final List<WorkDone> actualResult = workDoneService.findAllByCarId(carId);

        //then:
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void saveTest() {
        //given:
        final WorkDone workDone = createWorkDone(1);

        //mocks:
        Mockito.when(workDoneRepository.save(workDone)).thenReturn(workDone);

        //when:
        final WorkDone savedWorkDone = workDoneService.save(workDone);

        //then:
        assertEquals(workDone, savedWorkDone);
    }

    private WorkDone createWorkDone(int id) {
        WorkDone workDone = new WorkDone();
        workDone.setId(id);

        return workDone;
    }
}