package org.ivanov.service.impl;

import org.ivanov.domain.entity.WorkDone;
import org.ivanov.domain.repositories.WorkDoneRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
        when(workDoneRepository.findAll()).thenReturn(expectedResult);

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
        when(workDoneRepository.findAllByCarId(carId)).thenReturn(expectedResult);

        //when:
        final List<WorkDone> actualResult = workDoneService.findAllByCarId(carId);

        //then:
        assertEquals(expectedResult, actualResult);
    }

    @Test(expected = NullPointerException.class)
    public void findAllByCarIdTest_whenNullId_thenThrowNullPointerException() {
        workDoneService.findAllByCarId(null);
    }

    @Test
    public void findByIdTest() {
        //given:
        int workDoneId = 1;
        final Optional<WorkDone> expectedResult = Optional.of(createWorkDone(1));

        //mocks:
        when(workDoneRepository.findById(workDoneId)).thenReturn(expectedResult);

        //when:
        final Optional<WorkDone> actualResult = workDoneService.findById(workDoneId);

        //then:
        assertEquals(expectedResult, actualResult);
    }

    @Test(expected = NullPointerException.class)
    public void findByIdTest_whenNullId_thenThrowNullPointerException() {
        workDoneService.findById(null);
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

    @Test
    public void deleteTest() {
        //given:
        final int workDoneId = 1;

        //when:
        workDoneService.deleteById(workDoneId);

        //then:
        verify(workDoneRepository, times(1)).deleteById(workDoneId);
    }

    @Test(expected = NullPointerException.class)
    public void deleteTest_whenNullId_thenThrowNullPointerException() {
        workDoneService.deleteById(null);
    }

    private WorkDone createWorkDone(int id) {
        WorkDone workDone = new WorkDone();
        workDone.setId(id);

        return workDone;
    }
}