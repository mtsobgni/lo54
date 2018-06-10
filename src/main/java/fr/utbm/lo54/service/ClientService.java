package fr.utbm.lo54.service;

import fr.utbm.lo54.entity.Client;
import fr.utbm.lo54.repository.ClientDao;
import fr.utbm.lo54.repository.CourseSessionDao;

public class ClientService {
    public void registerClient(String firstname, String lastname, String address, String phone, String email, int idSession) {
        ClientDao clientDao = new ClientDao();
        CourseSessionDao courseSessionDao = new CourseSessionDao();
        clientDao.save(new Client(firstname, lastname, address, phone, email, courseSessionDao.getCourseSession(idSession)));
    }

    public int getNumClient(int idSession) {
        ClientDao clientDao = new ClientDao();
        return clientDao.getNumClient(idSession);
    }
}
