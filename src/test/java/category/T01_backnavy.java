package category;

import base_tests.basetests;
import dev.failsafe.internal.util.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class T01_backnavy extends basetests {
    @Test
    public void backnavy_loop() throws InterruptedException {
        var packback=home.select_category();
        packback.find("edit");
        packback.scrolldown();
        packback.change_price(100);
       String data = packback.cheack_price();
        assertEquals(data,"100EGP");
    }


}
