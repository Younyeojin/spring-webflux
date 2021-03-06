package gradle_jin.JinService.util;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MyUtilTest {
    @Mock
    MyUtil myUtil;
    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        myUtil = new MyUtil();
    }
    @DisplayName("현재 시간 출력")
    @Test
    void now() {
        System.out.println(myUtil.now());
    }
}