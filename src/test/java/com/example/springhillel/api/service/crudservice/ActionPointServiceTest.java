package com.example.springhillel.api.service.crudservice;

import com.example.springhillel.api.service.crudservice.convert.ActionPointConvert;
import com.example.springhillel.model.dto.ActionPointDTO;
import com.example.springhillel.model.entity.ActionPoint;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ActionPointServiceTest {

    private static ActionPointDTO actionPointDTO;
    private static ActionPoint actionPoint;
    @Mock
    private ActionPointService actionPointService;

    @Mock
    private ActionPointConvert actionPointConvert;

    @BeforeAll
    public static void beforeAll() {

        actionPoint = new ActionPoint("TEST_ACTION_POINT");
        actionPointDTO = new ActionPointDTO("TEST_ACTION_POINT");

    }

    @Test
    public void testOfCreatingActionPoint() {

        actionPointService.save(actionPointDTO);

        ArgumentCaptor<ActionPointDTO> requestCaptor = ArgumentCaptor.forClass(ActionPointDTO.class);

        Mockito.verify(actionPointService).save(requestCaptor.capture());

        assertFalse(requestCaptor.getAllValues().isEmpty());
        ActionPointDTO capturedArgument = requestCaptor.getValue();
        assertEquals(capturedArgument.getName(), "TEST_ACTION_POINT");

    }

    @Test
    public void testFindByIdActionPoint() {

        Optional<ActionPoint> actionPointList = Optional.of(actionPoint);

        Mockito.when(actionPointService.findById(1)).thenReturn(actionPointList);

        assertEquals("TEST_ACTION_POINT", actionPointService.findById(1).get().getName());

        Mockito.verify(actionPointService).findById(1);
    }

    @Test
    public void testGetAllActionPoint() {

        List<ActionPoint> actionPointList = new ArrayList<>();
        actionPointList.add(actionPoint);

        Mockito.when(actionPointService.getAll()).thenReturn(actionPointList);

        assertEquals("TEST_ACTION_POINT", actionPointService.getAll().get(0).getName());

        Mockito.verify(actionPointService).getAll();
    }

    @Test
    public void testDeleteByIdActionPoint() {

        actionPointService.deleteById(1);

        Mockito.verify(actionPointService).deleteById(1);
    }

    @Test
    public void testUpdateActionPoint() {

        Mockito.doNothing().when(actionPointService).update(actionPoint);

    }

}