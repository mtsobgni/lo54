package fr.utbm.lo54.service.mock;

import fr.utbm.lo54.entity.CourseSession;
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

import static org.mockito.Matchers.anyString;

public class SessionTestMock {

    // Mock du DAO
    @Mock
    private HibernateDao hb;
    // Classe à Tester
    @InjectMocks
    private ListeFormation lst;

    //On force le resultat du DAO en imposant lors de l'execution du service d'utiliser cette reponse
    CourseSession tr = new CourseSession();
    CourseSession trr = new CourseSession();
    CourseSession trrr = new CourseSession();
    // ArrayList<Location> ex = new ArrayList<Location>(tr);
    ArrayList<CourseSession> list = new ArrayList<CourseSession>( Arrays.asList(tr, trr, trrr));


    @Test
    public void test() throws ParseException {
       // BDDMockito.given(hb.listSession("%")).willReturn(list);
      //  BDDMockito.given(hb.listSessionFormation("%","%")).willReturn(list);
     // BDDMockito.given(hb.listSessionFormationDate("%","%","")).willReturn(list);
        Mockito.when(hb.listSession(anyString())).thenReturn(list);
        Mockito.when(hb.listSessionFormation(anyString(),anyString())).thenReturn(list);
        Mockito.when(hb.listSessionFormationDate(anyString(),anyString(),anyString())).thenReturn(list);


        List<CourseSession> toto =lst.SessionFormationDate("1","%","");

        Assertions.assertThat(list).isEqualTo(toto);
    }

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        lst = new ListeFormation(hb);
    }
}

