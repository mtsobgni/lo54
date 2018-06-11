package fr.utbm.lo54.service;

import fr.utbm.lo54.entity.Client;
import fr.utbm.lo54.repository.HibernateDaoCreate;

import java.util.List;

public class ServiceCreate {
    private HibernateDaoCreate hb1;

    public ServiceCreate(HibernateDaoCreate hb1) {
        this.hb1 = hb1;
    }

    public ServiceCreate(){
        hb1= new HibernateDaoCreate();
    };

    public boolean CreateUser(Integer idsession, String lname, String fname, String address, String tel, String email){

        boolean createUser=false;
        List<Client> lstClient= null;
       lstClient= hb1.checkSession(idsession);
       if(lstClient.isEmpty()){
           hb1.CreateClient(idsession,lname,fname,address,tel,email);
           createUser=true;
       }
       else{
           lstClient=hb1.checkClient(lname,fname,email);
           if (lstClient.isEmpty()){
               hb1.CreateClient(idsession,lname,fname,address,tel,email);
               createUser=true;
           }
           else{
               createUser=false;
           }

       }
return  createUser;

    }
}
