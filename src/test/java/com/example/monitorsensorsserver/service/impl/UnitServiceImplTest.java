package com.example.monitorsensorsserver.service.impl;

import com.example.monitorsensorsserver.entity.Unit;
import com.example.monitorsensorsserver.entity.UnitName;
import com.example.monitorsensorsserver.repository.UnitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UnitServiceImplTest {

    @Mock
    private UnitRepository unitRepository;
    private UnitServiceImpl unitService;
    private Unit unit;

    @BeforeEach
    void setUp() {
        unitService = new UnitServiceImpl(unitRepository);
        unit = new Unit();
        unit.setId(1L);
        unit.setUnitName(UnitName.BAR);
    }

    @Test
    void canSave() {
        unitService.save(unit);
        ArgumentCaptor<Unit> argumentCaptor = ArgumentCaptor.forClass(Unit.class);
        verify(unitRepository).save(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue()).isEqualTo(unit);
    }

    @Test
    void canGetById() {
        given(unitRepository.findById(unit.getId())).willReturn(Optional.of(unit));
        assertThat(unitService.getById(unit.getId()).get()).isEqualTo(unit);
    }
}
