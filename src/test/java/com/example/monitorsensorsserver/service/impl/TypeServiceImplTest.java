package com.example.monitorsensorsserver.service.impl;

import com.example.monitorsensorsserver.entity.Type;
import com.example.monitorsensorsserver.entity.TypeName;
import com.example.monitorsensorsserver.repository.TypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TypeServiceImplTest {

    @Mock
    private TypeRepository typeRepository;
    private TypeServiceImpl typeService;
    private Type type;

    @BeforeEach
    void setUp() {
        typeService = new TypeServiceImpl(typeRepository);
        type = new Type();
        type.setId(1L);
        type.setTypeName(TypeName.PRESSURE);
    }

    @Test
    void canSave() {
        typeService.save(type);
        ArgumentCaptor<Type> argumentCaptor = ArgumentCaptor.forClass(Type.class);
        verify(typeRepository).save(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue()).isEqualTo(type);
    }

    @Test
    void canGetById() {
        given(typeRepository.findById(type.getId())).willReturn(Optional.of(type));
        assertThat(typeService.getById(type.getId()).get()).isEqualTo(type);
    }
}
