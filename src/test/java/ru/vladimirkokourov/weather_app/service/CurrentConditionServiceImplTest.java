package ru.vladimirkokourov.weather_app.service;

import org.junit.jupiter.api.Test;
import ru.vladimirkokourov.weather_app.client.AccuWeatherClient;
import ru.vladimirkokourov.weather_app.model.api.currentcondition.CurrentConditionRoot;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class CurrentConditionServiceImplTest {

    private final AccuWeatherClient accuWeatherClient = mock(AccuWeatherClient.class);
    private final CurrentConditionService conditionService = new CurrentConditionServiceImpl(accuWeatherClient);

    @Test
    void getByKey_shouldBeSuccess() {
        var conditionRoot = new CurrentConditionRoot();
        when(accuWeatherClient.getCurrentCondition(anyInt())).thenReturn(conditionRoot);

        var actual = conditionService.getByKey(anyInt());

        assertSame(conditionRoot, actual);
        verify(accuWeatherClient).getCurrentCondition(anyInt());
    }
}