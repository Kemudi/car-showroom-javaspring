package com.example.lab9.managers;

import com.example.lab9.dao.CarShowroomRepo;
import com.example.lab9.models.CarShowroom;
import com.example.lab9.models.Rating;
import com.example.lab9.models.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)     //mockito - framework
class CarShowroomManagerTest {

    @Mock
    private CarShowroomRepo csRepo;
    private CarShowroomManager csManager;

    @BeforeEach
    public void initTest(){
        csManager = new CarShowroomManager(csRepo);
    }

    @Test
    void getRates() {
        CarShowroom cs = new CarShowroom();
        cs.setId(1);
        Rating r1 = new Rating();
        r1.setOcena(5);
        Rating r2 = new Rating();
        r2.setOcena(3);
        cs.addRate(r1);
        cs.addRate(r2);
        Mockito.when(csRepo.findById(cs.getId())).thenReturn(Optional.of(cs));
        assertEquals(csManager.getRates(cs.getId()),4);
        Mockito.when(csRepo.findById(63)).thenReturn(Optional.empty());
        assertThrows(NoSuchElementException.class,()->csManager.getRates(63));
    }


    @Test
    void getFulfillment() {
        CarShowroom cs = new CarShowroom();
        cs.setId(1);
        cs.setPojemnosc(10);
        cs.addCar(new Vehicle());
        cs.addCar(new Vehicle());
        cs.addCar(new Vehicle());

        Mockito.when(csRepo.findById(cs.getId())).thenReturn(Optional.of(cs));
        assertEquals(csManager.getFulfillment(cs.getId()),30);
    }
}