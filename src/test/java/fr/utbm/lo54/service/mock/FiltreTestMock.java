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
    Object[] tr = new Object[]{"1","BELFORT"};
    Object[] trr = new Object[]{"2","LILLE"};
    Object[] trrr = new Object[]{"3","MADRID"};

    ArrayList<Object[]> list = new ArrayList<Object[]>( Arrays.asList(tr, trr, trrr));

    Object[] lr = new Object[]{"1","2018-02-18"};
    Object[] lrr = new Object[]{"2","2019-01-03"};
    Object[] lrrr = new Object[]{"3","2018-10-11"};

    ArrayList<Object[]> listA = new ArrayList<Object[]>( Arrays.asList(lr, lrr, lrrr));


    @Test
    public void test() throws ParseException {
        String code= "1";
       // code= "%" + code + "%";
        String lieu ="BELFORT";
      //  lieu= "%" + lieu + "%";
       String date = "2018-02-18";
       String dateA="2018-02-10";
        //BDDMockito.given(hb.filtreCourse(anyString(),anyString()).willReturn(list);
        //BDDMockito.given(hb.filtreCourseDate(anyString(),anyString(),anyString())).willReturn(list);
        Mockito.when(hb.filtreCourse(code,lieu)).thenReturn(list);
        Mockito.when(hb.filtreCourseDate(code,lieu,date)).thenReturn(list);

      List<Object[]> toto =lst.filtreFormationDate(code,lieu,date);



      // List<Object[]> mockTest =lst.filtreFormationDate(code,lieu,dateA);

        Assertions.assertThat(list).isEqualTo(toto);

      //  Assertions.assertThat(listA).isEqualTo(mockTest);
    }

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        lst = new ListeFormation(hb);
    }
}
