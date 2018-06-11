package fr.utbm.lo54.service.mock;

import fr.utbm.lo54.entity.CourseSession;
import fr.utbm.lo54.entity.Location;
import fr.utbm.lo54.repository.HibernateDao;
import fr.utbm.lo54.service.ListeFormation;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;

public class FiltreTestMock {
    // Mock du DAO
    @Mock
    private HibernateDao hb;

    // Classe à Tester
    private ListeFormation lst;

    //On force le resultat du DAO en imposant lors de l'execution du service d'utiliser cette reponse
    Object[] tr = new Object[]{null,null};
    Object[] trr = new Object[]{null,null};
    Object[] trrr = new Object[]{null,null};

    ArrayList<Object[]> list = new ArrayList<Object[]>( Arrays.asList(tr, trr, trrr));


    @Test
    public void test() throws ParseException {
        String code= "2";
        String lieu ="BELFORT";
        String date = "2018-02-18";
       // BDDMockito.given(hb.filtreCourse(anyString(),anyString()).willReturn(list);
        //BDDMockito.given(hb.filtreCourseDate(anyString(),anyString(),anyString())).willReturn(list);
        Mockito.when(hb.filtreCourse(anyString(),anyString())).thenReturn(list);
        Mockito.when(hb.filtreCourseDate(anyString(),anyString(),anyString())).thenReturn(list);

       List<Object[]> toto =lst.filtreFormationDate("2","belfort","2018-02-13");

        Assertions.assertThat(list).isEqualTo(toto);
    }

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        lst = new ListeFormation(hb);
    }
}
