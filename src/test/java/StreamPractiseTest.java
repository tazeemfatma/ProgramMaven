import org.example.StreamPractise;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StreamPractiseTest {
    @InjectMocks
    private StreamPractise streamPractise;

    @Test
    public void testAvgandTotalSalary(){
        double salary = StreamPractise.avgandTotalSalary();
        assertEquals(359401,salary);

    }
}
