import com.sun.xml.internal.ws.policy.AssertionSet;
import fr.utbm.lo54.entity.Location;
import fr.utbm.lo54.repository.HibernateDao;
import fr.utbm.lo54.service.ListeFormation;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    @Mock
    private HibernateDao hb;

    private ListeFormation lst;
    Location tr = new Location();
    Location trr = new Location();
    Location trrr = new Location();
   // ArrayList<Location> ex = new ArrayList<Location>(tr);
    ArrayList<Location> list = new ArrayList<Location>( Arrays.asList(tr, trr, trrr));
    @Test
    public void test(){
         BDDMockito.given(hb.listLocation()).willReturn(list);

         List<Location> toto =lst.listLocation();

         //assert(list.equals(toto));
        Assertions.assertThat(list).isEqualTo(toto);
    }

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
         lst = new ListeFormation(hb);
    }
}
